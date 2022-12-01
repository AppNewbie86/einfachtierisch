package com.modul3.einfachtierisch.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import com.modul3.einfachtierisch.databinding.FragmentHomeBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */

class HomeFragment : Fragment() {


    /**
     * hier wird die binding Variable deklariert
     */

    private lateinit var binding: FragmentHomeBinding
    private lateinit var gatStartBtn: Button
    private lateinit var registerButton: Button

    /**
     * Hier holt man sich das ViewModel
     */
    private val viewModel: MainViewModel by activityViewModels()


    /**
     * Diese Funktion versteckt die NavBar auf dem Fragment
     */

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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Navigation zu LoginFragment
         */

        binding.getStartedBtn.setOnClickListener {
            findNavController()
                .navigate(HomeFragmentDirections.actionNavigationHomeToLoginFragment())
        }

        /**
         * Navigation zu RegisterFragment
         */

        binding.registerButton.setOnClickListener {
            findNavController()
                .navigate(HomeFragmentDirections.actionNavigationHomeToSignUpFragment())
        }


        //Indent auf FaceBook

        binding.facebookicon.setOnClickListener {
            val url = "https://www.facebook.com/"
            val f = Intent(Intent.ACTION_VIEW)
            f.data = Uri.parse(url)
            startActivity(f)
        }

        //Indent auf Instagram


        binding.instagramicon.setOnClickListener {
            val url = "https://www.instagram.com/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }



        //Indent auf GitHub


        binding.giticon.setOnClickListener {
            val url = "https://www.github.com/"
            val g = Intent(Intent.ACTION_VIEW)
            g.data = Uri.parse(url)
            startActivity(g)
        }


    }
}
