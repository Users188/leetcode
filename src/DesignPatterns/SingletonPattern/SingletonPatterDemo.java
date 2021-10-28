package DesignPatterns.SingletonPattern;

public class SingletonPatterDemo {
    public static void main(String[] args) {
        SingleObject1 object1=SingleObject1.getInstance();
        SingleObject2 object2=SingleObject2.getInstance();
        SingleObject3 object3=SingleObject3.getInstance();
        SingleObject4 object4=SingleObject4.getInstance();
        SingleObject5 object5=SingleObject5.instance;

        object1.showMessage();
        object2.showMessage();
        object3.showMessage();
        object4.showMessage();
        object5.showMessage();

    }
}
