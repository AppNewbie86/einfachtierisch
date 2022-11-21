package com.modul3.einfachtierisch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.NewsArticle

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    private var dataset = listOf<NewsArticle>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgView = view.findViewById<ImageView>(R.id.news_image)
        val title: TextView = view.findViewById(R.id.news_title_text)
        val location: TextView = view.findViewById(R.id.news_location_text)
        val date: TextView = view.findViewById(R.id.news_date_text)
        val image: ImageView = view.findViewById(R.id.news_image)
        val card: CardView = view.findViewById(R.id.news_card)
    }

    fun submitList(list: List<NewsArticle>) {
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return ItemViewHolder(itemLayout)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: NewsArticle = dataset[position]
/*
        val imgUri = item.toUri().buildUpon().scheme("https").build()

        // coil
        holder.imgView.load(imgUri) {
            //transformations(CircleCropTransformation())
            transformations(RoundedCornersTransformation(10f))
            error(R.drawable.ic_baseline_broken_image_24)
            placeholder(R.drawable.ic_launcher_foreground)
            crossfade(true)
        }

 */
    }


    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }

}