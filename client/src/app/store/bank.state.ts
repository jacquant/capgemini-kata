
export type Transaction = {
  id: number;
  sourceId?: number;
  targetId: number;
  amount: number;
  createdDate: string;
}

export type Account = {
  id: number;
  amount: number;
  inTransactions: Transaction[];
  outTransactions: Transaction[];
}

export type CustomerInfo = {
  id: number;
  firstName: string;
  lastName: string;
}

export type Customer  = {
  id: number;
  firstName: string;
  lastName: string;
  balance: number;
  accounts: Account[];
}

export type BankState = {
  customers: CustomerInfo[];
  currentCustomer: Customer;
  loading: boolean;
}

export const initialState: BankState = {
  customers: [],
  currentCustomer: null!,
  loading: false,
}
