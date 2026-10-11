package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Singletone {
    private static Singletone instance;

    private Singletone() {
    }
    private static synchronized Singletone getInstance(){
        if(instance == null){
            instance = new Singletone();
        }
        return instance;
    }
    static void main() {
      Singletone obj1 = Singletone.getInstance();
      Singletone obj2 = Singletone.getInstance();

      System.out.println(obj1==obj2);
    }
}
