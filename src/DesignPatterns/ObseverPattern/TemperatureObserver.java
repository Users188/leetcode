package DesignPatterns.ObseverPattern;

public class TemperatureObserver extends Observer{
    public TemperatureObserver(Monitor monitor){
        this.monitor = monitor;
        this.monitor.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Temperature:"+monitor.getTemperature());
    }
}
