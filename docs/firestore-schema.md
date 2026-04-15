# Firestore Schema Definitions (MVP)

## Collections

### products

- id
- name
- canonicalUrl
- store
- imageUrl
- currency
- active
- createdAt
- updatedAt

### priceSnapshots

- id
- productId
- price
- currency
- sourceType (`api` | `structured_data` | `dom_scrape`)
- confidenceScore
- extractedAt
- rawValue
- pageTitle

### userTracking

- id
- productId
- alertEnabled
- alertAbovePrice
- alertBelowPrice
- alertPercentThreshold
- pinned
