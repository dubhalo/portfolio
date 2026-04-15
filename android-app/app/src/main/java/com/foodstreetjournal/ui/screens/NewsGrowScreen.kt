package com.foodstreetjournal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsGrowScreen() {
    val tabs = listOf("News", "Grow Tips", "Savings Ideas")
    val selected = remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("News & Grow", style = MaterialTheme.typography.headlineSmall)
        TabRow(selectedTabIndex = selected.intValue) {
            tabs.forEachIndexed { idx, title ->
                Tab(
                    selected = selected.intValue == idx,
                    onClick = { selected.intValue = idx },
                    text = { Text(title) }
                )
            }
        }

        when (selected.intValue) {
            0 -> Text("Agriculture news placeholder content.")
            1 -> Text("Grow tips placeholder content.")
            else -> Text("Savings ideas placeholder content.")
        }
    }
}
