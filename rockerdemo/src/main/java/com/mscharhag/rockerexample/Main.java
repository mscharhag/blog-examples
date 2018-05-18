package com.mscharhag.rockerexample;

import com.fizzed.rocker.Rocker;
import com.fizzed.rocker.runtime.RockerRuntime;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String... args) throws Exception {
        RockerRuntime.getInstance().setReloading(true); // PR

        String output = null;

        output = views.basic.template("John")
                .render()
                .toString();


//        output = Rocker.template("views/basic.rocker.html")
//                .bind("name", "John")
//                .render()
//                .toString();


//        output = Rocker.template("views/expressions.rocker.html")
//                .bind("user", new User("Joe", "Smith"))
//                .render()
//                .toString();


//        output = Rocker.template("views/conditions.rocker.html")
//                .bind("user", new User("Martin", "Smith"))
//                .render()
//                .toString();


//        List<User> users = Arrays.asList(
//            new User("John", "Foo"),
//            new User("Martin", "Bar"),
//            new User("Anna", "Baz")
//        );
//        output = Rocker.template("views/loops.rocker.html")
//                .bind("users", users)
//                .render()
//                .toString();


        System.out.println(output);
    }
}
