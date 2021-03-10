package com.example.mvp_threadexecutor;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private final MainActivityContract.View view;
    private final MainActivityContract.allProcess process;

    private String massageAddMid,  massageRemMid, massageArrSearch;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.process = new MainProcess();
    }

    @Override
    public void doCalculations() {
        massageAddMid = process.arrAddiMid();
        massageRemMid = process.arrRemoveMid();
        massageArrSearch = process.arrSearchMid();
        view.arrAddMid(massageAddMid);
        view.arrRemMid(massageRemMid);
        view.arrSearch(massageArrSearch);
    }
    
}
