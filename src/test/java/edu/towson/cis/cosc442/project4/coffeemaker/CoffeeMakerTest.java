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

    @Test
    public void testAddRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void testAddDuplicateRecipe() {
        coffeeMaker.addRecipe(recipe);

        assertFalse(coffeeMaker.addRecipe(recipe));
    }

    @Test
    public void testDeleteRecipe() {
        coffeeMaker.addRecipe(recipe);

        assertTrue(coffeeMaker.deleteRecipe(recipe));
    }

    @Test
    public void testDeleteRecipeNotFound() {
        assertFalse(coffeeMaker.deleteRecipe(recipe));
    }

    @Test
    public void testDeleteNullRecipe() {
        assertFalse(coffeeMaker.deleteRecipe(null));
    }

    @Test
    public void testEditRecipeNotFound() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("Latte");
        newRecipe.setPrice(75);

        assertFalse(coffeeMaker.editRecipe(recipe, newRecipe));
    }

    @Test
    public void testAddInventory() {
        assertTrue(coffeeMaker.addInventory(5, 5, 0, 5));
    }

    @Test
    public void testAddNegativeInventory() {
        assertFalse(coffeeMaker.addInventory(-5, 5, 0, 5));
    }

    @Test
    public void testCheckInventory() {
        assertNotNull(coffeeMaker.checkInventory());
    }

    @Test
    public void testMakeCoffeeInsufficientPayment() {
        coffeeMaker.addRecipe(recipe);

        int change = coffeeMaker.makeCoffee(recipe, 20);

        assertEquals(20, change);
    }

    @Test
    public void testMakeCoffeeSuccessful() {
        coffeeMaker.addRecipe(recipe);

        int change = coffeeMaker.makeCoffee(recipe, 100);

        assertEquals(50, change);
    }

    @Test
    public void testGetRecipes() {
        assertNotNull(coffeeMaker.getRecipes());

        assertEquals(4, coffeeMaker.getRecipes().length);
    }

    @Test
    public void testGetRecipeForName() {
        coffeeMaker.addRecipe(recipe);

        Recipe result = coffeeMaker.getRecipeForName("Coffee");

        assertEquals("Coffee", result.getName());
    }

    @Test
    public void testGetRecipeForNameNotFound() {
        Recipe result = coffeeMaker.getRecipeForName("Tea");

        assertNull(result.getName());
    }

    @Test
    public void testAddRecipeWhenFull() {
        for (int i = 0; i < 4; i++) {
            Recipe r = new Recipe();
            r.setName("Recipe" + i);
            coffeeMaker.addRecipe(r);
        }

        Recipe extraRecipe = new Recipe();
        extraRecipe.setName("Extra");

        assertFalse(coffeeMaker.addRecipe(extraRecipe));
    }
}