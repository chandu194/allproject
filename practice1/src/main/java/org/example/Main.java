package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    private static  final String url = "https://localhost:8080/api/getdata";
    static void main() {
        CompletableFuture<String> device =
                CompletableFuture.supplyAsync(() -> getData("Device"));

        CompletableFuture<String> alarm =
                CompletableFuture.supplyAsync(() -> getData("Alarm"));

        CompletableFuture<String> inventory =
                CompletableFuture.supplyAsync(() -> getData("Inventory"));

        CompletableFuture<String> performance =
                CompletableFuture.supplyAsync(() -> getData("Performance"));

        CompletableFuture<String> config =
                CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            return   " Response";
                        });


        CompletableFuture.allOf(
                device,
                alarm,
                inventory,
                performance,
                config
        ).join();

        System.out.println(device.join());
        System.out.println(alarm.join());
        System.out.println(inventory.join());
        System.out.println(performance.join());
        System.out.println(config.join());
    }

    static String getData(String service) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return service + " Response";
    }
}
