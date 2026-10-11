package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Number {
    private int number = 1;
    private int limit = 10;
    public synchronized void printOdd() throws InterruptedException {
        while(number<=limit){
            while(number%2==0){
                wait();
            }
            System.out.println("The odd number is ::" + number);
            number++;
            notify();
        }
    }
    public synchronized void printEven() throws InterruptedException {
        while(number<=limit){
            while(number%2!=0){
                wait();
            }
            System.out.println("The even number is ::" +number);
            number++;
            notify();
        }
    }

}

public class Main {
    static void main() {
       Number number = new Number();
       Thread t1 = new Thread(()->{
           try {
               number.printOdd();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
       Thread t2 = new Thread(()->{
           try {
               number.printEven();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       });
       t1.start();
       t2.start();
    }
}
