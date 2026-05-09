import GlassCard from "../ui/GlassCard";
import type { ReactNode } from "react";

interface StatsCardProps {
  title: string;
  value: string;
  icon: ReactNode;
}

function StatsCard({
  title,
  value,
  icon,
}: StatsCardProps) {
  return (
    <GlassCard className="p-6">
      
      <div className="flex items-start justify-between">
        
        <div>
          <p className="text-slate-400">
            {title}
          </p>

          <h2 className="mt-4 text-5xl font-black">
            {value}
          </h2>
        </div>

        <div
          className="
            rounded-2xl
            bg-indigo-500/20
            p-4
            text-indigo-300
          "
        >
          {icon}
        </div>

      </div>

    </GlassCard>
  );
}

export default StatsCard;