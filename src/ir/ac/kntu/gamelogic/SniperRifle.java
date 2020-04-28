package ir.ac.kntu.gamelogic;

public class SniperRifle extends Rifle {
    Boolean zoom;

    public SniperRifle(Caliber caliber, boolean zoom) {
        super(20, 0.4, caliber);
        this.zoom = zoom;

        super.setName("SniperRifle");

        if(zoom) {
            int zoomRate = (RandomHelper.nextInt() % 11) + 5;
            super.setAccuracy( super.getAccuracy() + (super.getAccuracy() * (zoomRate / 100)));
        }

        if(caliber==Caliber.CALIBER5){
            super.setAccuracy(super.getAccuracy() + (super.getAccuracy()*(15/100)));
        }

        if(caliber==Caliber.CALIBER7){
            super.setAccuracy((super.getAccuracy()) - (super.getAccuracy()*(10/100)));
            super.setDamage(super.getDamage() + 10);
        }
        super.setFault(1 - super.getAccuracy());

    }

    public Boolean getZoom() {
        return zoom;
    }

    public void setZoom(Boolean zoom) {
        this.zoom = zoom;
    }

    @Override
    public String toString() {
        return "SniperRifle{" + super.toString() +
                "zoom=" + zoom +
                '}';
    }
}



