package Lesson1.obstacles;

import Lesson1.participants.Participant;

public class Race extends Obstacle{
    private int distance;

    public Race(int distance) {
        this.distance = 1500;
    }

    @Override
    public void doIt(Participant participant) {
        participant.run(distance);
    }
}
