import { useEffect, useState } from 'react';
import type { Task, TaskPayload } from '../types';

interface TaskFormProps {
  editingTask: Task | null;
  onCancelEdit: () => void;
  onSubmit: (task: TaskPayload) => Promise<void>;
}

const emptyForm: TaskPayload = {
  title: '',
  description: '',
  completed: false,
};

export function TaskForm({ editingTask, onCancelEdit, onSubmit }: TaskFormProps) {
  const [form, setForm] = useState<TaskPayload>(emptyForm);
  const [saving, setSaving] = useState(false);

  useEffect(() => {
    if (editingTask) {
      setForm({
        title: editingTask.title,
        description: editingTask.description,
        completed: editingTask.completed,
      });
      return;
    }

    setForm(emptyForm);
  }, [editingTask]);

  async function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setSaving(true);

    try {
      await onSubmit(form);
      if (!editingTask) {
        setForm(emptyForm);
      }
    } finally {
      setSaving(false);
    }
  }

  return (
    <form className="task-form" onSubmit={handleSubmit}>
      <div className="form-header">
        <h2>{editingTask ? 'Update Task' : 'Add Task'}</h2>
        {editingTask && (
          <button type="button" className="secondary-button" onClick={onCancelEdit}>
            Cancel
          </button>
        )}
      </div>

      <label>
        Title
        <input
          value={form.title}
          onChange={(event) => setForm({ ...form, title: event.target.value })}
          placeholder="Enter task title"
          required
        />
      </label>

      <label>
        Description
        <textarea
          value={form.description}
          onChange={(event) => setForm({ ...form, description: event.target.value })}
          placeholder="Enter task details"
          rows={4}
        />
      </label>

      <label className="checkbox-row">
        <input
          type="checkbox"
          checked={form.completed}
          onChange={(event) => setForm({ ...form, completed: event.target.checked })}
        />
        Completed
      </label>

      <button className="primary-button" type="submit" disabled={saving}>
        {saving ? 'Saving...' : editingTask ? 'Save Changes' : 'Add Task'}
      </button>
    </form>
  );
}
