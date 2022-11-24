package com.modul3.einfachtierisch.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Contact
import com.modul3.einfachtierisch.ui.dashboard.DashBoardDetailFragmentDirections


/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.ItemViewHolder>() {

    private var dataset: MutableList<Contact> = mutableListOf()

    fun submitList(list: MutableList<Contact>) {
        dataset = list
        notifyDataSetChanged()
    }

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPicture: ImageView = itemView.findViewById(R.id.ivContactPicture)
        val tvName: TextView = itemView.findViewById(R.id.tvContactName)
        val tvLastMessage: TextView = itemView.findViewById(R.id.tvContactLastMessage)
        val helpBtn: Button = itemView.findViewById(R.id.helpMeBtn)
        val clContact: ConstraintLayout = itemView.findViewById(R.id.clContact)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_message, parent, false)

        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Der aktuelle Kontakt wird aus dem Dataset geholt
        val contact = dataset[position]

        // Das Profilbild und der Profilname werden gesetzt
        holder.ivPicture.setImageResource(contact.imageResId)
        holder.tvName.text = contact.name

        // Falls Nachrichten in der Liste des Kontakts existieren wird die neuste Nachricht angezeigt
        if (contact.chatHistory.size > 0) {
            holder.tvLastMessage.text = contact.chatHistory[0].message
        }

        // Das komplette ConstraintLayout bekommt einen Click Listener, in dem zum ChatFragment navigiert wird
        holder.helpBtn.setOnClickListener {
            holder.itemView.findNavController().navigate(
                DashBoardDetailFragmentDirections.actionDashBoardDetailFragmentToRequestFragment(itemCount))

        }
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}
