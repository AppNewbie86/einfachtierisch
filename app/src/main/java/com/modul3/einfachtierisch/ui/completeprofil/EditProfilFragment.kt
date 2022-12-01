package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class EditProfilFragment : Fragment() {

    private lateinit var age: EditText
    private lateinit var expirience: EditText
    private lateinit var favoriteColor: EditText
    private lateinit var job: EditText
    private lateinit var gen: EditText

    // hier wird die binding Variable deklariert

    private lateinit var binding: FragmentEditProfilBinding

    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()


    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
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
        binding.saveInformationsBtn.setOnClickListener {
            setpersonalInformation()

        }


    }


    private fun setpersonalInformation() {
        binding.edittextfieldone.text.toString().toInt()
        binding.edittextfieldtwo.text.toString()
        binding.edittextfieldthree.text.toString()
        binding.edittextfieldfour.text.toString()
        binding.edittextfieldfive.text.toString()

        if (age.toString().isNotEmpty() && expirience.toString()
                .isNotEmpty() && favoriteColor.toString().isNotEmpty() &&
            job.toString().isNotEmpty() && gen.toString().isNotEmpty()
        ) {


        } else {
            // Toast.makeText(age, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }


}
