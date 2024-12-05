package ConstructorFlow;

class Parent {
    public Parent() {
        System.out.println("Parent constructor called.");
    }
}

class Child extends Parent {
    public Child() {
        // Implicitly calls super() before the body of the Child constructor
        System.out.println("Child constructor called.");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();  // Will print both Parent and Child constructor calls
    }
}
