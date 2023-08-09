package com.example.thebestquetosapp.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thebestquetosapp.Adapter.CategoryAdapter
import com.example.thebestquetosapp.Database.MyDatabase
import com.example.thebestquetosapp.ModalClass.CategoryModalClass
import com.example.thebestquetosapp.R
import com.example.thebestquetosapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    var CategoryList = ArrayList<CategoryModalClass>()
    lateinit var binding: ActivityCategoryBinding
    lateinit var Cadapter: CategoryAdapter
    lateinit var databse: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databse = MyDatabase(this)
        initview()
    }

    private fun initview() {


        binding.nevigationView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.rate -> {

                    val intent = Intent(this, RateActivity::class.java)
                    startActivity(intent)
                }


                R.id.privacy -> {

                    val openurl = Intent(Intent.ACTION_VIEW)
                    openurl.data =
                        Uri.parse("https://quotesdev.blogspot.com/p/quotes-privacy-policy.html?m=1")
                    startActivity(openurl)
                }

                R.id.shareApp -> {


                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Hey Check out this Great app:" + "https://play.google.com/store/apps/details?id=com.jd.english.quotes"
                    )
                    intent.type = "text/plain"
                    startActivity(Intent.createChooser(intent, "Share To:"))
                }


                R.id.termsofservice -> {


                    val openurl = Intent(Intent.ACTION_VIEW)
                    openurl.data =
                        Uri.parse("http://appworldinfotech.hol.es/terms/magneticlab/termsofservice.html")
                    startActivity(openurl)

                }

                R.id.feedback    -> {


//                    val intent = Intent(Intent.ACTION_SEND)
//                    intent.type = "text/html"
//                    intent.putExtra(Intent.EXTRA_EMAIL, "palakmaradiya1594@gmail.com")
//                    intent.putExtra(Intent.EXTRA_SUBJECT, "For FeedBack")
//                    intent.putExtra(Intent.EXTRA_TEXT, "Share Your FeedBack About Your Experience")
//                    startActivity(Intent.createChooser(intent, "Send Email"))


//                    for open direct email
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "For FeedBack ")
                    intent.putExtra(Intent.EXTRA_TEXT, "Share your Feedback About your Experience ")
                    startActivity(intent)


                }


                R.id.favourites ->
                {

                    var i = Intent(this,FavouriteQuotesActivity::class.java)
                    startActivity(i)
                }

            }
            true


        }

        binding.imgNaveView.setOnClickListener {

            binding.Drawerlayout.openDrawer(binding.nevigationView)
        }

        binding.Drawerlayout.setOnClickListener {
            binding.Drawerlayout.closeDrawer(binding.nevigationView)
        }


        CategoryList = databse.CategoryDisplay()
        Cadapter = CategoryAdapter(this, CategoryList , onItemClick = {id ,name  ->

            val i = Intent(this,QuotesActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("id",id)
            startActivity(i)
        })
        var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcv.adapter = Cadapter
        binding.rcv.layoutManager = manager









    }
}