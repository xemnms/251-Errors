import { Plus } from "lucide-react";

interface FloatingButtonProps {
  onClick: () => void;
}

function FloatingButton({
  onClick,
}: FloatingButtonProps) {
  return (
    <button
      onClick={onClick}
      className="
        fixed
        bottom-8
        right-8
        flex
        items-center
        gap-3
        rounded-2xl
        bg-indigo-500
        px-6
        py-4
        font-semibold
        shadow-2xl
        shadow-indigo-500/40
        transition-all
        duration-300
        hover:scale-105
        hover:bg-indigo-400
      "
    >
      <Plus size={20} />

      Add Task
    </button>
  );
}

export default FloatingButton;