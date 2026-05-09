import { useState, useEffect } from 'react';
import type {User} from './types/User';
import { getUsers, createUser, updateUser, deleteUser } from './api/userApi';
import UserForm from './components/UserForm';
import UserList from './components/UserList';
import './App.css';

function App() {
  const [users, setUsers] = useState<User[]>([]);
  const [editingUser, setEditingUser] = useState<User | undefined>(undefined);
  const [showForm, setShowForm] = useState(false);

  // Load all users from the backend when the page first opens
  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = () => {
    getUsers().then(setUsers);
  };

  const handleSubmit = (user: User) => {
    if (editingUser?.id) {
      updateUser(editingUser.id, user).then(() => {
        loadUsers();
        setEditingUser(undefined);
        setShowForm(false);
      });
    } else {
      createUser(user).then(() => {
        loadUsers();
        setShowForm(false);
      });
    }
  };

  const handleEdit = (user: User) => {
    setEditingUser(user);
    setShowForm(true);
  };

  const handleDelete = (id: number) => {
    deleteUser(id).then(loadUsers);
  };

  const handleCancel = () => {
    setEditingUser(undefined);
    setShowForm(false);
  };

  return (
    <div className="app">
      <h1>User Management</h1>

      {!showForm && (
        <button onClick={() => setShowForm(true)}>+ Add User</button>
      )}

      {showForm && (
        <UserForm
          onSubmit={handleSubmit}
          onCancel={handleCancel}
          existing={editingUser}
        />
      )}

      <UserList users={users} onEdit={handleEdit} onDelete={handleDelete} />
    </div>
  );
}

export default App;
