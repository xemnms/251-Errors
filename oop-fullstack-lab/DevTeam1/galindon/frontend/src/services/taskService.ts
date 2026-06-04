import axios from "axios";

const BASE_URL = "http://localhost:8081/api/tasks";

export const getTasks = async () => {
    return await axios.get(BASE_URL);
};

export const createTask = async (task: any) => {
    return await axios.post(BASE_URL, task);
};

export const updateTask = async (id: number, task: any) => {
    return await axios.put(`${BASE_URL}/${id}`, task);
};

export const deleteTask = async (id: number) => {
    return await axios.delete(`${BASE_URL}/${id}`);
};