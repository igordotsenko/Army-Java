package SpellCasters;

import Abilities.*;
import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import States.*;

public class Wizard extends SpellCaster {
    public Wizard(String name, int hitPoints, int damage, int manaPoints, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException {
        super(name, hitPoints, damage, manaPoints, desk, positionX, positionY);
        this.shortName = new String("Wzr");
        ability = new BattleCasterAbility(this);
        activeSpell = spellBook.get("Fireball");
        unitType = UnitType.WIZARDT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
