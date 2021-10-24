package DesignPatterns.AbstractFactoryPattern.ColorFactory;

import DesignPatterns.AbstractFactoryPattern.AbstractFactory;
import DesignPatterns.AbstractFactoryPattern.ShapeFactory.Shape;

public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if (color.equalsIgnoreCase("RED"))
            return new Red();
        if (color.equalsIgnoreCase("BLUE"))
            return new Blue();
        if (color.equalsIgnoreCase("GREEN"))
            return new Green();
        return null;
    }
}
