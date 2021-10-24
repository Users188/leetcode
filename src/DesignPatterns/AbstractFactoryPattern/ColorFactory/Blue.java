package DesignPatterns.AbstractFactoryPattern.ColorFactory;

public class Blue implements Color{
    @Override
    public void fill() {
        System.out.println("filled with Blue");
    }
}
