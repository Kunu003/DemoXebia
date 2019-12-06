package com.example.xebianytimesdemo.mvList;

import com.example.xebianytimesdemo.mvList.MostViewedListActivity;
import com.example.xebianytimesdemo.mvList.MostViewedViewModel;

import org.junit.Before;
import org.junit.Test;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import static org.junit.Assert.*;

/**
 * Created by Salim on 12/6/2019.
 */
public class MostViewedListActivityTest {

    MostViewedListActivity mostViewedListActivity;
    MostViewedViewModel mostViewedViewModel;

    @Before
    public void setMostViewedListActivity(MostViewedListActivity mostViewedListActivity) {
        this.mostViewedListActivity = mostViewedListActivity;
        this.mostViewedViewModel = ViewModelProviders.of(mostViewedListActivity).get(MostViewedViewModel.class);
    }

    @Test
    public void testObserver(){

    }
}