package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.FriendlyPresenter;
import com.b3sk.fodmaper.presenter.ModerateFodmapPresenter;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joopkins on 5/14/16.
 */
public class ModeratePresenterTest {

    ModerateFodmapPresenter moderateFodmapPresenter;
    List<Food> foods;


    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        moderateFodmapPresenter = mock(ModerateFodmapPresenter.class);
    }

    @Test
    public void verifyOnDataLoadedSetsModel() {
        doCallRealMethod().when(moderateFodmapPresenter).onDataLoaded(anyListOf(Food.class), anyString());
        doCallRealMethod().when(moderateFodmapPresenter).setModel(anyListOf(Food.class));
        moderateFodmapPresenter.onDataLoaded(foods, "string");
        verify(moderateFodmapPresenter).setModel(foods);
    }
}
