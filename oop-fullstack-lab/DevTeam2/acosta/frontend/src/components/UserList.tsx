import type {User} from '../types/User';

interface Props {
  users: User[];
  onEdit: (user: User) => void;
  onDelete: (id: number) => void;
}

export default function UserList({ users, onEdit, onDelete }: Props) {
  if (users.length === 0) {
    return <p>No users yet. Add one above!</p>;
  }

  return (
    <table className="user-table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Email</th>
          <th>Phone</th>
          <th>Role</th>
          <th>Regular</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {users.map(user => (
          <tr key={user.id}>
            <td>{user.name}</td>
            <td>{user.email}</td>
            <td>{user.phoneNumber}</td>
            <td>{user.role}</td>
            <td>{user.regular ? 'Yes' : 'No'}</td>
            <td>
              <button onClick={() => onEdit(user)}>Edit</button>
              <button onClick={() => onDelete(user.id!)}>Delete</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}
