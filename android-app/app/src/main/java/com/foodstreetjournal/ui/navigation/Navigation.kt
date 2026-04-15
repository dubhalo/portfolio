package com.foodstreetjournal.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.foodstreetjournal.data.mock.MockData
import com.foodstreetjournal.ui.screens.AlertsScreen
import com.foodstreetjournal.ui.screens.CompareScreen
import com.foodstreetjournal.ui.screens.HomeScreen
import com.foodstreetjournal.ui.screens.NewsGrowScreen
import com.foodstreetjournal.ui.screens.ProductDetailScreen

@Composable
fun FoodStreetApp() {
    MaterialTheme(
        colorScheme = if (false) darkColorScheme() else lightColorScheme()
    ) {
        val navController = rememberNavController()
        val tabs = listOf(BottomTab.Home, BottomTab.Compare, BottomTab.Alerts, BottomTab.NewsGrow)

        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    tabs.forEach { tab ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == tab.route } == true,
                            onClick = {
                                navController.navigate(tab.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(tab.icon, contentDescription = tab.label) },
                            label = { Text(tab.label) }
                        )
                    }
                }
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = BottomTab.Home.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(BottomTab.Home.route) {
                    HomeScreen(
                        products = MockData.products,
                        onOpenProduct = { productId -> navController.navigate("detail/$productId") }
                    )
                }
                composable("detail/{productId}") { entry ->
                    val productId = entry.arguments?.getString("productId") ?: return@composable
                    val product = MockData.products.firstOrNull { it.id == productId } ?: return@composable
                    ProductDetailScreen(product = product, history = MockData.history[productId].orEmpty())
                }
                composable(BottomTab.Compare.route) { CompareScreen(products = MockData.products) }
                composable(BottomTab.Alerts.route) { AlertsScreen(products = MockData.products, alertSettings = MockData.alerts) }
                composable(BottomTab.NewsGrow.route) { NewsGrowScreen() }
            }
        }
    }
}
