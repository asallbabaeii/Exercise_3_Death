package ir.ac.kntu.gamelogic;

import java.util.Objects;

public class Rifle {
    private String name;
    private int damage;
    private Caliber caliber;
    private Double accuracy;
    private Double fault;
    public Rifle(){}

    public Rifle(int damage,Double fault , Caliber caliber) {
        this.damage = damage;
        this.caliber = caliber;
        this.fault = fault;
        this.accuracy = 1 - this.fault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double getFault() {
        return fault;
    }

    public void setFault(Double fault) {
        this.fault = fault;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Caliber getCaliber() {
        return caliber;
    }

    public void setCaliber(Caliber caliber) {
        this.caliber = caliber;
    }

    public int handleCaliber(int life){
        return life;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rifle rifle = (Rifle) o;
        return damage == rifle.damage &&
                Objects.equals(name, rifle.name) &&
                caliber == rifle.caliber &&
                Objects.equals(accuracy, rifle.accuracy) &&
                Objects.equals(fault, rifle.fault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, damage, caliber, accuracy, fault);
    }

    @Override
    public String toString() {
        return "Rifle{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", caliber=" + caliber +
                ", accuracy=" + accuracy +
                ", fault=" + fault +
                '}';
    }
}
