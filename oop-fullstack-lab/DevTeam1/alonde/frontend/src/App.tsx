import { useState, useEffect } from 'react';
import { type Product, type ProductFormData } from './types/product';
import * as api from './api/productApi';
import ProductForm from './components/ProductForm';
import ProductList from './components/ProductList';
import './App.css';

export default function App() {

  // the list of products fetched from the backend
  const [products, setProducts] = useState<Product[]>([]);
  // which product is being edited (null = none)
  const [editingProduct, setEditingProduct] = useState<Product | null>(null);
  // or loading spinner
  const [loading, setLoading] = useState(false);
  // for error messages
  const [errorMsg, setErrorMsg] = useState('');

  // fetch all products when the page first loads
  useEffect(() => { loadProducts(); }, []);

  async function loadProducts() {
    setLoading(true);
    setErrorMsg('');
    try {
      const data = await api.getAllProducts();
      setProducts(data);
    } catch {
      setErrorMsg('Could not load products. Is the backend running?');
    } finally {
      setLoading(false);
    }
  }

  async function handleSubmit(formData: ProductFormData) {
    setErrorMsg('');
    try {
      if (editingProduct) {
        // UPDATE existing product
        const updated = await api.updateProduct(editingProduct.id,
            formData);
        setProducts(prev => prev.map(p => p.id === updated.id ? updated :
            p));
        setEditingProduct(null);
      } else {
        // CREATE new product
        const created = await api.createProduct(formData);
        setProducts(prev => [...prev, created]);
      }
    } catch {
      setErrorMsg('Failed to save product. Please check your input.');
    }
  }

  async function handleDelete(id: number) {
    if (!confirm('Delete this product?')) return;
    setErrorMsg('');
    try {
      await api.deleteProduct(id);
      setProducts(prev => prev.filter(p => p.id !== id));
    } catch {
      setErrorMsg('Failed to delete product.');
    }
  }

  return (
      <div className="app">
        <h1>Product Manager</h1>

        {errorMsg && <div className="error-banner">{errorMsg}</div>}

        <ProductForm
            onSubmit={handleSubmit}
            editingProduct={editingProduct}
            onCancel={() => setEditingProduct(null)}
        />

        {loading ? <p>Loading...</p> : (
            <ProductList
                products={products}
                onEdit={setEditingProduct}
                onDelete={handleDelete}
            />
        )}
      </div>
  );
}


