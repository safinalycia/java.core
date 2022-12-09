package dz4.task1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> fruit = new ArrayList<>();
        fruit.add("Apple");
        fruit.add("Apple");
        fruit.add("Apple");
        fruit.add("Orange");
        fruit.add("Orange");
        fruit.add("Lemon");
        fruit.add("Lemon");
        fruit.add("Lychee");
        fruit.add("Pineapple");
        fruit.add("Pineapple");
        fruit.add("Pear");
        fruit.add("Grape");
        fruit.add("Apricot");
        fruit.add("Peach");

        System.out.println();

        // ArrayList<String> uniqueFruit = new ArrayList<>();
        //  for (String fruits : fruit) {
        // if (!uniqueFruit.contains(fruit)) {
        //      uniqueFruit.add(fruits);
        //  }
        // }
        //  System.out.println(uniqueFruit);

        Map<String, Integer> uniqueFruit = new HashMap<>();
        for (String s : fruit) {
            uniqueFruit.put(s, uniqueFruit.getOrDefault(s, 0) + 1);
        }
        // uniqueFruit.entrySet().forEach(System.out::println);

        System.out.println("Сколько раз встречаются фрукты: " + uniqueFruit);

        System.out.println("Уникальные фрукты: ");

        Set<String> uniquesFruits = new HashSet<>(fruit);
        uniquesFruits.forEach(System.out::println);
    }
}
