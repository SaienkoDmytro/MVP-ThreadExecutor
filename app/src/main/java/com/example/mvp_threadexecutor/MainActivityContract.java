package com.example.mvp_threadexecutor;

import java.util.concurrent.ExecutionException;

public interface MainActivityContract {

    interface View {
        void setArrAddMid(String massage);
        void setArrRemMid(String massage);
        void setArrSearch(String massage);
        void setLinkAddMid(String massage);
        void setLinkRemMid(String massage);
    }

    interface Presenter {
        void doCalculations() throws ExecutionException, InterruptedException;
    }

    interface allProcess {
        String arrAddMid() throws ExecutionException, InterruptedException;
        String arrRemoveMid() throws ExecutionException, InterruptedException;
        String arrSearchMid() throws ExecutionException, InterruptedException;
        String linkedAddMid() throws ExecutionException, InterruptedException;
        String linkedRemMid() throws ExecutionException, InterruptedException;
    }

}
