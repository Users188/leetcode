package DesignPatterns.BuilderPattern.Itemimpl.Products;

import DesignPatterns.BuilderPattern.Itemimpl.Burger;

public class ChickenBurger extends Burger {
    @Override
    public String name(){
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 10f;
    }
}
