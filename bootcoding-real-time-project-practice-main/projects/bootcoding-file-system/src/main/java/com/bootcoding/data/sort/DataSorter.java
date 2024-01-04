package com.bootcoding.data.sort;

import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

public class DataSorter {

    public static void main(String[] args) {
        String[] fruits = { "Banana",
                "Watermelon", "Apple", "Pineapple", "Tomato"};

        print(fruits);

        Arrays.sort(fruits);

        System.out.println("After Sorting");

        print(fruits);

        Integer[] dates = { 4, 15, 3, 9, 25};
        print(dates);
        Arrays.sort(dates);
        System.out.println("After Integer Sorting");
        print(dates);


        ArrayList<String> data = new ArrayList<>();
        data.add("Ramesh");
        data.add("Ganesh");
        data.add("Suresh");
        data.add("Dinesh");
        data.add("Mahesh");
        print(data);
        Collections.sort(data);
        System.out.println("After sorting arraylist");
        print(data);

        ArrayList<Fruit> fruitList = new ArrayList<>();
        fruitList.add(Fruit.builder().name("Apple").quantity(10).build());
        fruitList.add(Fruit.builder().name("Pineapple").quantity(34).build());
        fruitList.add(Fruit.builder().name("Watermelon").quantity(25).build());
        fruitList.add(Fruit.builder().name("Tomato").quantity(25).build());
        fruitList.add(Fruit.builder().name("Banana").quantity(10).build());

        print(fruitList);
        Collections.sort(fruitList);
        System.out.println("After sorting Fruit Objects:");
        print(fruitList);

        Collections.sort(fruitList, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        Collections.sort(fruitList, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.quantity - o2.quantity;
            }
        });

        System.out.println("After double sorting");
        print(fruitList);

    }


    private static void print(Object[] arr){
        for(Object f : arr){
            System.out.println(f);
        }
    }

    private static void print(List arr){
        for(Object f : arr){
            System.out.println(f);
        }
    }
}
