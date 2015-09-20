package SpellCasters;

import Units.*;
import Abilities.*;
import States.*;

public class Healer extends SpellCaster {
    public Healer(String name, int hitPoints, int damage, int manaPoints) {
        super(name, hitPoints, damage, manaPoints);
        ability = new HealerAbility(this);
        activeSpell = spellBook.get("Heal");
        unitType = UnitType.HEALERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
