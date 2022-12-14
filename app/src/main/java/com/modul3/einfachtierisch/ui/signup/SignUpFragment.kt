package com.modul3.einfachtierisch.ui.signup

import com.modul3.einfachtierisch.MainViewModel
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
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentSignUpBinding


/**
 * SignUpFragment enthält das UI um einen neuen User zu registrieren
 */
class SignUpFragment : Fragment() {

    var simpleVideoView: VideoView? = null
    // declaring a null variable for MediaController
    var mediaControls: MediaController? = null

    /**
     * ViewModel wird verknüpft
     */

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

    /**
     * Layout wird vorbereitet zum Erstellen aufgeblasen
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simpleVideoView = binding.simpleVideoView
        if (mediaControls == null) {

            /**
             * bei Fragments benutzt man requireContext
             * creating an object of media controller class
             */

            mediaControls = MediaController(requireContext())

            /**
             *  set the anchor view for the video view
             */

            mediaControls!!.setAnchorView(this.simpleVideoView)
        }

        /**
         *  set the media controller for video view
         */


        simpleVideoView!!.setMediaController(mediaControls)

        /**
         * set the absolute path of the video file which is going to be played
         */

        simpleVideoView!!.setVideoURI(
            Uri.parse("android.resource://"
                + requireContext().packageName + "/" + R.raw.signup_animation))


        simpleVideoView!!.requestFocus()

        /**
         *  starting the video
         */

        simpleVideoView!!.start()


        /**
         * display a toast message
         * after the video is completed
         */

        simpleVideoView!!.setOnCompletionListener {
            Toast.makeText(requireContext(), "Video completed",
                Toast.LENGTH_LONG).show()

        }

        /**
         * display a toast message if any
         * error occurs while playing the video
         */

        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(requireContext(), "An Error Occurred " +
                    "While Playing Video !!!", Toast.LENGTH_LONG).show()
            false
        }

        /**
         * backtohomeButton der zurück Navigiert
         *
         */

        binding.backtohomebutton.setOnClickListener {
            findNavController().navigateUp()
        }

        /**
         * signup Button wird mit SignUp Methode versehen und diese wird bei jedem SignUp
         * durchgeführt
         */

        binding.signupBtn.setOnClickListener {
            signUp()
        }

        /**
         * Viewmodel überwacht mit dem Observe den Toast und wirft diesen bei Bedarf
         */

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

        /**
         * Viewmodel überwacht mit dem Observe den currentUser und wirft diesen bei Bedarf
         */

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.navigation_dashboard)
                }
            }
        )
    }

    /**
     * Funktion für den SignUp Prozess
     */


    private fun signUp() {
        val email = binding.signupMail.text.toString()
        val password = binding.signupPassword.text.toString()
        val name = binding.signupNickname.text.toString()

        /**
         * NullCheck wird durchgeführt
         * und Objekt erstellt
         */


        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            val newMember = Member(
                name = name,

            )

            /**
             * viewmodel führt signUp() aus und übergibt email , password
             */
            viewModel.signUp(email, password, newMember)
        }
    }
}
