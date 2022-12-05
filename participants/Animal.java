package Lesson1.participants;

public class Animal implements Participant {
    String type;
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public  void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(type + " " + name + " " + " успешно справился с бегом");
        } else {
            System.out.println(type + " " + name + " " + " не смог преодолеть бег");
            onDistance = false;
        }

    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (distance <= maxSwimDistance) {
            System.out.println(type + " " + name + " " + " успешно проплыл дистанцию");
        } else {
            System.out.println(type + " " + name + " " + " не смог проплыть дистанцию");
            onDistance = false;
        }

    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " " + " успешно справился с прыжками");
        } else {
            System.out.println(type + " " + name + " " + " не смог прыгнуть");
            onDistance = false;
        }

    }
    public void showResult() {
        System.out.println(type + " " + name + ": " + onDistance);

    }
}