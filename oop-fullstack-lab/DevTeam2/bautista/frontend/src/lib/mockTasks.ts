import type { Task } from "../types/task";

export const mockTasks: Task[] = [
  {
    id: 1,
    title: "Design dashboard UI",
    description:
      "Create a premium SaaS-inspired productivity dashboard interface.",
    status: "IN_PROGRESS",
    createdAt: "2 hours ago",
  },
  {
    id: 2,
    title: "Implement task filtering",
    description:
      "Allow users to filter tasks dynamically by status.",
    status: "PENDING",
    createdAt: "5 hours ago",
  },
  {
    id: 3,
    title: "Setup PostgreSQL schema",
    description:
      "Prepare production-ready relational database structure.",
    status: "COMPLETED",
    createdAt: "1 day ago",
  },
];