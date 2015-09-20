package Units;

import States.DefaultState;
import Abilities.RogueAbility;

public class Rogue extends Soldier{
    public Rogue(String name, int hitPoints, int damage) {
        super(name, hitPoints, damage);
        this.ability = new RogueAbility(this);
        this.unitType = UnitType.ROGUET;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
