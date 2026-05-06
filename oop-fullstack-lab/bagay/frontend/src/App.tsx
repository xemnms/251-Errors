import { EmployeeManager } from './components/employees/EmployeeManager';
import './App.css';

function App() {
  return (
    <main className="page">
      <header className="page-header">
        <h1>👥 Employee Management</h1>
      </header>
      <EmployeeManager />
    </main>
  );
}

export default App;
