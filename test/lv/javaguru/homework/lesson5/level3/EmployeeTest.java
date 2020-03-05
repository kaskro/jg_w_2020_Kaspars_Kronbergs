package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//skatīt iepriekšējosa komentārus
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
    void shouldSetAndGetContractNumber() {

        String contractNumber = "12345";

        employee.setContractNumber(contractNumber);

        assertEquals(contractNumber, employee.getContractNumber());
    }

    @Test
    void shouldSetAndGetSalary() {

        double salary = 500;

        employee.setSalary(salary);

        assertEquals(salary, employee.getSalary());
    }

    @Test
    void shouldSetAndGetDepartment() {

        employee.setDepartment(department);

        assertEquals(department, employee.getDepartment());
    }


    @Test
    void shouldBeEqualsEmployees() {

        String contractNumber = "1234";
        double salary = 500;

        Employee firstEmployee = createEmployee(contractNumber, salary);

        Employee secondEmployee = createEmployee(contractNumber, salary);

        assertTrue(firstEmployee.equals(secondEmployee));
    }

    private Employee createEmployee(String contractNumber, double salary) {
        employee = new Employee();
        employee.setContractNumber(contractNumber);
        employee.setSalary(salary);
        employee.setDepartment(department);
        return employee;
    }

    @Test
    void shouldNotBeEqualsEmployees() {

        Employee firstEmployee = createEmployee("12345", 600);

        Employee secondEmployee = createEmployee("323212", 100);

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