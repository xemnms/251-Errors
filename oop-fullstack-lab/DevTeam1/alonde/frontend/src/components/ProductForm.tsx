import { useState, useEffect } from 'react';
import { type Product, type ProductFormData } from '../types/product';

interface Props {
    onSubmit: (data: ProductFormData) => void;
    editingProduct?: Product | null;
    onCancel: () => void;
}

export default function ProductForm({ onSubmit, editingProduct, onCancel }: Props)
{

    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const [price, setPrice] = useState('');
    const [errors, setErrors] = useState<Record<string,string>>({});

    useEffect(() => {
        setTimeout(() => {
            if (editingProduct) {
                setName(editingProduct.name);
                setDescription(editingProduct.description);
                setPrice(editingProduct.price.toString());
            } else {
                setName('');
                setDescription('');
                setPrice('');
            }
        }, 0);
    }, [editingProduct]);

    function validate(): boolean {
        const e: Record<string,string> = {};
        if (!name.trim()) e.name = 'Name is required';
        if (!description.trim()) e.description = 'Description is required';
        if (!price || Number(price) <= 0) e.price = 'Price must be a positive number';
        setErrors(e);
        return Object.keys(e).length === 0;
    }

    function handleSubmit(e: React.FormEvent) {
        e.preventDefault();
        if (!validate()) return;
        onSubmit({ name, description, price: Number(price) });
        // Clear the form after submit
        setName(''); setDescription(''); setPrice(''); setErrors({});
    }

    return (
        <form onSubmit={handleSubmit} className="product-form">
            <h2>{editingProduct ? 'Edit Product' : 'Add New Product'}</h2>

            <label>Name</label>
            <input value={name} onChange={e => setName(e.target.value)} />
            {errors.name && <span className="error">{errors.name}</span>}

            <label>Description</label>
            <input value={description} onChange={e =>
                setDescription(e.target.value)} />
            {errors.description && <span
                className="error">{errors.description}</span>}

            <label>Price</label>
            <input type="number" step="0.01" value={price}
                   onChange={e => setPrice(e.target.value)} />
            {errors.price && <span className="error">{errors.price}</span>}

            <div className="form-buttons">
                <button type="submit">
                    {editingProduct ? 'Save Changes' : 'Add Product'}
                </button>
                {editingProduct && (
                    <button type="button" onClick={onCancel}>Cancel</button>
                )}
            </div>
        </form>
    );
}
