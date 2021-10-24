package DesignPatterns.AbstractFactoryPattern.ColorFactory;

public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("filled with Red");
    }
}
