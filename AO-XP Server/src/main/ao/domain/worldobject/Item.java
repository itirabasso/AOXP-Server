package ao.domain.worldobject;

import ao.domain.character.Reputation;
import ao.domain.character.archetype.UserArchetype;

public interface Item extends WorldObject {

	/**
	 * Retrieves the item's unique id.
	 * @return The item's unique id.
	 */
	int getId();
	
	/**
	 * Retrieves the item's amount.
	 * @return The amount of items put together.
	 */
	int getAmount();
	
	/**
	 * Attempts to use the item.
	 */
	void use();
	
	/**
	 * Adds (or subtracts if the given amount is negative) an amount of the item
	 * @param amount	references to the amount to be added (negative to subtract)
	 * @return			the new amount of the item.
	 */
	int addAmount(int amount);
	
	/**
	 * Checks if the item can be used/equipped given an archetype and reputation.
	 * @param archetype		The archetype attempting to use the item.
	 * @param reputation	The reputation of the character attempting to use the item.
	 * @return True if the item can be used, false otherwise.
	 */
	boolean canBeUsedBy(UserArchetype archetype, Reputation reputation);
	
	/**
	 * Retrieves the manufacture difficulty of the item (how hard it's to make).
	 * @return The manufacture difficulty of the item (how hard it's to make).
	 */
	int getManufactureDifficulty(); // TODO : Nota, esto reemplaza a minSkill para carpinteria, fundicion y herreria
	
	/**
	 * Retrieves the usage difficulty of the item.
	 * @return The usage difficulty of the item.
	 */
	int getUsageDifficulty(); // TODO : Nota, esto reemplaza minSkill para navegar, con lo que los separamos.
}
