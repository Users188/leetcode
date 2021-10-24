package DesignPatterns.AbstractFactoryPattern.ShapeFactory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("draw a square.");
    }
}
