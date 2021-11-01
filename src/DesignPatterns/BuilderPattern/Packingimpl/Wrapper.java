package DesignPatterns.BuilderPattern.Packingimpl;

import DesignPatterns.BuilderPattern.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}
