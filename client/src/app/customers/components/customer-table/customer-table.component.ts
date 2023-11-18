import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { CustomerInfo } from '../../../store/bank.state';

@Component({
  selector: 'app-customer-table',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './customer-table.component.html',
  styleUrl: './customer-table.component.scss',
})
export class CustomerTableComponent {
  @Input({ required: true }) customers: CustomerInfo[] = [];
  @Input() selectedCustomer: CustomerInfo | null = null;

  @Output() selectedCustomerId = new EventEmitter<number>();

  displayedColumns: string[] = ['id', 'lastName', 'firstName'];
}
