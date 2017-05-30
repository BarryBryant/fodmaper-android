package com.b3sk.fodmaper.model

import com.b3sk.fodmaper.helpers.FoodGenerator

/**
 * Created by barrybryant on 5/22/17.
 */
class JsonFoodRepoImpl(generator: FoodGenerator) : FoodRepo {

    val foods: MutableList<Food> = generator.generateFoodFromJSON()

    override fun getFodmaps(): MutableList<Food> {
        val fodmaps = foods.filter { it.f == 2 }.sorted()
        return fodmaps.toMutableList()
    }

    override fun getModerates(): MutableList<Food> {
        val fodmaps = foods.filter { it.f == 1 }.sorted()
        return fodmaps.toMutableList()    }

    override fun getFruits(): MutableList<Food> {
        val fruits = foods.filter { it.f == -1 }.sorted()
        return fruits.toMutableList()    }

    override fun getVeggies(): MutableList<Food> {
        val veggies = foods.filter { it.f == -2 }.sorted()
        return veggies.toMutableList()    }

    override fun getProtein(): MutableList<Food> {
        val proteins = foods.filter { it.f == -3 }.sorted()
        return proteins.toMutableList()    }

    override fun getGrains(): MutableList<Food> {
        val grains = foods.filter { it.f == -4 }.sorted()
        return grains.toMutableList()    }

    override fun getOthers(): MutableList<Food> {
        val others = foods.filter { it.f == -5 }.sorted()
        return others.toMutableList()    }

    override fun getAllFood(): MutableList<Food> {
        val sortedFoods = foods.sorted()
        return sortedFoods.toMutableList()
    }

}