package com.foodstreetjournal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.foodstreetjournal.model.AlertSettings
import com.foodstreetjournal.model.TrackedProduct

@Composable
fun AlertsScreen(products: List<TrackedProduct>, alertSettings: Map<String, AlertSettings>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Alerts", style = MaterialTheme.typography.headlineSmall)
            Text("Placeholder settings; wiring to backend comes in Milestone 2+")
        }
        items(products) { product ->
            val settings = alertSettings[product.id]
            Card {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(product.name, style = MaterialTheme.typography.titleMedium)
                    Switch(checked = settings?.enabled == true, onCheckedChange = {})
                    Text("Above: ${settings?.alertAbovePrice ?: "-"}")
                    Text("Below: ${settings?.alertBelowPrice ?: "-"}")
                    Text("% Threshold: ${settings?.alertPercentThreshold ?: "-"}")
                }
            }
        }
    }
}
