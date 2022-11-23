package com.modul3.einfachtierisch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.NewsArticle

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    private var dataset = listOf<String>()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imgView = view.findViewById<ImageView>(R.id.news_image)
    }

    fun submitList(list: List<NewsArticle>) {
        dataset = list
        notifyDataSetChanged()
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
//hallo
        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: String = dataset[position]

        val imgUri = item.toUri().buildUpon().scheme("https").build()

        // coil
        holder.imgView.load(imgUri) {
            //transformations(CircleCropTransformation())
            transformations(RoundedCornersTransformation(10f))
            error(R.drawable.ic_baseline_broken_image_24)
            placeholder(R.drawable.ic_launcher_foreground)
            crossfade(true)
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
