package edu.towson.cis.cosc442.project4.coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    public void setUp() {
        recipe = new Recipe();
        recipe.setName("Coffee");
        recipe.setPrice(50);
        recipe.setAmtCoffee(2);
        recipe.setAmtMilk(1);
        recipe.setAmtSugar(1);
        recipe.setAmtChocolate(1);
    }

    @Test
    public void testEqualsDifferentPrice() {
        Recipe recipe2 = new Recipe();
        recipe2.setName("Coffee");
        recipe2.setPrice(100);

        assertTrue(recipe.equals(recipe2));
    }

    @Test
    public void testToString() {
        assertEquals("Coffee", recipe.toString());
    }

    @Test
    public void testToStringAfterNameChange() {
        recipe.setName("Latte");

        assertEquals("Latte", recipe.toString());
    }
}