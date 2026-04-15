import * as functions from "firebase-functions";
import { mockProducts, mockSnapshots, mockTracking } from "../seed/mockData";

export const trackProduct = functions.https.onRequest((req, res) => {
  if (req.method !== "POST") {
    res.status(405).json({ error: "Method not allowed" });
    return;
  }

  res.json({
    message: "Milestone 1 placeholder: product track endpoint",
    accepted: true
  });
});

export const getProducts = functions.https.onRequest((req, res) => {
  if (req.method !== "GET") {
    res.status(405).json({ error: "Method not allowed" });
    return;
  }
  res.json({ products: mockProducts, tracking: mockTracking });
});

export const getProductById = functions.https.onRequest((req, res) => {
  if (req.method !== "GET") {
    res.status(405).json({ error: "Method not allowed" });
    return;
  }

  const id = req.path.split("/").pop();
  const product = mockProducts.find((p) => p.id === id);
  if (!product) {
    res.status(404).json({ error: "Product not found" });
    return;
  }

  res.json({ product });
});

export const getProductHistory = functions.https.onRequest((req, res) => {
  if (req.method !== "GET") {
    res.status(405).json({ error: "Method not allowed" });
    return;
  }

  const id = req.path.split("/").slice(-2, -1)[0] ?? req.path.split("/").pop();
  const history = mockSnapshots.filter((s) => s.productId === id);
  res.json({ history });
});

export const patchProductAlerts = functions.https.onRequest((req, res) => {
  if (req.method !== "PATCH") {
    res.status(405).json({ error: "Method not allowed" });
    return;
  }

  res.json({ message: "Milestone 1 placeholder: alerts patch endpoint", updated: true });
});
