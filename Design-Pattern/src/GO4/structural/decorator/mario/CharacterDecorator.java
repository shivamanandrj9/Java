package GO4.structural.decorator.mario;

public abstract class CharacterDecorator implements Character {
    protected final Character character;

    protected CharacterDecorator(Character character) {
        this.character = character;
    }
}


