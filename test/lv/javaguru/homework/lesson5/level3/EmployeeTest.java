package lv.javaguru.homework.lesson5.level3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void shouldGetContractNumber() {

        Employee employee = new Employee();

        assertNull(employee.getContractNumber());
    }

    @Test
    void shouldSetContractNumber() {

        String contractNumber = "12345";

        Employee employee = new Employee();
        employee.setContractNumber(contractNumber);

        assertEquals(contractNumber, employee.getContractNumber());
    }

    @Test
    void shouldGetSalary() {

        Employee employee = new Employee();

        assertEquals(0, employee.getSalary());
    }

    @Test
    void shouldSetSalary() {

        double salary = 500;

        Employee employee = new Employee();
        employee.setSalary(salary);

        assertEquals(salary, employee.getSalary());
    }

    @Test
    void shouldGetDepartment() {

        Employee employee = new Employee();

        assertNull(employee.getDepartment());
    }

    @Test
    void shouldSetDepartment() {

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("1234512345");

        Department department = new Department();
        department.setName("Testing");
        department.setCompany(company);

        Employee employee = new Employee();
        employee.setDepartment(department);

        assertEquals(department, employee.getDepartment());
    }


    @Test
    void shouldReturnTrueWhenTwoObjectsAreEqual() {

        String contractNumber = "1234";
        double salary = 500;

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("1234512345");

        Department department = new Department();
        department.setName("Testing");
        department.setCompany(company);

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

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("1234512345");

        Department department = new Department();
        department.setName("Testing");
        department.setCompany(company);

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

        Company company = new Company();
        company.setName("Demo");
        company.setRegistrationNumber("1234512345");

        Department department = new Department();
        department.setName("Testing");
        department.setCompany(company);

        String correctFormat = "Employee{" +
                "contractNumber='" + contractNumber + '\'' +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';

        Employee employee = new Employee();
        employee.setContractNumber(contractNumber);
        employee.setSalary(salary);
        employee.setDepartment(department);

        assertEquals(correctFormat, employee.toString());
    }

}