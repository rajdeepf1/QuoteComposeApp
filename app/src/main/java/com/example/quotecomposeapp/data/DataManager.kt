package com.example.quotecomposeapp.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotecomposeapp.Pages
import com.example.quotecomposeapp.models.QuotesModel
import com.google.gson.Gson

object DataManager {
    var quoteList  = emptyArray<QuotesModel>()
    var index = 0
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: QuotesModel? = null

    fun loadQuoteFromAssets(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json, Array<QuotesModel>::class.java)
        isDataLoaded.value = true
    }

    fun switchPage(quotesModel: QuotesModel?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quotesModel
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }

//    fun getQuote() = quoteList[index]
//
//    fun nextQuote() = quoteList[++index % quoteList.size]
//
//    fun previousQuote() = quoteList[(--index + quoteList.size) % quoteList.size]



}