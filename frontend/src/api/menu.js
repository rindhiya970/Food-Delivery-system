import api from "../utils/axios";

export const getMenu = (restaurantId) => {
  return api.get(`/api/menu/${restaurantId}`);
};
