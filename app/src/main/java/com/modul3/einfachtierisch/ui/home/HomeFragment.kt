package com.modul3.einfachtierisch.ui.home

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import com.modul3.einfachtierisch.MainViewModel
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainActivity
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
            scaler()

            findNavController()
                .navigate(HomeFragmentDirections.actionNavigationHomeToLoginFragment())
        }

        /**
         * Navigation zu RegisterFragment
         */

        binding.registerButton.setOnClickListener {
            scaler()
            findNavController()
                .navigate(HomeFragmentDirections.actionNavigationHomeToSignUpFragment())
        }

        /**
         * Intent auf Facebook Homepage
         */

        binding.facebookicon.setOnClickListener {
            val url = "https://www.facebook.com/"
            val f = Intent(Intent.ACTION_VIEW)
            f.data = Uri.parse(url)
            startActivity(f)
        }

        /**
         * Intent auf Instagram Homepage
         */


        binding.instagramicon.setOnClickListener {
            val url = "https://www.instagram.com/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }


        /**
         * Intent auf GitHub Homepage
         */


        binding.giticonVector.setOnClickListener {
            val url = "https://www.github.com/"
            val g = Intent(Intent.ACTION_VIEW)
            g.data = Uri.parse(url)
            startActivity(g)
        }


    }

    /**
     * scaler Funktion
     *
     * hier wird ein neuer ObjectAnimator erstellt der einen Float verändern soll welcher ans
     * SCALE Attribut gekoppelt ist
     */
    private fun scaler() {

        // animator verändert SCALE_Y von Pizza um 4f (4x vergrößert)
        // innerhalb 1500ms
        // wird 1x wiedeholt
        // die Wiederholung läuft Rückwärts
        // benutzt den OvershootInterpolator
//        val animator = ObjectAnimator.ofFloat(binding.pizza, View.SCALE_Y, 4f)
//        animator.duration = 1500
//        animator.repeatCount = 1
//        animator.repeatMode = ObjectAnimator.REVERSE
//        animator.interpolator = OvershootInterpolator()
//        animator.start()

//        // animator verändert SCALE_X und Scale_Y von Pizza um 10f (10x vergrößert)
//        // eine Möglichkeit 2 Attibute gliechzeitig zu ändern ist die Änderung innerhalb
//        // PropertyValuesHolder zu speichern
//        // innerhalb 3000ms
//        // wird 1x wiedeholt
//        // die Wiederholung läuft Rückwärts
//        // benutzt den DecelerateInterpolator - bremst gegen Ende
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 10f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 10f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(binding.getStartedBtn, scaleX, scaleY)
        animator.duration = 1500
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.interpolator = BounceInterpolator()
        animator.start()

        // animator verändert SCALE_X von Pizza um 0f (bis 0fach verkleinert)
        // innerhalb 200ms
        // wird 1x wiedeholt
        // die Wiederholung läuft Rückwärts
        val animatorTwo = ObjectAnimator.ofFloat(binding.getStartedBtn, View.SCALE_X, 0f)
        animatorTwo.duration = 200
        animatorTwo.repeatCount = 1
        animatorTwo.repeatMode = ObjectAnimator.REVERSE
        animatorTwo.start()
    }
}
