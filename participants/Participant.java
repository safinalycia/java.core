package Lesson1.participants;

public interface Participant {
     void run(int distance);
     void swim(int distance);
     void jump(int height);
     boolean isOnDistance();
     void showResult();
}
