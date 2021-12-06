package DesignPatterns.ObseverPattern;

public class PressureObserver extends Observer{

    public PressureObserver(Monitor monitor){
        this.monitor = monitor;
        this.monitor.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Pressure:"+monitor.getPressure());
    }
}
