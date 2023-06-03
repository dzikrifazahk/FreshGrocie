package com.bangkit.freshgrocie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangkit.freshgrocie.databinding.ActivityStoreBinding

class StoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        setContentView(binding.root)

        with(binding)
        {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener{ textView, actionId, event -> searchBar.text = searchView.text


                Toast.makeText(this@StoreActivity, searchView.text, Toast.LENGTH_SHORT).show()
                false}
        }
    }
}