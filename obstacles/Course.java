package Lesson1.obstacles;

import Lesson1.participants.Participant;
import Lesson1.participants.Team;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt (Team team){
        Participant[] teamMembers = team.getMembers();
        if(teamMembers.length > 0){
            for (Participant c: teamMembers){
                for (Obstacle o: obstacles){
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("Жаль, но никто не учавствует....");
        }

    }
}
