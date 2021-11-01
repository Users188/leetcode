package DesignPatterns.BuilderPattern.Itemimpl.Products;

import DesignPatterns.BuilderPattern.Itemimpl.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name(){
        return "Pepsi";
    }
    @Override
    public float price() {
        return 5f;
    }
}
