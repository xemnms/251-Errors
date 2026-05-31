import { type Product } from '../types/product';

interface Props {
    products: Product[];
    onEdit: (product: Product) => void;
    onDelete: (id: number) => void;
}
export default function ProductList({ products, onEdit, onDelete }: Props) {
    if (products.length === 0) {
        return <p className="empty">No products yet. Add one above!</p>;
    }
    return (
        <table className="product-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {products.map(p => (
                <tr key={p.id}>
                    <td>{p.id}</td>
                    <td>{p.name}</td>
                    <td>{p.description}</td>
                    <td>₱{p.price.toFixed(2)}</td>
                    <td>
                        <button onClick={() => onEdit(p)}>Edit</button>
                        <button onClick={() => onDelete(p.id)}>Delete</button>
                    </td>
                </tr>
            ))}
            </tbody>
        </table>
    );
}
