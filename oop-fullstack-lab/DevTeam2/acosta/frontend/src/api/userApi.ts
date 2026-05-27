import axios from 'axios';
import type {User} from '../types/User';

const BASE_URL = 'http://localhost:8080/api/users';

export const getUsers = () =>
  axios.get<User[]>(BASE_URL).then(res => res.data);

export const createUser = (user: User) =>
  axios.post<User>(BASE_URL, user).then(res => res.data);

export const updateUser = (id: number, user: User) =>
  axios.put<User>(`${BASE_URL}/${id}`, user).then(res => res.data);

export const deleteUser = (id: number) =>
  axios.delete(`${BASE_URL}/${id}`);
