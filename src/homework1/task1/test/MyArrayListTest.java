package homework1.task1.test;

import homework1.task1.MyArrayList;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(15);
        myArrayList.add(8);
        myArrayList.add(10);
        System.out.println("Вывод ArrayList: " + myArrayList);

        System.out.println("Вывод элемента по индексу: " + myArrayList.get(2));
        myArrayList.remove(3);

        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(30);
        myArrayList2.add(40);
        myArrayList.addAll(myArrayList2);
        System.out.println("Вывод ArrayList после всех изменений: " + myArrayList);
    }
}