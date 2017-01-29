package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.FodmapPresenterImpl;
import com.b3sk.fodmaper.view.FodmapView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Joopkins on 5/14/16.
 */
public class FodmapPresenterTests {


    FodmapPresenterImpl presenter;
    FodmapView mockFodmapView;
    FoodRepo mockFoodRepo;
    List<Food> foods;

    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        mockFodmapView = mock(FodmapView.class);
        mockFoodRepo = mock(FoodRepo.class);
        presenter = new FodmapPresenterImpl(mockFoodRepo);
    }

    @Test
    public void bindView_LoadsFoodFromRepoAndUpdatesView_NoFilterWhenSearchNull() {
        presenter.bindView(mockFodmapView);
        verify(mockFoodRepo).getFodmaps();
        verify(mockFodmapView).bindFoods(anyListOf(Food.class));
        verify(mockFodmapView, never()).animateToFilter(anyListOf(Food.class));
    }

    @Test
    public void bindView_LoadsFoodFromRepoAndUpdatesView_FilterWhenSearchNotNull() {
        presenter.bindView(mockFodmapView);
        verify(mockFoodRepo).getFodmaps();
        verify(mockFodmapView).bindFoods(anyListOf(Food.class));
        verify(mockFodmapView, times(0)).animateToFilter(anyListOf(Food.class));
        presenter.onQueryTextChanged("strangus");
        presenter.loadFood();
        verify(mockFodmapView, times(2)).animateToFilter(anyListOf(Food.class));
    }




}
