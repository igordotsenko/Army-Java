package Spells;

public class Heal extends Spell {
    public Heal() {
        name = "Heal";
        actionPoints = 15;
        cost = 10;
        actionRadius = 4;
        battleSpell = false;
    }
}
