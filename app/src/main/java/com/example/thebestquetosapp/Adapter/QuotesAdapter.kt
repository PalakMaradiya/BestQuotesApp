package com.example.thebestquetosapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thebestquetosapp.Activity.QuotesActivity
import com.example.thebestquetosapp.ModalClass.QuotesModalClass
import com.example.thebestquetosapp.R

class QuotesAdapter(
    var quotesActivity: QuotesActivity,
    var QuotesList: ArrayList<QuotesModalClass>,
    var OnCopy: ((id: Int, Quetos: String) -> Unit),
    var Share: ((id: Int, Quetos: String) -> Unit),
    var Edit: ((id: Int, Quetos: String) -> Unit),
    var Like: ((LikeStatus: Int, Id: String) -> Unit)
) : RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtQuotes: TextView = itemView.findViewById(R.id.txtQuotes)
        var imgCopy: ImageView = itemView.findViewById(R.id.imgCopy)
        var imgHeart: ImageView = itemView.findViewById(R.id.imgHeart)
        var imgShare: ImageView = itemView.findViewById(R.id.imgShare)
        var imgEdit: ImageView = itemView.findViewById(R.id.imgEdit)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.quotes_item_file, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {

        return QuotesList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtQuotes.text = QuotesList[position].id.toString()
        holder.txtQuotes.text = QuotesList[position].Quetos


        holder.imgCopy.setOnClickListener {
            OnCopy.invoke(QuotesList[position].id, QuotesList[position].Quetos)
        }

        holder.imgShare.setOnClickListener {
            Share.invoke(QuotesList[position].id, QuotesList[position].Quetos)
        }


        holder.imgEdit.setOnClickListener {
            Edit.invoke(QuotesList[position].id, QuotesList[position].Quetos)
        }

        if (QuotesList[position].like == 100) {
            holder.imgHeart.setImageResource(R.drawable.heart_fill)
        } else {
            holder.imgHeart.setImageResource(R.drawable.h1)
        }


//like
        holder.imgHeart.setOnClickListener {


            if (QuotesList[position].like == 100)
            {
                holder.imgHeart.setImageResource(R.drawable.h1)
                QuotesList[position].like = 0
                Like.invoke(QuotesList[position].like,QuotesList[position].id.toString())
            } else
            {

                holder.imgHeart.setImageResource(R.drawable.heart_fill)
                QuotesList[position].like = 100
                Like.invoke( QuotesList[position].like,QuotesList[position].id.toString())
            }
        }
    }
}



