import {BankState, Customer} from "./bank.state";
import {createSelector} from "@ngrx/store";

export const selectCustomers = ({bank}: { bank: BankState }) => bank.customers;

export const selectCurrentCustomer = ({bank}: {
  bank: BankState
}) => bank.currentCustomer;

export const selectLoading = ({bank}: { bank: BankState }) => bank.loading;

export const selectCurrentAccounts = createSelector(selectCurrentCustomer,
  (state: Customer) => state?.accounts || [])
