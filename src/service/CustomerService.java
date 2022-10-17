package service;

import com.sun.source.tree.ReturnTree;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static CustomerService customerService = null;

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    List<Customer> customers = new ArrayList<>();

    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customer: customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
