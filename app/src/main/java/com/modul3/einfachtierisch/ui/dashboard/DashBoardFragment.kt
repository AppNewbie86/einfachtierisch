package com.modul3.einfachtierisch.ui.dashboard

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.load
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.adapter.news.NewsAdapter
import com.modul3.einfachtierisch.databinding.FragmentDashBoardBinding

/**
 * Das MainFragment ist der Begrüßungsscreen unserer App
 * sollte kein User eingeloggt sein wird man automatisch zum Login weitergeleitet
 */
class DashBoardFragment : Fragment() {


    //später initialisierte Variable wo das binding aktiviert wird

    private lateinit var binding: FragmentDashBoardBinding

    private val viewModel: MainViewModel by activityViewModels()

    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            viewModel.uploadImage(uri)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
        val newsAdapter = NewsAdapter()
        binding.gallerieRecycler.adapter = newsAdapter

        viewModel.news.observe(
            viewLifecycleOwner,
            Observer {
                // immer wenn neue news kommen recyclerview updaten
                newsAdapter.submitList(it)
            }
        )

 */

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.loginFragment)
                } else {
                    viewModel.getMemberData()
                }
            }
        )

        viewModel.member.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    binding.playerNameText.text = it.name

                    binding.playerImage.load(it.image) {
                        error(resources.getDrawable(R.drawable.american))
                    }
                }
            }
        )

        /**
         * viewmodel überwacht den toast
         */

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                }
            }
        )

        /**
         * update Picture
         */

        binding.levelUpImage.setOnClickListener {
            getContent.launch("image/*")
        }

        /**
         * NewsButton
         */

        binding.newsBtn.setOnClickListener {
            findNavController()
                .navigate(DashBoardFragmentDirections.actionNavigationDashboardToNewsFragment())
        }


        /**
         * EditProfilButton navigiert zum EditProfilFragment
         */

        binding.editButton.setOnClickListener {
            findNavController()
                .navigate(DashBoardFragmentDirections.actionNavigationDashboardToEditProfilFragment())
        }

        /**
         * navigation zum HelpDeskFragment
         */

        binding.helpdeskbutton.setOnClickListener {
            findNavController()
                .navigate(DashBoardFragmentDirections.actionNavigationDashboardToHelpDeskFragment())
        }

        /**
        * LogoutButton
         */

        binding.LogoutButton.setOnClickListener {
            viewModel.logout()
        }
    }
}
