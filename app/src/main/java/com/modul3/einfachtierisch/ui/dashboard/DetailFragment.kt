package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.data.models.Dogs
import com.modul3.einfachtierisch.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var chatButton: Button
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



        val dogsId = requireArguments().getInt("dogsId", 0)

        val dogsList: List<Dogs>? = viewModel.dogs.value

        val dogs = dogsList?.find { it.id == dogsId }

        if (dogs != null) {
            binding.detailImage.setImageResource(id)
            binding.tv2.text = dogs.detail_text


        }

        binding.chatwithmebutton.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToContactFragment())
        }





        viewModel.dogs.observe(
            viewLifecycleOwner
        ) {
            println("WTF value of dogs by observer: $it")

        }
    }
}
