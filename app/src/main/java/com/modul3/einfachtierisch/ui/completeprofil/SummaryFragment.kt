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
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private val viewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSummaryBinding.inflate(inflater, container, false)


        // damit LiveData automatisch observed wird vom layout
        binding.lifecycleOwner = this.viewLifecycleOwner


        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /**
         * überwachung durch viewmodel ob currentUser eingeloggt ist
         */


        viewModel.member.observe(
            viewLifecycleOwner,
            Observer {
                if (true) {
                    binding.textLineSummaryName.setText(it.name)
                    binding.textLineSummaryAge.setText(it.myAge)
                    binding.editDogName.setText(it.myDogName)
                    binding.textLineSummaryLp.setText(it.livingPerson)
                    binding.textLineSummaryTimeDate.setText(it.timeDate)
                    binding.textLineSummaryPos.setText(it.personalityPosition)
                    binding.textinputline.setText(it.expirience)
                    binding.textinputlinejob.setText(it.job)
                }
            }
        )



        binding.itsAllRightBtn.setOnClickListener {
            findNavController().navigate(SummaryFragmentDirections.actionSummaryFragmentToNavigationDashboard())


        }
    }

    private fun updateMember() {
        val name = binding.textLineSummaryName.text.toString()
        val age = binding.textLineSummaryAge.text.toString().toInt()
        val nameDog = binding.editDogName.text.toString()
        val livingPer = binding.textLineSummaryLp.text.toString().toInt()
        val timeDate = binding.textLineSummaryTimeDate.text.toString()
        val dogPos = binding.textLineSummaryPos.text.toString()
        val myExpirience = binding.textinputline.text.toString()
        val myJob = binding.textinputlinejob.text.toString()

        val member = Member(
            name = name, myAge = age, myDogName = nameDog,
            livingPerson = livingPer, timeDate = timeDate, personalityPosition = dogPos,
            expirience = myExpirience, job = myJob
        )
        viewModel.updateMember(member)

    }
}
