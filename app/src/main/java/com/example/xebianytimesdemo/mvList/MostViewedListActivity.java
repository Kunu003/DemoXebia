package com.example.xebianytimesdemo.mvList;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xebianytimesdemo.R;
import com.example.xebianytimesdemo.mvList.adapter.MvListAdapter;
import com.google.android.material.snackbar.Snackbar;

public class MostViewedListActivity extends AppCompatActivity implements Navigator {

    private MostViewedViewModel viewModel;
    private RecyclerView recyclerView;
    private MvListAdapter adapter;

    private ProgressBar progressBar;
    private CoordinatorLayout coordinatorLayout;

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView textViewTitle = toolbar.findViewById(R.id.toolbar_title);
        textViewTitle.setText("Ny Times Most Popular");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setToolbar();
        initView();
        viewModel = ViewModelProviders.of(this).get(MostViewedViewModel.class);

        showLoader(true);
        viewModel.getList().observe(this,
                mvListResponse -> {
                    showLoader(false);
                    if (mvListResponse != null && mvListResponse.getResults() != null) {
                        if (mvListResponse.getResults().size() > 0)
                            adapter.addData(mvListResponse.getResults());
                        else
                            showSnackBar("No data");
                    } else {
                        showLoader(false);
                        showSnackBar("No data");
                    }
                });
    }

    private void initView() {
        coordinatorLayout = findViewById(R.id.coordinator);
        progressBar = findViewById(R.id.mvl_progress);
        recyclerView = findViewById(R.id.mvl_rv);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(MostViewedListActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new MvListAdapter();
        adapter.setNavigator(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

    private void showLoader(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void showSnackBar(String msg) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }

    @Override
    public void showMessage(String msg) {
        showSnackBar(msg);
    }
}
