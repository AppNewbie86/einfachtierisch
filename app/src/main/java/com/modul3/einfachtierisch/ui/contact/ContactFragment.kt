package com.modul3.einfachtierisch.ui.contact

import com.modul3.einfachtierisch.MainViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.adapter.contact.ContactAdapter
import com.modul3.einfachtierisch.databinding.FragmentContactBinding


class ContactFragment : Fragment() {

    /**
     * Viewmodel wird verknüpft
     */

    private val viewModel: MainViewModel by activityViewModels()

    /**
     * Binding Methode wird verwendet
     */

    private lateinit var binding: FragmentContactBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
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

        binding.navigatebackButton.setOnClickListener {
            findNavController()
                .navigate(ContactFragmentDirections.actionContactFragmentToNavigationDashboard())
        }

        /**
         * Contactadapter wird angeschlossen
         */

        val contactAdapter = ContactAdapter()
        binding.rvContacts.adapter = contactAdapter

        /**
         * Recyclerview wird dem adapter zugewiesen
         */

        viewModel.contactList.observe(
            viewLifecycleOwner,
            Observer {
                contactAdapter.submitList(it)
            }
        )
    }
}
