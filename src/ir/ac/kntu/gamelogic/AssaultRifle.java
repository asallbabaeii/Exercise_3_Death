package ir.ac.kntu.gamelogic;

public class AssaultRifle extends Rifle {

    public AssaultRifle(Caliber caliber) {

        super(10, 0.5, caliber);
        super.setName("AssaultRifle");

        if(super.getCaliber()==Caliber.CALIBER5){
            super.setAccuracy((super.getAccuracy()) + (super.getAccuracy()*(15/100)));
        }

        if(super.getCaliber()==Caliber.CALIBER7){
            super.setAccuracy((super.getAccuracy()) - (super.getAccuracy()*(10/100)));
            super.setDamage(super.getDamage() + 10);
        }

        super.setFault(1 - super.getAccuracy());
    }

    @Override
    public String toString() {
        return "AssaultRifle" + "{" + super.toString() + "}";
    }
}
