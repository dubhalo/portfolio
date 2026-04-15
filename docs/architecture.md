# FoodStreetJournal Architecture (Milestone 1)

## Frontend (Android)

- Kotlin + Jetpack Compose shell
- Material 3 UI
- Bottom navigation routes: Home, Sources, Alerts, News & Grow
- Glance AppWidget skeleton for small / medium / large layouts
- Local mock data used to render UI offline

## Backend (Firebase Functions + Firestore)

- TypeScript Cloud Functions entrypoint in `backend/src/index.ts`
- HTTP endpoint placeholders:
  - `POST /products/track`
  - `GET /products`
  - `GET /products/:id`
  - `GET /products/:id/history`
  - `PATCH /products/:id/alerts`
- Scheduled refresh scaffold running every 12 hours
- Extractor placeholder with planned strategy:
  1) API/feed
  2) Structured data JSON-LD
  3) DOM fallback

## Scope Notes

- Version 1 tracks exact user-pasted URLs only.
- No fuzzy entity matching in MVP.
