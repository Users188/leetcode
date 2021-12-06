package DesignPatterns.ObseverPattern;

import java.util.ArrayList;
import java.util.List;

public class Monitor {
    private List<Observer> observers;
    private int temperature;
    private int pressure;
    private boolean started;
    Monitor(){
       observers = new ArrayList<>();
    }

    public void setState(int temperature,int pressure,boolean started){
        this.temperature = temperature;
        this.pressure = pressure;
        this.started = started;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer:observers)
            observer.update();
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public boolean isStarted() {
        return started;
    }
}
