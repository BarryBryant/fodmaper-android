package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.presenter.ModeratePresenterImpl;
import com.b3sk.fodmaper.view.ModerateFodmapView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Joopkins on 5/14/16.
 */
public class ModeratePresenterTest {

    ModeratePresenterImpl presenter;
    List<Food> foods;
    ModerateFodmapView mockModerateView;
    FoodRepo mockFoodRepo;


    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        mockModerateView = mock(ModerateFodmapView.class);
        mockFoodRepo = mock(FoodRepo.class);
        presenter = new ModeratePresenterImpl(mockFoodRepo);
    }

    @Test
    public void loadFoodFromRepoAndUpdateView() {
        presenter.bindView(mockModerateView);
        verify(mockFoodRepo).getModerates();
        verify(mockModerateView).bindFoods(anyListOf(Food.class));
    }

}
