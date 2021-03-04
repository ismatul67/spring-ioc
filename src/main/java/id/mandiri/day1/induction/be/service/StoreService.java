package id.mandiri.day1.induction.be.service;

import id.mandiri.day1.induction.be.model.Fruit;

import java.util.List;

public interface StoreService {

    public Fruit addNewFruit(Fruit fruit);
    public List<Fruit> findAllFruits();
    public void sellAFruit(String fruitName, Integer quantity);

}
