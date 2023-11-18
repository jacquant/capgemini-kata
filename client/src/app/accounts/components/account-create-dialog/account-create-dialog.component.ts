import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle,
} from '@angular/material/dialog';
import { CustomerCreateDialogComponent } from '../../../customers/components/customer-create-dialog/customer-create-dialog.component';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';

export type CreateAccountDialogData = {
  amount: number;
};

@Component({
  selector: 'app-account-create-dialog',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogTitle,
    MatDialogContent,
    MatInputModule,
    FormsModule,
    MatDialogActions,
    MatButtonModule,
    MatDialogClose,
  ],
  templateUrl: './account-create-dialog.component.html',
  styleUrl: './account-create-dialog.component.scss',
})
export class AccountCreateDialogComponent {
  amount = 0;

  constructor(public dialogRef: MatDialogRef<CustomerCreateDialogComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
