package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static junit.framework.Assert.*;

/**
 * Created by Joopkins on 5/14/16.
 */
public class FoodTests {

    Food food;

    @Before
    public void setup() {
        food = new Food("Food", 1, 1, 0, 0, 0);
    }

    @Test
    public void verifyFoodConstructor() {
        assertEquals(food.getName(), "Food");
        assertEquals(food.getF(), 1);
        assertEquals(food.getO(), 1);
        assertEquals(food.getD(), 0);
        assertEquals(food.getM(), 0);
        assertEquals(food.getP(), 0);
    }

    @Test
    public void verifyGetFoodInfo() {
        assertEquals(food.getInfo(), "Contains: Oligosaccharides ");
    }

}
