export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  quantity: number;
  createdAt: string;
  updatedAt: string;
}

export interface ProductPayload {
  name: string;
  description: string;
  price: number;
  quantity: number;
}

export interface ApiError {
  timestamp: string;
  status: number;
  error: string;
  messages: string[];
}
