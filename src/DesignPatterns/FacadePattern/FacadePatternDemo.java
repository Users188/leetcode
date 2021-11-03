package DesignPatterns.FacadePattern;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker maker=new ShapeMaker();
        maker.drawCircle();
        maker.drawRectangle();
        maker.drawSquare();
    }
}
