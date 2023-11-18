import { inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { CustomerDataService } from './data-access/customer-data.service';
import { BankActions } from './bank.actions';
import { catchError, EMPTY, exhaustMap, map } from 'rxjs';

export const loadCustomersInfoEffect = createEffect(
  (actions$ = inject(Actions), customerService = inject(CustomerDataService)) =>
    actions$.pipe(
      ofType(BankActions.loadCustomers),
      exhaustMap(() =>
        customerService.fetchCustomers().pipe(
          map((customers) => BankActions.loadCustomersSuccess({ customers })),
          catchError(() => EMPTY),
        ),
      ),
    ),
  { functional: true },
);

export const loadCustomer = createEffect(
  (actions$ = inject(Actions), customerService = inject(CustomerDataService)) =>
    actions$.pipe(
      ofType(BankActions.loadCustomer),
      exhaustMap((action) =>
        customerService.fetchCustomer(action.id).pipe(
          map((customer) => BankActions.loadCustomerSuccess({ customer })),
          catchError(() => EMPTY),
        ),
      ),
    ),
  { functional: true },
);

export const createCustomer = createEffect(
  (actions$ = inject(Actions), customerService = inject(CustomerDataService)) =>
    actions$.pipe(
      ofType(BankActions.createCustomer),
      exhaustMap((action) =>
        customerService.createCustomer(action.customer).pipe(
          map((customer) => BankActions.createCustomerSuccess({ customer })),
          catchError(() => EMPTY),
        ),
      ),
    ),
  { functional: true },
);

export const createAccount = createEffect(
  (actions$ = inject(Actions), customerService = inject(CustomerDataService)) =>
    actions$.pipe(
      ofType(BankActions.createAccount),
      exhaustMap((action) =>
        customerService
          .createAccount(action.customerId, action.initialAmout)
          .pipe(
            map((account) => BankActions.createAccountSuccess({ account })),
            catchError(() => EMPTY),
          ),
      ),
    ),
  { functional: true },
);
