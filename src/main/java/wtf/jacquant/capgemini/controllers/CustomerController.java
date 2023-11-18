package wtf.jacquant.capgemini.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wtf.jacquant.capgemini.controllers.json.request.AccountCreateRequest;
import wtf.jacquant.capgemini.controllers.json.request.CreateCustomerRequest;
import wtf.jacquant.capgemini.dtos.AccountDto;
import wtf.jacquant.capgemini.dtos.CustomerDto;
import wtf.jacquant.capgemini.dtos.CustomerInfoDto;
import wtf.jacquant.capgemini.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public List<CustomerInfoDto> getCustomers() {
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable final Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("")
    public CustomerDto createCustomer(@RequestBody @Valid final CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest.getFirstName(), createCustomerRequest.getLastName());
    }

    @PostMapping("/{id}/accounts")
    public AccountDto createAccount(@PathVariable final Long id, @RequestBody @Valid final AccountCreateRequest accountCreateRequest) {
        if (!id.equals(accountCreateRequest.getCustomerId())) {
            throw new IllegalArgumentException("customerId in path and body must be the same");
        }
        return customerService.createAccount(id, accountCreateRequest.getInitialCredit());
    }
}
