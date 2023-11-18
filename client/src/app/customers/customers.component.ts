import { Component, DestroyRef, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { CustomerTableComponent } from './components/customer-table/customer-table.component';
import { Store } from '@ngrx/store';
import { toSignal } from '@angular/core/rxjs-interop';
import { selectCurrentCustomer, selectCustomers } from '../store/bank.selector';
import { BankActions } from '../store/bank.actions';
import { MatDialog } from '@angular/material/dialog';
import {
  CreateCustomerDialogData,
  CustomerCreateDialogComponent,
} from './components/customer-create-dialog/customer-create-dialog.component';
import { MatButtonModule } from '@angular/material/button';
import { Subject, takeUntil } from 'rxjs';

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    CustomerTableComponent,
    MatButtonModule,
  ],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.scss',
})
export class CustomersComponent implements OnInit {
  #store = inject(Store);
  customers = toSignal(this.#store.select(selectCustomers), {
    initialValue: [],
  });
  selectedCustomer = toSignal(this.#store.select(selectCurrentCustomer), {
    initialValue: null,
  });
  #dialog = inject(MatDialog);
  #destroyRef = inject(DestroyRef);
  #destroyed = new Subject<boolean>();

  ngOnInit(): void {
    this.#store.dispatch(BankActions.loadCustomers());
    this.#destroyRef.onDestroy(() => {
      this.#destroyed.next(true);
      this.#destroyed.complete();
    });
  }

  selectCustomer(id: number) {
    this.#store.dispatch(BankActions.loadCustomer({ id }));
  }

  addCustomer() {
    const dialogRef = this.#dialog.open(CustomerCreateDialogComponent);

    dialogRef
      .afterClosed()
      .pipe(takeUntil(this.#destroyed))
      .subscribe((result: CreateCustomerDialogData) => {
        this.#store.dispatch(BankActions.createCustomer({ customer: result }));
      });
  }
}
