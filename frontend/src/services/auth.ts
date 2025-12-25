import axios from "axios";

const API = "http://localhost:8080/api/auth";

export const login = async (data: {
  username: string;
  password: string;
}) => {
  return axios.post(`${API}/login`, data);
};
