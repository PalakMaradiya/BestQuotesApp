package com.example.thebestquetosapp.Activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thebestquetosapp.R
import com.example.thebestquetosapp.databinding.ActivityEditBinding
import java.io.File
import java.io.FileOutputStream
import java.util.*

class EditActivity : AppCompatActivity() {


    var id: Int = 0
    lateinit var Quotes: String
    lateinit var title: String
    var currentIndex = 0
    var img = arrayOf(R.drawable.bg1, R.drawable.bg2, R.drawable.bg4,R.drawable.bg3,R.drawable.bg5)

    lateinit var binding: ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        if (intent != null) {

            id = intent.getIntExtra("id", id)
            Quotes = intent.getStringExtra("Quetos").toString()
            title = intent.getStringExtra("name").toString()
            binding.txtTitle.text = title
            binding.txtQuotes.text = Quotes
        }




        binding.imgDwonlod.setOnClickListener {
            val pic: View =binding.layoutdownload
            pic.isDrawingCacheEnabled=true
            val hight:Int=pic.height
            val width:Int=pic.width
            pic.layout(0,0,width,hight)
            pic.buildDrawingCache(true)
            val bm: Bitmap = Bitmap.createBitmap(pic.drawingCache)
            pic.isDrawingCacheEnabled=false
            Toast.makeText(this, "Download Successfully", Toast.LENGTH_SHORT).show()
            MediaStore.Images.Media.insertImage(contentResolver,bm,null,null)
        }


       binding.backgroundImage.setOnClickListener {

           changeBackgroundImage()
       }
//
//            binding.backgroundImage.setBackgroundResource(R.drawable.bg4)
//
//            // Set click listener for the "Change Background" button
//            binding.backgroundImage.setOnClickListener {
//                // Change the visibility of the ImageView to make the background image visible
//                binding.backgroundImage.visibility = ImageView.VISIBLE
//                // Set the new background image
//                binding.backgroundImage.setBackgroundResource(R.drawable.bg2)
//            }
//        }


    }


//    for change background image

    private fun changeBackgroundImage() {
        if (currentIndex >= img.size) {
            currentIndex = 0 // Reset the index if it exceeds the array size
        }
        binding.backgroundImage.setBackgroundResource(img[currentIndex])
        currentIndex++
    }






}
