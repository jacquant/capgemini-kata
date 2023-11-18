import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Transaction } from '../../../store/bank.state';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-transaction-table',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './transaction-table.component.html',
  styleUrl: './transaction-table.component.scss',
})
export class TransactionTableComponent {
  @Input({ required: true }) transactions: Transaction[] = [];

  displayedColumns: string[] = [
    'id',
    'sourceId',
    'targetId',
    'amount',
    'createdDate',
  ];
}
