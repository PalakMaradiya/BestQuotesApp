package com.example.thebestquetosapp.Activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thebestquetosapp.Adapter.QuotesAdapter
import com.example.thebestquetosapp.Database.MyDatabase
import com.example.thebestquetosapp.ModalClass.QuotesModalClass
import com.example.thebestquetosapp.databinding.ActivityQuotesBinding

class QuotesActivity : AppCompatActivity() {

    var id : Int = 0
    lateinit var name : String
    var QuotesList = ArrayList<QuotesModalClass>()
    lateinit var  Qadapter :QuotesAdapter
    lateinit var databse: MyDatabase
    lateinit var  binding: ActivityQuotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databse = MyDatabase(this)
        initview()
    }

    private fun initview() {

        if(intent!=null)
        {
            id = intent.getIntExtra("id",id)
            name = intent.getStringExtra("name").toString()
            binding.txtTitle.text = name
        }

        if(id==1)
        {
            QuotesList = databse.AttitudeQuotesDisplay()
        }

        else if(id==2)
        {
            QuotesList = databse.AwesomeQuotesDisplay()
        }

        else if(id==3)
        {
            QuotesList = databse.CoolQuotesDisplay()
        }


        else if(id==4)
        {
            QuotesList = databse.FriendsQuotesDisplay()
        }


        else if(id==5)
        {
            QuotesList = databse.HappinessQuotesDisplay()
        }


        else if(id==6)
        {
            QuotesList = databse.HurtQuotesDisplay()
        }


        else if(id==7)
        {
            QuotesList = databse.InspirationalQuotesDisplay()
        }

        else if(id==8)
        {
            QuotesList = databse.LifeQuotesDisplay()
        }


        else if(id==9)
        {
            QuotesList = databse.MotivationalQuotesDisplay()
        }


        else if(id==10)
        {
            QuotesList = databse.MovingOnQuotesDisplay()
        }


        else if(id==11)
        {
            QuotesList = databse.SadQuotesDisplay()
        }


        else if(id==12)
        {
            QuotesList = databse.SelfLoveQuotesDisplay()
        }


        else if(id==13)
        {
            QuotesList = databse.SingleQuotesDisplay()
        }


        else if(id==14)
        {
            QuotesList = databse.SmileQuotesDisplay()
        }


        else if(id==15)
        {
            QuotesList = databse.SuccessQuotesDisplay()
        }

        else if(id==16)
        {
            QuotesList = databse.TrueQuotesDisplay()
        }

        else if(id==17)
        {
            QuotesList = databse.LoveQuotesDisplay()
        }

        else if(id==18)
        {
            QuotesList = databse.AngryQuotesDisplay()
        }

        else if(id==19)
        {
            QuotesList = databse.AloneQuotesDisplay()
        }


        Qadapter = QuotesAdapter(this, QuotesList, OnCopy = { id,Quetos ->
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Quetos", Quetos)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this, "Copied ", Toast.LENGTH_SHORT).show()


        },


            Share = { id, Quetos ->

            val dataToShare = Quetos
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, dataToShare)
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        } ,

             Edit = { id ,Quetos ->

                 val i = Intent(this,EditActivity::class.java)
                 i.putExtra("id",id)
                 i.putExtra("Quetos",Quetos)
                 i.putExtra("name",name)
                 startActivity(i)
        }

            ,Like = { LikeStatus ,id  ->
                databse.UpdateFavouriteQuote(LikeStatus,id.toInt())
            }



        )
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = Qadapter
        binding.rcv.layoutManager = manager




    }
}