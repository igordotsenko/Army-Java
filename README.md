# Army-Java

<b>Summary</b>

Study project which is still being developed.
Library for turn-based strategy which is close to Heroes of Might and Magic III battle mechanic.

<b>General description</b>

<b><i>Basic classes</i></b>
<li><b>Unit:</b> abstract warrior specializing in physical damage</li>
<li><b>Spellcaster:</b> abstract warrior specializing in magic damage. Is Unit subclass</li>

All units are situated on desk 8x8 cells size or larger.
In one cell can be only one unit at once.
Units can move vertically and horizontally along the desk by specified amount of cells at once.
Every unit can attack another unit.
If another unit stays alive after being attacked, it automatically conducts a counter-attack (brings half of damage).
Damage of spellcaster is less than other unit's damage.
Desk and units can be visualized in console.

<b><i>Warrior units</i></b>
<li><b>Soldier:</b> unit without any special abilities</li>
<li><b>Daemon:</b> similar to the Soldier. Can be only summoned by Warlock</li>
<li><b>Rogue:</b> cannot be counter-attacked</li>
<li><b>Berserker:</b> resistant to magic</li>
<li><b>Vampire:</b> undead. Whenever attacks an enemy, drains part of enemy's life and use it to heal itself. Can infect another unit (except Werewolf) after which this unit becomes a Vampire. Cannot be healed in other way</li>
<li><b>Werewolf:</b> has two states - human and wolf. In human state is similar to the Soldier. In wolf state has larger heat points and damage points, but takes more magic damage. Can infect another unit (except Vampire) after which this unit becomes a Werewolf</li>

<b><i>Magic units</i></b>
<li><b>Wizard:</b> battle spellcaster (healing spells have half effect)</li>
<li><b>Healer:</b> healing spellcaster (battle spells have half effect)</li>
<li><b>Priest:</b> healing spellcaster (battle spells have half effect on every unit except undeads)</li>
<li><b>Warlock:</b> battle spellcaster (healing spells have half effect). Can summon a Daemon</li>
<li><b>Necromancer:</b> undead. Battle spellcaster (healing spells have half effect). After attack on unit (phisicaly or by spell) starts observing this unit. After the death of observable unit, Necromancer gets part of obervable's heat points. Necromancer cannot be healed in other way</li>

All special abilities of units implemented in special classes, extended from abstract class Ability

<b><i>Basic spells</i></b>

There are battle (make damage) and healing (heal unit) spells. 
All spells are contained in spellcaster's spellbook.
Every spell has cost (mana points) and action points which can be different.
Every spell has specified radius of casting.

<li><b>Fireball:</b> battle spell</li>
<li><b>Heal:</b> healing spell</li>

<b><i>Implemented design patterns</i></b>
<li><b>Singleton</b> for Desk</li>
<li><b>State</b> for Werewolf (tranforming from human to wolf and back) </li>
<li><b>Strategy</b> for Spellcasters (spell change) and Units (ability change)</li>
<li><b>Observer</b> for Necromancer</li>





