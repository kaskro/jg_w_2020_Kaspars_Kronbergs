package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void shouldGetName() {

        Department department = new Department();

        assertNull(department.getName());
    }

    @Test
    void shouldSetName() {

        String name = "Demo";

        Department department = new Department();
        department.setName(name);

        assertEquals(name, department.getName());
    }

    @Test
    void shouldGetCompany() {

        Department department = new Department();

        assertNull(department.getCompany());
    }

    @Test
    void shouldSetCompany() {

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("12341234");

        Department department = new Department();
        department.setCompany(company);

        assertEquals(company, department.getCompany());
    }

    @Test
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        String name = "Testing";

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("12341234");

        Department firstDepartment = new Department();
        firstDepartment.setName(name);
        firstDepartment.setCompany(company);

        Department secondDepartment = new Department();
        secondDepartment.setName(name);
        secondDepartment.setCompany(company);

        assertTrue(firstDepartment.equals(secondDepartment));
    }

    @Test
    void shouldReturnFalseWhenTwoObjectsAreNotEqual() {

        Company firstCompany = new Company();
        firstCompany.setName("Demo");
        firstCompany.setRegistrationNumber("12341234");

        Department firstDepartment = new Department();
        firstDepartment.setName("Testing");
        firstDepartment.setCompany(firstCompany);

        Company secondCompany = new Company();
        secondCompany.setName("Nemo");
        secondCompany.setRegistrationNumber("11111111");

        Department secondDepartment = new Department();
        secondDepartment.setName("Coding");
        secondDepartment.setCompany(secondCompany);

        assertFalse(firstDepartment.equals(secondDepartment));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        String name = "Testing";

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("12341234");

        String correctFormat = "Department{" +
                "name='" + name + '\'' +
                ", company=" + company.getName() +
                '}';

        Department department = new Department();
        department.setName(name);
        department.setCompany(company);

        assertEquals(correctFormat, department.toString());
    }


}