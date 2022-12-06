package com.modul3.einfachtierisch.ui.helpDesk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DatabaseReference
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.databinding.FragmentHelpDeskBinding


class HelpDeskFragment : Fragment() {


    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentHelpDeskBinding

    private lateinit var database: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_desk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}

