package Units;

import Abilities.DefaultAbility;
import Desk.*;
import Exceptions.LocationIsNotFreeException;
import Exceptions.OutOfTheDeskException;
import States.DefaultState;

public class Soldier extends Unit {
    public Soldier(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, OutOfTheDeskException, OutOfTheDeskException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Slr");
        this.speed = 1;
        this.ability = new DefaultAbility(this);
        this.unitType = UnitType.SOLDIERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
