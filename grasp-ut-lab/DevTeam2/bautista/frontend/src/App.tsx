import { useEffect, useMemo, useState } from "react";

import Sidebar from "./components/layout/Sidebar";
import Navbar from "./components/layout/Navbar";

import StatsCard from "./components/dashboard/StatsCard";
import TaskCard from "./components/tasks/TaskCard";
import FloatingButton from "./components/tasks/FloatingButton";
import EmptyState from "./components/tasks/EmptyState";
import FilterBar from "./components/tasks/FilterBar";
import TaskModal from "./components/tasks/TaskModal";

import { CheckCircle2, Clock3, ListTodo } from "lucide-react";

import type { Task } from "./types/task";

import {
  getTasks,
  createTask,
  updateTask,
  deleteTask,
} from "./services/api";

function App() {
  const [tasks, setTasks] = useState<Task[]>([]);
  const [activeFilter, setActiveFilter] = useState("ALL");
  const [openModal, setOpenModal] = useState(false);
  const [editingTask, setEditingTask] = useState<Task | null>(null);

  // LOAD TASKS
  useEffect(() => {
    const load = async () => {
      const data = await getTasks();
      setTasks(data);
    };

    load();
  }, []);

  // FILTER
  const filteredTasks = useMemo(() => {
    if (activeFilter === "ALL") return tasks;
    return tasks.filter((t) => t.status === activeFilter);
  }, [tasks, activeFilter]);

  // CREATE / UPDATE
const handleSubmitTask = async (taskData: Omit<Task, "id">) => {
  if (editingTask) {
    await updateTask(editingTask.id, taskData);

    // 🔥 ALWAYS re-sync from backend
    const refreshed = await getTasks();
    setTasks(refreshed);

    setEditingTask(null);
    setOpenModal(false);
    return;
  }

  const newTask = await createTask(taskData);
  setTasks((prev) => [newTask, ...prev]);
  setOpenModal(false);
};

  // DELETE
  const handleDeleteTask = async (id: number) => {
    await deleteTask(id);
    setTasks((prev) => prev.filter((t) => t.id !== id));
  };

  // EDIT
  const handleEditTask = (task: Task) => {
    setEditingTask(task);
    setOpenModal(true);
  };

  return (
    <main className="flex min-h-screen">
      <Sidebar />

      <section className="flex-1 px-6 py-6 lg:px-10">
        <Navbar />

        {/* STATS */}
        <div className="mt-10 grid gap-6 md:grid-cols-3">
          <StatsCard
            title="Total Tasks"
            value={String(tasks.length)}
            icon={<ListTodo />}
          />

          <StatsCard
            title="Completed"
            value={String(tasks.filter((t) => t.status === "COMPLETED").length)}
            icon={<CheckCircle2 />}
          />

          <StatsCard
            title="Pending"
            value={String(tasks.filter((t) => t.status === "PENDING").length)}
            icon={<Clock3 />}
          />
        </div>

        {/* HEADER */}
        <section className="mt-10">
          <div className="mb-8 flex flex-col gap-6 lg:flex-row lg:items-center lg:justify-between">
            <div>
              <h2 className="text-3xl font-bold">Task Workspace</h2>
              <p className="mt-2 text-slate-400">
                Manage and organize your productivity pipeline.
              </p>
            </div>

            <FilterBar
              activeFilter={activeFilter}
              setActiveFilter={setActiveFilter}
            />
          </div>

          {/* TASKS */}
          {filteredTasks.length === 0 ? (
            <EmptyState />
          ) : (
            <div className="grid gap-6">
              {filteredTasks.map((task) => (
                <TaskCard
                  key={task.id}
                  task={task}
                  onDelete={handleDeleteTask}
                  onEdit={handleEditTask}
                />
              ))}
            </div>
          )}
        </section>
      </section>

      <FloatingButton
        onClick={() => {
          setEditingTask(null);
          setOpenModal(true);
        }}
      />

      <TaskModal
        key={editingTask?.id ?? "new"}
        open={openModal}
        onClose={() => setOpenModal(false)}
        onSubmit={handleSubmitTask}
        editingTask={editingTask}
      />
    </main>
  );
}

export default App;