package SpellCasters;

import Units.*;
import Abilities.*;
import States.*;

public class Warlock extends SpellCaster {
    private Daemon slave;
    public static int daemonCost = 20;

    public Warlock(String name, int hitPoints, int damage, int manaPoints) {
        super(name, hitPoints, damage, manaPoints);
        ability = new BattleCasterAbility(this);
        activeSpell = spellBook.get("Fireball");
        slave = null;
        unitType = UnitType.WARLOCKT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }

    public Daemon getSlave() {
        return slave;
    }

    public Daemon summonSlave() throws SlaveAlreadySummonedException, NotEnoughManaException {
        if ( slave != null ) {
            throw new SlaveAlreadySummonedException();
        }
        if ( manaPoints < daemonCost ) {
            throw new NotEnoughManaException();
        }
        slave = new Daemon(this);
        manaPoints -= daemonCost;
        return slave;
    }

    public void freeSlave() {
        slave = null;
    }

    @Override
    public String toString() {
        String out = super.toString();

        if ( slave != null ) {
            out += ", has slave";
        }
        return out;
    }
}
