package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        coffeeMaker = new CoffeeMaker();

        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtCoffee(2);
        recipe.setAmtMilk(1);
        recipe.setAmtSugar(1);
        recipe.setAmtChocolate(0);
    }

}