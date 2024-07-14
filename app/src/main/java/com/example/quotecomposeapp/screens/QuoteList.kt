package com.example.quotecomposeapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.quotecomposeapp.models.QuotesModel
import androidx.compose.ui.unit.*

@Composable
fun QuoteList(data: Array<QuotesModel>, onClick:(quotesModel:QuotesModel)->Unit) {
    Column {
        Box(modifier = Modifier.height(50.dp))
        Text(text = "Quotes App", modifier = Modifier.fillMaxWidth(1f), textAlign = TextAlign.Center, textDecoration = TextDecoration.Underline, fontSize = 28.sp)
        LazyColumn {
            items(data){
                QuoteListItem(quotesModel = it,onClick)
            }
        }
    }
}