import { Inbox } from "lucide-react";

function EmptyState() {
  return (
    <div
      className="
        flex
        flex-col
        items-center
        justify-center
        rounded-3xl
        border
        border-dashed
        border-white/10
        bg-white/[0.03]
        py-20
        text-center
      "
    >
      <div
        className="
          rounded-full
          bg-indigo-500/20
          p-6
          text-indigo-300
        "
      >
        <Inbox size={40} />
      </div>

      <h3 className="mt-6 text-2xl font-bold">
        No tasks found
      </h3>

      <p className="mt-3 max-w-md text-slate-400">
        Create your first task and start organizing your workflow efficiently.
      </p>
    </div>
  );
}

export default EmptyState;