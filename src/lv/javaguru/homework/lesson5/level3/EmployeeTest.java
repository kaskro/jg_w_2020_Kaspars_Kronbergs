package lv.javaguru.homework.lesson5.level3;

//ok
//labāk nakamreiz izmanto testus
public class EmployeeTest {
    public static void main(String[] args) {

        String companyName = "IKEA";
        String registrationNumber = "12324fcfgh5";
        String departmentName = "Kitchen";
        String contractNumber = "1434vdcfv3";
        double salary = 500;

        Company firstCompany = new Company();
        firstCompany.setName(companyName);
        firstCompany.setRegistrationNumber(registrationNumber);

        Department firstDepartment = new Department();
        firstDepartment.setCompany(firstCompany);
        firstDepartment.setName(departmentName);

        Employee firstEmployee = new Employee();
        firstEmployee.setDepartment(firstDepartment);
        firstEmployee.setContractNumber(contractNumber);
        firstEmployee.setSalary(salary);

        Company secondCompany = new Company();
        secondCompany.setName(companyName);
        secondCompany.setRegistrationNumber(registrationNumber);

        Department secondDepartment = new Department();
        secondDepartment.setCompany(secondCompany);
        secondDepartment.setName(departmentName);

        Employee secondEmployee = new Employee();
        secondEmployee.setDepartment(secondDepartment);
        secondEmployee.setContractNumber(contractNumber);
        secondEmployee.setSalary(salary);

        System.out.println(firstCompany.toString());
        System.out.println(firstDepartment.toString());
        System.out.println(firstEmployee.toString());

        System.out.println(secondCompany.toString());
        System.out.println(secondDepartment.toString());
        System.out.println(secondEmployee.toString());

        System.out.println("firstCompany is equal to secondCompany = " + firstCompany.equals(secondCompany));
        System.out.println("firstDepartment is equal to secondDepartment = " + firstDepartment.equals(secondDepartment));
        System.out.println("firstEmployee is equal to secondEmployee = " + firstEmployee.equals(secondEmployee));
    }
}
