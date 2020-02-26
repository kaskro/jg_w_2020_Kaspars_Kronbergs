package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void shouldGetName() {

        Company company = new Company();

        assertNull(company.getName());
    }

    @Test
    void shouldSetName() {

        String name = "Demo";

        Company company = new Company();
        company.setName(name);

        assertEquals(name, company.getName());
    }

    @Test
    void shouldGetRegistrationNumber() {

        Company company = new Company();

        assertNull(company.getRegistrationNumber());
    }

    @Test
    void shouldSetRegistrationNumber() {

        String registrationNumber = "12345112345";

        Company company = new Company();
        company.setRegistrationNumber(registrationNumber);

        assertEquals(registrationNumber, company.getRegistrationNumber());
    }

    @Test
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        String name = "Demo";
        String registrationNumber = "12345112345";

        Company firstCompany = new Company();
        firstCompany.setName(name);
        firstCompany.setRegistrationNumber(registrationNumber);

        Company secondCompany = new Company();
        secondCompany.setName(name);
        secondCompany.setRegistrationNumber(registrationNumber);

        assertTrue(firstCompany.equals(secondCompany));
    }

    @Test
    void shouldReturnFalseWhenTwoObjectsAreNotEqual() {

        String name = "Demo";
        String registrationNumber = "12345112345";

        Company firstCompany = new Company();
        firstCompany.setName(name);
        firstCompany.setRegistrationNumber(registrationNumber);

        Company secondCompany = new Company();
        secondCompany.setName("Not a Demo");
        secondCompany.setRegistrationNumber("111111111");

        assertFalse(firstCompany.equals(secondCompany));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        String name = "Demo";
        String registrationNumber = "12345112345";
        String correctFormat = "Company{" +
                "name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';

        Company company = new Company();
        company.setName(name);
        company.setRegistrationNumber(registrationNumber);

        assertEquals(correctFormat, company.toString());
    }

}