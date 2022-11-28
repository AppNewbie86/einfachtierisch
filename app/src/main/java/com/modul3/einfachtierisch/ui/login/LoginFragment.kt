package com.modul3.einfachtierisch.ui.login

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainActivity
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        return binding.root

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.lifecycleScope?.launchWhenCreated {
            (activity as MainActivity).hideNavBar()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.loginButton.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            )
        }



        binding.loginSignupButton.setOnClickListener {
            val email = binding.loginEmailEdit.text.toString()
            val password = binding.loginPasswordEdit.text.toString()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                viewModel.login(email, password)
            }
        }

        viewModel.toast.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    AlertDialog.Builder(requireContext())
                        .setMessage(it)
                        .create()
                        .show()
                }
            }
        )

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.navigation_dashboard)
                }
            }
        )
    }

}