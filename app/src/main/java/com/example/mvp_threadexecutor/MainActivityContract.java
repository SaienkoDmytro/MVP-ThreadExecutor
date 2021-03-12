package com.example.mvp_threadexecutor;

import java.util.concurrent.ExecutionException;

public interface MainActivityContract {

    interface View {
        void setTimeToTextView(String massage, int place);
        void showCalcStarted();
    }

    interface Presenter {
        void doCalculations() throws ExecutionException, InterruptedException;
        void onDestroy();
    }

    interface allProcess {
        void startThreads();
    }

}
