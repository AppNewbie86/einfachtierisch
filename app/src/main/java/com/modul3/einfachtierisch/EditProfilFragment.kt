package com.modul3.einfachtierisch

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.modul3.einfachtierisch.MainActivity
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.databinding.FragmentEditProfilBinding
import com.modul3.einfachtierisch.databinding.FragmentProfileBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class EditProfilFragment : Fragment() {

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






    }

    private fun init(){
        binding.saveInformationsBtn.setOnClickListener {
          //  personalInformation()


        }
    }
    /*
    private fun personalInformation(){
        val age = edittextfieldone.text.toString().toInt()
        val lastName = lastNameEditText.text.toString()
        val color = colorEditText.text.toString()
        val hobby = hobbyEditText.text.toString()
        val sport = sportEditText.text.toString()

        if (lastName.isNotEmpty() && lastName.isNotEmpty() && age.toString().isNotEmpty() &&
            color.isNotEmpty() && hobby.toString().isNotEmpty()
        ) {
            nextPageImageButton.setOnClickListener {
                val intent = Intent(this, User_Profile::class.java)
                intent.putExtra("name", name)
                intent.putExtra("last_name", lastName)
                intent.putExtra("age", age)
                intent.putExtra("color", color)
                intent.putExtra("hobby", hobby)
                intent.putExtra("sport", sport)
            }

        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }

     */
}
