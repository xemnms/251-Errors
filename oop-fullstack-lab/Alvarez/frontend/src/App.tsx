import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

interface Product {
  id?: number;
  name: string;
  price: number;
  quantity: number;
}

function App() {
  const [products, setProducts] = useState<Product[]>([]);
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [quantity, setQuantity] = useState("");
  const [editingId, setEditingId] = useState<number | null>(null);

  const API_URL = window.location.hostname.includes("-5173")
    ? `https://${window.location.hostname.replace("-5173", "-8080")}/products`
    : "http://localhost:8080/products";

  const fetchProducts = async () => {
    const response = await axios.get(API_URL);
    setProducts(response.data);
  };

  const clearForm = () => {
    setName("");
    setPrice("");
    setQuantity("");
    setEditingId(null);
  };

  const saveProduct = async () => {
    if (!name || !price || !quantity) return;

    const product = {
      name,
      price: Number(price),
      quantity: Number(quantity),
    };

    if (editingId) {
      await axios.put(`${API_URL}/${editingId}`, product);
    } else {
      await axios.post(API_URL, product);
    }

    await fetchProducts();
    clearForm();
  };

  const editProduct = (product: Product) => {
    setEditingId(product.id ?? null);
    setName(product.name);
    setPrice(String(product.price));
    setQuantity(String(product.quantity));
  };

  const deleteProduct = async (id?: number) => {
    if (!id) return;
    await axios.delete(`${API_URL}/${id}`);
    await fetchProducts();
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <main className="app">
      <section className="panel">
        <header className="header">
          <div>
            <p className="eyebrow">Inventory</p>
            <h1>Alvarez Products</h1>
          </div>
          <span className="status">Online</span>
        </header>

        <div className="form">
          <input
            placeholder="Product name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <input
            placeholder="Price"
            type="number"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
          />
          <input
            placeholder="Quantity"
            type="number"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
          <button className="primary" onClick={saveProduct}>
            {editingId ? "Update" : "Add"}
          </button>
          {editingId && (
            <button className="secondary" onClick={clearForm}>
              Cancel
            </button>
          )}
        </div>

        <div className="list-header">
          <h2>Products</h2>
          <span>{products.length} items</span>
        </div>

        <div className="products">
          {products.length === 0 ? (
            <div className="empty">No products yet.</div>
          ) : (
            products.map((product) => (
              <article className="card" key={product.id}>
                <div>
                  <h3>{product.name}</h3>
                  <p>Price: ₱{product.price}</p>
                  <p>Quantity: {product.quantity}</p>
                </div>

                <div className="actions">
                  <button onClick={() => editProduct(product)}>Edit</button>
                  <button className="danger" onClick={() => deleteProduct(product.id)}>
                    Delete
                  </button>
                </div>
              </article>
            ))
          )}
        </div>
      </section>
    </main>
  );
}

export default App;
