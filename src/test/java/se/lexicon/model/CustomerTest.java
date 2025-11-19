package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Customer model.
 * <p>
 * This test suite verifies the creation of a Customer instance and the behavior
 * of setters when assigning valid and invalid values. The goal is to ensure
 * that the Customer class enforces correct data handling and validation.
 */
class CustomerTest {

    Customer testObject;

    @BeforeEach
    void setUp() {
        // TODO: Initialize testObject with a default Customer instance
        /**
         * Runs before each test method.
         * Scenario:
         * - Prepare a fresh Customer object so test cases do not affect each other.
         */
        testObject = new Customer("Anna", "12345", "123asd");
    }

    /**
     * Scenario:
     * - Ensure that a new Customer object can be created successfully.
     * - Confirm that fields are assigned or initialized as expected.
     */
    @Test
    void shouldCreateCustomerSuccessfully() {
        // TODO: Arrange, Act, Assert
        Customer act = testObject;

        assertEquals("Anna", act.getName());
        assertEquals("12345", act.getPhoneNumber());
        assertEquals("123asd", act.getVehiclePlateNumber());
        assertNotNull(act.getId());
    }

    /**
     * Scenario:
     * - Assign a valid name to the customer.
     * - Verify that the name is stored correctly.
     */
    @Test
    void shouldSetNameWhenNameIsValid() {
        // TODO: Arrange, Act, Assert
        Customer act = testObject;

        act.setName("Anna");
        assertEquals("Anna", act.getName());
    }

    /**
     * Scenario:
     * - Attempt to set an invalid name (e.g., null or empty).
     * - The Customer class should prevent this and possibly throw an exception.
     */
    @Test
    void shouldNotSetNameWhenNameIsInvalid() {
        // TODO: Arrange, Act, Assert

        Customer act = testObject;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testObject.setName(null));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }

    /**
     * Scenario:
     * - Assign a valid phone number to the customer.
     * - Verify the number is stored correctly.
     */
    @Test
    void shouldSetPhoneNumberWhenValid() {
        // TODO: Arrange, Act, Assert

        Customer act = testObject;

        act.setPhoneNumber("12345");
        assertEquals("12345", act.getPhoneNumber());
    }

    /**
     * Scenario:
     * - Attempt to assign an invalid phone number (e.g., improperly formatted).
     * - The Customer class should prevent this or indicate an error.
     */
    @Test
    void shouldNotSetPhoneNumberWhenInvalid() {
        // TODO: Arrange, Act, Assert
        Customer act = testObject;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testObject.setPhoneNumber(null));
        assertEquals("phone number cannot be null or empty", exception.getMessage());

    }

    /**
     * Scenario:
     * - Assign a valid ID to the customer (e.g., positive number).
     * - Ensure the ID is updated correctly.
     */
    @Test
    void shouldSetIdWhenValid() {
        // TODO: Arrange, Act, Assert
        Customer act = testObject;

        assertNotNull(act.getId());
    }

    /**
     * Scenario:
     * - Assign a valid vehicle plate number to the customer.
     * - Verify that it is stored and retrievable.
     */
    @Test
    void shouldSetVehiclePlateNumberSuccessfully() {
        // TODO: Arrange, Act, Assert

        Customer act = testObject;

        act.setVehiclePlateNumber("12345");
        assertEquals("12345", act.getVehiclePlateNumber());
    }
}
