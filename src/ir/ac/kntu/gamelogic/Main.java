package ir.ac.kntu.gamelogic;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static ArrayList<Soldier> team1;
    private static ArrayList<Soldier> team2;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of death area :");
        Integer numberOfSoldier = scanner.nextInt();
        scanner.close();
        createTeam1(numberOfSoldier);
        createTeam2(numberOfSoldier);
        mainLoop();
    }

    public static void mainLoop() {
        int count = 0;
        while (!(team1.isEmpty() || team2.isEmpty())) {
           // System.out.println(team1.get(0).shoot());
            int randomIndex1 = RandomHelper.nextInt(team1.size());
            int randomIndex2 = RandomHelper.nextInt(team2.size());
            //take a random soldier from team1
            //take a random soldier from team2
            Soldier soldier1 = team1.remove(randomIndex1);
            Soldier soldier2 = team2.remove(randomIndex2);
            int fight1 = soldier1.shoot();
            int fight2 = soldier2.shoot();
            int life1  = soldier1.getLife() - fight2;
            int life2 = soldier2.getLife() - fight1;
            //call team1 soldier to shoot -> subtract it from team2 soldier
            //call team2 soldier to shoot -> subtract it from team1 soldier
            soldier1.setLife(life1);
            soldier2.setLife(life2);
            if (life1 > 0) {
                //return it to team list
                team1.add(soldier1);
            }
            if (life2 > 0) {
                //return it to team list
                team2.add(soldier2);
            }
            printRound(count,soldier1,soldier2,fight1,fight2);
            count ++;
        }
    }

    public static void printRound(int count,Soldier soldier1,Soldier soldier2,int fight1 , int fight2){
        System.out.println("*******" + "ROUND" + count + "*******");
        System.out.println("[" + soldier1 + "]");
        System.out.println("[" + soldier2 + "]");
        System.out.println("Attack" + fight1 + "," + fight2);
        System.out.println("*******" + "END ROUND" + count + "*******");
    }

    public static void createTeam1(int count){
        team1 = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Soldier soldier = new Soldier(i);
            team1.add(soldier);
        }
    }

    public static void createTeam2(int count){
        team2 = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Soldier soldier = new Soldier(i);
            team2.add(soldier);
        }
    }
}
