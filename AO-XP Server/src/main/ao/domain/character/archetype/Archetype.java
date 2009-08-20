package ao.domain.character.archetype;

import ao.domain.spell.Spell;
import ao.domain.worldobject.Boat;
import ao.domain.worldobject.EquipableItem;
import ao.domain.worldobject.Item;
import ao.domain.worldobject.Weapon;

public interface Archetype {

	/**
	 * Checks if the user has the skills needed to create the given item.
	 * @param blacksmithSkill	The user's blacksmithing skill.
	 * @param item				The item to be created.
	 * @return True if the user can create the item, false otherwise.
	 */
	boolean canBlacksmith(int blacksmithSkill, Item item);
	
	/**
	 * Checks if the user has the skills needed to create the given item.
	 * @param woodWorkSkill	The user's woodworking skill.
	 * @param item				The item to be created.
	 * @return True if the user can create the item, false otherwise.
	 */
	boolean canWoodWork(int woodWorkSkill, Item item);
	
	/**
	 * Checks if the user has the skills needed to iron work the given item.
	 * @param ironWorkingSkill	The user's iron working skill.
	 * @param item				The item to be created.
	 * @return True if the user can create the item, false otherwise.
	 */
	boolean canIronWork(int ironWorkingSkill, Item item);
	
	/**
	 * Checks if the user has the skills needed to sail the given boat.
	 * @param woodWorkSkill	The user's sailing skill.
	 * @param boat				The boat to be used for sailing.
	 * @return True if the user can sail the given boat, false otherwise.
	 */
	boolean canSail(int sailingSkill, Boat boat);
	
	/**
	 * Checks if the archetype allows to perform a critical blow.
	 * @return True if the archetype allows to perform a critical blow, false otherwise.
	 */
	boolean canCriticalBlow();
	
	/**
	 * Checks if the archetype allows to pick-pocket.
	 * @return True if the archetype allows to pick-pocket, false otherwise.
	 */
	boolean canPickPocket();
	
	/**
	 * Checks if the archetype allows to immobilize .
	 * @return True if the archetype allows to immobilize, false otherwise.
	 */
	boolean canImmobilize();
	
	/**
	 * Checks if the archetype allows to disarm an enemy.
	 * @return True if the archetype allows to disarm an enemy, false otherwise.
	 */
	boolean canDisarm();
	
	/**
	 * Checks if the user has the skills needed to create the given item.
	 * @param stabbingSkill	The user's stabbing skill.
	 * @return True if the user can stab an enemy, false otherwise.
	 */
	boolean canStab(int stabbingSkill);
	
	/**
	 * Checks if the user can cast a given spell.
	 * @param spell		The spell to be casted.
	 * @param weapon	The weapon being equipped by the user.
	 * @param ring		The ring being equipped by the user.
	 * @return True if the user can cast the given spell, false otherwise.
	 */
	boolean canCast(Spell spell, Weapon weapon, EquipableItem ring);
	
	/**
	 * Checks if the user can walk while hidden.
	 * @return True if the user can walk while hidden, false otherwise.
	 */
	boolean canWalkHidden();
	
	/**
	 * Retrieves the minimum level required to sail.
	 * @return The minimum level required to sail.
	 */
	int getSailingMinLevel();
	
	/**
	 * Retrieves the stamina required for blacksmithing.
	 * @return The stamina required for blacksmithing.
	 */
	int getBlacksmithingStaminaCost();
	
	/**
	 * Retrieves the stamina required for wood working.
	 * @return The stamina required for wood working.
	 */
	int getWoodWorkStaminaCost();
	
	/**
	 * Retrieves the stamina required for fish.
	 * @return The stamina required for fish.
	 */
	int getFishingStaminaCost();
	
	/**
	 * Retrieves the stamina required for lumberjack.
	 * @return The stamina required for lumberjack.
	 */
	int getLumberjackingStaminaCost();
	
	/**
	 * Retrieves the stamina required for mining.
	 * @return The stamina required for mining.
	 */
	int getMiningStaminaCost();
	
	/**
	 * Retrieves the minimum amount of fish that can be captured.
	 * @return The minimum amount of fish that can be captured.
	 */
	int getFishedMinAmount();
	
	/**
	 * Retrieves the maximum amount of fish that can be captured.
	 * @return The maximum amount of fish that can be captured.
	 */
	int getFishedMaxAmount();
	
	/**
	 * Retrieves the minimum amount of gold that can be stolen.
	 * @return The minimum amount of gold that can be stolen.
	 */
	int getStolenMinAmount();
	
	/**
	 * Retrieves the maximum amount of gold that can be stolen.
	 * @return The maximum amount of gold that can be stolen.
	 */
	int getStolenMaxAmount();
	
	/**
	 * Retrieves the minimum amount of wood that can be lumbered.
	 * @return The minimum amount of wood that can be lumbered.
	 */
	int getLumberedMinAmount();
	
	/**
	 * Retrieves the maximum amount of wood that can be lumbered.
	 * @return The maximum amount of wood that can be lumbered.
	 */
	int getLumberedMaxAmount();
	
	/**
	 * Retrieves the minimum amount of minerals that can be mined.
	 * @return The minimum amount of minerals that can be mined.
	 */
	int getMiningMinAmount();
	
	/**
	 * Retrieves the maximum amount of minerals that can be mined.
	 * @return The maximum amount of minerals that can be mined.
	 */
	int getMiningMaxAmount();
	
	/**
	 * Retrieve the amount by which to increment the user's hit each level.
	 * @param level	The level the user has just reached.
	 * @return The amount by which to increment the user's hit.
	 */
	int getHitIncrement(int level);
	
	/**
	 * Retrieve the amount by which to increment the user's stamina each level.
	 * @param level	The level the user has just reached.
	 * @return The amount by which to increment the user's stamina.
	 */
	int getStaminaIncrement(int level);
	
	/**
	 * Retrieve the amount by which to increment the user's mana each level.
	 * @param intelligence The user's intelligence.
	 * @return The amount by which to increment the user's mana.
	 */
	int getManaIncrement(int intelligence);
	
	/**
	 * Retrieves the chance of succeeding at theft.
	 * Must be a number between 0 (impossible) and 1 (always)
	 * @return The chance of succeeding at theft.
	 */
	float getThievingChance();
	
	/**
	 * Retrieves the chance of succeeding at stabbing an opponent.
	 * Must be a number between 0 (impossible) and 1 (always)
	 * @param stabSkill The user's stab skill.
	 * @return The chance of succeeding at stabbing an opponent.
	 */
	float getStabbingChance(int stabSkill);
	
	/**
	 * Retrieves the damage multiplier for stabbing an opponent.
	 * @return The damage multiplier for stabbing an opponent.
	 */
	float getStabbingDamageModifier();
	
	/**
	 * Retrieves the chance to train taming.
	 * Must be a number between 0 (impossible) and 1 (always)
	 * @return The chance to train taming.
	 */
	float getTamingTrainingChance();
}
