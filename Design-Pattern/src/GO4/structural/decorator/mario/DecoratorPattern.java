package GO4.structural.decorator.mario;

public class DecoratorPattern {
    public static void main(String[] args) {
        Character mario = new Mario();
        System.out.println("Basic Character: " + mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}


