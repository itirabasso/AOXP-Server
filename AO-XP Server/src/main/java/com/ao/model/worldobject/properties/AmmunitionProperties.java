/*
    AO-XP Server (XP stands for Cross Platform) is a Java implementation of Argentum Online's server 
    Copyright (C) 2009 Juan Martín Sotuyo Dodero. <juansotuyo@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.ao.model.worldobject.properties;

import java.util.List;

import com.ao.model.character.Race;
import com.ao.model.character.archetype.UserArchetype;
import com.ao.model.worldobject.WorldObjectType;

/**
 * Defines an Equippable Item's properties. Allows a lightweight pattern implementation.
 */
public class AmmunitionProperties extends EquippableItemProperties {

	protected int minHit;
	protected int maxHit;
	
	// TODO : add poison and paralizing modifiers!
	
	/**
	 * Creates a new AmmunitionProperties instance.
	 * @param type The type of the item.
	 * @param id The id of the item.
	 * @param name The name of the item.
	 * @param graphic The graphic for the item.
	 * @param tradeable True if it's tradeable, false otherwise.
	 * @param value The item's value.
	 * @param forbiddenArchetypes List of UserArchetypes not allowed to use this item.
	 * @param forbiddenRaces List of Races not allowed to use this item.
	 * @param newbie Whether the item is newbie or not.
	 * @param noLog Whether this item should be logged or not.
	 * @param falls Whether this item falls or not.
	 * @param respawnable Whether this item respawns or not when in a merchant NPC's inventory.
	 * @param equippedGraphic The id of the grpahic to display when equipped.
	 * @param minHit The minimum hit done by this item.
	 * @param maxHit The maximum hit done by this item.
	 */
	public AmmunitionProperties(WorldObjectType type, int id, String name, int graphic,
			int value, List<UserArchetype> forbiddenArchetypes, List<Race> forbiddenRaces,
			boolean newbie, boolean noLog, boolean falls, boolean respawnable, 
			int equippedGraphic, int minHit, int maxHit) {
		super(type, id, name, graphic, value,
				forbiddenArchetypes, forbiddenRaces, newbie, noLog, falls, respawnable, equippedGraphic);
		
		this.maxHit = maxHit;
		this.minHit = minHit;
	}

	/**
	 * @return the minHit
	 */
	public int getMinHit() {
		return minHit;
	}

	/**
	 * @return the maxHit
	 */
	public int getMaxHit() {
		return maxHit;
	}
}
