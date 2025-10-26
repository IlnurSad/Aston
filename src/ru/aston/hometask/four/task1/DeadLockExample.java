package ru.aston.hometask.four.task1;

public class DeadLockExample {

    public static void main(String[] args) {
        DeadLock example = new DeadLock();

        Thread thread1 = new Thread(() -> {
            while (true) {
                example.method1();
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            while (true) {
                example.method2();
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();
    }
}