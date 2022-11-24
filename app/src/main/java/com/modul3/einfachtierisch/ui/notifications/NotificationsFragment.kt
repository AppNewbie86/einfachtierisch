package com.modul3.einfachtierisch.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.ContactAdapter
import com.modul3.einfachtierisch.data.models.Contact
import com.modul3.einfachtierisch.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MainViewModel by activityViewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentNotificationsBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactAdapter = ContactAdapter()
        binding.rvContacts.adapter = contactAdapter

        // Die RecyclerView bekommt den ContactAdapter zugewiesen
        viewModel.chat.observe(
            viewLifecycleOwner,
            Observer {
                contactAdapter.submitList(it)
            }
        )
    }
}
