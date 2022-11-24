package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.adapter.news.NewsAdapter
import com.modul3.einfachtierisch.databinding.FragmentDashboardBinding

/**
 * Dieses Fragment verwaltet die Anzeige der Lesezeichen
 */
class DashBoardFragment : Fragment() {

    // hier wird die binding Variable deklariert

    private lateinit var binding: FragmentDashboardBinding

    // Hier wird das ViewModel geholt
    private val viewModel: MainViewModel by activityViewModels()

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsAdapter = NewsAdapter()
        binding.newsRecycler.adapter = newsAdapter

        viewModel.news.observe(
            viewLifecycleOwner,
            Observer {
                // immer wenn neue news kommen recyclerview updaten
                newsAdapter.submitList(it)
            }
        )


    }
}
