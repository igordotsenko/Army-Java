package SpellCasters;

import java.util.HashMap;

import Desk.Desk;
import Exceptions.*;
import Units.*;
import Abilities.*;
import Spells.*;

public abstract class SpellCaster extends Unit {
    protected int manaPoints;
    protected int manaPointsLimit;
    protected HashMap<String, Spell> spellBook;
    protected Spell activeSpell;

    public SpellCaster(String name, int hitPoints, int damage, int manaPoints, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException {
        super(name, hitPoints, damage, desk, positionX, positionY);
        this.manaPoints = manaPoints;
        this.manaPointsLimit = manaPoints;
        this.speed = 1;
        ability = new BattleCasterAbility(this);
        spellBook = new HashMap<String, Spell>();
        addSpell(new Fireball());
        addSpell(new Heal());
    }

    public int getManaPoints() {
        return manaPoints;
    }
    public int getManaPointsLimit() {
        return manaPointsLimit;
    }
    public Spell getActiveSpell() {
        return activeSpell;
    }

    public void addManaPoints(int manaPoints) {
        int newManaPoints = this.manaPoints + manaPoints;

        if ( newManaPoints >= manaPointsLimit ) {
            this.manaPoints = manaPointsLimit;
            return;
        }

        this.manaPoints = newManaPoints;
    }
    public void castSpell(Unit target) throws UnitIsDeadException, NotEnoughManaException {
        ensureIsAlive();
        if ( manaPoints < activeSpell.getCost() ) {
            throw new NotEnoughManaException();
        }
        ability.castSpell(target, activeSpell);
        manaPoints -= activeSpell.getCost();
    }
    public void changeSpell(String newActiveSpell) {
        activeSpell = spellBook.get(newActiveSpell);
    }
    public void addSpell(Spell newSpell) {
        spellBook.put(newSpell.getName(), newSpell);
    }
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        String out = new String();

        buffer.append(super.toString());
        if ( hitPoints == 0 ) {
            out = buffer.toString();
            return out;
        }
        buffer.append(", mana(" + manaPoints + "/" + manaPointsLimit + ")");
        buffer.append(", active spell is " + activeSpell.getName());
        out = buffer.toString();
        return out;
    }
}
