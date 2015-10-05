package Units;

import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import States.DefaultState;
import Abilities.RogueAbility;

public class Rogue extends Soldier{
    public Rogue(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, Exceptions.OutOfTheDeskException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Rge");
        this.speed = 2;
        this.ability = new RogueAbility(this);
        this.unitType = UnitType.ROGUET;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
