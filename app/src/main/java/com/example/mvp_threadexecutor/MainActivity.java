package com.example.mvp_threadexecutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private MainActivityContract.Presenter presenter;
    private TextView txtArrListAdd, txtLinkListAdd, txtCopyListAdd, txtArrListRem, txtLinkListRem, txtCopyListRem, txtArrListSearch, txtLinkListSearch, txtCopyListSearch;

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

        txtArrListAdd = findViewById(R.id.arr_addmid);
        txtLinkListAdd = findViewById(R.id.link_addmid);
        txtCopyListAdd = findViewById(R.id.copy_addmid);
        txtArrListRem = findViewById(R.id.arr_remmid);
        txtLinkListRem = findViewById(R.id.link_remmid);
        txtCopyListRem = findViewById(R.id.copy_remmid);
        txtArrListSearch = findViewById(R.id.arr_search);
        txtLinkListSearch = findViewById(R.id.link_search);
        txtCopyListSearch = findViewById(R.id.copy_search);
    }

    @Override
    public void setTimeToTextView(String massage, int place) {
        if (place == 11) {
            runOnUiThread(() -> txtArrListAdd.setText(massage));
        }
        if(place == 12) {
            runOnUiThread(() -> txtArrListRem.setText(massage));
        }
        if (place == 13) {
            runOnUiThread(() -> txtArrListSearch.setText(massage));
        }
        if (place == 21) {
            runOnUiThread(() -> txtLinkListAdd.setText(massage));
        }
        if (place == 22) {
            runOnUiThread(() -> txtLinkListRem.setText(massage));
        }
        if (place == 23) {
            runOnUiThread(() -> txtLinkListSearch.setText(massage));
        }
        if (place == 31) {
            runOnUiThread(() -> txtCopyListAdd.setText(massage));
        }
        if (place == 32) {
            runOnUiThread(() -> txtCopyListRem.setText(massage));
        }
        if (place == 33) {
            runOnUiThread(() -> txtCopyListSearch.setText(massage));
        }
    }

    @Override
    public void showCalcStarted() {
        txtArrListAdd.setText(R.string.calculating);
        txtArrListRem.setText(R.string.calculating);
        txtArrListSearch.setText(R.string.calculating);
        txtLinkListAdd.setText(R.string.calculating);
        txtLinkListRem.setText(R.string.calculating);
        txtLinkListSearch.setText(R.string.calculating);
        txtCopyListAdd.setText(R.string.calculating);
        txtCopyListRem.setText(R.string.calculating);
        txtCopyListSearch.setText(R.string.calculating);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}