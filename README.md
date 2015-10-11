# Army-Java

<b>Summary</b>

Study project which I keep developing.
Library for turn-based strategy which is close to Heroes of Might and Magic III battle.

<b>General description</b>

<b><i>Basic classes</i></b>
<li><b>Unit:</b> abstract warrior specializing in physical damage</li>
<li><b>Spellcaster:</b> abstract warrior specializing in magic damage. Is Unit subclass</li>

All units are situated on desk with size 8x8 cells or larger.
In one cell can be only one unit at once.
Units can move vertically and horizontally through the desk.
Every unit can attack another unit.
If another unit stays alive after being attacked, he automatically conducts a counter-attack (brings half of damage).
Damage of spellcaster is less then unit's damage.
Desk and units could be visualisated in console.

<b><i>Warrior units</i></b>
<li><b>Soldier:</b> unit without any special abilities</li>
<li><b>Daemon:</b> same to the soldier. Can be only summoned by Warlock</li>
<li><b>Rogue:</b> cannot be counter-attacked</li>
<li><b>Berserker:</b> resistant to magic</li>
<li><b>Vampire:</b> undead. Whenever attacks an enemy, drains part of its life and heal himself. Can infect another unit (except werewolf) after which it become a vampire. Cannot be healed</li>
<li><b>Werewolf:</b> has two states - human and wolf. In state of wolf has larger heat points and damage points, but takes more magic damage. Can infect another unit (except vampire) after which it become a werewolf</li>

<b><i>Magic units</i></b>
<li><b>Wizard:</b> battle mage (healing spells have half effect)</li>
<li><b>Healer:</b> healing mage (battle spells have half effect)</li>
<li><b>Priest:</b> healing mage (battle spells have half effect on every unit except undeads)</li>
<li><b>Warlock:</b> battle mage (battle spells have half effect). Can summon a Daemon</li>
<li><b>Necromancer:</b> undead. Battle mage (battle spells have half effect). Observes everyone whom attacked (phisicaly or by spell). After the death of observable get part of its heat points. Can not be healed</li>

<b><i>Basic spells</i></b>

All spells are contained in mage's spellbook.
Every spell has cost (mana points) and action points which may be different.
Every spell has radius of using.

<li><b>Fireaball:</b> battle spell</li>
<li><b>Heal:</b> healing spell</li>





