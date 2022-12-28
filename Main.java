package Lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Lycia",Arrays.asList(new Course("HTML&CSS"), new Course("Linux"), new Course("Java.1level"), new Course("Komp.sety"))));
        students.add(new Student("Tanya",Arrays.asList(new Course("Java.Core"), new Course("Linux"), new Course("OOP"))));
        students.add(new Student("Ivan", Arrays.asList(new Course("Testing"), new Course("Testing WEB"), new Course("Komp.sety"))));
        students.add(new Student("Goga", Arrays.asList(new Course("Math"), new Course("Excel"), new Course("C#"))));

        System.out.println("Список всех курсов: ");


        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        System.out.println("Любознательный студент: ");




        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toSet()));



        System.out.println("Уникальный курс: ");

        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toSet()));



    }
}
