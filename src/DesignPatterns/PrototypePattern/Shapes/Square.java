package DesignPatterns.PrototypePattern.Shapes;

import DesignPatterns.PrototypePattern.Shape;

public class Square extends Shape  {

    public Square(){
        type="Square";
    }

    @Override
    public void draw() {
        System.out.println(getId()+":"+getType());
    }
}
