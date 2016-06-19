package com.b3sk.fodmaper;

import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepo;
import com.b3sk.fodmaper.presenter.FriendlyPresenterImpl;
import com.b3sk.fodmaper.view.FriendlyView;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Joopkins on 5/16/16.
 */
public class FriendlyPresenterTest {

    FriendlyPresenterImpl presenter;
    FriendlyView mockFriendlyView;
    List<Food> foods;
    FoodRepo mockFoodRepo;

    @Before
    public void setup() {
        foods = new ArrayList<>();
        foods.add(new Food("FoodA", 1, 1, 0, 0, 0));
        foods.add(new Food("FoodB", 1, 1, 0, 0, 0));
        mockFriendlyView = mock(FriendlyView.class);
        mockFoodRepo = mock(FoodRepo.class);
        presenter = new FriendlyPresenterImpl(mockFoodRepo);
    }

    @Test
    public void loadFoodFromRepo_UpdateToggles() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        verify(mockFoodRepo).getFruits();
        verify(mockFoodRepo).getVeggies();
        verify(mockFoodRepo).getProtein();
        verify(mockFoodRepo).getGrains();
        verify(mockFoodRepo).getOthers();
        verify(mockFriendlyView).onFruitClicked(anyBoolean());
        verify(mockFriendlyView).onVegiClicked(anyBoolean());
        verify(mockFriendlyView).onProteinClicked(anyBoolean());
        verify(mockFriendlyView).onGrainClicked(anyBoolean());
        verify(mockFriendlyView).onOtherClicked(anyBoolean());
    }

    @Test
    public void onFruitClicked_DoesntUpdate_Toggles_WhenAlreadyActive() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        presenter.onFruitClicked();
        verify(mockFriendlyView, times(1)).onFruitClicked(anyBoolean());
        verify(mockFriendlyView, times(1)).onVegiClicked(anyBoolean());
        verify(mockFriendlyView, times(1)).onProteinClicked(anyBoolean());
        verify(mockFriendlyView, times(1)).onGrainClicked(anyBoolean());
        verify(mockFriendlyView, times(1)).onOtherClicked(anyBoolean());
    }

    @Test
    public void onVegiClickedUpdatesToggles() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        presenter.onVegiClicked();
        verify(mockFriendlyView, times(2)).onFruitClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onVegiClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onProteinClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onGrainClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onOtherClicked(anyBoolean());
    }

    @Test
    public void onProteinClickedUpdatesToggles() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        presenter.onProteinClicked();
        verify(mockFriendlyView, times(2)).onFruitClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onVegiClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onProteinClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onGrainClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onOtherClicked(anyBoolean());
    }

    @Test
    public void onGrainClickedUpdatesToggles() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        presenter.onGrainClicked();
        verify(mockFriendlyView, times(2)).onFruitClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onVegiClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onProteinClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onGrainClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onOtherClicked(anyBoolean());
    }

    @Test
    public void onOtherClickedUpdatesToggles() {
        presenter.bindView(mockFriendlyView);
        presenter.loadFood();
        presenter.onOtherClicked();
        verify(mockFriendlyView, times(2)).onFruitClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onVegiClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onProteinClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onGrainClicked(anyBoolean());
        verify(mockFriendlyView, times(2)).onOtherClicked(anyBoolean());
    }


}
