package structural.decorator.mario;

public class HeightUp extends CharacterDecorator {
    public HeightUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with HeightUp";
    }
}


