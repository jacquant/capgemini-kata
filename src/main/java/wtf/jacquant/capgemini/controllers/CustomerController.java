package wtf.jacquant.capgemini.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wtf.jacquant.capgemini.controllers.json.request.AccountCreateRequest;
import wtf.jacquant.capgemini.controllers.json.request.CreateCustomerRequest;
import wtf.jacquant.capgemini.dtos.AccountDto;
import wtf.jacquant.capgemini.dtos.CustomerDto;
import wtf.jacquant.capgemini.services.CustomerService;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable final Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/")
    public CustomerDto createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {
        return customerService.createCustomer(createCustomerRequest.getFirstName(), createCustomerRequest.getLastName());
    }

    @PostMapping("/{id}/accounts")
    public AccountDto createAccount(@PathVariable final Long id, @RequestBody @Valid AccountCreateRequest accountCreateRequest) {
        if (!id.equals(accountCreateRequest.getCustomerId())) {
            throw new IllegalArgumentException("customerId in path and body must be the same");
        }
        return customerService.createAccount(id, accountCreateRequest.getInitialCredit());
    }
}
