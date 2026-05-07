import { useEffect, useState } from 'react';
import { TaskForm } from './components/TaskForm';
import { TaskList } from './components/TaskList';
import { createTask, deleteTask, getTasks, updateTask } from './services/taskApi';
import type { Task, TaskPayload } from './types';

export default function App() {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [editingTask, setEditingTask] = useState<Task | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  async function loadTasks() {
    setLoading(true);
    setError('');

    try {
      setTasks(await getTasks());
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to load tasks');
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    void loadTasks();
  }, []);

  async function handleSubmit(payload: TaskPayload) {
    setError('');

    try {
      if (editingTask) {
        const updated = await updateTask(editingTask.id, payload);
        setTasks((current) => current.map((task) => (task.id === updated.id ? updated : task)));
        setEditingTask(null);
        return;
      }

      const created = await createTask(payload);
      setTasks((current) => [...current, created]);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to save task');
    }
  }

  async function handleDelete(id: number) {
    setError('');

    try {
      await deleteTask(id);
      setTasks((current) => current.filter((task) => task.id !== id));
      if (editingTask?.id === id) {
        setEditingTask(null);
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Unable to delete task');
    }
  }

  return (
    <main className="app-shell">
      <section className="page-header">
        <div>
          <h1>Task Manager</h1>
          <p>React, Spring Boot, and PostgreSQL CRUD lab</p>
        </div>
        <button type="button" className="secondary-button" onClick={() => void loadTasks()}>
          Refresh
        </button>
      </section>

      {error && <div className="error-banner">{error}</div>}

      <section className="workspace">
        <TaskForm editingTask={editingTask} onCancelEdit={() => setEditingTask(null)} onSubmit={handleSubmit} />
        <section className="list-panel">
          <h2>Tasks</h2>
          <TaskList tasks={tasks} loading={loading} onEdit={setEditingTask} onDelete={(id) => void handleDelete(id)} />
        </section>
      </section>
    </main>
  );
}
