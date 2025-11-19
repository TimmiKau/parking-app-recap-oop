package se.lexicon.dao.impl;
//

import se.lexicon.dao.CustomerDao;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private final HashMap<Integer, Customer> customerOptional = new HashMap<>();


    @Override
    public Customer create(Customer customer) {
        customers.add(customer);
        return customer;
    }

    //might work, need to know data type, getId, and if ArrayList<Customer> is correct.
    @Override
    public Optional<Customer> findById(int id) {
        return Optional.ofNullable(customerOptional.get(id));
    }

    public  ArrayList<Customer> findAll() {
        return new ArrayList<>(customers);
    }
/*
    //not correct need getters and setters in Customer class
    public HashMap<Integer, Customer> getCustomerOptional() {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customerOptional;
            }
        }
        return null;
    }
*/
    public Customer deleteCustomer (Customer customer) {
        if (customers.contains(customer)) {
            customers.remove(customer);
        }
        return null;
    }
}
