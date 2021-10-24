package DesignPatterns.AbstractFactoryPattern.ColorFactory;

public class Green implements Color{

    @Override
    public void fill() {
        System.out.println("filled with Green");
    }
}
