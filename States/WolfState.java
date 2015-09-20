package States;

import Units.Unit;

public class WolfState extends State{
    public WolfState(Unit actionUnit) {
        super(actionUnit);
        name = "Wolf state";
        hitPointsLimit = actionUnit.getHitPointsLimit() * 2;
        damage = actionUnit.getDamage() * 2;
    }

    @Override
    public void takeMagicDamage(int dmg) {
        int hitPoints = actionUnit.getHitPoints();
        int newDmg = dmg * 2;

        if ( newDmg > hitPoints ) {
            actionUnit.setHitPoints(0);
            return;
        }
        actionUnit.setHitPoints(hitPoints -= newDmg);
    }
}
