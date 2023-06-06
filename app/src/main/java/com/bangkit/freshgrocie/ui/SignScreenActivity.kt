package com.bangkit.freshgrocie.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bangkit.freshgrocie.R
import com.bangkit.freshgrocie.databinding.ActivityHomeBinding
import com.bangkit.freshgrocie.fragment.HomeFragment
import com.bangkit.freshgrocie.fragment.ProfileFragment
import com.bangkit.freshgrocie.fragment.StoreFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider


class SignScreenActivity : AppCompatActivity() {
    private lateinit var ChartButtonHome : ImageButton

    private val TAG = "GoogleActivity"
    private val RC_SIGN_IN = 9001

    // [START declare_auth]
    private var mAuth: FirebaseAuth? = null
    // [END declare_auth]

    // [END declare_auth]
    private var mGoogleSignInClient: GoogleSignInClient? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_transaction)
//        firebaseinit()

//        setContentView(R.layout.activity_home)
//        ChartButtonHome.setOnClickListener{
//
//        }

//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        PreferenceManager.getDefaultSharedPreferences(this).apply {
//            if (!getBoolean(OnboardingFragment.COMPLETED_ONBOARDING_PREF_NAME, false)) {
//                startActivity(Intent(this@HomeActivity, StoreActivity::class.java))
////            }
////        }

//
//        startActivity(Intent(this@HomeActivity, SignScreen::class.java))
////        startActivity(Intent(this@HomeActivity, HomeActivity::class.java))

        startActivity(Intent(this@SignScreenActivity, TransactionActivity::class.java))
    }

    fun firebaseinit(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();


        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // [END config_signin]

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        val signBtn = findViewById<Button>(R.id.gButton)

        signBtn.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth!!.currentUser
        updateUI(currentUser)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                account.idToken?.let { firebaseAuthWithGoogle(it) }
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth!!.currentUser
                    if (user != null) {
                        updateUI(user)
                        val intent = Intent()
                        intent.setClass(applicationContext, HomeActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }
    private fun signIn() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    private fun updateUI(user: FirebaseUser?) {

    }


}


