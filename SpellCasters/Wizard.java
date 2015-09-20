package SpellCasters;

import Abilities.*;
import States.*;

public class Wizard extends SpellCaster {
    public Wizard(String name, int hitPoints, int damage, int manaPoints) {
        super(name, hitPoints, damage, manaPoints);
        ability = new BattleCasterAbility(this);
        activeSpell = spellBook.get("Fireball");
        unitType = UnitType.WIZARDT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
