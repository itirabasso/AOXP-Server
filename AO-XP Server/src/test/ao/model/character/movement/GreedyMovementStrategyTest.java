package ao.model.character.movement;

import junit.framework.Assert;

import org.junit.Test;

import ao.model.map.Heading;
import ao.model.map.Position;
import ao.model.map.Tile;
import ao.model.map.WorldMap;

public class GreedyMovementStrategyTest {

	private MovementStrategy movement = new GreedyMovementStrategy();

	@Test
	public void testMove() {
		WorldMap map = new WorldMap("foo", 0, new Tile[0]);
		
		Position pos = new Position((byte) 50, (byte) 50, map);
		Position target = new Position((byte) 60, (byte) 60, map);
		
		// Should go to northeast
		moveTest(pos, target, Heading.WEST, Heading.SOUTH);
		
		target.setY((byte) 20);
		
		// Should go to southeast
		moveTest(pos, target, Heading.WEST, Heading.NORTH);
		
		target.setX((byte) 20);
		
		// Should go to southwest
		moveTest(pos, target, Heading.EAST, Heading.NORTH);
		
		target.setY((byte) 60);
		
		// Should go to northwest
		moveTest(pos, target, Heading.EAST, Heading.SOUTH);
		
	}

	private void moveTest(Position pos, Position target, Heading shouldnt1, Heading shouldnt2) {
		Heading move = null;
		movement.setTarget(target);
		
		// Save this values because they will change and we don't want to modify the original object.
		byte x = pos.getX();
		byte y = pos.getY();
		
		int steps = Math.abs(pos.getX() - target.getX()) + Math.abs(pos.getY() - target.getY());
		
		for (int i = 0; i < steps; i++) {
			move = movement.move(pos);
			movePosition(pos, move);
			
			Assert.assertNotSame(shouldnt1, move);
			Assert.assertNotSame(shouldnt2, move);
		}
		
		// Has arrieved to target.
		Assert.assertNull(movement.move(pos));
		
		pos.setX(x);
		pos.setY(y);
	}
	
	private void movePosition(Position pos, Heading direction) {
		switch (direction) {
		case NORTH:
			pos.setY((byte) (pos.getY() + 1));
			break;
			
		case SOUTH:
			pos.setY((byte) (pos.getY() - 1));
			break;
			
		case EAST:
			pos.setX((byte) (pos.getX() + 1));
			break;
			
		case WEST:
			pos.setX((byte) (pos.getX() - 1));
		}
	}
	
}
