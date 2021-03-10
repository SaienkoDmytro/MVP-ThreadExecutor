package com.example.mvp_threadexecutor;

import java.util.concurrent.ExecutionException;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private final MainActivityContract.View view;
    private final MainActivityContract.allProcess process;

    private String massageAddMid,  massageRemMid, massageArrSearch, massageLinkAddMid, massageLinkRemMid;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
        this.process = new MainProcess();
    }

    @Override
    public void doCalculations() throws ExecutionException, InterruptedException {
        massageAddMid = process.arrAddMid();
        massageRemMid = process.arrRemoveMid();
        massageArrSearch = process.arrSearchMid();
        massageLinkAddMid = process.linkedAddMid();
        massageLinkRemMid = process.linkedRemMid();
        view.setArrAddMid(massageAddMid);
        view.setArrRemMid(massageRemMid);
        view.setArrSearch(massageArrSearch);
        view.setLinkAddMid(massageLinkAddMid);
        view.setLinkRemMid(massageLinkRemMid);
    }
    
}
