package DesignPatterns.PrototypePattern.Shapes;

import DesignPatterns.PrototypePattern.Shape;

public class Rectangle extends Shape {
    public Rectangle(){
        type="Rectangle";
    }

    @Override
    public void draw() {
        System.out.println(getId()+":"+getType());
    }

}
