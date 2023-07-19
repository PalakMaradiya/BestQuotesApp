package com.example.thebestquetosapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thebestquetosapp.Activity.CategoryActivity
import com.example.thebestquetosapp.ModalClass.CategoryModalClass
import com.example.thebestquetosapp.R

class CategoryAdapter(var categoryActivity: CategoryActivity, var CategoryList: ArrayList<CategoryModalClass>
) : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        var txtCategory : TextView = itemView.findViewById(R.id.txtCategory)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.MyViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_file,parent,false)

        return MyViewHolder(view)
    }




    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {

        holder.txtCategory.text = CategoryList[position].name

    }

    override fun getItemCount(): Int {
        return  CategoryList.size

    }
}