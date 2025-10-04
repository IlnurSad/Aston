package homework1.task1.test;

import homework1.task1.MyHashSet;

public class MyHashSetTest {
    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.add("A");
        myHashSet.add("B");
        myHashSet.add("C");
        myHashSet.add("D");
        myHashSet.add("E");
        System.out.println("Вывод ArrayList: " + myHashSet);

        myHashSet.remove("B");
        System.out.println("Вывод MyHashSet после всех изменений: " + myHashSet);
    }
}