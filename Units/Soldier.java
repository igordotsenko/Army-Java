package Units;

import Abilities.DefaultAbility;
import States.DefaultState;

/**
 * Created by Igor on 13.09.2015.
 */
public class Soldier extends Unit {
    public Soldier(String name, int hitPoints, int damage) {
        super(name, hitPoints, damage);
        this.ability = new DefaultAbility(this);
        this.unitType = UnitType.SOLDIERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
