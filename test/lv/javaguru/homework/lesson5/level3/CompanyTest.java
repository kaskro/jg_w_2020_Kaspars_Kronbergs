package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//skatīt iepriekšējosa komentārus
class CompanyTest {

    private Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
    }

    @Test
    void shouldSetAndGetName() {

        String name = "Demo";

        company.setName(name);

        assertEquals(name, company.getName());
    }

    @Test
    void shouldSetAndGetRegistrationNumber() {

        String registrationNumber = "12345112345";

        company.setRegistrationNumber(registrationNumber);

        assertEquals(registrationNumber, company.getRegistrationNumber());
    }

    @Test
    void shouldBeEqualsCompanies() {

        String name = "Demo";
        String registrationNumber = "12345112345";

        Company firstCompany = createCompany(name, registrationNumber);

        Company secondCompany = createCompany(name, registrationNumber);

        assertTrue(firstCompany.equals(secondCompany));
    }

    private Company createCompany(String name, String registrationNumber) {
        company = new Company();
        company.setName(name);
        company.setRegistrationNumber(registrationNumber);
        return company;
    }

    @Test
    void shouldNotBeEqualsCompanies() {

        String name = "Demo";
        String registrationNumber = "12345112345";

        Company firstCompany = createCompany(name, registrationNumber);

        Company secondCompany = createCompany("Not a Demo", "111111111");

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

        company.setName(name);
        company.setRegistrationNumber(registrationNumber);

        assertEquals(correctFormat, company.toString());
    }

}