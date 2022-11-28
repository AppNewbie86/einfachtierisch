package com.modul3.einfachtierisch.ui.signup

import android.app.AlertDialog
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils.*
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
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentSignUpBinding

/**
 * SignUpFragment enthält das UI um einen neuen User zu registrieren
 */
class SignUpFragment : Fragment() {

    var simpleVideoView: VideoView? = null
    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simpleVideoView = binding.signupVideo


        if (mediaControls == null) {
            // bei Fragments benutzt man requireContext
            // creating an object of media controller class
            mediaControls = MediaController(requireContext())
            // set the anchor view for the video view
            mediaControls!!.setAnchorView(this.simpleVideoView)
        }
        /**
         * Immer Null Savety beachten nicht einfach null setzen
         */

        // set the media controller for video view
        simpleVideoView!!.setMediaController(mediaControls)

        // set the media controller for video view
        simpleVideoView!!.setMediaController(mediaControls)
        // set the absolute path of the video file which is going to be played
        simpleVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
                + requireContext().packageName + "/" + R.raw.signup_animation))
        simpleVideoView!!.requestFocus()
        // starting the video
        // TODO VideoStart in einen ClickOnLISTENER SETZEN
        simpleVideoView!!.start()
        // display a toast message
        // after the video is completed
        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(requireContext(), "Video completed",
                Toast.LENGTH_LONG).show()
        }
        // display a toast message if any
        // error occurs while playing the video
        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(requireContext(), "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }


        binding.signupButton.setOnClickListener {
            signUp()
          //  CreateAccount()
        }

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                   Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
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

    private fun signUp() {
        val email = binding.emailId.text.toString()
        val password = binding.password1.text.toString()

        val name = binding.nickName.text.toString()

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            val newMember = Member(
                name = name,
            )
            viewModel.signUp(email, password, newMember)
        }
    }
/*
    private fun CreateAccount() {
        val emailtext = binding.signupMail.text.toString()
        val password = binding.signupPassword.text.toString()
        val name = binding.signupNickname.text.toString()

        when {
            isEmpty(binding.signupMail.toString()) -> Toast.makeText(requireContext(), Toast.LENGTH_SHORT).show()
            isEmpty(binding.signupPassword.toString()) -> Toast.makeText(this, "The Email is required!")
            isEmpty(binding.signupNickname.toString()) -> Toast.makeText(this, "The Email is required!")

        }

    }

 */
}