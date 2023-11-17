import {createActionGroup, emptyProps, props} from "@ngrx/store";
import {Account, Customer, CustomerInfo} from "./bank.state";

export const BankActions = createActionGroup({
  source: 'Bank',
  events: {
    'Load Customers': emptyProps(),
    'Load Customers Success': props<{customers: CustomerInfo[]}>(),

    'Load Customer': props<{ id: number }>(),
    'Load Customer Success': props<{ customer: Customer }>(),

    'Create Customer': props<{ customer: Customer }>(),
    'Create Customer Success': props<{ customer: Customer }>(),

    'Create Account': props<{ customerId: number, initialAmout: number }>(),
    'Create Account Success': props<{ account: Account}>(),
  },
})
