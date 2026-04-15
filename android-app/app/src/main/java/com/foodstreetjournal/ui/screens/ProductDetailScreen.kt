package com.foodstreetjournal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodstreetjournal.model.PriceHistoryPoint
import com.foodstreetjournal.model.TrackedProduct

@Composable
fun ProductDetailScreen(product: TrackedProduct, history: List<PriceHistoryPoint>) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(product.name, style = MaterialTheme.typography.headlineSmall)
        Text("Store: ${product.store}")
        Text("Current: $${"%.2f".format(product.currentPrice)}")
        Text("7-day: ${"%.1f".format(product.change7dPercent)}%")
        Text("30-day: ${"%.1f".format(product.change30dPercent)}%")
        Text("Last updated: ${product.lastUpdated}")

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Sparkline / Chart Placeholder", style = MaterialTheme.typography.titleMedium)
                Text("History points: ${history.size}")
                history.forEach { Text("${it.timestamp}: $${"%.2f".format(it.price)}") }
            }
        }
    }
}
