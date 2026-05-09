const filters = [
  "ALL",
  "PENDING",
  "IN_PROGRESS",
  "COMPLETED",
];

interface FilterBarProps {
  activeFilter: string;
  setActiveFilter: (
    filter: string
  ) => void;
}

function FilterBar({
  activeFilter,
  setActiveFilter,
}: FilterBarProps) {
  return (
    <div className="flex flex-wrap gap-3">

      {filters.map((filter) => (

        <button
          key={filter}
          onClick={() =>
            setActiveFilter(filter)
          }
          className={`
            rounded-2xl
            px-5
            py-3
            text-sm
            font-medium
            transition-all
            duration-300

            ${
              activeFilter === filter
                ? "bg-indigo-500 text-white shadow-lg shadow-indigo-500/30"
                : "bg-white/5 text-slate-400 hover:bg-white/10 hover:text-white"
            }
          `}
        >
          {filter.replace("_", " ")}
        </button>

      ))}

    </div>
  );
}

export default FilterBar;