package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding
import kotlinx.coroutines.Job

class EditProfilFragment : Fragment() {

    private lateinit var binding: FragmentEditProfilBinding

    private lateinit var nametext: EditText
    private lateinit var nameDog: EditText
    private lateinit var job: EditText
    private lateinit var erfahrung: EditText



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

    }

    private fun getValuesAndSave() {
        val myName = binding.textLineSummaryName.text.toString()
        val myExpirience = binding.expertisetext.text.toString()
        val job = binding.yourJobText.text.toString()
        val newMember = Member(

            name = nametext.toString(),
            myDogName = nameDog.toString(),
            expirience = erfahrung.toString(),
            job = job
        )
        viewModel.updateMember()
    }
}
