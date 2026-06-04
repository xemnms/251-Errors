import axios from 'axios';
import { type Product, type ProductFormData } from '../types/product.ts';

const BASE_URL = 'http://localhost:8080/api/products';

// GET all products
export const getAllProducts = (): Promise<Product[]> =>
    axios.get(BASE_URL).then(res => res.data);

// POST — create a new product
export const createProduct = (data: ProductFormData): Promise<Product> =>
    axios.post(BASE_URL, data).then(res => res.data);

// PUT — update an existing product
export const updateProduct = (id: number, data: ProductFormData): Promise<Product> =>
    axios.put(`${BASE_URL}/${id}`, data).then(res => res.data);

// DELETE — remove a product
export const deleteProduct = (id: number): Promise<void> =>
    axios.delete(`${BASE_URL}/${id}`).then(() => {});