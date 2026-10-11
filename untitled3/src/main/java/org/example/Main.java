package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Employee {
    private String name;
    private String department;
    private double salary;
    private Boolean active;

    public Employee(String name, String department, double salary, Boolean active) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }
}
public class Main {
    static void main() {
//        Write a Java Stream expression to:
//        1.Filter employees who are active.
//           2.     Group them by their Department.
//        3.For each department, find the Employee with the highest salary.
//
//        You have a list of Employee objects. Each employee belongs to a Department and has a Salary.
//        Some employees might have a active on Projects they are working on.
        List<Employee> employeeList = Arrays.asList(
                new Employee("Chandana","development",12000.0,true),
                new Employee("Sinchana","development",11000.0,false),
                new Employee("Shaila","testing",11000.0,true),
                new Employee("Virat","testing",13000.0,false)

        );
//        Map<Boolean,Map<String,Optional<Employee>>> highSalaryEmployee =employeeList.stream().
//        .filter()
//                collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
//        System.out.println(highSalaryEmployee);
        Map<String,Optional<Employee>> highSalaryEmployee =   employeeList.stream()
                .filter(Employee::getActive)
                . collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(highSalaryEmployee);

    }
}
