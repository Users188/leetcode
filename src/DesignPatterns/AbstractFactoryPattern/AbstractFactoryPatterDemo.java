package DesignPatterns.AbstractFactoryPattern;

//抽象工厂模式
public class AbstractFactoryPatterDemo {
    public static void main(String[] args) {
        //通过工厂创造器创建抽象工厂
        AbstractFactory shapeFactory=FactoryProducer.getFactory("shape");
        //然后就是工厂模式
        assert shapeFactory != null;
        shapeFactory.getShape("square").draw();

        //工厂创造器可以创造不同的工厂
        AbstractFactory colorFactory=FactoryProducer.getFactory("color");
        assert colorFactory != null;
        colorFactory.getColor("red").fill();

    }
}
