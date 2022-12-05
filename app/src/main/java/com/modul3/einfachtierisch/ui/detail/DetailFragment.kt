package com.modul3.einfachtierisch.ui.detail

import com.modul3.einfachtierisch.MainViewModel
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.modul3.einfachtierisch.MainActivity
import com.modul3.einfachtierisch.data.models.Dogs
import com.modul3.einfachtierisch.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    /**
     * Deklaration der gebrauchten Objekte
     */

    private lateinit var binding: FragmentDetailBinding
    private lateinit var dayWithDogBtn: FloatingActionButton
    private lateinit var detailImage: ImageView
    private lateinit var numberOfDogs: TextView
    private lateinit var nameOfDogs: TextView
    private lateinit var descriptionText: TextView

    // com.modul3.einfachtierisch.MainViewModel wird verknüpft

    private val viewModel: MainViewModel by activityViewModels()

    // Navbar wird ausgeblendet

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycleScope?.launchWhenCreated {
            (activity as MainActivity).hideNavBar()
        }
    }


    /**
     * Layout wird zum aufblasen vorbereitet
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         *  später initialierte Variable currentDog
         */

        lateinit var currentDog: Dogs

        /**
         *         //feste initialisierung der Objekte auf dem Fragment
         */
        nameOfDogs = binding.nameOfDogs
        numberOfDogs = binding.numberOfDogs
        dayWithDogBtn = binding.daywithdogBtn
        descriptionText = binding.descriptionText
        descriptionText.movementMethod = ScrollingMovementMethod()


        /**
         * gesetzte Value mit requireArguments und dem Key dogId mit Value 1
         */

        val dogId = requireArguments().getInt("dogId", 1)


        /**
         *  Viewmodel überwacht mit dem Observer dogList auf Updates
         */
        viewModel.dogs.observe(
            viewLifecycleOwner, Observer {

                /**
                 *  wir erzwingen den comnpiler die DogId zufinden
                 *  und da wir das gewährleisten können das er sie findet ... erzwingen wir ihn
                 */
                currentDog = it.find { it.id == dogId }!!

                /**
                 *  ich binde die Objekte auf das DetailFragment
                 *  und kann sie da aufrufen und anzeigen
                 */

                binding.numberOfDogs.text = currentDog.id.toString()
                binding.nameOfDogs.text = "Name:" + currentDog.name.toString()
                binding.descriptionText.text = "Beschreibung:" + currentDog.detail_text.toString()

            }
        )

        /**
         *  navigation zum ContactFragment
         */

        binding.daywithdogBtn.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToContactFragment())
        }


    }

}