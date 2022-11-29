package com.modul3.einfachtierisch

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.modul3.einfachtierisch.adapter.dog.DogAdapter
import com.modul3.einfachtierisch.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private lateinit var dayWithDogBtn: FloatingActionButton
    private lateinit var imageList: RecyclerView
    private lateinit var dogAdapter: DogAdapter


    private lateinit var detailImage: ImageView
    private lateinit var numberOfDogs: TextView
    private lateinit var nameOfDogs: TextView
    private lateinit var descriptionText: TextView
    private lateinit var card: ConstraintLayout


    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dayWithDogBtn: FloatingActionButton = view.findViewById(R.id.daywithdogBtn)


        val imageList = binding.detailImage

        val imageListAdapter = DogAdapter(emptyList())


        viewModel.dogs.observe(
            viewLifecycleOwner
        ) { it ->
            println("WTF value of drinks by observer: $it")
            imageListAdapter.submitList(it)

            viewModel.dogs.observe(viewLifecycleOwner) {
                println("from Observer: ")
                println(it.toString())
                nameOfDogs.text = "Name : $it"
                descriptionText.text = "Url: $it"

            }
            binding.daywithdogBtn.setOnClickListener {
                findNavController()
                    .navigate(DetailFragmentDirections.actionDetailFragmentToContactFragment())
            }


        }
    }

}