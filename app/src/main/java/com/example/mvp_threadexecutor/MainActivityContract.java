package com.example.mvp_threadexecutor;

import java.util.concurrent.ExecutionException;

public interface MainActivityContract {

    interface View {
        void setArrAddMid(String massage);
        void setArrRemMid(String massage);
        void setArrSearch(String massage);
        void setLinkAddMid(String massage);
        void setLinkRemMid(String massage);
        void setLinkSearch(String massage);
        void showCalcStarted();
    }

    interface Presenter {
        void doCalculations() throws ExecutionException, InterruptedException;
    }

    interface allProcess {
        void arrAddMid();
        void arrRemoveMid();
        void arrSearchMid();
        void linkedAddMid();
        void linkedRemMid();
        void linkedSearch();
    }

}
