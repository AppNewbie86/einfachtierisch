package com.modul3.einfachtierisch.adapter.memberinformationen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.MemberInformationen
import com.modul3.einfachtierisch.ui.completeprofil.EditProfilFragmentDirections


// der Adapter braucht den Context um auf String Resourcen zuzugreifen
class MemberInformationenAdapter(
    private val dataset: List<MemberInformationen>
) : RecyclerView.Adapter<MemberInformationenAdapter.ItemViewHolder>() {

    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val myName: TextView = view.findViewById(R.id.info_name)
        val myAge: TextView = view.findViewById(R.id.info_age)
        val myDogName: TextView = view.findViewById(R.id.info_personalitydogname)
        val livingPers: TextView = view.findViewById(R.id.living_person)
        val timeDate: TextView = view.findViewById(R.id.time_date)
        val personalityPosition: TextView = view.findViewById(R.id.position)
        val expirience: TextView = view.findViewById(R.id.expirience)
        val myJob: TextView = view.findViewById(R.id.job)

        val myCardLayout: ConstraintLayout = view.findViewById(R.id.cardlayout)
    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.profildatas_item, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.myName.text = item.fullName
        holder.myAge.text = item.age.toString()
        holder.myDogName.text = item.dogName
        holder.livingPers.text = item.livingPerson.toString()
        holder.timeDate.text = item.timeDate
        holder.personalityPosition.text = item.personalityPosition
        holder.expirience.text = item.expirience
        holder.myJob.text = item.job




        holder.myCardLayout.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(EditProfilFragmentDirections.actionEditProfilFragmentToSummaryFragment())
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
