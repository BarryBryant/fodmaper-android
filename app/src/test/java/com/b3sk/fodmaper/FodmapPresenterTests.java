package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
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
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Joopkins on 5/14/16.
 */
public class FodmapPresenterTests {


    FodmapPresenter fodmapPresenter;
    FodmapPresenter spyFodmapPresenter;
    FodmapView mockFodmapView;
    List<Food> foods;

    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        fodmapPresenter = new FodmapPresenter();
        spyFodmapPresenter = spy(new FodmapPresenter());
        mockFodmapView = mock(FodmapView.class);
    }

    @Test
    public void viewUpdatesOnBindViewAndSetModel() {
        fodmapPresenter.setModel(foods);
        fodmapPresenter.bindView(mockFodmapView);
        verify(mockFodmapView).bindFoods(anyListOf(Food.class));
    }


    @Test
    public void OnQueryUpdatesView() {
        fodmapPresenter.setModel(foods);
        fodmapPresenter.bindView(mockFodmapView);
        fodmapPresenter.onQueryTextChanged(anyString());
        verify(mockFodmapView).animateToFilter(anyListOf(Food.class));
    }

    @Test
    public void noInteractionWithViewOnQueryNullView() {
        fodmapPresenter.setModel(foods);
        fodmapPresenter.onQueryTextChanged("string");
        verifyNoMoreInteractions(mockFodmapView);
    }

    @Test
    public void noInteractionWithViewOnQueryNullModel() {
        fodmapPresenter.onQueryTextChanged("string");
        verifyZeroInteractions(mockFodmapView);
    }

    @Test
    public void updateViewMaintainsNonNullSearch() {
        spyFodmapPresenter.setModel(foods);
        spyFodmapPresenter.onQueryTextChanged("string");
        spyFodmapPresenter.bindView(mockFodmapView);
        verify(spyFodmapPresenter, times(2)).onQueryTextChanged("string");

    }

    @Test
    public void verifyOnDataLoadedSetsModel() {
        spyFodmapPresenter.onDataLoaded(foods, "string");
        verify(spyFodmapPresenter).setModel(foods);
    }



}
