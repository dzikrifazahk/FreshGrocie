package com.bangkit.freshgrocie.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageFormat
import android.graphics.Matrix
import android.graphics.Rect
import android.graphics.YuvImage
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.database.response.ModelClassifier
import com.bangkit.freshgrocie.databinding.ActivityCameraBinding
import java.io.ByteArrayOutputStream
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCameraBinding

    private var hasInfered: Boolean? = false
    private var currentBitmapForInference: Bitmap? = null

    private lateinit var cameraExecutor: ExecutorService
    private var tfLiteClassifier: ModelClassifier = ModelClassifier(this@CameraActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)

        //Navigation
        binding.btnSeeNutrition.setOnClickListener {
            startActivity(Intent(applicationContext, NutritionActivity::class.java))
        }
        binding.backButton.setOnClickListener {
            startActivity(Intent(applicationContext, HomeActivity::class.java))
        }
        binding.btnMakeAFood.setOnClickListener {
            startActivity(Intent(applicationContext, ReceiptActivity::class.java))
        }



        setContentView(binding.root)
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        cameraExecutor = Executors.newSingleThreadExecutor()

        var futureObj = tfLiteClassifier
            .initializeUsingFuture()

        while (true) {
            try {
                if (futureObj.isDone) {
                    println(" FutureTask Complete")
                    return
                }

            } catch (e: java.lang.Exception) {
                println("Exception: $e")
            }
        }


    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.preview.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            val imageAnalysis = buildImageAnalysisUseCase()
            imageAnalysis.setAnalyzer(cameraExecutor) { image ->

                val rotationDegrees = image.imageInfo.rotationDegrees
                // Analyze image. Make sure to close it before returning from the method, otherwise the pipeline will be blocked.

                if (!hasInfered!!) {
                    hasInfered = true

                    currentBitmapForInference = rotateBitmap(image.toBitmap(), rotationDegrees.toFloat())

                    var inputBitmap = BitmapFactory.decodeResource(resources, R.drawable.apple_season)
                    var futureClassifierObj = tfLiteClassifier
                        .classifyUsingFuture(currentBitmapForInference!!)

                    while (true) {
                        try {
                            if (futureClassifierObj.isDone) {
                                Log.d("RESULT",  futureClassifierObj.get())
                                this.runOnUiThread(Runnable {
                                    binding.predictedTextView?.text = futureClassifierObj.get()
//                                    binding.imageView.setImageBitmap(currentBitmapForInference!!)
                                    Handler().postDelayed({
                                        hasInfered = false

                                    }, 1000)

                                }
                                )
                                image.close()
                                return@setAnalyzer
                            }

                        } catch (e: java.lang.Exception) {
                            println("Exception: $e")
                        }
                    }

                }
                else {
                    image.close()
                }

            }

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageAnalysis
                )

            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    private fun rotateBitmap(source: Bitmap, angle: Float): Bitmap? {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }

    private fun ImageProxy.toBitmap(): Bitmap {
        val yBuffer = planes[0].buffer // Y
        val uBuffer = planes[1].buffer // U
        val vBuffer = planes[2].buffer // V

        val ySize = yBuffer.remaining()
        val uSize = uBuffer.remaining()
        val vSize = vBuffer.remaining()

        val nv21 = ByteArray(ySize + uSize + vSize)

        yBuffer.get(nv21, 0, ySize)
        vBuffer.get(nv21, ySize, vSize)
        uBuffer.get(nv21, ySize + vSize, uSize)

        val yuvImage = YuvImage(nv21, ImageFormat.NV21, this.width, this.height, null)
        val out = ByteArrayOutputStream()
        yuvImage.compressToJpeg(Rect(0, 0, yuvImage.width, yuvImage.height), 100, out)
        val imageBytes = out.toByteArray()

        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    private fun buildImageAnalysisUseCase(): ImageAnalysis {
        return ImageAnalysis.Builder()
            .build()
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onDestroy() {
        super.onDestroy()
        tfLiteClassifier.close()
        cameraExecutor.shutdown()
    }

    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera()
            } else {
                Toast.makeText(
                    this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
}