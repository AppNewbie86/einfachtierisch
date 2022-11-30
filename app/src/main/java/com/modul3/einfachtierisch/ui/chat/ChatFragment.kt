package com.modul3.einfachtierisch.ui.chat

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.MessageAdapter
import com.modul3.einfachtierisch.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MainViewModel by activityViewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentChatBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Das übergebene Argument ("contact Index") wird in eine Variable gespeichert
        val contactIndex = requireArguments().getInt("contactIndex")

        // Über die Funktion aus dem ViewModel wird der Chat initialisiert
        viewModel.initializeChat(contactIndex)

        binding.chatToolbar.title = viewModel.currentContact.name
        binding.chatToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val messageAdapter = MessageAdapter()
        binding.rvMessages.adapter = messageAdapter

        viewModel.chat.observe(
            viewLifecycleOwner,
            Observer {
                Log.d("ChatFragment", "Observer BANG")
                messageAdapter.submitList(it)
            }
        )

        // Der btnSend bekommt einen Click Listener
        binding.btnSend.setOnClickListener {
            val text = binding.textInput.text.toString()
            if (text == "") {
                Toast.makeText(context, "Bitte zuerst eine Nachricht eingeben!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.sendMessage(text)
                binding.textInput.setText("")
                //Dieser Code sorgt dafür, dass die Tastatur wieder eingeklappt wird
                val imm: InputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
//                messageAdapter.notifyItemInserted(0)
//                messageAdapter.notifyItemInserted(1)
            }
        }
    }
}
