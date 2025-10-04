package creational.abstract_factory.gui;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Painting a Windows checkbox");
    }
}
