package structural.decorator.mario;

public class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character character) {
        super(character);
    }

    @Override
    public String getAbilities() {
        return character.getAbilities() + " with Gun";
    }
}


