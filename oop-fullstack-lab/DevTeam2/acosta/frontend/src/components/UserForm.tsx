import { useState, useEffect } from 'react';
import type {User} from '../types/User';

interface Props {
  onSubmit: (user: User) => void;
  onCancel: () => void;
  existing?: User;
}

const empty: User = { name: '', email: '', phoneNumber: '', regular: false, role: '' };

export default function UserForm({ onSubmit, onCancel, existing }: Props) {
  const [form, setForm] = useState<User>(empty);

  // When editing, pre-fill the form with the existing user's data
  useEffect(() => {
    setForm(existing ?? empty);
  }, [existing]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, type, checked } = e.target;
    setForm(prev => ({ ...prev, [name]: type === 'checkbox' ? checked : value }));
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    onSubmit(form);
    setForm(empty);
  };

  return (
    <form onSubmit={handleSubmit} className="user-form">
      <h2>{existing ? 'Edit User' : 'Add User'}</h2>
      <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
      <input name="email" placeholder="Email" value={form.email} onChange={handleChange} required />
      <input name="phoneNumber" placeholder="Phone Number" value={form.phoneNumber} onChange={handleChange} />
      <input name="role" placeholder="Role" value={form.role} onChange={handleChange} />
      <label>
        <input name="regular" type="checkbox" checked={form.regular} onChange={handleChange} />
        Regular user
      </label>
      <div className="form-buttons">
        <button type="submit">{existing ? 'Update' : 'Add'}</button>
        <button type="button" onClick={onCancel}>Cancel</button>
      </div>
    </form>
  );
}
