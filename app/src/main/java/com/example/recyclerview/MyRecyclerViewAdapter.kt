package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitList: List<Fruit>,
    private val clickLister: (Fruit) -> Unit
) : RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val fruit = fruitList[position]
        holder.bind(fruit, clickLister)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }
}

class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
    fun bind(fruit: Fruit, clickLister: (Fruit) -> Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener() {
            clickLister(fruit)
        }
    }
}