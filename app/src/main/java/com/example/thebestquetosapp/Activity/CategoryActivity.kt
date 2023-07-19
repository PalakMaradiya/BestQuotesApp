package com.example.thebestquetosapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thebestquetosapp.Adapter.CategoryAdapter
import com.example.thebestquetosapp.Database.MyDatabase
import com.example.thebestquetosapp.ModalClass.CategoryModalClass
import com.example.thebestquetosapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    var  CategoryList = ArrayList<CategoryModalClass>()
    lateinit var  binding: ActivityCategoryBinding
    lateinit var Cadapter : CategoryAdapter
    lateinit var  databse : MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databse = MyDatabase(this)
        initview()
    }

    private fun initview() {


        CategoryList = databse.CategoryDisplay()
        Cadapter  = CategoryAdapter(this,CategoryList)
        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rcv.adapter = Cadapter
        binding.rcv.layoutManager = manager

    }
}