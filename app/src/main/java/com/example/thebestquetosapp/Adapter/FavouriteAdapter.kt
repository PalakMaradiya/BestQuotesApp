package com.example.thebestquetosapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thebestquetosapp.ModalClass.FavouriteQuoteModelclass
import com.example.thebestquetosapp.Activity.FavouriteQuotesActivity
import com.example.thebestquetosapp.R

class FavouriteAdapter(var favouriteQuoteActivity: FavouriteQuotesActivity,
                       var favouritelist: ArrayList<FavouriteQuoteModelclass>, var like: (Int, Int) -> Unit) : RecyclerView.Adapter<FavouriteAdapter.MyViewHolder>() {
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtQuotes: TextView = itemView.findViewById(R.id.txtQuotes)
        var imgHeart: ImageView = itemView.findViewById(R.id.imgHeart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {


        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.quotes_item_file, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {

        return  favouritelist.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtQuotes.text = favouritelist[position].Quetos

        //like
        holder.imgHeart.setImageResource(R.drawable.heart_fill)


        //like
        holder.imgHeart.setOnClickListener {


            like.invoke(0,favouritelist[position].id)
            favouritelist[position].status = 0



            //click button and set unlike
            deleteItem(position)  //create function and set position
        }



    }


    fun updateList(list: ArrayList<FavouriteQuoteModelclass>) {
        this.favouritelist = list
        notifyDataSetChanged()

    }

    fun deleteItem(position: Int) {
        favouritelist.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, favouritelist.size)
    }
}