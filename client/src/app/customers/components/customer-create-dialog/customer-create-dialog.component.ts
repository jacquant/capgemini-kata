import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle,
} from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';

export type CreateCustomerDialogData = {
  lastName: string;
  firstName: string;
};

@Component({
  selector: 'app-customer-create-dialog',
  standalone: true,
  imports: [
    CommonModule,
    MatDialogTitle,
    MatDialogContent,
    MatInputModule,
    FormsModule,
    MatDialogActions,
    MatDialogClose,
    MatButtonModule,
  ],
  templateUrl: './customer-create-dialog.component.html',
  styleUrl: './customer-create-dialog.component.scss',
})
export class CustomerCreateDialogComponent {
  lastName = '';
  firstName = '';

  constructor(public dialogRef: MatDialogRef<CustomerCreateDialogComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
