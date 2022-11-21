package com.modul3.einfachtierisch.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modul3.einfachtierisch.data.Repository
import com.modul3.einfachtierisch.data.models.NewsArticle

class DashboardViewModel : ViewModel() {

    private val repository = Repository()

    private val _news = MutableLiveData<List<NewsArticle>>()
    val news: LiveData<List<NewsArticle>>
        get() = _news

    init {
        _news.value = repository.loadNews()
    }


    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}