package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee;
    private Company company;
    private Department department;

    @BeforeEach
    void setUp() {
        employee = new Employee();

        company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("1234512345");

        department = new Department();
        department.setName("Testing");
        department.setCompany(company);
    }

    @Test
    void shouldGetContractNumber() {

        assertNull(employee.getContractNumber());
    }

    @Test
    void shouldSetContractNumber() {

        String contractNumber = "12345";

        employee.setContractNumber(contractNumber);

        assertEquals(contractNumber, employee.getContractNumber());
    }

    @Test
    void shouldGetSalary() {

        assertEquals(0, employee.getSalary());
    }

    @Test
    void shouldSetSalary() {

        double salary = 500;

        employee.setSalary(salary);

        assertEquals(salary, employee.getSalary());
    }

    @Test
    void shouldGetDepartment() {

        assertNull(employee.getDepartment());
    }

    @Test
    void shouldSetDepartment() {

        employee.setDepartment(department);

        assertEquals(department, employee.getDepartment());
    }


    @Test
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        String contractNumber = "1234";
        double salary = 500;

        Employee firstEmployee = new Employee();
        firstEmployee.setContractNumber(contractNumber);
        firstEmployee.setSalary(salary);
        firstEmployee.setDepartment(department);

        Employee secondEmployee = new Employee();
        secondEmployee.setContractNumber(contractNumber);
        secondEmployee.setSalary(salary);
        secondEmployee.setDepartment(department);

        assertTrue(firstEmployee.equals(secondEmployee));
    }

    @Test
    void shouldReturnFalseWhenTwoObjectsAreNotEqual() {

        Employee firstEmployee = new Employee();
        firstEmployee.setContractNumber("12345");
        firstEmployee.setSalary(600);
        firstEmployee.setDepartment(department);

        Employee secondEmployee = new Employee();
        secondEmployee.setContractNumber("323212");
        secondEmployee.setSalary(100);
        secondEmployee.setDepartment(department);

        assertFalse(firstEmployee.equals(secondEmployee));
    }

    @Test
    void shouldReturnTrueWhenStringHasCorrectFormat() {

        String contractNumber = "1234";
        double salary = 500;

        String correctFormat = "Employee{" +
                "contractNumber='" + contractNumber + '\'' +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';

        employee.setContractNumber(contractNumber);
        employee.setSalary(salary);
        employee.setDepartment(department);

        assertEquals(correctFormat, employee.toString());
    }

}