package se.lexicon.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test suite for CustomerDaoImpl.
 * <p>
 * These tests verify that customer data is stored, retrieved,
 * and managed correctly in the DAO implementation.
 * <p>
 * All test logic is intentionally left as TODO so students can implement the tests.
 */
class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    /**
     * Runs before each test.
     * Scenario:
     * - Create a new instance of the DAO so each test starts clean.
     */
    @BeforeEach
    void setUp() {
        // TODO: Initialize testObject before each test
        testObject = new CustomerDaoImpl();
    }

    /**
     * Scenario:
     * - Add a new customer to the DAO.
     * - Ensure the customer can be retrieved afterward.
     */
    @Test
    void shouldCreateAndStoreCustomerSuccessfully() {
        // TODO: Arrange, Act, Assert
        Customer customer = new Customer("Alice", "67495", "647hjf");
        testObject.create(customer);
    }

    /**
     * Scenario:
     * - Retrieve all stored customers.
     * - Verify that the list contains the expected number of customers.
     */
    @Test
    void shouldReturnAllCustomers() {
        // TODO: Arrange, Act, Assert
        Customer  customer1 = new Customer("Alice", "67495", "647hjf");
        Customer  customer2 = new Customer("Jakob", "17495", "617hjf");

        testObject.create(customer1);
        testObject.create(customer2);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        List<Customer> AllCustomers = testObject.findAll();
        assertEquals(2, AllCustomers.size());

        assertTrue(AllCustomers.contains(customer1));
        assertTrue(AllCustomers.contains(customer2));

        assertEquals(customer1, AllCustomers.get(0));
        assertEquals(customer2, AllCustomers.get(1));

    }

    /**
     * Scenario:
     * - Search for a customer by ID.
     * - If the customer exists, return it.
     * - If not, return an empty optional or null (depending on your design).
     */
    @Test
    void shouldFindCustomerById() {
        // TODO: Arrange, Act, Assert
        testObject.create(new Customer("Alice", "67495", "647hjf"));

        Optional<Customer> result = testObject.findById(0);
        assert(result.isPresent());
        assert("Alice".equals(result.get().getName()));
    }

    /**
     * Scenario:
     * - Delete a customer from the DAO.
     * - Verify the customer is no longer retrievable.
     */
    @Test
    void shouldDeleteCustomerSuccessfully() {
        // TODO: Arrange, Act, Assert
        Customer customer = new Customer("Alice", "67495", "67675");
        testObject.create(customer);

        String message = testObject.deleteCustomer(customer);
        assertEquals("Customer removed", message);

        String message2 = testObject.deleteCustomer(customer);
        assertEquals("Customer not found", message2);
    }
}
