package com.foodstreetjournal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
fun CompareScreen(products: List<TrackedProduct>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Compare / Sources", style = MaterialTheme.typography.headlineSmall)
            Text("MVP shows source store + exact tracked URL")
        }
        items(products) { product ->
            Card {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(product.name, style = MaterialTheme.typography.titleMedium)
                    Text("Store: ${product.store}")
                    Text("URL: ${product.canonicalUrl}")
                }
            }
        }
    }
}
