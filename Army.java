import SpellCasters.*;
import Units.*;

public class Army  {

    public static void main(String[] args) throws UnitIsDeadException, SelfAttackException, NotEnoughManaException, SlaveAlreadySummonedException, MasterAttackException {
        Soldier soldier = new Soldier("Soldier", 50, 10);
        Rogue rogue = new Rogue("Rogue", 50, 10);
        Berserker berserker = new Berserker("Berserker", 50, 15);
        Vampire vampire = new Vampire("Vampire", 50, 5);
        Werewolf werewolf = new Werewolf("Werewolf", 60, 15);
        Wizard wizard = new Wizard("Wizard", 50, 5, 50);
        Healer healer = new Healer("Healer", 50, 5, 50);
        Warlock warlock = new Warlock("Warlcok", 50, 10, 60);
        Necromancer necr = new Necromancer("Necromancer", 50, 10, 50);

        System.out.println(soldier.toString());
        System.out.println(rogue.toString());
        System.out.println(berserker.toString());
        System.out.println(vampire.toString());
        System.out.println(werewolf.toString());
        System.out.println(wizard.toString());
        System.out.println(healer.toString());
        System.out.println(warlock.toString());
        System.out.println(necr.toString());

        System.out.println("---------------------------");
        necr.castSpell(soldier);
        necr.castSpell(rogue);
        rogue.attack(necr);
        System.out.println(soldier.toString());
        System.out.println(rogue.toString());
        System.out.println(necr.toString());

        System.out.println("---------------------------");
        for ( int i = 1; i <= 4; i++ ) {
            rogue.attack(soldier);
        }
        System.out.println(soldier.toString());
        System.out.println(rogue.toString());
        System.out.println(necr.toString());

        System.out.println("---------------------------");
        for ( int i = 1; i <= 10; i++ ) {
            vampire.attack(necr);
            necr.addHitPoints(100);
        }

        System.out.println("---------------------------");
        System.out.println(soldier.toString());
        System.out.println(rogue.toString());
        System.out.println(berserker.toString());
        System.out.println(vampire.toString());
        System.out.println(werewolf.toString());
        System.out.println(wizard.toString());
        System.out.println(healer.toString());
        System.out.println(necr.toString());
    }
}