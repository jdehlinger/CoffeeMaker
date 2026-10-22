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
    public void testGetName() {
        assertEquals("Coffee", recipe.getName());
    }

    @Test
    public void testSetName() {
        recipe.setName("Latte");

        assertEquals("Latte", recipe.getName());
    }

    @Test
    public void testSetNullName() {
        recipe.setName(null);

        assertNull(recipe.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50, recipe.getPrice());
    }

    @Test
    public void testSetPrice() {
        recipe.setPrice(75);

        assertEquals(75, recipe.getPrice());
    }

    @Test
    public void testSetNegativePrice() {
        recipe.setPrice(-10);

        assertEquals(0, recipe.getPrice());
    }

    @Test
    public void testGetAmtCoffee() {
        assertEquals(2, recipe.getAmtCoffee());
    }

    @Test
    public void testSetAmtCoffee() {
        recipe.setAmtCoffee(5);

        assertEquals(5, recipe.getAmtCoffee());
    }

    @Test
    public void testSetNegativeCoffee() {
        recipe.setAmtCoffee(-5);

        assertEquals(0, recipe.getAmtCoffee());
    }

    @Test
    public void testGetAmtMilk() {
        assertEquals(1, recipe.getAmtMilk());
    }

    @Test
    public void testSetAmtMilk() {
        recipe.setAmtMilk(5);

        assertEquals(5, recipe.getAmtMilk());
    }

    @Test
    public void testSetNegativeMilk() {
        recipe.setAmtMilk(-5);

        assertEquals(0, recipe.getAmtMilk());
    }

    @Test
    public void testGetAmtSugar() {
        assertEquals(1, recipe.getAmtSugar());
    }

    @Test
    public void testSetAmtSugar() {
        recipe.setAmtSugar(5);

        assertEquals(5, recipe.getAmtSugar());
    }

    @Test
    public void testSetNegativeSugar() {
        recipe.setAmtSugar(-5);

        assertEquals(0, recipe.getAmtSugar());
    }

    @Test
    public void testGetAmtChocolate() {
        assertEquals(1, recipe.getAmtChocolate());
    }

    @Test
    public void testSetAmtChocolate() {
        recipe.setAmtChocolate(5);

        assertEquals(5, recipe.getAmtChocolate());
    }

    @Test
    public void testSetNegativeChocolate() {
        recipe.setAmtChocolate(-5);

        assertEquals(0, recipe.getAmtChocolate());
    }

    @Test
    public void testEqualsSameName() {
        Recipe recipe2 = new Recipe();
        recipe2.setName("Coffee");

        assertTrue(recipe.equals(recipe2));
    }

    @Test
    public void testEqualsDifferentName() {
        Recipe recipe2 = new Recipe();
        recipe2.setName("Latte");

        assertFalse(recipe.equals(recipe2));
    }

    @Test
    public void testEqualsNullRecipeName() {
        Recipe recipe2 = new Recipe();

        assertFalse(recipe.equals(recipe2));
    }

    @Test
    public void testEqualsThisNameNull() {
        recipe.setName(null);

        Recipe recipe2 = new Recipe();
        recipe2.setName("Coffee");

        assertFalse(recipe.equals(recipe2));
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