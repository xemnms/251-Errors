import { useEffect, useState } from 'react';
import type { Account } from './types/Account';
import { getAllAccounts, createAccount, updateAccount, deleteAccount } from './services/api';
import AccountForm from './components/AccountForm';

export default function App() {
  const [accounts, setAccounts] = useState<Account[]>([]);
  const [editing, setEditing]   = useState<Account | null>(null);
  const [loading, setLoading]   = useState(false);
  const [error, setError]       = useState('');

  const fetchAll = async () => {
    setLoading(true);
    try {
      const res = await getAllAccounts();
      setAccounts(res.data);
    } catch (err) {
      setError('Could not connect to backend. Is Spring Boot running?');
    }
    setLoading(false);
  };

  useEffect(() => { void fetchAll(); }, []);

  const handleCreate = async (a: Account) => {
    try {
      await createAccount(a);
      setError('');
      void fetchAll();
    } catch (err: any) {
      setError(err.response?.data || 'Failed to create account.');
    }
  };

  const handleUpdate = async (a: Account) => {
    try {
      if (editing?.id) await updateAccount(editing.id, a);
      setEditing(null);
      setError('');
      void fetchAll();
    } catch (err: any) {
      setError(err.response?.data || 'Failed to update account.');
    }
  };

  const handleDelete = async (id: number) => {
    await deleteAccount(id);
    void fetchAll();
  };

  return (
      <div>
        <h1>Account Manager</h1>

        {error && <p style={{ color: 'red' }}>{error}</p>}

        {editing
            ? <AccountForm initial={editing} onSubmit={handleUpdate} onCancel={() => setEditing(null)} />
            : <AccountForm onSubmit={handleCreate} />
        }

        {loading && <p>Loading...</p>}

        <ul>
          {accounts.map(a => (
              <li key={a.id}>
                <strong>{a.username}</strong> — {a.email} — {a.role}
                <button onClick={() => setEditing(a)}>Edit</button>
                <button onClick={() => handleDelete(a.id!)}>Delete</button>
              </li>
          ))}
        </ul>
      </div>
  );
}