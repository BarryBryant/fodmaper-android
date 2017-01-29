package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by Joopkins on 5/14/16.
 */

public class FoodTest {




    @Test
    public void verifyGetFoodInfo() {
        Food foodOne = new Food("Food", 0, 0, 0, 0, 0);
        assertEquals("FODMAP Free", foodOne.getInfo());

        Food foodTwo = new Food("Food", 1, 0, 1, 0, 0);
        assertEquals("Contains: Disaccharides ", foodTwo.getInfo());

        Food foodThree = new Food("Food", 1, 0, 0, 1, 0);
        assertEquals("Contains: Monosaccharides ", foodThree.getInfo());

        Food foodFour = new Food("Food", 1, 0, 0, 0, 1);
        assertEquals("Contains: Polyols ", foodFour.getInfo());

        Food foodFive = new Food("Food", 1, 1, 1, 0, 0);
        assertEquals("Contains: Oligosaccharides Disaccharides ", foodFive.getInfo());

        Food foodSix = new Food("Food", 1, 1, 0, 0, 0);
        assertEquals("Contains: Oligosaccharides ", foodSix.getInfo());
    }

    @Test
    public void sameValueFoodReturnsSameHashCode() {
        Food foodOne = new Food("Food", 0, 0, 0, 0, 0);
        Food foodTwo = new Food("Food", 0, 0, 0, 0, 0);
        assertEquals(foodOne.hashCode(), foodTwo.hashCode());
    }

    @Test
    public void differentValueFoodReturnsDifferentHashCode() {
        Food foodOne = new Food("Food", 0, 0, 0, 0, 0);
        Food foodTwo = new Food("FoodTwo", 0, 0, 0, 0, 0);
        assertFalse(foodOne.hashCode() == foodTwo.hashCode());
    }

    @Test
    public void twoFoodsWithSameValueReturnTrueOnEquals() {
        Food foodOne = new Food("Food", 0, 0, 0, 0, 0);
        Food foodTwo = new Food("Food", 0, 0, 0, 0, 0);
        assertTrue(foodOne.equals(foodTwo));
    }

    @Test
    public void twoFoodsWithDifferentValueReturnFalseOnEquals() {
        Food foodOne = new Food("FoodOne", 0, 0, 0, 0, 0);
        Food foodTwo = new Food("FoodTwo", 0, 0, 0, 0, 0);
        assertFalse(foodOne.equals(foodTwo));
    }

}
