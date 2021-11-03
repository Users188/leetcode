package DesignPatterns.FacadePattern.Shapes;

import DesignPatterns.FacadePattern.Shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a circle.");
    }
}
