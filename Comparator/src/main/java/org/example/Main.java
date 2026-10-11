package org.example;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee{
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
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

class idSorting implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.id - e2.id;
    }
}

class nameSorting implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Main {
    static void main() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(2,"chandana",569.00),
                new Employee(3,"sinchana",521.00),
                new Employee(1,"shaila",300.00)

        );
        Collections.sort(employeeList,new idSorting());
        for(Employee e:employeeList){
            System.out.println(e);
        }
        Collections.sort(employeeList, new nameSorting());
        for(Employee e:employeeList){
            System.out.println(e);
        }


    }
}
