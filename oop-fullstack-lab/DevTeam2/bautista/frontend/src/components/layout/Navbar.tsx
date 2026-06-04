import { Bell, Search } from "lucide-react";

function Navbar() {
  return (
    <header
      className="
        flex
        items-center
        justify-between
        gap-4
      "
    >
      <div>
        <h2 className="text-3xl font-bold">
          Dashboard
        </h2>

        <p className="mt-1 text-slate-400">
          Organize your workflow efficiently.
        </p>
      </div>

      <div className="flex items-center gap-4">
        
        <div
          className="
            flex
            items-center
            gap-3
            rounded-2xl
            border
            border-white/10
            bg-white/5
            px-4
            py-3
          "
        >
          <Search size={18} className="text-slate-400" />

          <input
            placeholder="Search tasks..."
            className="
              bg-transparent
              outline-none
              placeholder:text-slate-500
            "
          />
        </div>

        <button
          className="
            rounded-2xl
            border
            border-white/10
            bg-white/5
            p-4
            transition
            hover:bg-white/10
          "
        >
          <Bell size={20} />
        </button>

      </div>
    </header>
  );
}

export default Navbar;