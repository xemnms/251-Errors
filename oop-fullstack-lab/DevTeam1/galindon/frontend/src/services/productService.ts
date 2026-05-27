import axios from "axios";
import type { Product } from "../models/Product";

const BASE_URL = "http://localhost:8081/api/tasks";

export const getProducts = async () => {
  return axios.get<Product[]>(BASE_URL);
};

export const createProduct = async (product: Product) => {
  return axios.post<Product>(BASE_URL, product);
};

export const updateProduct = async (id: number, product: Product) => {
  return axios.put<Product>(`${BASE_URL}/${id}`, product);
};

export const deleteProduct = async (id: number) => {
  return axios.delete(`${BASE_URL}/${id}`);
};
