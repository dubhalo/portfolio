import * as functions from "firebase-functions";

export const scheduledRefresh = functions.pubsub
  .schedule("every 12 hours")
  .onRun(async () => {
    console.log("Milestone 1 scheduled refresh scaffold triggered.");
    // Milestone 3: fetch active products, extract price, validate, persist snapshots.
    return null;
  });
