package lv.javaguru.homework.lesson5.level3;

import java.util.Objects;

//ok
public class Employee {
    private String contractNumber;
    private double salary;
    private Department department;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(contractNumber, employee.contractNumber) &&
                Objects.equals(department, employee.department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "contractNumber='" + contractNumber + '\'' +
                ", salary=" + salary +
                ", department=" + department.getName() +
                '}';
    }

}
