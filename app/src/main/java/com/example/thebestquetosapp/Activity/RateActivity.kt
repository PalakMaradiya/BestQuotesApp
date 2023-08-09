package com.example.thebestquetosapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.thebestquetosapp.R
import com.example.thebestquetosapp.databinding.ActivityRateBinding

class RateActivity : AppCompatActivity() {

    lateinit var  binding: ActivityRateBinding

    lateinit var ratingbar : RatingBar

    lateinit var btnSumbit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {


        binding.btnSumbit.setOnClickListener {

            if (ratingbar != null) {
                val button = findViewById<AppCompatButton>(R.id.btnSumbit)
                button?.setOnClickListener {
                    val msg = ratingbar.rating.toString()
                    Toast.makeText(this@RateActivity,
                        "Rating is: "+msg, Toast.LENGTH_SHORT).show()
                }
            }


        }

    }
}