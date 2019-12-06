package com.example.xebianytimesdemo.mvList;

import com.example.xebianytimesdemo.mvList.entity.MVListResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Salim on 12/6/2019.
 */
public class MostViewedViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    MostViewedViewModel viewModel;

    @Mock
    Observer<MVListResponse> observer;

    @Mock
    MediatorLiveData<MVListResponse> apiData;

    @Mock
    MvRepo repository;

    @Mock
    LifecycleOwner owner;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        viewModel = new MostViewedViewModel();
        viewModel.getList().observe(owner, observer);
    }

    @Test
    public void testNull() {
        when(repository.getList()).thenReturn(null);
        assertNotNull(viewModel.getList());
        assertTrue(viewModel.getList().hasObservers());

        viewModel.setmApiResponse(apiData);
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
        when(repository.getList()).thenReturn(apiData);
        viewModel.getList();
    }

//    @Test
//    public void testApiFetchDataError() {
//        when(apiClient.fetchNews()).thenReturn(Single.error(new Throwable("Api error")));
//        viewModel.getList();
//        verify(observer).onChanged(NewsListViewState.LOADING_STATE);
//        verify(observer).onChanged(NewsListViewState.ERROR_STATE);
//    }
}