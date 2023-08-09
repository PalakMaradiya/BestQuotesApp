package com.example.thebestquetosapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thebestquetosapp.Adapter.FavouriteAdapter
import com.example.thebestquetosapp.Database.MyDatabase
import com.example.thebestquetosapp.ModalClass.FavouriteQuoteModelclass
import com.example.thebestquetosapp.databinding.ActivityFavouriteQuotesBinding

class FavouriteQuotesActivity : AppCompatActivity() {
    lateinit var  binding: ActivityFavouriteQuotesBinding

    var favouritelist = ArrayList<FavouriteQuoteModelclass>()
    lateinit var favouriteadapter: FavouriteAdapter
    lateinit var databse: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavouriteQuotesBinding.inflate(layoutInflater)
        databse = MyDatabase(this)
        setContentView(binding.root)

        initview()
    }

    private fun initview() {
        binding.imgBack.setOnClickListener {
            onBackPressed()

        }


        favouritelist = databse.FavouriteQuoteDisplay()
        favouriteadapter = FavouriteAdapter(this, favouritelist, like = {
                status, id -> databse.UpdateFavouriteQuote(status, id)
        })
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = favouriteadapter
        binding.rcv.layoutManager = manager
    }
}