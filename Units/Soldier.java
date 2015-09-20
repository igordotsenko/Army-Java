package Units;

import Abilities.DefaultAbility;
import Desk.*;
import States.DefaultState;

public class Soldier extends Unit {
    public Soldier(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Slr");
        this.ability = new DefaultAbility(this);
        this.unitType = UnitType.SOLDIERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
