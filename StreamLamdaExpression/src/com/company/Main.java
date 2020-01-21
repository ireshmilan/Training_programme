package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        HashMap<String,Integer> hashmap= new HashMap<>();
        hashmap.put("Iresh",59);
        hashmap.put("Yoyo",100);
        hashmap.put("Mithila",77);
        hashmap.put("Lakshitha",69);
        hashmap.put("Gayan",99);
        hashmap.put("Tatyana",45);
        hashmap.put("Indika",84);
        hashmap.put("Indika",77);//Hashmap cannot duplicate key
        System.out.println(hashmap.keySet());
        List<String> student=hashmap.keySet().stream().filter((s) ->  hashmap.get(s) > 60).sorted().collect(Collectors.toList());
        System.out.println(student);



    }
}
