package com.petclinic;

import java.util.*;
import java.lang.Math;


public class HashMapDemo {

    public static void main(String[] args) {
        Map<Integer, Map<Integer, String>> h = new LinkedHashMap<>();
        Map<String, Integer> lh = new HashMap<>();
        Map<Integer, String> lhs = new LinkedHashMap<>();

List<Integer> list = new LinkedList<>();
//lis5

for(Object o:list)
    System.out.println(o);


        lh.put("1",2);
        lh.put("1",3);
        System.out.println(lh.get("1"));

    }
}
