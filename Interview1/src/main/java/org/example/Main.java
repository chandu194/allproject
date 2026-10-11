package org.example;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        //duplicate string
        String[] events = {
                "LINK_DOWN_101",
                "LINK_DOWN_101",
                "CPU_HIGH_202"
        };

        Set<String> dup = new HashSet<>();
        for(String event : events){
            dup.add(event);
        }
        System.out.println(dup);

        //find first nonrepeating character
        String str="swiss";
        String s1 = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue() ==1)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();
        System.out.println(s1);

    }
}
