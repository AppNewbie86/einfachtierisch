package com.modul3.einfachtierisch.adapter.dog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Dogs
import com.modul3.einfachtierisch.ui.news.NewsFragmentDirections

class DogAdapter(emptyList: List<Any>) : RecyclerView.Adapter<DogAdapter.ItemViewHolder>() {

    private var dataset = listOf<Dogs>()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.list_image)

        val card: ConstraintLayout = view.findViewById(R.id.card)


        val textView1: TextView = view.findViewById(R.id.tv1)

        val textView7: TextView = view.findViewById(R.id.tv7)



    }

    fun submitList(list: List<Dogs>) {
        dataset = list
        notifyDataSetChanged()
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Dogs = dataset[position]

        holder.card.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(NewsFragmentDirections.actionNewsFragmentToDetailFragment2(item.id))
        }


        holder.textView7.text = "Nummer: " + item.id
        holder.textView1.text = "Name : " + item.name
      //  holder.textView4.text = "Haarlänge: " + item.coat_lenght
     //   holder.textView5.text = "Fellfarbe: " + item.coat_color
       // holder.textView6.text = "Höhe: " + item.height
       // holder.textView8.text = "Beschreibung: " + item.detail_text

        val imgUri = item.image.toUri().buildUpon().scheme("https").build()

        holder.imageView.load(imgUri) {
            error(R.drawable.ic_round_broken_image_24)
            transformations(RoundedCornersTransformation(10f))
        }


    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }



}