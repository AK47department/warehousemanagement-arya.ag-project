package com.aryaag.warehouseservice.service;
import com.aryaag.warehouseservice.model.Commodity;

import com.aryaag.warehouseservice.model.Customer;
import com.aryaag.warehouseservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Get all customers with their commodities and warehouses
    public List<Customer> getAllCustomersWithDetails() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Commodity> getCommoditiesByCustomerId(Long customerId) {
        Customer customer = getCustomerById(customerId);
        return customer.getCommodities();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setContactDetails(updatedCustomer.getContactDetails());
            existingCustomer.setContractDetails(updatedCustomer.getContractDetails());
            existingCustomer.setLastUpdatedOn(updatedCustomer.getLastUpdatedOn());
            return customerRepository.save(existingCustomer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}



