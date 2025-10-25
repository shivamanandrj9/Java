package GO4.structural.decorator.mario;

public class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Star Power (Limited Time)";
    }
}


