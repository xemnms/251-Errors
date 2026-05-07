import { Save, X } from 'lucide-react';
import { useEffect, useState } from 'react';
import type { FormEvent } from 'react';
import type { Product, ProductPayload } from '../types/Product';

interface ProductFormProps {
  selectedProduct: Product | null;
  isSubmitting: boolean;
  onSubmit: (payload: ProductPayload) => Promise<void>;
  onCancelEdit: () => void;
}

const emptyForm: ProductPayload = {
  name: '',
  description: '',
  price: 1,
  quantity: 0,
};

export default function ProductForm({
  selectedProduct,
  isSubmitting,
  onSubmit,
  onCancelEdit,
}: ProductFormProps) {
  const [formData, setFormData] = useState<ProductPayload>(emptyForm);
  const [formError, setFormError] = useState('');

  useEffect(() => {
    if (selectedProduct) {
      setFormData({
        name: selectedProduct.name,
        description: selectedProduct.description,
        price: selectedProduct.price,
        quantity: selectedProduct.quantity,
      });
    } else {
      setFormData(emptyForm);
    }
    setFormError('');
  }, [selectedProduct]);

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setFormError('');

    if (!formData.name.trim() || !formData.description.trim()) {
      setFormError('Name and description are required.');
      return;
    }

    if (formData.price <= 0) {
      setFormError('Price must be greater than zero.');
      return;
    }

    if (formData.quantity < 0) {
      setFormError('Quantity cannot be negative.');
      return;
    }

    await onSubmit({
      ...formData,
      name: formData.name.trim(),
      description: formData.description.trim(),
    });

    if (!selectedProduct) {
      setFormData(emptyForm);
    }
  }

  return (
    <form className="product-form" onSubmit={handleSubmit}>
      <div className="form-heading">
        <div>
          <p className="eyebrow">Inventory</p>
          <h2>{selectedProduct ? 'Update product' : 'Add product'}</h2>
        </div>
        {selectedProduct && (
          <button className="icon-button" type="button" onClick={onCancelEdit} aria-label="Cancel edit">
            <X size={18} />
          </button>
        )}
      </div>

      <label>
        Name
        <input
          value={formData.name}
          onChange={(event) => setFormData({ ...formData, name: event.target.value })}
          placeholder="Wireless Mouse"
          maxLength={120}
        />
      </label>

      <label>
        Description
        <textarea
          value={formData.description}
          onChange={(event) => setFormData({ ...formData, description: event.target.value })}
          placeholder="Compact mouse for daily productivity"
          maxLength={500}
          rows={4}
        />
      </label>

      <div className="form-grid">
        <label>
          Price
          <input
            type="number"
            min="0.01"
            step="0.01"
            value={formData.price}
            onChange={(event) => setFormData({ ...formData, price: Number(event.target.value) })}
          />
        </label>

        <label>
          Quantity
          <input
            type="number"
            min="0"
            step="1"
            value={formData.quantity}
            onChange={(event) => setFormData({ ...formData, quantity: Number(event.target.value) })}
          />
        </label>
      </div>

      {formError && <p className="inline-error">{formError}</p>}

      <button className="primary-button" type="submit" disabled={isSubmitting}>
        <Save size={18} />
        {isSubmitting ? 'Saving...' : selectedProduct ? 'Save changes' : 'Add product'}
      </button>
    </form>
  );
}
