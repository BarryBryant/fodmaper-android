package com.b3sk.fodmaper;

import com.b3sk.fodmaper.presenter.FriendlyPresenter;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Joopkins on 5/14/16.
 */
public class FodmapFriendlyPresenterTests {

    private FriendlyPresenter friendlyPresenter;

    @Before
    public void setup() {
        friendlyPresenter = new FriendlyPresenter();
    }

    @Test
    public void verifyOnFruitClicked() {
        friendlyPresenter.onFruitClicked();

    }
}
