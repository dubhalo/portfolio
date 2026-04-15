import { PriceSnapshot, Product, UserTracking } from "../models/types";

export const mockProducts: Product[] = [
  {
    id: "p1",
    name: "Organic Bananas (2 lb)",
    canonicalUrl: "https://www.walmart.com/ip/example",
    store: "walmart",
    imageUrl: "https://example.com/img/bananas.jpg",
    currency: "USD",
    active: true,
    createdAt: new Date().toISOString(),
    updatedAt: new Date().toISOString()
  }
];

export const mockSnapshots: PriceSnapshot[] = [
  {
    id: "s1",
    productId: "p1",
    price: 2.98,
    currency: "USD",
    sourceType: "structured_data",
    confidenceScore: 0.95,
    extractedAt: new Date().toISOString(),
    rawValue: "$2.98",
    pageTitle: "Organic Bananas"
  }
];

export const mockTracking: UserTracking[] = [
  {
    id: "t1",
    productId: "p1",
    alertEnabled: true,
    alertAbovePrice: 3.5,
    alertBelowPrice: 2.7,
    alertPercentThreshold: 8,
    pinned: true
  }
];
