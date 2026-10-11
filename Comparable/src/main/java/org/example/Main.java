package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Employee implements Comparable<Employee>{
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.id - emp.id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class Main {
    static void main() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(2,"chandana",569.00),
                new Employee(3,"sinchana",521.00),
                new Employee(1,"shaila",300.00)

        );
        Collections.sort(employeeList);
        for(Employee e:employeeList){
            System.out.println(e);
        }

    }
}
