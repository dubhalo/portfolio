export function isValidPrice(price: number): boolean {
  if (!Number.isFinite(price)) return false;
  if (price <= 0) return false;
  if (price > 100000) return false;
  return true;
}

export function isExtremeChange(previous: number, next: number, thresholdPercent = 60): boolean {
  if (previous <= 0) return false;
  const delta = Math.abs(((next - previous) / previous) * 100);
  return delta >= thresholdPercent;
}
