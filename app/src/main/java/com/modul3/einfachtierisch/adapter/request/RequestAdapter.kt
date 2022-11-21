package com.modul3.einfachtierisch.adapter.request

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Request


/**
 * der Adapter braucht den Context um auf String Resourcen zuzugreifen
 * und die Liste an Requests um sie für die RecyclerView vorzubereiten
 */
/*
class RequestAdapter(
    private val dataset: List<Request>,
) : RecyclerView.Adapter<RequestAdapter.ItemViewHolder>() {
    /**
     * der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
     */

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.findViewById(R.id.item_name_text)
        val requestArt: TextView = view.findViewById(R.id.item_request_text)
        val requestText: TextView = view.findViewById(R.id.item_request_usertext)


        val requestcard: ConstraintLayout = view.findViewById(R.id.item_layout)
    }

    /**
     * der ViewHolder wird erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        /**
         * Itemlayout wird gebaut
         */
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.request_item, parent, false)
        /**
         * Und einem ViewHolder zurückgegeben
         */
        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter werden verändert
     */

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.userName.text = item.name
        holder.requestArt.text = item.requestarten
        holder.requestText.text = item.requestText




    }

    /**
     *  damit der LayoutManager weiß wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}

 */
