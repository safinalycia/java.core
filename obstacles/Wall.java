package Lesson1.obstacles;

import Lesson1.participants.Participant;


public class Wall extends Obstacle{

    private int height;

    public Wall(int height) {
        this.height = 6;
    }

    @Override
    public void doIt(Participant participant) {
        participant.jump(height);
    }
}
