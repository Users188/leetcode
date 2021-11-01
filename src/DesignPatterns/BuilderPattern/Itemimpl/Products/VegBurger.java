package DesignPatterns.BuilderPattern.Itemimpl.Products;

import DesignPatterns.BuilderPattern.Itemimpl.Burger;

public class VegBurger extends Burger {
    public String name(){
        return "VegBurger";
    }

    @Override
    public float price() {
        return 20f;
    }
}
