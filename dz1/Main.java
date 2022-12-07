package dz1;

public class Main {
    public static void main(String[] args) {

        Participant[]participant = new Participant[5];
        participant[0]= new Participant("Alex", 100);
        participant[1]=new Participant("Kiki", 90);
        participant[2]= new Participant("Chika", 80);
        participant[3]=new Participant("Nick", 70);
        participant[4]=new Participant("Sofa", 60);

        Team team = new Team("Дружба", participant);

        Obstacle obstacle = new Obstacle(100, 5, 10);
        String result = obstacle.doIt(team);



        System.out.println(result);
    }
}
