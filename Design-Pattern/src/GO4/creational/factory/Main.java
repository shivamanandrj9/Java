package GO4.creational.factory;

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeInstanceFactory.getShapeInstance("circle", 3.0);
        circle.draw();
        System.out.println("Area: " + circle.area());

        Shape rectangle = ShapeInstanceFactory.getShapeInstance("rectangle", 4.0, 5.0);
        rectangle.draw();
        System.out.println("Area: " + rectangle.area());
    }
}
