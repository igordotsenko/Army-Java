import SpellCasters.*;
import Units.*;
import Desk.*;

public class Army  {

    public static void main(String[] args) throws UnitIsDeadException, SelfAttackException, MasterAttackException, FieldIsOccupiedException, ToFarException {
        Desk desk = new Desk();
        Soldier soldier = new Soldier("Soldier", 50, 10, desk, 0, 0);
//        Rogue rogue = new Rogue("Rogue", 50, 10);
//        Berserker berserker = new Berserker("Berserker", 50, 15);
//        Vampire vampire = new Vampire("Vampire", 50, 5);
//        Werewolf werewolf = new Werewolf("Werewolf", 60, 15);
        Wizard wizard = new Wizard("Wizard", 50, 5, 50, desk, 0, 1);
//        Healer healer = new Healer("Healer", 50, 5, 50);
//        Warlock warlock = new Warlock("Warlcok", 50, 10, 60);
//        Necromancer necr = new Necromancer("Necromancer", 50, 10, 50);


//        System.out.println(soldier.toString());
//        System.out.println(rogue.toString());
//        System.out.println(berserker.toString());
//        System.out.println(vampire.toString());
//        System.out.println(werewolf.toString());
//        System.out.println(wizard.toString());
//        System.out.println(healer.toString());
//        System.out.println(warlock.toString());
//        System.out.println(necr.toString());
//        System.out.println("+---+");
//        System.out.println("|   |");
//        System.out.println("|   |");
//        System.out.println("+---+");
        System.out.println(desk.toString());
        soldier.move(1, 0);
        Rogue rogue = new Rogue("Rogue", 50, 10, desk, 0, 0);
        System.out.println(desk.toString());
        soldier.move(2, 1);
        System.out.println(desk.toString());

//
//
//        System.out.println("---------------------------");
//        System.out.println(soldier.toString());
//        System.out.println(rogue.toString());
//        System.out.println(berserker.toString());
//        System.out.println(vampire.toString());
//        System.out.println(werewolf.toString());
//        System.out.println(wizard.toString());
//        System.out.println(healer.toString());
//        System.out.println(necr.toString());
    }
}