package Units;

import States.DefaultState;
import Abilities.BerserkerAbility;


public class Berserker extends Unit {
    public Berserker(String name, int hitPoints, int damage) {
        super(name, hitPoints, damage);
        ability = new BerserkerAbility(this);
        unitType = UnitType.BERSERKRT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
