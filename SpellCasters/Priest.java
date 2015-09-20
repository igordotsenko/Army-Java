package SpellCasters;

import Abilities.*;
import States.*;

public class Priest extends SpellCaster {
    public Priest(String name, int hitPoints, int damage, int manaPoints) {
        super(name, hitPoints, damage, manaPoints);
        ability = new PriestAbility(this);
        activeSpell = spellBook.get("Heal");
        unitType = UnitType.PRIESTT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
