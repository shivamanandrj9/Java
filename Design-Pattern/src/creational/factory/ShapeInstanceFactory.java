package creational.factory;

public class ShapeInstanceFactory {
    public static Shape getShapeInstance(String value){
        if(value.equals("circle")) {
            return new Circle();
        } else if(value.equals("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}
