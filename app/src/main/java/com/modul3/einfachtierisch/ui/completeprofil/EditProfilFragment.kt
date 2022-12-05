package com.modul3.einfachtierisch.ui.completeprofil
/*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding

class EditProfilFragment : Fragment() {

    private lateinit var database: DatabaseReference

    private lateinit var binding: FragmentEditProfilBinding

    private val viewModel: MainViewModel by activityViewModels()


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

        database = Firebase.database.reference

        binding.buttonSaveDatas.setOnClickListener {

            binding.fieldDogName.text.toString()
            binding.fieldJob.text.toString()

            saveMemberData()

        }
        viewModel.updateMember()
    }

    //saveMember

    private fun saveMemberData() {
        val etFieldDog = binding.fieldDogName.text.toString()
        val etFieldJob = binding.fieldJob.text.toString()
/*
        //Nullcheck und objekt erstellen

        if (!etFieldDog.isNullOrEmpty() && !etFieldJob.isNullOrEmpty()) {
            val newMember = Member(
                myDogName = etFieldDog,
                job = etFieldJob.toString()



        )
         // Aufruf von ViewModel und Punktnotation der Function updateMember
 */
    }

 */




