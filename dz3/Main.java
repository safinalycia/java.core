package dz3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Apple [] apples = new Apple[6];
        ArrayList<Apple> appleList = new ArrayList<>(6);


        Apple apple0 = new Apple("1", 10);
        Apple apple1 = new Apple("2", 11);
        Apple apple2 = new Apple("3", 12);
        Apple apple3 = new Apple("4",13);

        apples[0] = apple0;
        appleList.add(apple0);
        apples[1] = apple1;
        appleList.add(apple1);
        apples[2] = apple2;
        appleList.add(apple2);
        apples[3] = apple3;
        appleList.add(apple3);
        Box<Apple> Box1 = new Box<>(appleList);

        ArrayList<Orange> orangeList1 = new ArrayList<>();
        orangeList1.add(new Orange("1", 12));
        orangeList1.add(new Orange("2", 13));
        orangeList1.add(new Orange("3", 14));
        orangeList1.add(new Orange("4", 15));
        orangeList1.add(new Orange("5", 16));
        Box<Orange> Box2 = new Box<>(orangeList1);

        ArrayList<Apple> appleList2 = new ArrayList<>();
        Box<Apple> Box3 = new Box<>(appleList2);

        ArrayList<Orange> orangeList2 = new ArrayList<>();
        Box<Orange> Box4 = new Box<>(orangeList2);

        System.out.println("Вес первой коробки равен: " + Box1.getWeightList() + " грамм.");
        System.out.println("Вес второй коробки равен: " + Box2.getWeightList() + " грамм.");
        System.out.println("Вес третьей коробки равен: " + Box3.getWeightList() + " грамм.");
        System.out.println("Вес четвертой коробки равен: " + Box4.getWeightList() + " грамм.\n");

        System.out.println(Box1.compareList(Box2));
        System.out.println(Box3.compareList(Box4) + "\n");

        Box1.toEmptyList(Box3);
        Box2.toEmptyList(Box4);

        System.out.println("Вес первой коробки равен: " + Box1.getWeightList() + " грамм.");
        System.out.println("Вес второй коробки равен: " + Box2.getWeightList() + " грамм.");
        System.out.println("Вес третьей коробки равен: " + Box3.getWeightList() + " грамм.");
        System.out.println("Вес четвертой коробки равен: " + Box4.getWeightList() + " грамм.\n");

        System.out.println(Box1.compareList(Box2));
        System.out.println(Box3.compareList(Box4));
    }


    }

