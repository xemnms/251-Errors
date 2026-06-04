import { useEffect, useState } from "react";
import "./App.css";

const API = "http://localhost:8080/api";

function App() {
  const [products, setProducts] = useState([]);

  const [product, setProduct] = useState({
    name: "",
    description: "",
    price: "",
    quantity: "",
    category: ""
  });

  const loadProducts = () => {
    fetch(`${API}/products`)
      .then((res) => res.json())
      .then((data) => setProducts(data));
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const addProduct = async (e) => {
    e.preventDefault();

    await fetch(`${API}/products`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        ...product,
        price: Number(product.price),
        quantity: Number(product.quantity)
      })
    });

    setProduct({
      name: "",
      description: "",
      price: "",
      quantity: "",
      category: ""
    });

    loadProducts();
  };

  const deleteProduct = async (id) => {
    await fetch(`${API}/products/${id}`, {
      method: "DELETE"
    });

    loadProducts();
  };

  return (
    <main className="page">
      <section className="hero">
        <p className="brand">AJ'S</p>
        <h1>Welcome!</h1>
      </section>

      <section className="layout">
        <div className="panel">
          <p className="label">ADD PRODUCT</p>

          <form onSubmit={addProduct}>
            <input
              placeholder="Product Name"
              value={product.name}
              onChange={(e) =>
                setProduct({ ...product, name: e.target.value })
              }
            />

            <input
              placeholder="Description"
              value={product.description}
              onChange={(e) =>
                setProduct({ ...product, description: e.target.value })
              }
            />

            <input
              placeholder="Price"
              value={product.price}
              onChange={(e) =>
                setProduct({ ...product, price: e.target.value })
              }
            />

            <input
              placeholder="Quantity"
              value={product.quantity}
              onChange={(e) =>
                setProduct({ ...product, quantity: e.target.value })
              }
            />

            <input
              placeholder="Category"
              value={product.category}
              onChange={(e) =>
                setProduct({ ...product, category: e.target.value })
              }
            />

            <button type="submit">Add Product</button>
          </form>
        </div>

        <div className="panel">
          <div className="products-header">
            <div>
              <p className="label">PRODUCTS</p>
              <h2>Catalog</h2>
            </div>

            <span>{products.length} item/s</span>
          </div>

          <div className="products">
            {products.length === 0 ? (
              <div className="empty">
                No products yet.
              </div>
            ) : (
              products.map((p) => (
                <div className="product-card" key={p.id}>
                  <div>
                    <h3>{p.name}</h3>
                    <p>{p.description}</p>
                    <small>
                      ₱{p.price} · Qty {p.quantity} · {p.category}
                    </small>
                  </div>

                  <button
                    className="delete"
                    onClick={() => deleteProduct(p.id)}
                  >
                    Delete
                  </button>
                </div>
              ))
            )}
          </div>
        </div>
      </section>
    </main>
  );
}

export default App;
