package lv.javaguru.homework.lesson10.level1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//ok
class UserValidationServiceTest {

    @Test
    void shouldGetErrorWhenNameIsLessThan3Characters() {
        User user = new User("Te", "Tests", 10);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Name must be in range from 3 to 15 characters", ex.getMessage());
        }
    }

    @Test
    void shouldGetErrorWhenNameIsMoreThan15Characters() {
        User user = new User("Thisnameismorethanallowed", "Tests", 10);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Name must be in range from 3 to 15 characters", ex.getMessage());
        }
    }

    @Test
    void shouldGetErrorWhenLastNameIsLessThan3Characters() {
        User user = new User("Test", "Te", 10);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Surname must be in range from 3 to 15 characters", ex.getMessage());
        }
    }

    @Test
    void shouldGetErrorWhenLastNameIsMoreThan15Characters() {
        User user = new User("Test", "Thisnameismorethanallowed", 10);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Surname must be in range from 3 to 15 characters", ex.getMessage());
        }
    }

    @Test
    void shouldGetErrorWhenAgeIsLessThan0() {
        User user = new User("Tests", "Tests", -1);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Age must be in range from 0 to 120 characters", ex.getMessage());
        }
    }

    @Test
    void shouldGetErrorWhenAgeIsMoreThan120() {
        User user = new User("Tests", "Tests", 121);
        try {
            UserValidationService.validate(user);
            fail();
        } catch (ValidationException ex) {
            assertEquals("Age must be in range from 0 to 120 characters", ex.getMessage());
        }
    }

}