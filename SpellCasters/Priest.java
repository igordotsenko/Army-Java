package SpellCasters;

import Desk.Desk;
import Exceptions.LocationIsNotFreeException;
import Exceptions.OutOfTheDeskException;
import States.*;

public class Priest extends SpellCaster {
    public Priest(String name, int hitPoints, int damage, int manaPoints, Desk desk, int positionX, int positionY) throws LocationIsNotFreeException, OutOfTheDeskException, OutOfTheDeskException {
        super(name, hitPoints, damage, manaPoints, desk, positionX, positionY);
        this.shortName = new String("Pst");
        activeSpell = spellBook.get("Heal");
        unitType = UnitType.PRIESTT;
        currentState = new DefaultState(this);
        altState = new DefaultState(this);
    }
}
