package com.mscharhag.streamstatistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;

public class Example {

    private static class Person {
        private int age;

        public Person(String name, int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String... args) {

        List<Person> list = Arrays.asList(
                new Person("John Blue", 28),
                new Person("Anna Brown", 53),
                new Person("Paul Black", 47)
        );

        int min = list.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElseThrow(NoSuchElementException::new);

        int max = list.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElseThrow(NoSuchElementException::new);

        IntSummaryStatistics statistics = list.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();

//        int min = statistics.getMin();
//        int max = statistics.getMax();

        System.out.println(min + " " + max);
    }
}
