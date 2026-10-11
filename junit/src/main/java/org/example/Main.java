package org.example;

import java.lang.foreign.PaddingLayout;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int add(int a, int b) {
        return a + b;
    }
    static void main() {
     System.out.println(add(1,2));
    }
}
