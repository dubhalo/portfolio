package com.foodstreetjournal.model

import java.time.Instant

data class TrackedProduct(
    val id: String,
    val name: String,
    val canonicalUrl: String,
    val store: String,
    val imageUrl: String?,
    val currentPrice: Double,
    val currency: String = "USD",
    val change7dPercent: Double,
    val change30dPercent: Double,
    val sparkline: List<Double>,
    val lastUpdated: Instant
)

data class PriceHistoryPoint(
    val timestamp: Instant,
    val price: Double
)

data class AlertSettings(
    val enabled: Boolean,
    val alertAbovePrice: Double?,
    val alertBelowPrice: Double?,
    val alertPercentThreshold: Double?
)
