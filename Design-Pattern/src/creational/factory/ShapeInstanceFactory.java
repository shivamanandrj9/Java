package creational.factory;

public class ShapeInstanceFactory {
    public static Shape getShapeInstance(String type, double... params){
        if(type.equalsIgnoreCase("circle")) {
            return new Circle(params[0]);
        } else if(type.equalsIgnoreCase("rectangle")){
            return new Rectangle(params[0], params[1]);
        }
        throw new IllegalArgumentException("Unknown shape type: " + type);
    }
}
