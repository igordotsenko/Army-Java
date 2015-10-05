package Units;

import Abilities.VampireAbility;
import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import States.DefaultState;

public class Vampire extends Unit{
    public Vampire(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, Exceptions.OutOfTheDeskException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Vmp");
        this.speed = 2;
        ability = new VampireAbility(this);
        undead = true;
        unitType = UnitType.VAMPIRET;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }

    @Override
    public void heal(int healPoints) {}
}
