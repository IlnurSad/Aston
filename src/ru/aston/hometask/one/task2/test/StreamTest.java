package ru.aston.hometask.one.task2.test;

import ru.aston.hometask.one.task2.Book;
import ru.aston.hometask.one.task2.Student;

import java.util.Comparator;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Student> students = getStudents();

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .peek(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        book -> System.out.println("Final result - Book year: " + book.getYear()),
                        () -> System.out.println("Final result - Book not found")
                );
    }

    private static List<Student> getStudents() {
        List<Book> books1 = List.of(
                new Book("Java. Эффективное программирование", "Джошуа Блох", 2018, 416),
                new Book("Чистый код", "Роберт Мартин", 2008, 464),
                new Book("Java. Конкурентность на практике", "Брайан Гетц", 2006, 424),
                new Book("Kotlin в действии", "Дмитрий Жемеров", 2017, 360),
                new Book("Шаблоны корпоративных приложений", "Мартин Фаулер", 2002, 560)
        );

        List<Book> books2 = List.of(
                new Book("Рефакторинг. Улучшение существующего кода", "Мартин Фаулер", 2019, 448),
                new Book("Чистая архитектура", "Роберт Мартин", 2017, 432),
                new Book("Паттерны проектирования", "Э. Фримен, Э. Фримен", 2004, 694),
                new Book("Предметно-ориентированное проектирование", "Эрик Эванс", 2003, 560),
                new Book("Java. Эффективное программирование", "Джошуа Блох", 2018, 416)
        );

        List<Book> books3 = List.of(
                new Book("Проектирование данных-интенсивных приложений", "Мартин Клеппман", 2017, 616),
                new Book("Практичный программист", "Эндрю Хант, Дэвид Томас", 1999, 352),
                new Book("Чистый код", "Роберт Мартин", 2008, 464),
                new Book("Выпускайте! Надёжные приложения", "Майкл Нигард", 2018, 350),
                new Book("Эффективная работа с унаследованным кодом", "Майкл Физерс", 2004, 456)
        );

        return List.of(
                new Student("Alisa", books1),
                new Student("Dima", books2),
                new Student("Artur", books3)
        );
    }
}