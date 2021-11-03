package DesignPatterns.FacadePattern.Shapes;

import DesignPatterns.FacadePattern.Shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw a rectangle.");
    }
}
