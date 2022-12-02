package com.modul3.einfachtierisch.ui.completeprofil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.memberinformationen.MemberInformationenAdapter
import com.modul3.einfachtierisch.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private lateinit var binding: FragmentSummaryBinding
    private lateinit var recyclerView: RecyclerView
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


        val recyclerView = binding.profilrecyclerList

        viewModel.memberInformationenList.observe(
            viewLifecycleOwner,
            Observer {
                recyclerView.adapter = MemberInformationenAdapter(it)
            }
        )

        binding.itsAllRightBtn.setOnClickListener {
            findNavController().navigate(SummaryFragmentDirections.actionSummaryFragmentToNavigationDashboard())
        }
    }
}
