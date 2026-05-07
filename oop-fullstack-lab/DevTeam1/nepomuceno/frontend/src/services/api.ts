import axios from 'axios';
import type { Account } from '../types/Account';

const BASE_URL = 'http://localhost:8080/api/accounts';

export const getAllAccounts = ()                       => axios.get<Account[]>(BASE_URL);
export const createAccount  = (a: Account)             => axios.post<Account>(BASE_URL, a);
export const updateAccount  = (id: number, a: Account) => axios.put<Account>(`${BASE_URL}/${id}`, a);
export const deleteAccount  = (id: number)             => axios.delete(`${BASE_URL}/${id}`);