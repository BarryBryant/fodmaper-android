package com.b3sk.fodmaper;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.b3sk.fodmaper.data.FodmapTask;
import com.b3sk.fodmaper.data.FoodContract;
import com.b3sk.fodmaper.model.Food;
import com.b3sk.fodmaper.model.FoodRepository;
import com.b3sk.fodmaper.presenter.FodmapPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    CountDownLatch signal = null;
    String[] columns = {FoodContract.ModerateEntry.COLUMN_MODERATE_NAME,
            FoodContract.ModerateEntry.COLUMN_MODERATE_F,
            FoodContract.ModerateEntry.COLUMN_MODERATE_O,
            FoodContract.ModerateEntry.COLUMN_MODERATE_D,
            FoodContract.ModerateEntry.COLUMN_MODERATE_M,
            FoodContract.ModerateEntry.COLUMN_MODERATE_P};
    FodmapPresenter fPresenter = new FodmapPresenter();



    @Override
    protected void setUp(){
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown(){
        signal.countDown();
    }

    public void testFodmapTask() throws InterruptedException {
        new FodmapTask(fPresenter, FoodContract.ModerateEntry.buildModerateUri(),
                columns, "fodmaps") {

            @Override
            public void onPostExecute(List<Food> foods) {
                assertTrue(foods != null);
                signal.countDown();
            }
        }.execute();
        signal.await();

    }

}


