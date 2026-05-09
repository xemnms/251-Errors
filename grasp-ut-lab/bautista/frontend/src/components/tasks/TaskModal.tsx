import { useState } from "react";
import { X } from "lucide-react";

import type { Task, TaskStatus } from "../../types/task";

interface TaskModalProps {
  open: boolean;
  onClose: () => void;
  onSubmit: (task: Omit<Task, "id">) => void;
  editingTask: Task | null;
}

function TaskModal({
  open,
  onClose,
  onSubmit,
  editingTask,
}: TaskModalProps) {

  // ✅ initialize ONCE only
  const [formData, setFormData] = useState({
    title: editingTask?.title ?? "",
    description: editingTask?.description ?? "",
    status: (editingTask?.status ?? "PENDING") as TaskStatus,
  });
  
  if (!open) return null;

  const handleChange = (
    field: keyof typeof formData,
    value: string
  ) => {
    setFormData((prev) => ({
      ...prev,
      [field]:
        field === "status"
          ? (value as TaskStatus)
          : value,
    }));
  };

  const handleSubmit = () => {
    if (!formData.title.trim()) return;

    onSubmit({
      title: formData.title,
      description: formData.description,
      status: formData.status,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    });

    onClose();
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/60">
      <div className="w-full max-w-xl rounded-3xl bg-[#0f172a] p-8 text-white">

        <div className="flex justify-between mb-6">
          <h2 className="text-2xl font-bold">
            {editingTask
              ? "Edit Task"
              : "Create Task"}
          </h2>

          <button onClick={onClose}>
            <X />
          </button>
        </div>

        <input
          value={formData.title}
          onChange={(e) =>
            handleChange(
              "title",
              e.target.value
            )
          }
          placeholder="Title"
          className="w-full p-3 mb-3 bg-white/10 rounded-xl"
        />

        <textarea
          value={formData.description}
          onChange={(e) =>
            handleChange(
              "description",
              e.target.value
            )
          }
          placeholder="Description"
          className="w-full p-3 mb-3 bg-white/10 rounded-xl"
        />

        <select
          value={formData.status}
          onChange={(e) =>
            handleChange(
              "status",
              e.target.value
            )
          }
          className="w-full p-3 mb-4 bg-white/10 rounded-xl"
        >
          <option
            value="PENDING"
            className="text-black"
          >
            PENDING
          </option>

          <option
            value="IN_PROGRESS"
            className="text-black"
          >
            IN PROGRESS
          </option>

          <option
            value="COMPLETED"
            className="text-black"
          >
            COMPLETED
          </option>
        </select>

        <button
          onClick={handleSubmit}
          className="w-full bg-indigo-500 p-3 rounded-xl"
        >
          {editingTask
            ? "Save Changes"
            : "Create Task"}
        </button>

      </div>
    </div>
  );
}

export default TaskModal;