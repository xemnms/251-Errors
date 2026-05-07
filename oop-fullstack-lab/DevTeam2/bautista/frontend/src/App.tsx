import {
  useMemo,
  useState,
} from "react";

import Sidebar from "./components/layout/Sidebar";
import Navbar from "./components/layout/Navbar";

import StatsCard from "./components/dashboard/StatsCard";

import TaskCard from "./components/tasks/TaskCard";
import FloatingButton from "./components/tasks/FloatingButton";
import EmptyState from "./components/tasks/EmptyState";
import FilterBar from "./components/tasks/FilterBar";
import TaskModal from "./components/tasks/TaskModal";

import {
  CheckCircle2,
  Clock3,
  ListTodo,
} from "lucide-react";

import { mockTasks } from "./lib/mockTasks";

import type { Task } from "./types/task";

function App() {

  const [tasks, setTasks] =
    useState<Task[]>(mockTasks);

  const [activeFilter, setActiveFilter] =
    useState("ALL");

  const [openModal, setOpenModal] =
    useState(false);

  const [
    editingTask,
    setEditingTask,
  ] = useState<Task | null>(null);

  const filteredTasks = useMemo(() => {

    if (activeFilter === "ALL") {
      return tasks;
    }

    return tasks.filter(
      (task) =>
        task.status === activeFilter
    );

  }, [tasks, activeFilter]);

  const handleCreateTask = (
    taskData: Omit<Task, "id">
  ) => {

    if (editingTask) {

      setTasks((prev) =>
        prev.map((task) =>
          task.id === editingTask.id
            ? {
                ...task,
                ...taskData,
              }
            : task
        )
      );

      setEditingTask(null);

      return;
    }

    const newTask: Task = {
      id: Date.now(),
      ...taskData,
    };

    setTasks((prev) => [
      newTask,
      ...prev,
    ]);
  };

  const handleDeleteTask = (
    id: number
  ) => {

    setTasks((prev) =>
      prev.filter(
        (task) => task.id !== id
      )
    );
  };

  const handleEditTask = (
    task: Task
  ) => {

    setEditingTask(task);

    setOpenModal(true);
  };

  return (
    <main className="flex min-h-screen">

      <Sidebar />

      <section className="flex-1 px-6 py-6 lg:px-10">

        <Navbar />

        <div
          className="
            mt-10
            grid
            gap-6
            md:grid-cols-3
          "
        >

          <StatsCard
            title="Total Tasks"
            value={String(tasks.length)}
            icon={<ListTodo />}
          />

          <StatsCard
            title="Completed"
            value={String(
              tasks.filter(
                (t) =>
                  t.status === "COMPLETED"
              ).length
            )}
            icon={<CheckCircle2 />}
          />

          <StatsCard
            title="Pending"
            value={String(
              tasks.filter(
                (t) =>
                  t.status === "PENDING"
              ).length
            )}
            icon={<Clock3 />}
          />

        </div>

        <section className="mt-10">

          <div
            className="
              mb-8
              flex
              flex-col
              gap-6
              lg:flex-row
              lg:items-center
              lg:justify-between
            "
          >

            <div>

              <h2 className="text-3xl font-bold">
                Task Workspace
              </h2>

              <p className="mt-2 text-slate-400">
                Manage and organize your productivity pipeline.
              </p>

            </div>

            <FilterBar
              activeFilter={activeFilter}
              setActiveFilter={
                setActiveFilter
              }
            />

          </div>

          {filteredTasks.length === 0 ? (

            <EmptyState />

          ) : (

            <div className="grid gap-6">

              {filteredTasks.map((task) => (

                <TaskCard
                  key={task.id}
                  task={task}
                  onDelete={
                    handleDeleteTask
                  }
                  onEdit={
                    handleEditTask
                  }
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
        open={openModal}
        onClose={() =>
          setOpenModal(false)
        }
        onSubmit={
          handleCreateTask
        }
        editingTask={
          editingTask
        }
      />

    </main>
  );
}

export default App;