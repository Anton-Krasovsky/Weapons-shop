package com.example.website

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(
    val items: List<Weapons>,
    val context: Context
) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageMP155)
        val title: TextView = view.findViewById(R.id.MP155_title)
        val desc: TextView = view.findViewById(R.id.MP155_desc)
        val price: TextView = view.findViewById(R.id.Mp155_price)
        val buttonInfo: Button = view.findViewById(R.id.button_MP155_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_weapons, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString() + "BYN"

        val imageId = context.resources.getIdentifier(
            items[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)

        holder.buttonInfo.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra("weaponTitle", items[position].title)
            intent.putExtra("weaponText", items[position].text)


            context.startActivity(intent)
        }

    }
}