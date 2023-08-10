package com.example.thebestquetosapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.thebestquetosapp.databinding.ActivitySpleshScreenBinding

class SpleshScreenActivity : AppCompatActivity() {
    lateinit var  binding : ActivitySpleshScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpleshScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        Handler().postDelayed(
            {
                val i = Intent(this@SpleshScreenActivity, CategoryActivity::class.java)
                startActivity(i)
                finish()
            }, 5000)


    }
}