package ru.aston.hometask.four.task1;

public class LiveLockExample {
    private static boolean polite = true;

    public static void main(String[] args) {
        Thread person1 = new Thread(() -> {
            while (polite) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }

                if (polite) {
                    System.out.println("Человек 1: Пропускаю вперед.");
                }
            }
            System.out.println("Человек 1: Прохожу.");
        });

        Thread person2 = new Thread(() -> {
            while (polite) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }

                if (polite) {
                    System.out.println("Человек 2: Пропускаю вперед.");
                }
            }
            System.out.println("Человек 2: Прохожу.");
        });

        System.out.println("=== Два вежливых человека у двери ===");
        person1.start();
        person2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        polite = false;
        System.out.println("\n=== Перестали быть вежливыми ===");
    }
}
