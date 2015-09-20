package SpellCasters;

import Abilities.Ability;
import States.*;
import Units.*;

public class Necromancer extends SpellCaster {
    public Necromancer(String name, int hitPoints, int damage, int manaPoints) {
        super(name, hitPoints, damage, manaPoints);
        activeSpell = spellBook.get("Fireball");
        undead = true;
        unitType = UnitType.NECROMANCERT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }

    @Override
    public void changeAbility(Ability newAbility) {
        notifyObservables();
        observables.clear();
        super.changeAbility(newAbility);
    }
    @Override
    public void castSpell(Unit target) throws UnitIsDeadException, NotEnoughManaException {
        super.castSpell(target);
        addObservable(target);
    }
    @Override
    public void heal(int healPoints) {}
}
