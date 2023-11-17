import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTableModule} from "@angular/material/table";

@Component({
  selector: 'app-customer-table',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './customer-table.component.html',
  styleUrl: './customer-table.component.scss'
})
export class CustomerTableComponent {

}
