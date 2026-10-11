package org.example;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FileWriterTask implements Runnable{
    private String threadName;
    private String data;
private static final Object lock = new Object();
    public FileWriterTask(String threadName, String data) {
        this.threadName = threadName;
        this.data = data;
    }

    @Override
    public void run() {
       synchronized (lock){
            String fileName = "output.txt";
            try(FileWriter writer = new FileWriter(fileName)){
              writer.write(data);
              System.out.println(threadName + "completed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while((line = reader.readLine()) != null) {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " reading "
                                    + fileName
                                    + " : "
                                    + line
                    );
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
        }
    }
}
public class Main {
    static void main() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new FileWriterTask("thread-1","ne1"));
        executorService.submit(new FileWriterTask("thread-2","ne2"));
        executorService.submit(new FileWriterTask("thread-3","ne3"));
        executorService.submit(new FileWriterTask("thread-4","ne4"));
        executorService.shutdown();

        while(!executorService.isTerminated()){
            Thread.sleep(1000);
        }
        System.out.println("completed");
    }
}


//with Reentrant Lock

//package org.example;
//
//import java.io.*;
//        import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//
//class FileWriterTask implements Runnable {
//
//    private String threadName;
//    private String data;
//
//    private static final Lock lock = new ReentrantLock();
//
//
//    public FileWriterTask(String threadName, String data) {
//        this.threadName = threadName;
//        this.data = data;
//    }
//
//
//    @Override
//    public void run() {
//
//        lock.lock();   // acquire lock
//
//        try {
//
//            String fileName = "output.txt";
//
//
//            try(FileWriter writer = new FileWriter(fileName)) {
//
//                writer.write(data);
//
//                System.out.println(
//                        threadName + " completed"
//                );
//
//            } catch(IOException e) {
//                throw new RuntimeException(e);
//            }
//
//
//
//            try(BufferedReader reader =
//                        new BufferedReader(new FileReader(fileName))) {
//
//
//                String line;
//
//                while((line = reader.readLine()) != null) {
//
//                    System.out.println(
//                            Thread.currentThread().getName()
//                                    + " reading "
//                                    + fileName
//                                    + " : "
//                                    + line
//                    );
//                }
//
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }
//        finally {
//
//            lock.unlock();  // release lock
//
//        }
//    }
//}
//
//
//
//public class Main {
//
//    public static void main(String[] args)
//            throws InterruptedException {
//
//
//        ExecutorService executorService =
//                Executors.newFixedThreadPool(3);
//
//
//        executorService.submit(
//                new FileWriterTask("thread-1","ne1")
//        );
//
//
//        executorService.submit(
//                new FileWriterTask("thread-2","ne2")
//        );
//
//
//        executorService.submit(
//                new FileWriterTask("thread-3","ne3")
//        );
//
//
//        executorService.submit(
//                new FileWriterTask("thread-4","ne4")
//        );
//
//
//        executorService.shutdown();
//
//
//        while(!executorService.isTerminated()) {
//
//            Thread.sleep(1000);
//        }
//
//
//        System.out.println("completed");
//    }
//}