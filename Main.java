package Lesson1;

import Lesson1.participants.*;
import Lesson1.obstacles.*;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {new Sheep("Dolly"), new Cat("Chika"), new Dog("Rex")};

        Obstacle [] obstacles = {new Race(1500), new Wall(5), new Water(4)};

            Team team = new Team("команда Животных", participants);

        System.out.println("--команда создана--");
        System.out.println(team.getTeamName());

        Course course = new Course(obstacles);

        System.out.println("--команда на старте--");
        course.doIt(team);

        System.out.println("--результат команды");
        team.showResults();

        System.out.println("финиш");
        team.showMembersFinishedCourse();

    }
}
