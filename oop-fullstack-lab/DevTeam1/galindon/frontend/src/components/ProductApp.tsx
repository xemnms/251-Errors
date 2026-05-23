import { useEffect, useMemo, useState } from "react";
import type { Product } from "../models/Product";
import {
  createProduct,
  deleteProduct,
  getProducts,
  updateProduct,
} from "../services/productService";

const emptyForm = (): Product => ({ name: "", price: 0 });

export default function ProductApp() {
  const [products, setProducts] = useState<Product[]>([]);
  const [form, setForm] = useState<Product>(emptyForm());
  const [editingId, setEditingId] = useState<number | null>(null);
  const [query, setQuery] = useState("");
  const [status, setStatus] = useState("Ready to browse and choose from our collection!");

  const loadProducts = async () => {
    try {
      const response = await getProducts();
      setProducts(response.data);
      setStatus(`Loaded ${response.data.length} products.`);
    } catch (error) {
      console.error(error);
      setStatus("Couldn’t reach the backend. Check that the Spring server is running.");
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const filteredProducts = useMemo(() => {
    const value = query.trim().toLowerCase();

    if (!value) {
      return products;
    }

    return products.filter((product) =>
      product.name.toLowerCase().includes(value)
    );
  }, [products, query]);

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    if (!form.name.trim()) {
      setStatus("Name your product before saving.");
      return;
    }

    try {
      if (editingId) {
        await updateProduct(editingId, form);
        setStatus(`Updated ${form.name}.`);
      } else {
        await createProduct(form);
        setStatus(`Added ${form.name} to the catalog.`);
      }

      setForm(emptyForm());
      setEditingId(null);
      await loadProducts();
    } catch (error) {
      console.error(error);
      setStatus("Save failed. Please try again.");
    }
  };

  const handleEdit = (product: Product) => {
    setForm({
      id: product.id,
      name: product.name,
      price: product.price,
    });
    setEditingId(product.id ?? null);
    setStatus(`Editing ${product.name}.`);
  };

  const handleDelete = async (product: Product) => {
    if (!product.id) {
      return;
    }

    try {
      await deleteProduct(product.id);
      setStatus(`Removed ${product.name}.`);
      await loadProducts();
    } catch (error) {
      console.error(error);
      setStatus("Delete failed. Please try again.");
    }
  };

  const formatter = new Intl.NumberFormat("en-PH", {
    style: "currency",
    currency: "PHP",
  });

  return (
    <main className="product-shell">
      <section className="hero-panel">
        <div>
          <p className="eyebrow">linet's boutique</p>
          <h1>Welcome!</h1>
          <p className="hero-copy">
            Browse and choose from our collection!
          </p>
          <div className="hero-actions">
            <a href="#catalog" className="primary-btn">
              Browse products
            </a>
            <span className="status-pill">{status}</span>
          </div>
        </div>
      </section>

      <section className="builder-grid">
        <form className="product-form" onSubmit={handleSubmit}>
          <div>
            <p className="eyebrow">{editingId ? "Edit product" : "Add product"}</p>
            <h2>{editingId ? "Update the details" : "Create a new product"}</h2>
          </div>

          <label>
            Product name
            <input
              type="text"
              value={form.name}
              onChange={(event) =>
                setForm((current) => ({ ...current, name: event.target.value }))
              }
              placeholder="e.g. Velvet Lamp"
            />
          </label>

          <label>
            Price
            <input
              type="number"
              min="0"
              step="0.01"
              value={form.price}
              onChange={(event) =>
                setForm((current) => ({
                  ...current,
                  price: Number(event.target.value),
                }))
              }
            />
          </label>

          <div className="form-actions">
            <button type="submit" className="primary-btn">
              {editingId ? "Save changes" : "Add product"}
            </button>
            {editingId ? (
              <button
                type="button"
                className="secondary-btn"
                onClick={() => {
                  setEditingId(null);
                  setForm(emptyForm());
                  setStatus("Draft cleared.");
                }}
              >
                Cancel
              </button>
            ) : null}
          </div>
        </form>

      </section>

      <section id="catalog" className="catalog-section">
        <div className="catalog-head">
          <div>
            <p className="eyebrow">Catalog</p>
            <h2>Product list</h2>
          </div>

          <label className="search-box">
            <span>Search</span>
            <input
              type="search"
              value={query}
              onChange={(event) => setQuery(event.target.value)}
              placeholder="Find a product"
            />
          </label>
        </div>

        {filteredProducts.length === 0 ? (
          <div className="empty-state">
            <p>No products match your search yet.</p>
          </div>
        ) : (
          <div className="product-grid">
            {filteredProducts.map((product) => (
              <article className="product-card" key={product.id ?? product.name}>
                <p className="eyebrow">#{product.id ?? "new"}</p>
                <h3>{product.name}</h3>
                <p className="price-tag">{formatter.format(product.price)}</p>
                <div className="card-actions">
                  <button
                    type="button"
                    className="secondary-btn"
                    onClick={() => handleEdit(product)}
                  >
                    Edit
                  </button>
                  <button
                    type="button"
                    className="danger-btn"
                    onClick={() => handleDelete(product)}
                  >
                    Delete
                  </button>
                </div>
              </article>
            ))}
          </div>
        )}
      </section>
    </main>
  );
}
