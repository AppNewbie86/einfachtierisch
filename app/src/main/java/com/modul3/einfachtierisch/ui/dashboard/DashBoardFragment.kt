package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.modul3.einfachtierisch.ApiStatus
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.ContactAdapter
import com.modul3.einfachtierisch.adapter.dog.DogAdapter
import com.modul3.einfachtierisch.databinding.FragmentDashBoardBinding

class DashBoardFragment : Fragment() {


    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentDashBoardBinding
    private lateinit var contactButton: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDashBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val imageList = binding.imageList

        val imageListAdapter = DogAdapter(emptyList())

        imageList.adapter = imageListAdapter


        viewModel.loading.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                ApiStatus.LOADING -> binding.progressBar.visibility = View.VISIBLE
                ApiStatus.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorImage.visibility = View.VISIBLE
                }
                else -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorImage.visibility = View.GONE
                }
            }
        }

        viewModel.dogs.observe(
            viewLifecycleOwner
        ) {
            println("WTF value of drinks by observer: $it")
            imageListAdapter.submitList(it)
        }

    }

}
