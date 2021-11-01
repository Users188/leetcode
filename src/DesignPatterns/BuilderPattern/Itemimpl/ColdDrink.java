package DesignPatterns.BuilderPattern.Itemimpl;

import DesignPatterns.BuilderPattern.Item;
import DesignPatterns.BuilderPattern.Packing;
import DesignPatterns.BuilderPattern.Packingimpl.Bottle;

public abstract class ColdDrink implements Item {
    @Override
    public String name() {
        return "ColdDrink";
    }

    @Override
    public Packing packing() {
        return new Bottle();
    }

    public abstract float price();
}
