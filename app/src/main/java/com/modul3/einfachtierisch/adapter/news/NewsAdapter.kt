package com.modul3.einfachtierisch.adapter.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.NewsArticle
import com.modul3.einfachtierisch.ui.dashboard.DashBoardFragmentDirections

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {

    private var dataset = listOf<NewsArticle>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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

        holder.title.text = item.title
        holder.location.text = item.location
        holder.date.text = item.date
        holder.image.setImageResource(item.imageResourceId)

        holder.card.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(DashBoardFragmentDirections.actionNavigationDashboardToDashBoardDetailFragment(item.id))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}