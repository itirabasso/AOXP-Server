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

package com.ao.model.worldobject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.ao.model.worldobject.properties.DoorProperties;

public class DoorTest extends AbstractWorldObjectTest {

	private static final boolean OPEN = true;
	private static final boolean LOCKED = false;
	private static final int CODE = 123;
	private static final DoorProperties OTHER_PROPERTIES = null;

	private Door door1;

	@Before
	public void setUp() throws Exception {
		final DoorProperties props1 = new DoorProperties(WorldObjectType.DOOR, 1, "Puerta abierta", 1,
				OPEN, LOCKED, CODE, OTHER_PROPERTIES);
		door1 = new Door(props1);

		object = door1;
		objectProps = props1;
	}

	@Test
	public void testGetOpen() {
		assertTrue(door1.getOpen());
	}

	@Test
	public void testGetLocked() {
		assertFalse(door1.getLocked());
	}

	@Test
	public void testGetCode() {
		assertEquals(CODE, door1.getCode());
	}

}