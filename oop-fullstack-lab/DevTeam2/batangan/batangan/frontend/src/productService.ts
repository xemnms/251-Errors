import axios from 'axios';

export interface Product {
  id?: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  category: string;
}

const API_BASE_URL = '/api/products';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

export const productService = {
  getAll: async (): Promise<Product[]> => {
    const response = await api.get<Product[]>('/');
    return response.data;
  },

  getById: async (id: number): Promise<Product> => {
    const response = await api.get<Product>(`/${id}`);
    return response.data;
  },

  create: async (product: Product): Promise<Product> => {
    const response = await api.post<Product>('/', product);
    return response.data;
  },

  update: async (id: number, product: Product): Promise<Product> => {
    const response = await api.put<Product>(`/${id}`, product);
    return response.data;
  },

  delete: async (id: number): Promise<void> => {
    await api.delete(`/${id}`);
  },
};
