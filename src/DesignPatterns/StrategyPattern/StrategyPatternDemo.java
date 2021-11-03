package DesignPatterns.StrategyPattern;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        int a=10,b=20;
        Context context=new Context(new OperationAdd());
        System.out.println(context.executeStrategy(a,b));

        context=new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(a,b));

        context=new Context(new OperationSubstract());
        System.out.println(context.executeStrategy(a,b));
    }
}
