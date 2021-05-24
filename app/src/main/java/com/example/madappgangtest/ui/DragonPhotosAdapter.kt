package com.example.madappgangtest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madappgangtest.R
import com.example.madappgangtest.data.Dragon
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class DragonPhotosAdapter(var photosList: MutableList<String>) :
    RecyclerView.Adapter<DragonPhotosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val photoImageView = view.findViewById<ImageView>(R.id.photoImageView)
        val progressBar = view.findViewById<ProgressBar>(R.id.photoProgressBar)

        fun bind(photo: String) {
            Picasso.get()
                .load(photo)
                .into(photoImageView, object :Callback {
                    override fun onSuccess() {
                        progressBar.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        photoImageView.setImageResource(R.drawable.ic_baseline_close_24)
                    }

                })
            // use Picasso for download image from url
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(inflater.inflate(R.layout.dragon_photo_item_layout, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(photosList[position])
    }

    override fun getItemCount(): Int {
        return photosList.size
    }
}