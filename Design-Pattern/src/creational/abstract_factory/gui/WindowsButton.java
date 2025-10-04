package creational.abstract_factory.gui;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Painting a Windows button");
    }
}
