import { EmployeeManager } from './components/employees/EmployeeManager';
import './App.css';

function App() {
  return (
    <main className="page">
      <header className="page-header">
        <h1>Employee Management</h1>
        <p>Connected to Spring Boot Employee REST API.</p>
      </header>
      <EmployeeManager />
    </main>
  );
}

export default App;
