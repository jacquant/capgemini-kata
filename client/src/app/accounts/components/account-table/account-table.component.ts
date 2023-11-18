import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { Account } from '../../../store/bank.state';

@Component({
  selector: 'app-account-table',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './account-table.component.html',
  styleUrl: './account-table.component.scss',
})
export class AccountTableComponent {
  @Input({ required: true }) accounts: Account[] = [];
  @Input() selectedAccountId: number | null = null;

  @Output() selectAccountId = new EventEmitter<number>();

  displayedColumns: string[] = ['id', 'amount'];
}
