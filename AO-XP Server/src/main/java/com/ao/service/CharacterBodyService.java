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

package com.ao.service;

import com.ao.model.character.Gender;
import com.ao.model.character.Race;

public interface CharacterBodyService {

	/**
	 * Validate the character head
	 * @param head		The character's head
	 * @param race		The character's race
	 * @param gender	The character's gender
	 * @return			True if is valid
	 */
	boolean isValidHead(int head, Race race, Gender gender);
	
	/**
	 * Returns the correct body for the given race and gender
	 * @param race		The character's race
	 * @param gender	The character's gender
	 * @return			The character' body
	 */
	int GetBody(Race race, Gender gender);
}