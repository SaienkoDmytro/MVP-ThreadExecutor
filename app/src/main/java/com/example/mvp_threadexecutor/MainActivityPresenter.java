package com.example.mvp_threadexecutor;

public class MainActivityPresenter implements MainActivityContract.Presenter, MainProcess.Callback {

    private MainActivityContract.View view;
    private MainActivityContract.allProcess process;


    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.process = new MainProcess(this);
    }

    @Override
    public void doCalculations() {
        view.showCalcStarted();
        process.startThreads();
    }

    @Override
    public void onDestroy() {
        view = null;
        process = null;
    }

    @Override
    public void getCalculatedResultPlace(String result, int place) {
        view.setTimeToTextView(result, place);
    }

}
