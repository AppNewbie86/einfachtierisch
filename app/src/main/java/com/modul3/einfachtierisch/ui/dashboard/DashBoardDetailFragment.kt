package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.modul3.einfachtierisch.data.models.NewsArticle
import com.modul3.einfachtierisch.databinding.FragmentDashboarddetailBinding

class DashBoardDetailFragment : Fragment() {

    private var _binding: FragmentDashboarddetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboarddetailBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val newsId = requireArguments().getInt("newsId", 0)

        val newsList: List<NewsArticle>? = DashboardViewModel.news.value

        val newsArticle = newsList?.find { it.id == newsId }

        if (newsArticle != null) {
            binding.detailImage.setImageResource(newsArticle.imageResourceId)
            binding.detailTitle.text = newsArticle.title
            binding.detailDatum.text = newsArticle.date
            binding.detailText.text = newsArticle.article
        }
        return root


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}