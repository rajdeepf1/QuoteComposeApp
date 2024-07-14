package com.example.quotecomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.quotecomposeapp.data.DataManager
import com.example.quotecomposeapp.models.QuotesModel
import com.example.quotecomposeapp.screens.QuoteDetail
import com.example.quotecomposeapp.screens.QuoteList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            //delay(4000)
            DataManager.loadQuoteFromAssets(applicationContext)
        }

        setContent {
            App()
        }
    }
}
@Composable
fun App() {
        if (DataManager.isDataLoaded.value){
    if (DataManager.currentPage.value == Pages.LISTING){
            QuoteList(data = DataManager.quoteList ) {
                //Log.d("xoxoxoxox","${it.toString()}")
                DataManager.switchPage(it)
            }
    }else{
            DataManager.currentQuote?.let { QuoteDetail(it) }
        }
    }else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = androidx.compose.ui.Modifier.fillMaxSize(1f)
            ){
            Text(text = "Loading....")
        }
    }

}

enum class Pages{
    LISTING,
    DETAIL
}
