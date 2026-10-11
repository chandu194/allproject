package org.example;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        int[] numbers = {2,3,4,5,6,9,2,3};
        int start =0;
        int end= numbers.length -1;
        while(start < end){
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;

        }

        for(int num: numbers){
            System.out.println(num+"");
        }

        //unique in the array
        Set<Integer> set = new HashSet<>();
        for(int num:numbers){
            set.add(num);
        }
        System.out.println(set);


        //unique without hashset
        int[] numbers1 = {2,3,4,5,6,9,2,3};
        int uniqueCount =0;
        for(int i =0; i<numbers1.length;i++){
            int count =0;
            for(int j=0;j<numbers1.length;j++) {
                if (numbers1[i] == numbers1[j]){
                    count++;
                }
            }
            if(count ==1){
                uniqueCount++;
                if(uniqueCount==2){
                System.out.println(numbers1[i]+"");
                break;
                }
            }

        }

        //using hashmap
        int[] numbers2 = {2,3,4,5,6,9,2,3};
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:numbers2){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:numbers2){
            if(map.get(num)==1){
                System.out.println(num);
            }
        }
    }
}
