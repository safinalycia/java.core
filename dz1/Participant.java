package dz1;

public class Participant {

    private String nameParticipant;
    private int able;

    public Participant(String nameParticipant, int able) {
        this.nameParticipant = nameParticipant;
        this.able = able;
    }

    public String getNameParticipant() {
        return nameParticipant;
    }

    public int getAble() {
        return able;
    }
}
