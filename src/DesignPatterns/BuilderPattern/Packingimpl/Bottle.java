package DesignPatterns.BuilderPattern.Packingimpl;

import DesignPatterns.BuilderPattern.Packing;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}