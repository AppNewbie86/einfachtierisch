package com.modul3.einfachtierisch.ui.login

import com.modul3.einfachtierisch.MainViewModel
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.databinding.FragmentLoginBinding

/**
 * LoginFragment enthält das Login UI
 */
class LoginFragment : Fragment() {


    var simpleVideoView2: VideoView? = null
    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null


    private lateinit var binding: FragmentLoginBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        simpleVideoView2 = binding.simpleVideoView2
        if (mediaControls == null) {
            // bei Fragments benutzt man requireContext
            // creating an object of media controller class
            mediaControls = MediaController(requireContext())
            // set the anchor view for the video view
            mediaControls!!.setAnchorView(this.simpleVideoView2)
        }
        /**
         * Immer Null Savety beachten nicht einfach null setzen
         */

        // set the media controller for video view
        simpleVideoView2!!.setMediaController(mediaControls)
        // set the absolute path of the video file which is going to be played
        simpleVideoView2!!.setVideoURI(
            Uri.parse("android.resource://"
                    + requireContext().packageName + "/" + R.raw.login_animation))
        simpleVideoView2!!.requestFocus()
        // starting the video
        // TODO VideoStart in einen ClickOnLISTENER SETZEN
        simpleVideoView2!!.start()
        // display a toast message
        // after the video is completed
        simpleVideoView2!!.setOnCompletionListener {
            Toast.makeText(requireContext(), "Video completed",
                Toast.LENGTH_LONG).show()
        }
        // display a toast message if any
        // error occurs while playing the video
        simpleVideoView2!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(requireContext(), "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }


        binding.loginSignupButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }

        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEdit.text.toString()
            val password = binding.loginPasswordEdit.text.toString()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                if (email.matches(emailPattern.toRegex()))
                viewModel.login(email, password)
            }
        }

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
//                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(requireContext())
                        .setMessage(it)
                        .create()
                        .show()
                }
            }
        )

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.navigation_dashboard)
                }
            }
        )
    }
}
