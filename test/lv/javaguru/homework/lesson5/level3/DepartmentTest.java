package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//skatīt iepriekšējosa komentārus
class DepartmentTest {

    private Department department;

    @BeforeEach
    void setUp() {
        department = new Department();
    }

    @Test
    void shouldSetAndGetName() {

        String name = "Demo";

        department.setName(name);

        assertEquals(name, department.getName());
    }

    @Test
    void shouldSetAndGetCompany() {

        Company company = createCompany("Demo", "12341234");

        department.setCompany(company);

        assertEquals(company, department.getCompany());
    }

    @Test
    void shouldBeEqualsDepartments() {

        String name = "Testing";

        Company company = createCompany("Demo", "12341234");

        Department firstDepartment = createDepartment(name, company);

        Department secondDepartment = createDepartment(name, company);

        assertTrue(firstDepartment.equals(secondDepartment));
    }

    private Department createDepartment(String name, Company company) {
        department = new Department();
        department.setName(name);
        department.setCompany(company);
        return department;
    }

    @Test
    void shouldNotBeEqualsDepartments() {

        Company firstCompany = createCompany("Demo", "12341234");

        Department firstDepartment = createDepartment("Testing", firstCompany);

        Company secondCompany = createCompany("Nemo", "11111111");

        Department secondDepartment = createDepartment("Coding", secondCompany);

        assertFalse(firstDepartment.equals(secondDepartment));
    }

    private Company createCompany(String demo, String s) {
        Company company = new Company();
        company.setName(demo);
        company.setRegistrationNumber(s);
        return company;
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        String name = "Testing";

        Company company = createCompany("Demo", "12341234");

        String correctFormat = "Department{" +
                "name='" + name + '\'' +
                ", company=" + company.getName() +
                '}';

        department.setName(name);
        department.setCompany(company);

        assertEquals(correctFormat, department.toString());
    }


}