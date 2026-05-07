import type { ApiError, Product, ProductPayload } from '../types/Product';

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL ?? 'http://localhost:8080/api';

async function request<T>(path: string, options: RequestInit = {}): Promise<T> {
  const response = await fetch(`${API_BASE_URL}${path}`, {
    headers: {
      'Content-Type': 'application/json',
      ...options.headers,
    },
    ...options,
  });

  if (!response.ok) {
    let message = 'Request failed';
    try {
      const error = (await response.json()) as ApiError;
      message = error.messages?.join(', ') || error.error || message;
    } catch {
      message = `${response.status} ${response.statusText}`;
    }
    throw new Error(message);
  }

  if (response.status === 204) {
    return undefined as T;
  }

  return response.json() as Promise<T>;
}

export const productService = {
  getAll(): Promise<Product[]> {
    return request<Product[]>('/products');
  },

  create(payload: ProductPayload): Promise<Product> {
    return request<Product>('/products', {
      method: 'POST',
      body: JSON.stringify(payload),
    });
  },

  update(id: number, payload: ProductPayload): Promise<Product> {
    return request<Product>(`/products/${id}`, {
      method: 'PUT',
      body: JSON.stringify(payload),
    });
  },

  delete(id: number): Promise<void> {
    return request<void>(`/products/${id}`, {
      method: 'DELETE',
    });
  },
};
