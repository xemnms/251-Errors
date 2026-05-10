import type { Task } from "../types/task";

const BASE_URL =
  "https://ubiquitous-doodle-v64xj56g4xxvcw6xx-8080.app.github.dev/api/tasks";

export const getTasks = async (): Promise<Task[]> => {
  const res = await fetch(BASE_URL);
  return res.json();
};

export const createTask = async (task: Omit<Task, "id">) => {
  const res = await fetch(BASE_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(task),
  });

  return res.json();
};

export const updateTask = async (id: number, task: Omit<Task, "id">) => {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(task),
  });

  return res.json();
};

export const deleteTask = async (id: number) => {
  await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE",
  });
};