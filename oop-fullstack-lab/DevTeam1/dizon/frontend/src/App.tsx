import { RefreshCcw } from 'lucide-react';
import { useCallback, useEffect, useMemo, useState } from 'react';
import ProductForm from './components/ProductForm';
import ProductList from './components/ProductList';
import { productService } from './services/productService';
import type { Product, ProductPayload } from './types/Product';

export default function App() {
  const [products, setProducts] = useState<Product[]>([]);
  const [selectedProduct, setSelectedProduct] = useState<Product | null>(null);
  const [loading, setLoading] = useState(true);
  const [submitting, setSubmitting] = useState(false);
  const [deletingId, setDeletingId] = useState<number | null>(null);
  const [error, setError] = useState('');

  const totalStockValue = useMemo(
    () => products.reduce((total, product) => total + product.price * product.quantity, 0),
    [products],
  );

  const loadProducts = useCallback(async () => {
    setLoading(true);
    setError('');
    try {
      const data = await productService.getAll();
      setProducts(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to load products');
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    void loadProducts();
  }, [loadProducts]);

  async function handleSubmit(payload: ProductPayload) {
    setSubmitting(true);
    setError('');
    try {
      if (selectedProduct) {
        const updated = await productService.update(selectedProduct.id, payload);
        setProducts((current) => current.map((product) => (product.id === updated.id ? updated : product)));
        setSelectedProduct(null);
      } else {
        const created = await productService.create(payload);
        setProducts((current) => [...current, created]);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to save product');
    } finally {
      setSubmitting(false);
    }
  }

  async function handleDelete(id: number) {
    setDeletingId(id);
    setError('');
    try {
      await productService.delete(id);
      setProducts((current) => current.filter((product) => product.id !== id));
      if (selectedProduct?.id === id) {
        setSelectedProduct(null);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to delete product');
    } finally {
      setDeletingId(null);
    }
  }

  return (
    <main className="app-shell">
      <header className="topbar">
        <div>
          <p className="eyebrow">OOP Full-Stack Lab</p>
          <h1>Product Manager</h1>
        </div>
        <button className="secondary-button" type="button" onClick={loadProducts} disabled={loading}>
          <RefreshCcw size={18} />
          {loading ? 'Loading' : 'Refresh'}
        </button>
      </header>

      <section className="stats-band">
        <div>
          <span>Total products</span>
          <strong>{products.length}</strong>
        </div>
        <div>
          <span>Total quantity</span>
          <strong>{products.reduce((total, product) => total + product.quantity, 0)}</strong>
        </div>
        <div>
          <span>Stock value</span>
          <strong>
            {new Intl.NumberFormat('en-PH', { style: 'currency', currency: 'PHP' }).format(totalStockValue)}
          </strong>
        </div>
      </section>

      {error && <div className="error-banner">{error}</div>}

      <div className="content-grid">
        <ProductForm
          selectedProduct={selectedProduct}
          isSubmitting={submitting}
          onSubmit={handleSubmit}
          onCancelEdit={() => setSelectedProduct(null)}
        />
        <ProductList
          products={products}
          loading={loading}
          deletingId={deletingId}
          onEdit={setSelectedProduct}
          onDelete={handleDelete}
        />
      </div>
    </main>
  );
}
