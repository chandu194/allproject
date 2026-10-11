package org.example;

import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
 class Employee {

    private int id;
    private String name;
    private double salary;
    private String department;
    private List<Integer> projects;

    public Employee(int id, String name, double salary, String department, List<Integer> projects) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department=department;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public List<Integer> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return name + " " + salary +" "+ department;
    }
}
public class Main {
    static void main() {
        List<Employee> employees = Arrays.asList(

                new Employee(1, "John", 90000,"dev",
                        Arrays.asList(101,102,103)),

                new Employee(2, "Alex", 60000, "dev",
                        Arrays.asList(104,105)),

                new Employee(3, "David", 120000, "test",
                        Arrays.asList(106,107,108,109)),

                new Employee(4, "Mike", 80000, "test",
                        Arrays.asList(110))

        );
        //1. Count projects for employee in each department
       Map<String,Integer> eachDepartementProjectCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(e->e.getProjects().size())
                ));
       System.out.println(eachDepartementProjectCount);

       //2. Find the department having the highest number of projects
       Map<String, Optional<Employee>> highNumberofProjectDept= employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getDepartment))

                ));
       System.out.println(highNumberofProjectDept);

       //3. Find the second highest salary employee
       Employee secondHighSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get();
       System.out.println(secondHighSalary);

       //4. Find the second highest salary in each department
      Map<String,Employee> secondHighSalaryDept =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary)
                                                .reversed())
                                        .skip(1)
                                        .findFirst()
                                        .get()
                        )
                        ));
      System.out.println(secondHighSalaryDept);

      //5. Find employees whose project count is greater than average project count
       double averageProjCount = employees.stream()
                .collect(Collectors.averagingInt(e->e.getProjects().size()));
       employees.stream()
               .filter(e->e.getProjects().size()>averageProjCount)
               .forEach(System.out::println);

       //6. Find the department with highest average salary
       Map<String,Double> avergaeSalaryInDept =employees.stream()
               .collect(Collectors.groupingBy(Employee::getDepartment,
                       Collectors.averagingDouble(Employee::getSalary)));
       String dept = avergaeSalaryInDept
               .entrySet()
               .stream()
               .max(Map.Entry.comparingByValue())
               .get()
               .getKey();
       System.out.println(dept);

       //7. Find top 2 highest paid employees in each department
        Map<String,List<Employee>> twoHighPaidEmployeeInDept =employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),list -> list
                                .stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .limit(2)
                                .collect(Collectors.toList()))));
        System.out.println(twoHighPaidEmployeeInDept);


       //8. Find department with maximum employees
        Map<String,Long> employeeCountInDept =employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.counting()));
        String dept1 =employeeCountInDept.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        System.out.println(dept1);

        //9. Find employees who are not assigned any project
        List<Employee> employeeWithZeroProject =employees.stream()
                .filter(e-> e.getProjects().isEmpty())
                .collect(Collectors.toList());
        System.out.println(employeeWithZeroProject);

        //10. Find average number of projects per employee
        Double avergaeNumberOfProjectPerEmpolyee=employees.stream()
                .mapToInt(e->e.getProjects().size())
                        .average()
                                .getAsDouble();
        System.out.println(avergaeNumberOfProjectPerEmpolyee);

        //11. Find highest paid employee from each department
        Map<String,Optional<Employee>> highPaidEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        ));
        System.out.println(highPaidEmployee);

        //12. Sort employees by:
        //Department ascending
        //Salary descending
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment).thenComparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);

        //13. Find the employee with maximum salary among employees having more than 2 projects
        List<Employee> moreThantwoProj =employees.stream()
                .filter(e->e.getProjects().size()>2)
                .collect(Collectors.toList());
       Employee employee3 =moreThantwoProj.stream()
                .max(Comparator.comparing(Employee::getSalary))
.get();
        System.out.println(employee3);}}

