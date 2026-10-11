package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.binarySearch;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        IntStream.rangeClosed(1,100)
                .filter(x->x%2==0)
                .map(n ->n*n)
                .forEach(System.out::println);

        List<String> fruits =Arrays.asList("banana","apple","grapes","banana","grapes","orange");
        Map<String,Long> occurrence = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(occurrence);


        int[] score = {120,130,140,150,170,190};
        String[] players = {"virat","rohith","hardik","patidar"};

//        int low=0;
//        int high = score.length-1;
//        while(low <= high){
//            int mid = low +(high-low)/2;
//            if(score[mid] )

//                class employee id,name,department,salary
//                find the highest paid employee
//                find avg salary by department
//                find high paid employee in each dept
//                find top 3 salaries
        List<Employee> employeeList =
                Arrays.asList(
                        new Employee(101, "John", "IT", 75000),
                        new Employee(102, "Alice", "HR", 60000),
                        new Employee(103, "Bob", "Finance", 85000),
                        new Employee(104, "David", "IT", 95000),
                        new Employee(105, "Emma", "Marketing", 70000),
                        new Employee(106, "Frank", "Finance", 90000),
                        new Employee(107, "Grace", "HR", 65000),
                        new Employee(108, "Henry", "IT", 80000),
                        new Employee(109, "Isabella", "Marketing", 72000),
                        new Employee(110, "Jack", "Finance", 88000),
                        new Employee(111, "Kevin", "IT", 78000),
                        new Employee(112, "Lily", "HR", 62000),
                        new Employee(113, "Michael", "Marketing", 76000),
                        new Employee(114, "Nancy", "Finance", 93000),
                        new Employee(115, "Oliver", "IT", 105000),
                        new Employee(116, "Peter", "HR", 67000),
                        new Employee(117, "Queen", "Marketing", 74000),
                        new Employee(118, "Robert", "Finance", 97000),
                        new Employee(119, "Sophia", "IT", 82000),
                        new Employee(120, "Thomas", "HR", 69000)
                );
        //                find the highest paid employee

      Employee highestPaidEmployee =  employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
      System.out.println(highestPaidEmployee);

        //                find avg salary by department

       Map<String,Double> eachDeptAvgSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
       System.out.println(eachDeptAvgSalary);

//                find high paid employee in each dept

                    employeeList.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment,
                                    Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        //                find top 3 salaries
                        employeeList.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .limit(3)
                                .collect(Collectors.toList());

//        int[] scores = {120,130,140,150,170,190};
//        int low =0;
//        int high = scores.length -1;
//        int result = 0;
//        while(low<=high){
//            int mid = low +(high - low);
//            if(scores[mid] <=)
//
//        }


int[] arr = {30,10,34,89,23};
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the target");
        int target = sc.nextInt();
        Arrays.sort(arr);
        int index = binarySearch1(arr,target);
 if(index!=-1){
     System.out.println("element found at index "+ index);

 }else{
     System.out.println("element didnt found");
 }

        }

    private static int binarySearch1(int[] arr, int target) {
        int low =0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high =mid -1;
            }

        }
        return -1;
    }
}

