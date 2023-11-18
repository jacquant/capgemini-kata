import { Account, BankState, Customer } from './bank.state';
import { createSelector } from '@ngrx/store';

export const selectCustomers = ({ bank }: { bank: BankState }) =>
  bank.customers;

export const selectCurrentCustomer = ({ bank }: { bank: BankState }) =>
  bank.currentCustomer;

export const selectLoading = ({ bank }: { bank: BankState }) => bank.loading;

export const selectCurrentAccounts = createSelector(
  selectCurrentCustomer,
  (state: Customer) => state?.accounts || [],
);

export const selectCurrentAccountId = ({ bank }: { bank: BankState }) =>
  bank.currentAccountId;

export const selectCurrentAccount = createSelector(
  selectCurrentAccounts,
  selectCurrentAccountId,
  (accounts, id) => accounts.find((a) => a.id === id) || null,
);

export const selectCurrentTransaction = createSelector(
  selectCurrentAccount,
  (account: Account | null) => {
    if (account) {
      return (
        [...account.inTransactions, ...account.outTransactions]
          // @ts-expect-error date comparison is valid
          .sort((a, b) => new Date(b.createdDate) - new Date(a.createdDate))
      );
    }
    return [];
  },
);
