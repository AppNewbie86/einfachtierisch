package com.modul3.einfachtierisch.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.data.models.NewsArticle
import com.modul3.einfachtierisch.databinding.FragmentDashboarddetailBinding

class DashBoardDetailFragment : Fragment() {

    private lateinit var binding: FragmentDashboarddetailBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboarddetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsId = requireArguments().getInt("newsId", 0)

        val newsList: List<NewsArticle>? = viewModel.news.value

        val newsArticle = newsList?.find { it.id == newsId }

        if (newsArticle != null) {
            binding.detailImage.setImageResource(newsArticle.imageResourceId)
            binding.detailTitle.text = newsArticle.title
            binding.detailDatum.text = newsArticle.date
            binding.detailText.text = newsArticle.article
        }
    }
}
