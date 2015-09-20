package States;

import Units.Unit;

/**
 * Created by Igor on 13.09.2015.
 */
public abstract class State {
    protected Unit actionUnit;
    protected String name;
    protected int hitPointsLimit;
    protected int damage;

    public State(Unit actionUnit) {
        this.actionUnit = actionUnit;
        this.hitPointsLimit = actionUnit.getHitPointsLimit();
        this.damage = actionUnit.getDamage();
    }



    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }

    public int getHitPointsLimit() {
        return hitPointsLimit;
    }
    public State(int damage) {
        this.damage = damage;
    }
    public void takeMagicDamage(int dmg) {
        int hitPoints = actionUnit.getHitPoints();

        if ( dmg > hitPoints ) {
            actionUnit.setHitPoints(0);
            return;
        }
        actionUnit.setHitPoints( hitPoints -= dmg);
    }
}
