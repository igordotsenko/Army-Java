package Units;

import Abilities.VampireAbility;
import States.DefaultState;

public class Vampire extends Unit{
    public Vampire(String name, int hitPoints, int damage) {
        super(name, hitPoints, damage);
        ability = new VampireAbility(this);
        undead = true;
        unitType = UnitType.VAMPIRET;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }

    @Override
    public void heal(int healPoints) {}
}
