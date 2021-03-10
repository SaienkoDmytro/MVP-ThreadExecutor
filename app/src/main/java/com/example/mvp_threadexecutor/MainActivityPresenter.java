package com.example.mvp_threadexecutor;

public class MainActivityPresenter implements MainActivityContract.Presenter, MainProcess.Callback {

    private final MainActivityContract.View view;
    private final MainActivityContract.allProcess process;


    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.process = new MainProcess(this);
    }

    @Override
    public void doCalculations() {
        view.showCalcStarted();

        process.arrAddMid();
        process.arrRemoveMid();
        process.arrSearchMid();
        process.linkedAddMid();
        process.linkedRemMid();
        process.linkedSearch();
    }

    @Override
    public void onArrAdMidCalculated(String result) {
        view.setArrAddMid(result);
    }

    @Override
    public void onArrRemoveMidCalculated(String result) {
        view.setArrRemMid(result);
    }

    @Override
    public void onArrSearchMidCalculated(String result) {
        view.setArrSearch(result);
    }

    @Override
    public void onLinkAdMidCalculated(String result)  {
        view.setLinkAddMid(result);
    }

    @Override
    public void onLinkRemoveMidCalculated(String result)  {
        view.setLinkRemMid(result);
    }

    @Override
    public void onLinkSearchMidCalculated(String result)  {
        view.setLinkSearch(result);
    }

}
