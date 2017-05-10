package com.you.vieweventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class contActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvToDoList;
    private adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvToDoList = (RecyclerView) findViewById(R.id.rvToDoList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvToDoList.setLayoutManager(linearLayoutManager);
        mAdapter = new adapter(this);
        rvToDoList.setAdapter(mAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
