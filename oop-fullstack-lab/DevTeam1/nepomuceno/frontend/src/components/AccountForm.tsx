import { useState } from 'react';
import type { Account } from '../types/Account';

interface Props {
    onSubmit: (a: Account) => void;
    initial?: Account;
    onCancel?: () => void;
}

export default function AccountForm({ onSubmit, initial, onCancel }: Props) {
    const [form, setForm] = useState<Account>(
        initial ?? { username: '', email: '', password: '', role: 'USER' }
    );

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    return (
        <form onSubmit={e => { e.preventDefault(); onSubmit(form); }}>
            <input name="username" value={form.username} onChange={handleChange} placeholder="Username" required />
            <input name="email" type="email" value={form.email} onChange={handleChange} placeholder="Email" required />
            <input name="password" type="password" value={form.password} onChange={handleChange} placeholder="Password" required />
            <select name="role" value={form.role} onChange={handleChange}>
                <option value="USER">USER</option>
                <option value="ADMIN">ADMIN</option>
            </select>
            <button type="submit">{initial ? 'Update Account' : 'Register'}</button>
            {onCancel && <button type="button" onClick={onCancel}>Cancel</button>}
        </form>
    );
}