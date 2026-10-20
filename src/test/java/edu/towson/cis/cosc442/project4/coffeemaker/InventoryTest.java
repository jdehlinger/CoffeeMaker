package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory;
    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();

        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtCoffee(2);
        recipe.setAmtMilk(1);
        recipe.setAmtSugar(1);
        recipe.setAmtChocolate(1);
    }

    @Test
    public void testInventoryConstructor() {
        assertEquals(15, inventory.getCoffee());
        assertEquals(15, inventory.getMilk());
        assertEquals(15, inventory.getSugar());
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testGetCoffee() {
        assertEquals(15, inventory.getCoffee());
    }

    @Test
    public void testSetCoffee() {
        inventory.setCoffee(20);

        assertEquals(20, inventory.getCoffee());
    }

    @Test
    public void testSetNegativeCoffee() {
        inventory.setCoffee(-5);

        assertEquals(0, inventory.getCoffee());
    }

    @Test
    public void testGetMilk() {
        assertEquals(15, inventory.getMilk());
    }

    @Test
    public void testSetMilk() {
        inventory.setMilk(20);

        assertEquals(20, inventory.getMilk());
    }

    @Test
    public void testSetNegativeMilk() {
        inventory.setMilk(-5);

        assertEquals(0, inventory.getMilk());
    }

    @Test
    public void testGetSugar() {
        assertEquals(15, inventory.getSugar());
    }

    @Test
    public void testSetSugar() {
        inventory.setSugar(20);

        assertEquals(20, inventory.getSugar());
    }

    @Test
    public void testSetNegativeSugar() {
        inventory.setSugar(-5);

        assertEquals(0, inventory.getSugar());
    }

    @Test
    public void testGetChocolate() {
        assertEquals(15, inventory.getChocolate());
    }

    @Test
    public void testSetChocolate() {
        inventory.setChocolate(20);

        assertEquals(20, inventory.getChocolate());
    }

    @Test
    public void testSetNegativeChocolate() {
        inventory.setChocolate(-5);

        assertEquals(0, inventory.getChocolate());
    }

    @Test
    public void testEnoughIngredients() {
        assertTrue(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testNotEnoughCoffee() {
        inventory.setCoffee(1);

        assertFalse(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testNotEnoughMilk() {
        inventory.setMilk(0);

        assertFalse(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testNotEnoughSugar() {
        inventory.setSugar(0);

        assertFalse(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testNotEnoughChocolate() {
        inventory.setChocolate(0);

        assertFalse(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testEnoughIngredientsExactAmount() {
        inventory.setCoffee(2);
        inventory.setMilk(1);
        inventory.setSugar(1);
        inventory.setChocolate(1);

        assertTrue(inventory.enoughIngredients(recipe));
    }

    @Test
    public void testToString() {
        String expected = "Coffee: 15\n" +
                          "Milk: 15\n" +
                          "Sugar: 15\n" +
                          "Chocolate: 15\n";

        assertEquals(expected, inventory.toString());
    }
}