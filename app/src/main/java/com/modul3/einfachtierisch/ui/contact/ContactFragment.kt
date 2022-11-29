package com.modul3.einfachtierisch.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.ContactAdapter
import com.modul3.einfachtierisch.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    /**
     *  Hier wird das ViewModel, in dem die Logik stattfindet, geholt
     */

    private val viewModel: MainViewModel by activityViewModels()


    /**
     *  Das binding für das QuizFragment wird deklariert
     */

    private lateinit var binding: FragmentContactBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout aufgeblasen
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
         * ContactRecyclerView wird mit ContactAdapter verbunden
         */

        val contactAdapter = ContactAdapter()
        binding.rvContacts.adapter = contactAdapter


        /**
         * ViewModel überwacht ContactRecyclerView mit dem Observer
         * und updatet bei Neuigkeiten
         */

        viewModel.contactList.observe(
            viewLifecycleOwner,
            Observer {
                contactAdapter.submitList(it)
            }
        )




    }
}
