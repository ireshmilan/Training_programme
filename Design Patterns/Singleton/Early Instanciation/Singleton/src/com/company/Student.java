package com.company;

public class Student {
    //Early, instance will be created at load time
    private static Student obj = new Student();

    //private constructor for outside class cannot generate instance fro that
    private Student() {

    }

    //this provides the global point of access to the singleton object and return the instance to the caller
    public static Student getObj() {
        return obj;
    }
}
