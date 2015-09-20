package Spells;

/**
 * Created by Igor on 13.09.2015.
 */
public abstract class Spell {
    protected String name;
    protected int actionPoints;
    protected int cost;
    protected boolean battleSpell;

    public Spell() {}

    public String getName() {
        return name;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public int getCost() {
        return cost;
    }

    public boolean isBattleSpell() {
        return battleSpell;
    }
}
