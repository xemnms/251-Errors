import type { ReactNode } from "react";
import clsx from "clsx";

interface GlassCardProps {
  children: ReactNode;
  className?: string;
}

function GlassCard({
  children,
  className,
}: GlassCardProps) {
  return (
    <div
      className={clsx(
        `
        rounded-3xl
        border border-white/10
        bg-white/5
        backdrop-blur-xl
        shadow-2xl
        `,
        className
      )}
    >
      {children}
    </div>
  );
}

export default GlassCard;