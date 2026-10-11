package org.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Transaction{
    private int id;
    private String type;
    private double amount;
    private String accountHolder;
    private LocalDate date;

    public Transaction(int id, String type, double amount, String accountHolder, LocalDate date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.accountHolder = accountHolder;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
public class Main {
    static void main() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(101, "CREDIT", 5000, "Ravi",LocalDate.of(2025,1,10)),
                new Transaction(102, "DEBIT", 2000,"Anil", LocalDate.of(2025,1,11)),
                new Transaction(103,"CREDIT", 15000,"Ravi",LocalDate.of(2025,1,12)),
                new Transaction(104,"DEBIT",7000,"Kiran",LocalDate.of(2025,1,15)),
                new Transaction(105,"CREDIT",3000,"Anil",LocalDate.of(2025,2,1))
        );

        //Month 1 : total amount
        //Month 2 : total amount
        Map<Month,Double> monthSummary=transactions.stream().collect(Collectors.groupingBy(date->
                date.getDate().getMonth(),
                Collectors.summingDouble(Transaction::getAmount)
                ));

        System.out.println(monthSummary);
    }
}
