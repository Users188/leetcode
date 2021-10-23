package DesignPatterns.FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        //创建工厂实例
        ShapeFactory shapeFactory=new ShapeFactory();
        //通过工厂实例获取产品（具体对象）
        Shape shape=shapeFactory.getShape("circle");
        //调用对象方法
        shape.draw();
    }
}
