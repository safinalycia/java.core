package dz1;

public class Obstacle {

    String result;
    private int run;
    private int jump;
    private int swim;

    public Obstacle(int run, int jump, int swim) {
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }

    public String doIt(Team team){
        result = "команда: "+ team.getTeamName()+ " " + '\n';
        for (Participant participant: team.getParticipants()){
            result += "имя участника: " + participant.getNameParticipant()+ " " + '\n';
            int value = participant.getAble();
            testRun(value);
            testJump(value);
            testSwim(value);

        }

        return result;
    }

    private void testRun(int value) {
        if (value<run) result = result + "участник не добежал" + '\n';
        else result += "добежал" + '\n';
    }

    private void testJump(int value) {
        if (value<jump) result = result + "участник не допрыгнул" + '\n';
        else result += "допрыгнул" + '\n';

    }

    private void testSwim(int value) {
        if (value<swim) result = result + "участник не доплыл" + '\n';
        else result += "доплыл" + '\n';
    }




}
