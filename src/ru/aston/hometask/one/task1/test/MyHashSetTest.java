package ru.aston.hometask.one.task1.test;

import ru.aston.hometask.one.task1.MyHashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class MyHashSetTest {
    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>(12);
        myHashSet.add("A");
        myHashSet.add("B");
        myHashSet.add(null);
        myHashSet.add("C");
        myHashSet.add("D");
        myHashSet.add("E");
        System.out.println("Вывод ArrayList: " + myHashSet);

        myHashSet.remove("B");
        myHashSet.remove(null);
        System.out.println("Вывод MyHashSet после всех изменений: " + myHashSet);
    }
}