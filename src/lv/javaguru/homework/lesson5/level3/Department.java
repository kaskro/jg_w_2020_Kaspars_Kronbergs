package lv.javaguru.homework.lesson5.level3;

import java.util.Objects;

public class Department {
    private String name;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(company, that.company);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", company=" + company.getName() +
                '}';
    }
}
