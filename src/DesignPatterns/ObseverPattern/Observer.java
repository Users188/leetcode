package DesignPatterns.ObseverPattern;

public abstract class Observer {
    protected Monitor monitor;
    public abstract void update();
}
