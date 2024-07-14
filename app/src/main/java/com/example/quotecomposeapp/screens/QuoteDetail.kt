package com.example.quotecomposeapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotecomposeapp.data.DataManager
import com.example.quotecomposeapp.models.QuotesModel


@Composable
 fun QuoteDetail(quotesModel: QuotesModel) {

     BackHandler {
         DataManager.switchPage(null)
     }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(colors = listOf(Color.Gray, Color.DarkGray))
            )
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                )
                Text(
                    text = quotesModel.text,
                    style = MaterialTheme.typography.bodyMedium

                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = quotesModel.author,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }

}