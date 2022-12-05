package Lesson1.participants;

public class Team {
    String teamName;

    Participant[] teamMembers = new Participant[4];

    public Team(String teamName, Participant[] teamMembers) {
        this.teamName = "команда животных";
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return "Team name: " + teamName;
    }



    public Participant[] getMembers() {
        return teamMembers;
    }

   // public void showResults(){
       // for (Participant c : teamMembers){
           // c.showResult();
        //}
   // }

    public void showResults(){
        for (Participant participant : teamMembers) {
            //obstacle.doIt(participant);
            if (!participant.isOnDistance()) {
                break;
            }
        }
    }

    public void showMembersFinishedCourse() {
        for (Participant c : teamMembers){
            if (c.isOnDistance())
            c.showResult();
        }
    }
}
