import { z } from "zod";

export const productSchema = z.object({
  id: z.string(),
  name: z.string(),
  canonicalUrl: z.string().url(),
  store: z.enum(["walmart", "chewy", "target", "generic"]),
  imageUrl: z.string().url().optional(),
  currency: z.string().default("USD"),
  active: z.boolean().default(true),
  createdAt: z.string(),
  updatedAt: z.string()
});

export const priceSnapshotSchema = z.object({
  id: z.string(),
  productId: z.string(),
  price: z.number().nonnegative(),
  currency: z.string().default("USD"),
  sourceType: z.enum(["api", "structured_data", "dom_scrape"]),
  confidenceScore: z.number().min(0).max(1),
  extractedAt: z.string(),
  rawValue: z.string(),
  pageTitle: z.string().optional()
});

export const userTrackingSchema = z.object({
  id: z.string(),
  productId: z.string(),
  alertEnabled: z.boolean().default(false),
  alertAbovePrice: z.number().optional(),
  alertBelowPrice: z.number().optional(),
  alertPercentThreshold: z.number().optional(),
  pinned: z.boolean().default(false)
});
