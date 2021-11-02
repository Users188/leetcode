package DesignPatterns.ProxyPattern;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image=new ProxyImage("proxyImage");
        image.display();
    }
}
