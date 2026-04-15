export type ExtractedPrice = {
  price: number;
  currency: string;
  sourceType: "structured_data" | "dom_scrape" | "api";
  confidenceScore: number;
  rawValue: string;
  pageTitle?: string;
};

export async function extractPriceFromUrl(url: string): Promise<ExtractedPrice> {
  // Milestone 3 implementation target:
  // 1) API/feeds
  // 2) JSON-LD structured data
  // 3) DOM fallback via Playwright
  console.log(`Extraction placeholder for ${url}`);
  return {
    price: 0,
    currency: "USD",
    sourceType: "structured_data",
    confidenceScore: 0,
    rawValue: "N/A"
  };
}
