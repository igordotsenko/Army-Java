package Units;

import Abilities.WerewolfAbility;
import Exceptions.LocationIsNotFreeException;
import States.DefaultState;
import States.WolfState;
import Desk.*;

public class Werewolf extends Unit{
    public Werewolf(String name, int hitPoints, int damage, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.shortName = new String("Wlf");
        this.speed = 2;
        ability = new WerewolfAbility(this);
        unitType = UnitType.WEREWOLFT;
        currentState = new DefaultState(this);
        altState = new WolfState(this);
    }
}
