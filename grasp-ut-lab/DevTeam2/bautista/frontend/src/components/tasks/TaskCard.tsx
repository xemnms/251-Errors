import GlassCard from "../ui/GlassCard";

import {
  Pencil,
  Trash2,
  Clock3,
} from "lucide-react";

import { motion } from "framer-motion";

import type { Task } from "../../types/task";

interface TaskCardProps {
  task: Task;
  onDelete: (id: number) => void;
  onEdit: (task: Task) => void;
}

function TaskCard({
  task,
  onDelete,
  onEdit,
}: TaskCardProps) {

  const statusStyles = {
    PENDING:
      "bg-yellow-500/20 text-yellow-300",

    IN_PROGRESS:
      "bg-blue-500/20 text-blue-300",

    COMPLETED:
      "bg-green-500/20 text-green-300",
  };

  return (
    <motion.div
      layout
      initial={{
        opacity: 0,
        y: 20,
      }}
      animate={{
        opacity: 1,
        y: 0,
      }}
      exit={{
        opacity: 0,
      }}
      transition={{
        duration: 0.3,
      }}
    >
      <GlassCard
        className="
          p-6
          transition-all
          duration-300
          hover:-translate-y-1
          hover:bg-white/10
        "
      >
        <div className="flex items-start justify-between">

          <div>

            <div
              className={`
                mb-4
                inline-flex
                rounded-full
                px-3
                py-1
                text-sm
                font-medium
                ${statusStyles[task.status]}
              `}
            >
              {task.status.replace("_", " ")}
            </div>

            <h3 className="text-2xl font-bold">
              {task.title}
            </h3>

            <p className="mt-3 max-w-md leading-relaxed text-slate-400">
              {task.description}
            </p>

          </div>

          <div className="flex gap-2">

            <button
              onClick={() =>
                onEdit(task)
              }
              className="
                rounded-xl
                bg-white/5
                p-3
                transition
                hover:bg-indigo-500
              "
            >
              <Pencil size={18} />
            </button>

            <button
              onClick={() =>
                onDelete(task.id)
              }
              className="
                rounded-xl
                bg-white/5
                p-3
                transition
                hover:bg-red-500
              "
            >
              <Trash2 size={18} />
            </button>

          </div>
        </div>

        <div
          className="
            mt-6
            flex
            items-center
            gap-2
            text-slate-500
          "
        >
          <Clock3 size={16} />

          <span className="text-sm text-slate-500">
            Created:{" "}
            {new Date(task.updatedAt || task.createdAt).toLocaleString(
              "en-PH",
              {
                timeZone: "Asia/Manila",
                dateStyle: "medium",
                timeStyle: "short",
              }
            )}
          </span>
        </div>

      </GlassCard>
    </motion.div>
  );
}

export default TaskCard;