import { createReducer, on } from '@ngrx/store';
import { initialState } from './bank.state';
import { BankActions } from './bank.actions';

export const bankReducer = createReducer(
  initialState,
  on(BankActions.loadCustomersSuccess, (state, { customers }) => ({
    ...state,
    customers,
  })),
  on(BankActions.loadCustomerSuccess, (state, { customer }) => ({
    ...state,
    currentCustomer: customer,
  })),
  on(BankActions.createCustomerSuccess, (state, { customer }) => ({
    ...state,
    customers: [
      ...state.customers,
      {
        id: customer.id,
        firstName: customer.firstName,
        lastName: customer.lastName,
      },
    ],
  })),
  on(BankActions.loadAccount, (state, { accountId }) => ({
    ...state,
    currentAccountId: accountId,
  })),
  on(BankActions.createAccountSuccess, (state, { account }) => ({
    ...state,
    currentCustomer: {
      ...state.currentCustomer,
      accounts: [...state.currentCustomer.accounts, account],
    },
  })),
);
