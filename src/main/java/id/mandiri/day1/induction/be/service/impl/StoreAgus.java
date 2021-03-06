package id.mandiri.day1.induction.be.service.impl;

import id.mandiri.day1.induction.be.model.Fruit;
import id.mandiri.day1.induction.be.service.StoreService;


import java.util.ArrayList;
import java.util.List;

public class StoreAgus implements StoreService {

    Fruit fruit;

    ArrayList<Fruit> fruits;

    public StoreAgus(Fruit fruit, ArrayList<Fruit> fruits) {
        this.fruit = fruit;
        this.fruits = fruits;
    }

    @Override
    public Fruit addNewFruit(Fruit fruit) {
        this.fruit = fruit;
        this.fruits.add(fruit);
        return this.fruit;
    }

    @Override
    public List<Fruit> findAllFruits() {
        return this.fruits;
    }

    @Override
    public void sellAFruit(String fruitName, Integer quantity) {
        if (this.fruits.isEmpty()){
            System.out.println("Belum ada stok");
        }else {
            Fruit fruitToBuy= null;
            for (Fruit fruit: this.fruits) {
                if (fruit.getName().toLowerCase().equals(fruitName.toLowerCase())){
                    fruitToBuy=fruit;
                    fruit.setQuantity(fruit.getQuantity()-quantity);
                }
            }

            if (fruitToBuy!=null){
                double total = fruitToBuy.getPrice() *quantity;
                System.out.println("you buy this fruit, you should pay " + total);
            }else {
                System.out.println(fruitName + " is empty");
            }
        }
    }


}
