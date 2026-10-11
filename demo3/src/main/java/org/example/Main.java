package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    private static final String url = "https://localhost:8080/api/getData";
    static void main() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        RestTemplate restTemplate = new RestTemplate();
        List<Future<String>> futures = new ArrayList<>();

        //using callable
        for (int i =0; i<1000; i++){
            Callable<String> task = () -> {
                restTemplate.getForObject(url, String.class);
                return "success";
            };
            futures.add(executorService.submit(task));
        }
        for(Future<String> future: futures){
            System.out.println(future.get());
        }


        //using Runnable
        for (int i =0; i<1000; i++) {
        executorService.submit(() ->{
                restTemplate.put(url,null);
                });
        }

        //using parallelstream
        IntStream.rangeClosed(0,1000)
                        .parallel()
                                .forEach(i->
                                        executorService.submit(() ->restTemplate.put(url,null)));


        executorService.shutdown();




    }
}
