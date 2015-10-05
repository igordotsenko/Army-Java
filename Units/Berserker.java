package Units;

import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import States.DefaultState;
import Abilities.BerserkerAbility;


public class Berserker extends Unit {
    public Berserker(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, Exceptions.OutOfTheDeskException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Brs");
        this.speed = 2;
        ability = new BerserkerAbility(this);
        unitType = UnitType.BERSERKRT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
