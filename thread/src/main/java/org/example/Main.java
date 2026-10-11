package org.example;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MultiThread implements Runnable{
      private String threadName;
      private String data;

    public MultiThread(String threadName, String data) {
        this.threadName = threadName;
        this.data = data;
    }

    private static final Lock lock = new ReentrantLock();
    @Override
    public void run() {
        String fileName = "output.txt";
        lock.lock();
        try {
            try(FileWriter writer= new FileWriter(fileName)) {
                writer.write(data);
                System.out.println("completed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                String line;
                while ((line = reader.readLine())!= null){
                    System.out.println("reading the line");

                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        finally {
lock.unlock();
        }
}

public class Main {
    static void main() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new MultiThread("Thread-1","ne1"));
        executorService.submit(new MultiThread("Thread-2","ne2"));
        executorService.submit(new MultiThread("Thread-3","ne3"));
        executorService.shutdown();
        while(!executorService.isTerminated()){
            Thread.sleep(1000);
        }

    }
}
