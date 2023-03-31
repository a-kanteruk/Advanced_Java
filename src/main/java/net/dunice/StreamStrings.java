package net.dunice;

import java.util.Arrays;
import java.util.List;

public class StreamStrings {
    public static void main(String[] args) {
        List<String> myList = List.of("a1", "a4", "a3", "a2", "a1", "a4");

        System.out.println("Сортировка по алфавиту: ");
        myList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Вывод с добавлением '_1': ");
        myList.stream()
                .map(item -> item + "_1")
                .forEach(System.out::println);

        System.out.println("Вывод коллекции преобразованной в массив чисел: ");
        int[] myArray = myList.stream()
                              .map(item -> item.replace("a",""))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        Arrays.stream(myArray)
                .forEach(System.out::println);

        System.out.println("Вывод отсортированной коллекции без дубликатов: ");
        myList.stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }
}
