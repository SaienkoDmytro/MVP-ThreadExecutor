package com.example.mvp_threadexecutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter presenter;
    private TextView arrAddmid, linkAddmid, copyAddmid, arrRemmid, linkRemmid, copyRemmid, arrSearch, linkSearch, copySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        ImageView calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(view -> presenter.doCalculations());

        arrAddmid = findViewById(R.id.arr_addmid);
        linkAddmid = findViewById(R.id.link_addmid);
        copyAddmid = findViewById(R.id.copy_addmid);
        arrRemmid = findViewById(R.id.arr_remmid);
        linkRemmid = findViewById(R.id.link_remmid);
        copyRemmid = findViewById(R.id.copy_remmid);
        arrSearch = findViewById(R.id.arr_search);
        linkSearch = findViewById(R.id.link_search);
        copySearch = findViewById(R.id.copy_search);
    }

    @Override
    public void arrAddMid(String massage) {
        arrAddmid.setText(massage);
    }

    @Override
    public void arrRemMid(String massage) {
        arrRemmid.setText(massage);
    }

    @Override
    public void arrSearch(String massage) {
        arrSearch.setText(massage);
    }


}