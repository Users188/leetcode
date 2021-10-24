package DesignPatterns.AbstractFactoryPattern;

import DesignPatterns.AbstractFactoryPattern.ColorFactory.Color;
import DesignPatterns.AbstractFactoryPattern.ShapeFactory.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);
    public abstract Color getColor(String color);
}
