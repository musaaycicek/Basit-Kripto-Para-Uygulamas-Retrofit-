package com.example.retrofitkriptopara.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkriptopara.R
import com.example.retrofitkriptopara.model.CryptoModel
import com.example.retrofitkriptopara.view.MainActivity

class RecyclerViewAdapter(
    private val cryptoList: ArrayList<CryptoModel>,
    mainActivity: MainActivity
):RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }
    public val color:Array<String> = arrayOf("#8fce00","#2986cc","#6a329f","#f1c232","#3d85c6","#cc0000","#f9cb9c","#741b47")
    class RowHolder(view: View): RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.itemView.setBackgroundColor(Color.parseColor(color[position %8].toString()))
        holder.itemView.findViewById<TextView>(R.id.text_name).text=cryptoList[position].currency
        holder.itemView.findViewById<TextView>(R.id.text_price).text=cryptoList[position].price

        holder.itemView.setOnClickListener {


        }

    }
}