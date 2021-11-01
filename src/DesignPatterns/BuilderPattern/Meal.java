package DesignPatterns.BuilderPattern;

import java.util.ArrayList;

public class Meal{
    ArrayList<Item> items=new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost=0;
        for(Item item:items){
            cost+=item.price();
        }
        return cost;
    }
    public void showItems(){
        for(Item item:items){
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
