package com.foodstreetjournal.data.mock

import com.foodstreetjournal.model.AlertSettings
import com.foodstreetjournal.model.PriceHistoryPoint
import com.foodstreetjournal.model.TrackedProduct
import java.time.Instant

object MockData {
    val products = listOf(
        TrackedProduct(
            id = "p1",
            name = "Organic Bananas (2 lb)",
            canonicalUrl = "https://www.walmart.com/ip/example",
            store = "Walmart",
            imageUrl = null,
            currentPrice = 2.98,
            change7dPercent = -3.2,
            change30dPercent = 1.8,
            sparkline = listOf(3.12, 3.08, 3.04, 3.10, 3.00, 2.99, 2.98),
            lastUpdated = Instant.now()
        ),
        TrackedProduct(
            id = "p2",
            name = "Dog Food 15 lb",
            canonicalUrl = "https://www.chewy.com/example",
            store = "Chewy",
            imageUrl = null,
            currentPrice = 31.49,
            change7dPercent = 4.1,
            change30dPercent = 9.4,
            sparkline = listOf(28.8, 29.2, 29.9, 30.2, 30.8, 31.0, 31.49),
            lastUpdated = Instant.now()
        ),
        TrackedProduct(
            id = "p3",
            name = "Olive Oil 1L",
            canonicalUrl = "https://www.target.com/p/example",
            store = "Target",
            imageUrl = null,
            currentPrice = 12.79,
            change7dPercent = -1.0,
            change30dPercent = -6.3,
            sparkline = listOf(13.6, 13.5, 13.2, 13.0, 12.9, 12.8, 12.79),
            lastUpdated = Instant.now()
        )
    )

    val history: Map<String, List<PriceHistoryPoint>> = products.associate { product ->
        product.id to product.sparkline.mapIndexed { idx, price ->
            PriceHistoryPoint(
                timestamp = Instant.now().minusSeconds((6 - idx) * 24L * 3600L),
                price = price
            )
        }
    }

    val alerts = mapOf(
        "p1" to AlertSettings(true, alertAbovePrice = 3.50, alertBelowPrice = 2.70, alertPercentThreshold = 8.0),
        "p2" to AlertSettings(true, alertAbovePrice = 35.00, alertBelowPrice = 28.00, alertPercentThreshold = 10.0),
        "p3" to AlertSettings(false, alertAbovePrice = null, alertBelowPrice = null, alertPercentThreshold = null)
    )
}
