import {
  LayoutDashboard,
  CheckSquare,
  BarChart3,
  Settings,
} from "lucide-react";

const items = [
  {
    icon: LayoutDashboard,
    label: "Dashboard",
    active: true,
  },
  {
    icon: CheckSquare,
    label: "Tasks",
  },
  {
    icon: BarChart3,
    label: "Analytics",
  },
  {
    icon: Settings,
    label: "Settings",
  },
];

function Sidebar() {
  return (
    <aside
      className="
        hidden
        lg:flex
        w-72
        flex-col
        border-r
        border-white/10
        bg-black/20
        backdrop-blur-2xl
      "
    >
      <div className="px-8 py-10">
        <p className="text-sm uppercase tracking-[0.3em] text-indigo-400">
          Productivity
        </p>

        <h1 className="mt-3 text-4xl font-black">
          FlowState
        </h1>
      </div>

      <nav className="flex-1 px-4">
        {items.map((item) => {
          const Icon = item.icon;

          return (
            <button
              key={item.label}
              className={`
                mb-2
                flex
                w-full
                items-center
                gap-4
                rounded-2xl
                px-5
                py-4
                transition-all
                duration-300
                ${
                  item.active
                    ? "bg-indigo-500 text-white shadow-lg shadow-indigo-500/30"
                    : "text-slate-400 hover:bg-white/5 hover:text-white"
                }
              `}
            >
              <Icon size={22} />
              <span className="font-medium">
                {item.label}
              </span>
            </button>
          );
        })}
      </nav>
    </aside>
  );
}

export default Sidebar;