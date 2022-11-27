package com.modul3.einfachtierisch.adapter.dog

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Dogs

class DogAdapter(emptyList: List<Any>) : RecyclerView.Adapter<DogAdapter.ItemViewHolder>() {

    private var dataset = listOf<Dogs>()

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView = view.findViewById<ImageView>(R.id.list_image)


        val textView1: TextView = view.findViewById(R.id.tv1)
        val textView4: TextView = view.findViewById(R.id.tv4)
        val textView5: TextView = view.findViewById(R.id.tv5)
        val textView6: TextView = view.findViewById(R.id.tv6)
        val textView7: TextView = view.findViewById(R.id.tv7)
        val textView3: TextView = view.findViewById(R.id.tv3)

        val textView8: TextView = view.findViewById(R.id.tv8)


    }

    @SuppressLint("NotifyDataSetChanged")
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
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Dogs = dataset[position]


        holder.textView1.text = "Name : " + item.name
        holder.textView3.text = "image: " + item.image
        holder.textView4.text = "coat_lenght: " + item.coat_lenght
        holder.textView5.text = "coat_color: " + item.coat_color
        holder.textView6.text = "height: " + item.height
        holder.textView7.text = "id: " + item.id
        holder.textView8.text = "detail_text: " + item.detail_text

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

private fun View.load(data: Uri?, builder: ImageRequest.Builder.() -> Unit) {

}
