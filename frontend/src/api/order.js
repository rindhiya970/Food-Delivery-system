import api from "../utils/axios";

export const placeOrder = (order) => {
  return api.post("/api/orders", order);
};

export const getMyOrders = () => {
  return api.get("/api/orders/my");
};
