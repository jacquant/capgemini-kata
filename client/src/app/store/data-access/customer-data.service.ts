import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account, Customer, CustomerInfo } from '../bank.state';
import { Observable } from 'rxjs';
import { API_URL, CUSTOMER_API_VERSION } from '../../app.config';

@Injectable({
  providedIn: 'root',
})
export class CustomerDataService {
  #httpClient = inject(HttpClient);
  #apiUrl = inject(API_URL);
  #customerApiVersion = inject(CUSTOMER_API_VERSION);

  fetchCustomers(): Observable<CustomerInfo[]> {
    return this.#httpClient.get<CustomerInfo[]>(this.buildUrl(''));
  }

  fetchCustomer(id: number): Observable<Customer> {
    return this.#httpClient.get<Customer>(this.buildUrl(id.toString()));
  }

  createCustomer(customer: {
    lastName: string;
    firstName: string;
  }): Observable<Customer> {
    return this.#httpClient.post<Customer>(this.buildUrl(''), customer);
  }

  createAccount(
    customerId: number,
    initialCredit: number,
  ): Observable<Account> {
    return this.#httpClient.post<Account>(
      this.buildUrl(customerId + '/accounts'),
      {
        customerId,
        initialCredit,
      },
    );
  }

  private buildUrl(path: string): string {
    return `${this.#apiUrl}/${this.#customerApiVersion}/customers${
      path ? `/${path}` : ''
    }`;
  }
}
