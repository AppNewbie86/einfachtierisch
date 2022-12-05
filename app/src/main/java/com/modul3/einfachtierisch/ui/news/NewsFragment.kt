package com.modul3.einfachtierisch.ui.news

import com.modul3.einfachtierisch.ApiStatus
import com.modul3.einfachtierisch.MainViewModel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.modul3.einfachtierisch.MainActivity
import com.modul3.einfachtierisch.adapter.dog.DogAdapter
import com.modul3.einfachtierisch.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {


    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()


    private lateinit var binding: FragmentNewsBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var navigationView: BottomNavigationView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycleScope?.launchWhenCreated {
            (activity as MainActivity).showNavBar()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
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
            println("WTF value of dogs by observer: $it")
            imageListAdapter.submitList(it)
        }


    }


}
