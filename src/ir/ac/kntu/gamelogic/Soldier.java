package ir.ac.kntu.gamelogic;

import static ir.ac.kntu.gamelogic.Caliber.CALIBER5;
import static ir.ac.kntu.gamelogic.Caliber.CALIBER7;

public class Soldier {
    private Rifle rifle;
    private int life = 100;
    private int number;

    public Soldier(int number) {
        this.number = number;
        generateRifle();
    }

    public int shoot() {
        return RandomHelper.nextInt(100) <= rifle.getAccuracy() * 100 ? rifle.getDamage() : 0;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Rifle getRifle() {
        return rifle;
    }


    public void setRifle(Rifle rifle) {
        this.rifle = rifle;
    }
    public void generateRifle() {
        int random=RandomHelper.nextInt(6);
        switch (random){
            case 0:
                this.rifle=new AssaultRifle(CALIBER5);
                break;
            case 1:
                this.rifle=new AssaultRifle(CALIBER7);
            case 2:
                this.rifle=new SniperRifle(CALIBER5, true);
                break;
            case 3:
                this.rifle=new SniperRifle(CALIBER5, false);
                break;
            case 4:
                this.rifle=new SniperRifle(CALIBER7, true);
                break;
            case 5:
                this.rifle=new SniperRifle(CALIBER7, false);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + random);
        }
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "rifle=" + rifle +
                ", life=" + life +
                ", number=" + number +
                '}';
    }
}
