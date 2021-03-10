package com.example.mvp_threadexecutor;

public interface MainActivityContract {

    interface View {
        void arrAddMid(String massage);
        void arrRemMid(String massage);
    }

    interface Presenter {
        void doCalculations();
    }

    interface allProcess {
        String arrAddiMid();
        String arrRemoveMid();
    }

}
