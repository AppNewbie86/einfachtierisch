package com.modul3.einfachtierisch.ui.dashboard

import android.media.AudioAttributes
import android.media.MediaPlayer
import com.modul3.einfachtierisch.MainViewModel
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.load
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.databinding.FragmentDashBoardBinding

/**
 * Das MainFragment ist der Begrüßungsscreen unserer App
 * sollte kein User eingeloggt sein wird man automatisch zum Login weitergeleitet
 */
class DashBoardFragment : Fragment() {


    //später initialisierte Variable wo das binding aktiviert wird

    private lateinit var binding: FragmentDashBoardBinding


    private val viewModel: MainViewModel by activityViewModels()

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
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

                    binding.imagePlaceholderDashboard.load(it.image) {
                        error(resources.getDrawable(R.drawable.addfriend))
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

        binding.uploadImage.setOnClickListener {
            getContent.launch("image/*")
        }

        /**
         * NewsButton
         */


        //Hundebellen

        val preview = (R.raw.hundebellen)
        binding.dogwikiBtn.setOnClickListener {
            //  viewModel.playSong()
            findNavController()
                .navigate(DashBoardFragmentDirections.actionNavigationDashboardToNewsFragment())
        }


        /**
         * EditProfilButton navigiert zum EditProfilFragment
         */

        binding.editButton.setOnClickListener {
            findNavController()
                .navigate(R.id.editProfilFragment) //kürzere mMethode
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

/*
    //Musik abspielen

    fun playSong() {


        var mediaPlayer = MediaPlayer.create(context, R.raw.hundebellen)
        mediaPlayer.start() // no need to call prepare(); create() does that for you
        mediaPlayer.release()


        MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(R.raw.hundebellen)
            prepare() // might take long! (for buffering, etc)
            start()


        }

 */
}




