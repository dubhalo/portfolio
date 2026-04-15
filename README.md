# FoodStreetJournal MVP Scaffold

FoodStreetJournal is an **Android-first price tracking app** for real product URLs (Walmart, Chewy, Target, and generic fallback). This repository currently delivers **Milestone 1**: project scaffold, Android app shell with Compose navigation and placeholders, widget skeleton, backend scaffold, Firestore data models, and local mock data.

## Repository Layout

- `android-app/` Android Kotlin + Jetpack Compose shell + Glance widget skeleton
- `backend/` Firebase Functions + Firestore scaffold in TypeScript
- `shared/` Shared docs/types placeholder
- `docs/` Architecture and schema notes

## Milestone 1 Included

- Android shell app with Material 3 + bottom navigation
- Placeholder screens:
  - Home
  - Product Detail
  - Compare / Sources
  - Alerts
  - News & Grow (News, Grow Tips, Savings Ideas tabs)
- Widget skeleton (small/medium/large responsive layouts)
- Local mock data to render UI immediately
- Firebase Functions scaffold and API route placeholders
- Firestore model definitions (`Product`, `PriceSnapshot`, `UserTracking`)
- Seed/mock backend data

## Quick Start

### Android App (Android Studio)

1. Open `android-app/` in Android Studio (Giraffe+).
2. Let Gradle sync.
3. Run app on emulator/device.
4. App starts with mock data enabled and placeholder navigation flow.

### Backend (Node.js 20+)

```bash
cd backend
npm install
npm run build
npm run serve
```

This runs local Firebase Functions emulation entrypoints.

## Notes

- MVP v1 tracks **exact user-supplied URLs only**.
- No fuzzy cross-store matching is included.
- Extraction implementation comes in Milestone 3.
- Alerts logic implementation comes in Milestone 4.

## Next Milestones

- **Milestone 2:** track product by pasted URL + persistence + detail history wiring
- **Milestone 3:** structured-data extractor + DOM fallback + scheduled refresh
- **Milestone 4:** alerts + widget refresh pipeline
