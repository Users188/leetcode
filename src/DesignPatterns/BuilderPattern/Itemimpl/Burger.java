package DesignPatterns.BuilderPattern.Itemimpl;

import DesignPatterns.BuilderPattern.Item;
import DesignPatterns.BuilderPattern.Packing;
import DesignPatterns.BuilderPattern.Packingimpl.Wrapper;

public abstract class Burger implements Item {
    @Override
    public String name() {
        return "Burger";
    }

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
