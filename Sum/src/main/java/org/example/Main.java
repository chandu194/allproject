package org.example;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Sum implements Runnable{
    int a;
    int b;
private static final Object lock = new Object();

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
       // synchronized (lock){
            int sum = a+b;
            System.out.println(sum);
       // }
    }
}

public class Main {
    static void main() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Sum(10,20));
        executorService.submit(new Sum(30,20));
        executorService.submit(new Sum(40,20));
        executorService.shutdown();
        if(!executorService.isTerminated()){
            Thread.sleep(1000);
        }

//        int a = 10;
//        int b = 20;
//
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//
//        Callable<Integer> task = () -> {
//            int sum = a + b;
//            return sum;
//        };
//
//        Future<Integer> future = executor.submit(task);
//
//        int result = future.get();
//
//        System.out.println("Sum = " + result);
//
//        executor.shutdown();
    }
}
