package com.modul3.einfachtierisch.ui.completeprofil

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding
import com.modul3.einfachtierisch.databinding.FragmentSummaryBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class SummaryFragment : Fragment() {

    // hier wird die binding Variable deklariert

    private lateinit var binding: FragmentSummaryBinding
    private lateinit var textViewAge: TextView
    private lateinit var textViewExpirience: TextView
    private lateinit var textViewFavoriteColor: TextView
    private lateinit var textViewGen: TextView


    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()


    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        binding.ageTextView.text
        binding.expirienceTextView.text
        binding.colorTextView.text
        binding.genTextView.text
        binding.coverImageView.drawable
        binding.profileImageView.drawable


    }

    private fun init() {
        Glide.with(this)
            .load("https://i.pinimg.com/originals/89/9b/5a/899b5a79d5896d3a8c4938a5ad3970ee.jpg")
            .into(binding.coverImageView)

        Glide.with(this)
            .load("https://cdn4.iconfinder.com/data/icons/people-avatar-1-2/512/7-512.png")
            .into(binding.profileImageView)

        extractMemberInformationen()
    }

    private fun extractMemberInformationen() {

        val age = binding.ageTextView.text.get(textViewAge.toString().toInt())





    }
}
