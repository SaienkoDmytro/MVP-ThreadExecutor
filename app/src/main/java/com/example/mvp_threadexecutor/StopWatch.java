package com.example.mvp_threadexecutor;

class StopWatch {

    private long mStartTime = 0;

    public void start() {
        mStartTime = System.currentTimeMillis();
    }

    public long end() {
        if (mStartTime == 0) {
            return 0; // early exit
        }

        long elapsedTime = System.currentTimeMillis() - mStartTime;
        mStartTime = 0;
        return elapsedTime;
    }
}
