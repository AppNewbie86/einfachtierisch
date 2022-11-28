package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.dog.DogAdapter
import com.modul3.einfachtierisch.data.models.Dogs
import com.modul3.einfachtierisch.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dogsAdapter = DogAdapter(emptyList())


        viewModel.dogs.observe(
            viewLifecycleOwner,
            Observer {
                // immer wenn neue dogs kommen recyclerview updaten
                dogsAdapter.submitList(it)
            }
        )

        val dogsId = requireArguments().getInt("dogsId", 0)

        val dogsList: List<Dogs>? = viewModel.dogs.value

        val dogs = dogsList?.find { it.id == dogsId }

        if (dogs != null) {
            binding.detailImage.drawable.isVisible

        }
    }
}
