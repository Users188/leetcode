package DesignPatterns.ObseverPattern;

//观察者模式
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.setState(100,99,true);
        TemperatureObserver temperatureObserver = new TemperatureObserver(monitor);
        PressureObserver pressureObserver = new PressureObserver(monitor);
        monitor.setState(100,90,false);
        monitor.detach(temperatureObserver);
        monitor.setState(100,0,false);
    }
}
