package com.aryaag.warehouseservice.controller;
import com.aryaag.warehouseservice.model.Commodity;

import com.aryaag.warehouseservice.model.Customer;
import com.aryaag.warehouseservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    // Get all customers with their commodities and warehouse details
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomersWithDetails() {
        return ResponseEntity.ok(customerService.getAllCustomersWithDetails());
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }


    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/{customerId}/commodities")
    public ResponseEntity<List<Commodity>> getCommoditiesByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(customerService.getCommoditiesByCustomerId(customerId));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}



