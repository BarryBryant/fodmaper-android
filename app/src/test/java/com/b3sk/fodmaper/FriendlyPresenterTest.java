package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.presenter.FodmapPresenter;
import com.b3sk.fodmaper.presenter.FriendlyPresenter;
import com.b3sk.fodmaper.view.FodmapView;
import com.b3sk.fodmaper.view.FriendlyView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Joopkins on 5/16/16.
 */
public class FriendlyPresenterTest {

    FriendlyPresenter friendlyPresenter;
    FriendlyPresenter spyFriendlyPresenter;
    FriendlyView mockFriendlyView;
    List<Food> foods;

    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        friendlyPresenter = new FriendlyPresenter();
        spyFriendlyPresenter = spy(new FriendlyPresenter());
        mockFriendlyView = mock(FriendlyView.class);
    }

    @Test
    public void viewUpdatesOnBindViewAndSetModel() {
        friendlyPresenter.setModel(foods);
        friendlyPresenter.bindView(mockFriendlyView);
        verify(mockFriendlyView).bindFoods(anyListOf(Food.class));
    }

    @Test
    public void verifyNoActionOnClickEngagedToggle() {
        friendlyPresenter.onFruitClicked();
        verifyNoMoreInteractions(mockFriendlyView);
    }

    @Test
    public void verifyViewUpdatedOnCickDisengagedToggle() {
        friendlyPresenter.setModel(foods);
        friendlyPresenter.bindView(mockFriendlyView);
        friendlyPresenter.onDataLoaded(foods, "vegi");
        friendlyPresenter.onVegiClicked();

        //animateToFilter called at end of updateViewOnToggle
        verify(mockFriendlyView).animateToFilter(anyListOf(Food.class));
    }

    @Test
    public void verifyInitializeModelNotCalledUntilAllDataLoaded() {
        //model set to prevent async call from bindView with a null model
        spyFriendlyPresenter.setModel(foods);
        spyFriendlyPresenter.bindView(mockFriendlyView);
        spyFriendlyPresenter.onDataLoaded(foods, "fruit");
        spyFriendlyPresenter.onDataLoaded(foods, "vegi");
        spyFriendlyPresenter.onDataLoaded(foods, "protein");
        spyFriendlyPresenter.onDataLoaded(foods, "grain");
        spyFriendlyPresenter.onDataLoaded(foods, "other");

        //Set model called second time by initializeModel()
        verify(spyFriendlyPresenter, times(2)).setModel(anyListOf(Food.class));

    }



}
