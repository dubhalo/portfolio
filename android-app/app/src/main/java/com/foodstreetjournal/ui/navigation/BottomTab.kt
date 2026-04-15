package com.foodstreetjournal.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : BottomTab("home", "Home", Icons.Default.Home)
    data object Compare : BottomTab("compare", "Sources", Icons.Default.List)
    data object Alerts : BottomTab("alerts", "Alerts", Icons.Default.Notifications)
    data object NewsGrow : BottomTab("news_grow", "News & Grow", Icons.Default.Public)
}
