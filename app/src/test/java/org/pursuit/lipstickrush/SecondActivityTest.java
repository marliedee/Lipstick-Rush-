package org.pursuit.lipstickrush;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pursuit.lipstickrush.model.MakeupPOJO;

import java.util.ArrayList;
import java.util.List;

public class SecondActivityTest {
    private SecondActivity secondActivity;

    @Before
    public void setUp() throws Exception {
        secondActivity = SecondActivity.getInstance();
    }

    @Test
    public void isOnQueryTextChangeNonNull() {
        List<MakeupPOJO> makeupList = new ArrayList<>();
        for (MakeupPOJO makeup : makeupList) {
            if (makeup.getBrand() == null) {
                continue;
            }
            String newText = "lipstick";
            boolean val = secondActivity.onQueryTextChange("lipstick");
            Assert.assertTrue(newText, val);
        }
    }
        @After
        public void tearDown () throws Exception {
            secondActivity = null;
        }
}

