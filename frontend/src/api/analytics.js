import api from "../utils/axios";

export const getOrdersPerDay = () => {
  return api.get("/api/analytics/orders/per-day");
};

export const getRevenue = () => {
  return api.get("/api/analytics/revenue");
};

export const getTotalOrders = () => {
  return api.get("/api/analytics/orders/count");
};
