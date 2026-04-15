package com.foodstreetjournal.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodstreetjournal.model.TrackedProduct

@Composable
fun HomeScreen(products: List<TrackedProduct>, onOpenProduct: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Good morning 👋", style = MaterialTheme.typography.headlineSmall)
            Text("FoodStreetJournal", style = MaterialTheme.typography.titleMedium)
        }
        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    val total = products.sumOf { it.currentPrice }
                    Text("Basket Summary", style = MaterialTheme.typography.titleMedium)
                    Text("${products.size} tracked products")
                    Text("Current basket value: $${"%.2f".format(total)}")
                }
            }
        }
        items(products) { product ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenProduct(product.id) }
            ) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(product.name, style = MaterialTheme.typography.titleMedium)
                    Text(product.store, style = MaterialTheme.typography.labelMedium)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("$${"%.2f".format(product.currentPrice)}")
                        Text("7d ${"%.1f".format(product.change7dPercent)}%  •  30d ${"%.1f".format(product.change30dPercent)}%")
                    }
                    Text("Sparkline: ${product.sparkline.joinToString(prefix = "[", postfix = "]") { "%.2f".format(it) }}")
                }
            }
        }
    }
}
