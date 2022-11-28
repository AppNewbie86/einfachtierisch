package com.modul3.einfachtierisch.ui.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainActivity
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.databinding.FragmentProfileBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class ProfileFragment : Fragment() {

    // hier wird die binding Variable deklariert

    private lateinit var binding: FragmentProfileBinding
    private lateinit var button: Button

    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycleScope?.launchWhenCreated {
            (activity as MainActivity).hideNavBar()
        }
    }

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editButton.setOnClickListener {
            findNavController()
                .navigate(ProfileFragmentDirections.actionNavigationProfileToEditProfilFragment())
        }

        binding.LogoutButton.setOnClickListener {
            viewModel.logout()
        }
//LiveData schauen und wenn currentUser Null ist dann navigiere mich weg

    }
}
