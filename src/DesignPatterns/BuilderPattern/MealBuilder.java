package DesignPatterns.BuilderPattern;

import DesignPatterns.BuilderPattern.Itemimpl.Products.ChickenBurger;
import DesignPatterns.BuilderPattern.Itemimpl.Products.Coke;
import DesignPatterns.BuilderPattern.Itemimpl.Products.Pepsi;

public class MealBuilder {
    public Meal prepareMeal(){
        Meal meal=new Meal();
        meal.addItem(new Pepsi());
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return meal;
    }

}
