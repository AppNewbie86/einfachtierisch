package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.data.models.MemberInformationen
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding

class EditProfilFragment : Fragment() {

    private lateinit var binding: FragmentEditProfilBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.profildatasaveBtn.setOnClickListener {
            getValuesAndSave()
        }

        binding.profildatacancelBtn.setOnClickListener {
            findNavController().navigate(EditProfilFragmentDirections.actionEditProfilFragmentToNavigationDashboard())
        }

        viewModel.completeState.observe(
            viewLifecycleOwner,
            Observer {
                if (it == true) {
                    findNavController().navigate(EditProfilFragmentDirections.actionEditProfilFragmentToSummaryFragment())
                    viewModel.unsetComplete()
                }
            }
        )
    }

    private fun getValuesAndSave() {
        val myName = binding.nameTextLine.text.toString()
        val myAge = binding.nameTextLine.text.toString()
        val myDogName = binding.nameTextLine.text.toString()
        val livingPers = binding.nameTextLine.text.toString()
        val timeDate = binding.nameTextLine.text.toString()
        val personalityPosition = binding.nameTextLine.text.toString()
        val expirience = binding.nameTextLine.text.toString()
        val job = binding.nameTextLine.text.toString()
        val newMemberProfil = MemberInformationen(
                myName = myName,
                myAge = myAge,
                myDogName = myDogName,
                livingPers = livingPers,
                timeDate = timeDate,
                personalityPosition = personalityPosition,
                expirience = expirience,
                job = job
            )
        viewModel.insertMemberInformationen(newMemberProfil)
    }
}
