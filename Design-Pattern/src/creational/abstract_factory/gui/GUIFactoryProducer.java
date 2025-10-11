package creational.abstract_factory.gui;

public class GUIFactoryProducer {
    public static GUIFactory getFactory(String osType) {
        if (osType.equalsIgnoreCase("Windows")) {
            return new WindowsFactory();
        } else if (osType.equalsIgnoreCase("Mac")) {
            return new MacFactory();
        }
        throw new IllegalArgumentException("Unknown OS type: " + osType);
    }
}

