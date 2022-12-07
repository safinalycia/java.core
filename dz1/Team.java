package dz1;

public class Team {
    private String teamName;
    private Participant[]participants;

    public Team(String teamName, Participant[] participants) {
        this.teamName = teamName;
        this.participants = participants;
    }

    public String getTeamName() {
        return teamName;
    }

    public Participant[] getParticipants() {
        return participants;
    }
}
