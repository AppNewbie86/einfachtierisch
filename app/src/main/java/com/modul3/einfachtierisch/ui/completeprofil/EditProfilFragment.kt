package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding

class EditProfilFragment : Fragment() {

    /**
     * Datenbank Reference als später initialisierte Variable
     */

    private lateinit var database: DatabaseReference

    /**
     * BindingMethode wird verknüpft
     */

    private lateinit var binding: FragmentEditProfilBinding

    /**
     * ViewModel wird angehängt
     */

    private val viewModel: MainViewModel by activityViewModels()

    /**
     * Layout wird aufgeblasen und zum erstellen vorbereitet
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Navigation zum DashBoard
         */

        binding.profileeditarrowbackbtn.setOnClickListener {

          findNavController()
              .navigate(EditProfilFragmentDirections.actionEditProfilFragmentToNavigationDashboard())

        }

        /**
         * FirebasedatenBank wird verknüpft
         */

        database = Firebase.database.reference

        /**
         * Button zum speichern der Daten führt die Funktion aus
         */

        binding.buttonSaveDatas.setOnClickListener {

            saveMemberData()

        }
    }

    /**
     * Funktion Save Member
     */

    private fun saveMemberData() {
        val etFieldDog = binding.fieldDogName.text.toString()
        val etFieldJob = binding.fieldJob.text.toString()

        /**
         * Nullcheck und objekt erstellen
         */

        if (!etFieldDog.isNullOrEmpty() && !etFieldJob.isNullOrEmpty()) {
            val member = Member(
                myDogName = etFieldDog,
                job = etFieldJob.toString()


            )// Viewmodel führt die Funktion UpdateMember aus
            viewModel.updateMember(member)
        }// Viewmodel überwacht mit dem Observer den Aktuellen User
        // und wenn Daten gespeichert wurden dann navigiert er zum Dashboard
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








