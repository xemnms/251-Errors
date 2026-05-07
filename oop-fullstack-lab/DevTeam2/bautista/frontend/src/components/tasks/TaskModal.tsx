import { useState } from "react";

import { X } from "lucide-react";

import type {
  Task,
  TaskStatus,
} from "../../types/task";

interface TaskModalProps {
  open: boolean;

  onClose: () => void;

  onSubmit: (
    task: Omit<Task, "id">
  ) => void;

  editingTask: Task | null;
}

function TaskModal({
  open,
  onClose,
  onSubmit,
  editingTask,
}: TaskModalProps) {

  const [formData, setFormData] =
    useState({
      title: "",
      description: "",
      status: "PENDING" as TaskStatus,
    });

  if (!open) return null;

  const currentData = editingTask
    ? {
        title: editingTask.title,
        description:
          editingTask.description,
        status: editingTask.status,
      }
    : formData;

  const handleChange = (
    field: string,
    value: string
  ) => {

    setFormData((prev) => ({
      ...prev,
      [field]: value,
    }));
  };

  const handleSubmit = () => {

    if (!currentData.title.trim())
      return;

    onSubmit({
      title: currentData.title,
      description:
        currentData.description,
      status: currentData.status,
      createdAt: "Just now",
    });

    setFormData({
      title: "",
      description: "",
      status: "PENDING",
    });

    onClose();
  };

  return (
    <div
      className="
        fixed
        inset-0
        z-50
        flex
        items-center
        justify-center
        bg-black/60
        backdrop-blur-sm
      "
    >
      <div
        className="
          w-full
          max-w-xl
          rounded-3xl
          border
          border-white/10
          bg-[#0f172a]
          p-8
          shadow-2xl
        "
      >

        <div className="mb-8 flex items-center justify-between">

          <div>

            <h2 className="text-3xl font-bold">
              {editingTask
                ? "Edit Task"
                : "Create Task"}
            </h2>

            <p className="mt-2 text-slate-400">
              Manage your productivity workflow.
            </p>

          </div>

          <button
            onClick={onClose}
            className="
              rounded-xl
              bg-white/5
              p-3
              hover:bg-white/10
            "
          >
            <X size={20} />
          </button>

        </div>

        <div className="space-y-5">

          <input
            value={currentData.title}
            onChange={(e) =>
              handleChange(
                "title",
                e.target.value
              )
            }
            placeholder="Task title"
            className="
              w-full
              rounded-2xl
              border
              border-white/10
              bg-white/5
              px-5
              py-4
              outline-none
              transition
              focus:border-indigo-500
            "
          />

          <textarea
            value={
              currentData.description
            }
            onChange={(e) =>
              handleChange(
                "description",
                e.target.value
              )
            }
            placeholder="Task description"
            rows={5}
            className="
              w-full
              rounded-2xl
              border
              border-white/10
              bg-white/5
              px-5
              py-4
              outline-none
              transition
              focus:border-indigo-500
            "
          />

          <select
            value={currentData.status}
            onChange={(e) =>
              handleChange(
                "status",
                e.target.value
              )
            }
            className="
              w-full
              rounded-2xl
              border
              border-white/10
              bg-white/5
              px-5
              py-4
              outline-none
              focus:border-indigo-500
            "
          >

            <option value="PENDING">
              PENDING
            </option>

            <option value="IN_PROGRESS">
              IN PROGRESS
            </option>

            <option value="COMPLETED">
              COMPLETED
            </option>

          </select>

          <button
            onClick={handleSubmit}
            className="
              w-full
              rounded-2xl
              bg-indigo-500
              py-4
              font-semibold
              transition
              hover:bg-indigo-400
            "
          >
            {editingTask
              ? "Save Changes"
              : "Create Task"}
          </button>

        </div>

      </div>
    </div>
  );
}

export default TaskModal;