package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        //reverse the list
        int[] intArray = {1,2,3,4,5,6};
        int a =0;
        int b = intArray.length-1;
        while(a<b){
            int temp;
            temp = intArray[a];
            System.out.println("temp  " +temp);
            intArray[a] = intArray[b];
            System.out.println("a  " +intArray[a]);
            intArray[b] = temp;
            System.out.println("b  " +intArray[b]);
            a++;
            b--;
        }
        System.out.println(Arrays.toString(intArray));

        //move all zero to end by maintaining the order
        int[] nums = {0,1,0,3,12};
        int compareNumber =0;
        for(int i=0; i<nums.length-1; i++){
            System.out.println(compareNumber);
            if(nums[i]!=0){
              int  temp = nums[compareNumber];

                nums[compareNumber] = nums[i];
                nums[i]=temp;
                compareNumber++;
            }

        }


    }
}
