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

package com.ao.model.spell.effect;

import com.ao.exception.InvalidTargetException;
import com.ao.model.character.Character;
import com.ao.model.character.UserCharacter;
import com.ao.model.worldobject.WorldObject;

/**
 * An effect to turn characters invisible.
 */
public class InvisibilityEffect implements Effect {

	/*
	 * (non-Javadoc)
	 * @see com.ao.model.spell.effect.Effect#apply(ao.model.character.Character, com.ao.model.character.Character)
	 */
	@Override
	public void apply(Character caster, Character target) {
		target.setInvisible(true);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ao.model.spell.effect.Effect#appliesTo(ao.model.character.Character, com.ao.model.character.Character)
	 */
	@Override
	public boolean appliesTo(Character caster, Character target) {
		if (!(target instanceof UserCharacter) || target.isDead()) {
			return false;
		}
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ao.model.spell.effect.Effect#appliesTo(ao.model.character.Character, com.ao.model.worldobject.WorldObject)
	 */
	@Override
	public boolean appliesTo(Character caster, WorldObject worldobject) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see com.ao.model.spell.effect.Effect#apply(ao.model.character.Character, com.ao.model.worldobject.WorldObject)
	 */
	@Override
	public void apply(Character caster, WorldObject target) {
		throw new InvalidTargetException();
	}
	
}
