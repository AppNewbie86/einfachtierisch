package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding
import com.modul3.einfachtierisch.databinding.FragmentSummaryBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class SummaryFragment : Fragment() {

    // hier wird die binding Variable deklariert

    private lateinit var binding: FragmentSummaryBinding

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


    }
}
