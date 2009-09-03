package ao.model.spell.effect;

import ao.model.character.Character;
import ao.model.character.UserCharacter;
import ao.model.character.archetype.UserArchetype;
import ao.model.worldobject.WorldObject;

public class MimetismEffect implements Effect {

	@Override
	public boolean appliesTo(Character caster, Character target) {
		// Only druids (or maybe npcs, not yet defined) can mimetize themselves with NPC's
		if (!(target instanceof UserCharacter) 
				&& (caster instanceof UserCharacter)
				&& ((UserCharacter)caster).getArchetype() != UserArchetype.DRUID.getArchetype()) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean appliesTo(Character caster, WorldObject worldobject) {
		// Only druids (or maybe npcs, not yet defined) can mimetize themselves with world objects
		if (caster instanceof UserCharacter && ((UserCharacter)caster).getArchetype() != UserArchetype.DRUID.getArchetype()) {
			return false;
		}
		
		return true;
	}

	@Override
	public void apply(Character caster, Character target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void apply(Character caster, WorldObject target) {
		// TODO Auto-generated method stub

	}

}