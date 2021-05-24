package com.example.madappgangtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madappgangtest.R
import com.example.madappgangtest.data.Dragon
import com.squareup.picasso.Picasso

class DragonListAdapter(var dragonList: MutableList<Dragon>,val onDragonClick: (Dragon) -> Unit  /* create callback  так же как и onResponseDragons */) :
    RecyclerView.Adapter<DragonListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        val imView = view.findViewById<ImageView>(R.id.imView)

        fun bind(dragon: Dragon, onDragonClick: (Dragon) -> Unit) {
            itemView.setOnClickListener {
                //return result from dragon to callback
              onDragonClick(dragon)
            }
            tvTitle.text = dragon.name
            tvContent.text = dragon.firstFlight
            Picasso.get()
                .load(dragon.flickrImages[0])
                .into(imView)

            // use Picasso for download image from url
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(inflater.inflate(R.layout.dragon_item_layout, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dragonList[position], onDragonClick)
    }

    override fun getItemCount(): Int {
        return dragonList.size
    }
}