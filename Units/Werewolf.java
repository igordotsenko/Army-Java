package Units;

import Abilities.WerewolfAbility;
import States.DefaultState;
import States.WolfState;

public class Werewolf extends Unit{
    public Werewolf(String name, int hitPoints, int damage) {
        super(name, hitPoints, damage);
        ability = new WerewolfAbility(this);
        unitType = UnitType.WEREWOLFT;
        currentState = new DefaultState(this);
        altState = new WolfState(this);
    }
}
