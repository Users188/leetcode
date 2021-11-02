package DesignPatterns.PrototypePattern;

import DesignPatterns.PrototypePattern.Shapes.Circle;
import DesignPatterns.PrototypePattern.Shapes.Rectangle;
import DesignPatterns.PrototypePattern.Shapes.Square;

import java.util.HashMap;
import java.util.Map;

public class ShapeCache {
    private static Map<String,Shape> shapeMap=new HashMap<>();
    public static Shape getShape(String shapeId){
        Shape cachedShape=shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }
    // 对每种形状都运行数据库查询，并创建该形状
    // shapeMap.put(shapeKey, shape);
    // 例如，我们要添加三种形状
    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(),circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(),square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(),rectangle);
    }
}
