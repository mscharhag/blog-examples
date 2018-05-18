package com.mscharhag.streamstatistics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
/*
Streams of primitive types (IntStream, etc.) provide a summaryStatistics() methods that can be used
to get multiple _statistical_ properties of a stream (minimum value, average value, etc.)

Assume we have a list of people. Our goal is to get the minimum, maximum and average age of the people in the list.
The problem is that the computation of the minimum, maximum and average values are terminal operations.
So we need to come up with our own reduction implementation or create a new stream for every computation.
A naive implementation might look like this:
 */
        List<Person> list = Arrays.asList(
                new Person("John Blue", 28),
                new Person("Anna Brown", 53),
                new Person("Paul Black", 47)
        );

        double average = list.stream()
                .collect(Collectors.averagingInt(Person::getAge));

        int min = list.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElseThrow(NoSuchElementException::new);

        int max = list.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElseThrow(NoSuchElementException::new);

/*
        Luckily Java provides a much simpler way to do this using the summaryStatistics() method:
 */

        IntSummaryStatistics statistics = list.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();

//        double average = statistics.getAverage();
//        int min = statistics.getMin();
//        int max = statistics.getMax();

/*
        IntSummaryStatistics also provides methods to obtain the count and sum of the stream elements.
 */
        System.out.println(average + " " + min + " " + max);
    }
}
