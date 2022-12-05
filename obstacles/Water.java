package Lesson1.obstacles;

import Lesson1.participants.Participant;

public class Water extends Obstacle{

    private int distance;

    public Water(int distance) {
        this.distance = 7;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(distance);
    }
}
