export type SourceType = "api" | "structured_data" | "dom_scrape";

export interface Product {
  id: string;
  name: string;
  canonicalUrl: string;
  store: "walmart" | "chewy" | "target" | "generic";
  imageUrl?: string;
  currency: string;
  active: boolean;
  createdAt: string;
  updatedAt: string;
}

export interface PriceSnapshot {
  id: string;
  productId: string;
  price: number;
  currency: string;
  sourceType: SourceType;
  confidenceScore: number;
  extractedAt: string;
  rawValue: string;
  pageTitle?: string;
}

export interface UserTracking {
  id: string;
  productId: string;
  alertEnabled: boolean;
  alertAbovePrice?: number;
  alertBelowPrice?: number;
  alertPercentThreshold?: number;
  pinned: boolean;
}
