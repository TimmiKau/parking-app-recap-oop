package se.lexicon.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

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
        Customer customer = new Customer();
        //customer.setName("Alice");
    }

    /**
     * Scenario:
     * - Retrieve all stored customers.
     * - Verify that the list contains the expected number of customers.
     */
    @Test
    void shouldReturnAllCustomers() {
        // TODO: Arrange, Act, Assert
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
    }

    /**
     * Scenario:
     * - Delete a customer from the DAO.
     * - Verify the customer is no longer retrievable.
     */
    @Test
    void shouldDeleteCustomerSuccessfully() {
        // TODO: Arrange, Act, Assert
    }
}
