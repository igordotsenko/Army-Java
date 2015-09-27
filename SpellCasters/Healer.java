package SpellCasters;

import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import Units.*;
import Abilities.*;
import States.*;

public class Healer extends SpellCaster {
    public Healer(String name, int hitPoints, int damage, int manaPoints, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException {
        super(name, hitPoints, damage, manaPoints, desk, positionX, positionY);
        this.shortName = new String("Hlr");
        ability = new HealerAbility(this);
        activeSpell = spellBook.get("Heal");
        unitType = UnitType.HEALERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
