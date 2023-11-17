import {inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Account, Customer, CustomerInfo} from "../bank.state";
import {Observable} from "rxjs";
import {API_URL} from "../../app.config";


@Injectable({
  providedIn: 'root'
})
export class CustomerDataService {

  #httpClient = inject(HttpClient);
  #apiUrl = inject(API_URL);


  fetchCustomers(): Observable<CustomerInfo[]> {
    return this.#httpClient.get<CustomerInfo[]>(API_URL + '/customers');
  }

  fetchCustomer(id: number): Observable<Customer> {
    return this.#httpClient.get<Customer>(API_URL + '/customers/' + id);
  }

  createCustomer(customer: { lastName: string, firstName: string }): Observable<Customer> {
    return this.#httpClient.post<Customer>(API_URL + '/customers', customer);
  }

  createAccount(customerId: number, initialCredit: number): Observable<Account> {
    return this.#httpClient.post<Account>(API_URL + '/customers/' + customerId + '/accounts', {customerId, initialCredit});
  }
}

