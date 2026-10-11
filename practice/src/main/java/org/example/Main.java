package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        //count frequency of the element
        List<Integer> elm1 = Arrays.asList(1,2,2,3,4,5,6,6,6);
       Map<Integer,Long> freqElements= elm1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       System.out.println("freqElements "+freqElements);

       //Find Duplicate elements
        List<Integer> duplicateEleemnts =elm1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("Duplicate elements "+ duplicateEleemnts);


        //Find the second Highest number
        Integer secondHigh =elm1.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("Second Highest Number " + secondHigh);


        //count even numbers
        Map<Boolean,List<Integer>> evenOdd = elm1.stream()
                .collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println("List of even and odd numbers " + evenOdd);

        //find max value
        Integer maxValue=elm1.stream()
                .distinct()
                .max(Integer::compare)
                .get();
        System.out.println("maxValue " +maxValue);

        //Merge two List
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        List<Integer> list3=Stream.of(list1,list2)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("merging 2 lsits " + list3);

        //Find sum of elements
        Integer sumNumbers =elm1.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of numbers is " + sumNumbers);

      //find the highest length of word from sentence
        String s1 = "I am learning java";
        String maxLengthString =Arrays.stream(s1.split(" "))
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println("maximum length string is ::" + maxLengthString);

        //find first non repeating character
        String text = "Java RestAPI Microservice SpringBootJ";
        String s2 =Arrays.stream(text.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("First non repeating character is " + s2);


        String str = "programming";

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);


        String sentence = "java is good java is powerful";

        String[] words = sentence.split(" ");

        Map<String, Integer> map1 = new HashMap<>();

        for (String word : words) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        System.out.println(map1);

        String str1 = "swiss";

        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str1.toCharArray()) {
            if (map2.get(ch) == 1) {
                System.out.println("First non-repeating character: " + ch);
                break;
            }
        }




    }
}
