import { Component, DestroyRef, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatExpansionModule } from '@angular/material/expansion';
import { Store } from '@ngrx/store';
import { MatDialog } from '@angular/material/dialog';
import { Subject, takeUntil } from 'rxjs';
import { toSignal } from '@angular/core/rxjs-interop';
import {
  selectCurrentAccountId,
  selectCurrentAccounts,
  selectCurrentCustomer,
  selectCurrentTransaction,
} from '../store/bank.selector';
import { AccountTableComponent } from './components/account-table/account-table.component';
import { BankActions } from '../store/bank.actions';
import {
  AccountCreateDialogComponent,
  CreateAccountDialogData,
} from './components/account-create-dialog/account-create-dialog.component';
import { CustomerTableComponent } from '../customers/components/customer-table/customer-table.component';
import { MatButtonModule } from '@angular/material/button';
import { TransactionTableComponent } from './components/transaction-table/transaction-table.component';

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [
    CommonModule,
    MatExpansionModule,
    AccountTableComponent,
    CustomerTableComponent,
    MatButtonModule,
    TransactionTableComponent,
  ],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.scss',
})
export class AccountsComponent implements OnInit {
  #store = inject(Store);
  accounts = toSignal(this.#store.select(selectCurrentAccounts), {
    initialValue: [],
  });
  selectedAccountId = toSignal(this.#store.select(selectCurrentAccountId), {
    initialValue: null,
  });
  selectedCustomer = toSignal(this.#store.select(selectCurrentCustomer), {
    initialValue: null,
  });
  transactions = toSignal(this.#store.select(selectCurrentTransaction), {
    initialValue: [],
  });

  #dialog = inject(MatDialog);
  #destroyRef = inject(DestroyRef);
  #destroyed = new Subject<boolean>();

  ngOnInit(): void {
    this.#destroyRef.onDestroy(() => {
      this.#destroyed.next(true);
      this.#destroyed.complete();
    });
  }

  selectAccount(accountId: number) {
    this.#store.dispatch(BankActions.loadAccount({ accountId }));
  }

  addAccount() {
    const dialogRef = this.#dialog.open(AccountCreateDialogComponent);

    dialogRef
      .afterClosed()
      .pipe(takeUntil(this.#destroyed))
      .subscribe((result: CreateAccountDialogData) => {
        this.#store.dispatch(
          BankActions.createAccount({
            initialAmout: result.amount,
            customerId: this.selectedCustomer()!.id,
          }),
        );
      });
  }
}
