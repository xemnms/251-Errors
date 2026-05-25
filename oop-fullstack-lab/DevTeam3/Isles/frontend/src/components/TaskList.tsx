import type { Task } from '../types';

interface TaskListProps {
  tasks: Task[];
  loading: boolean;
  onEdit: (task: Task) => void;
  onDelete: (id: number) => void;
}

export function TaskList({ tasks, loading, onEdit, onDelete }: TaskListProps) {
  if (loading) {
    return <p className="status-text">Loading tasks...</p>;
  }

  if (tasks.length === 0) {
    return <p className="status-text">No tasks yet.</p>;
  }

  return (
    <div className="task-list">
      {tasks.map((task) => (
        <article className="task-card" key={task.id}>
          <div>
            <div className="task-title-row">
              <h3>{task.title}</h3>
              <span className={task.completed ? 'badge done' : 'badge'}>{task.completed ? 'Done' : 'Open'}</span>
            </div>
            {task.description && <p>{task.description}</p>}
          </div>

          <div className="task-actions">
            <button type="button" className="secondary-button" onClick={() => onEdit(task)}>
              Edit
            </button>
            <button type="button" className="danger-button" onClick={() => onDelete(task.id)}>
              Delete
            </button>
          </div>
        </article>
      ))}
    </div>
  );
}
