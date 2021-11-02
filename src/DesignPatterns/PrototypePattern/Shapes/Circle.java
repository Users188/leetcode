package DesignPatterns.PrototypePattern.Shapes;

import DesignPatterns.PrototypePattern.Shape;

public class Circle extends Shape{

    public Circle(){
        type="Circle";
    }

    @Override
    public void draw() {
        System.out.println(getId()+":"+getType());
    }
}
