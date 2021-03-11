package com.example.mvp_threadexecutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter presenter;
    private TextView arrAddmid, linkAddmid, copyAddmid, arrRemmid, linkRemmid, copyRemmid, arrSearch, linkSearch, copySearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        ImageView calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(view -> {
            try {
                presenter.doCalculations();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });

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
    public void setArrAddMid(String massage) {
        runOnUiThread(() -> arrAddmid.setText(massage));
    }

    @Override
    public void setArrRemMid(String massage) {
        runOnUiThread(() -> arrRemmid.setText(massage));
    }

    @Override
    public void setArrSearch(String massage) {
        runOnUiThread(() -> arrSearch.setText(massage));
    }

    @Override
    public void setLinkAddMid(String massage) {
        runOnUiThread(() -> linkAddmid.setText(massage));
    }

    @Override
    public void setLinkRemMid(String massage) {
        runOnUiThread(() -> linkRemmid.setText(massage));
    }

    @Override
    public void setLinkSearch(String massage)  {
        runOnUiThread(() -> linkSearch.setText(massage));
    }

    @Override
    public void setCopyAddMid(String massage)   {
        runOnUiThread(() -> copyAddmid.setText(massage));
    }

    @Override
    public void setCopyRemMid(String massage)   {
        runOnUiThread(() -> copyRemmid.setText(massage));
    }

    @Override
    public void setCopySearch(String massage)   {
        runOnUiThread(() -> copySearch.setText(massage));
    }


    @Override
    public void showCalcStarted() {
        arrAddmid.setText(R.string.calculating);
        arrRemmid.setText(R.string.calculating);
        arrSearch.setText(R.string.calculating);
        linkAddmid.setText(R.string.calculating);
        linkRemmid.setText(R.string.calculating);
        linkSearch.setText(R.string.calculating);
        copyAddmid.setText(R.string.calculating);
        copyRemmid.setText(R.string.calculating);
        copySearch.setText(R.string.calculating);
    }
}