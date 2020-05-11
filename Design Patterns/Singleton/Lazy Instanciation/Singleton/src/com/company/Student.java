package com.company;

public class Student {

    private static Student obj;

    //private constructor for outside class cannot generate instance fro that
    private Student() {

    }

    //this provides the global point of access to the singleton object and return the instance to the caller
    public static Student getObj() {
        if(obj==null){
            synchronized (Student.class){
                if(obj==null){
                    obj=new Student();//instance will be created at request time 
                }
            }
        }
        return obj;
    }
}
