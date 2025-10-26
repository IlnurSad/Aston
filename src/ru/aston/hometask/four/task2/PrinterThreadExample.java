package ru.aston.hometask.four.task2;

import java.util.concurrent.Semaphore;

public class PrinterThreadExample {
    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(0);
    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (running) {
                try {
                    semaphore1.acquire();
                    System.out.println("1");
                    Thread.sleep(500);
                    semaphore2.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (running) {
                try {
                    semaphore2.acquire();
                    System.out.println("2");
                    Thread.sleep(500);
                    semaphore1.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false;
        thread1.interrupt();
        thread2.interrupt();
    }
}