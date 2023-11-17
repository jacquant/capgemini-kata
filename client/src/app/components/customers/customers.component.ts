import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTableModule} from "@angular/material/table";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.scss'
})
export class CustomersComponent {

}
