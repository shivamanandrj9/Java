package creational.abstract_factory.gui;

public class Main {
    public static void main(String[] args) {
        GUIFactory winFactory = GUIFactoryProducer.getFactory("Windows");
        Button winBtn = winFactory.createButton();
        winBtn.paint();
        Checkbox winChk = winFactory.createCheckbox();
        winChk.paint();

        GUIFactory macFactory = GUIFactoryProducer.getFactory("Mac");
        Button macBtn = macFactory.createButton();
        macBtn.paint();
        Checkbox macChk = macFactory.createCheckbox();
        macChk.paint();
    }
}

