import { Edit3, PackageOpen, Trash2 } from 'lucide-react';
import type { Product } from '../types/Product';

interface ProductListProps {
  products: Product[];
  loading: boolean;
  deletingId: number | null;
  onEdit: (product: Product) => void;
  onDelete: (id: number) => Promise<void>;
}

const moneyFormatter = new Intl.NumberFormat('en-PH', {
  style: 'currency',
  currency: 'PHP',
});

export default function ProductList({ products, loading, deletingId, onEdit, onDelete }: ProductListProps) {
  if (loading) {
    return (
      <section className="list-panel">
        <div className="skeleton-row" />
        <div className="skeleton-row" />
        <div className="skeleton-row" />
      </section>
    );
  }

  if (products.length === 0) {
    return (
      <section className="empty-state">
        <PackageOpen size={44} />
        <h2>No products yet</h2>
        <p>Add the first product to start the inventory list.</p>
      </section>
    );
  }

  return (
    <section className="list-panel">
      <div className="list-header">
        <h2>Products</h2>
        <span>{products.length} item{products.length === 1 ? '' : 's'}</span>
      </div>

      <div className="table-wrap">
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Price</th>
              <th>Qty</th>
              <th>Updated</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id}>
                <td className="name-cell">{product.name}</td>
                <td>{product.description}</td>
                <td>{moneyFormatter.format(product.price)}</td>
                <td>{product.quantity}</td>
                <td>{new Date(product.updatedAt).toLocaleString()}</td>
                <td>
                  <div className="row-actions">
                    <button className="icon-button" type="button" onClick={() => onEdit(product)} aria-label="Edit product">
                      <Edit3 size={17} />
                    </button>
                    <button
                      className="icon-button danger"
                      type="button"
                      onClick={() => onDelete(product.id)}
                      disabled={deletingId === product.id}
                      aria-label="Delete product"
                    >
                      <Trash2 size={17} />
                    </button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </section>
  );
}
