package com.example.mvp_threadexecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProcess implements MainActivityContract.allProcess {

    private ExecutorService arrAddMidExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService arrRemoveMidExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService arrSearchMidExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService linkAddMidExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService linkRemoveMidExecutor = Executors.newSingleThreadExecutor();
    private ExecutorService linkSearchMidExecutor = Executors.newSingleThreadExecutor();

    private Callback callback;


    public MainProcess(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void arrAddMid() {
        Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
            list.add(5000000, 10);
            long elapsedTime = stopWatch.end();
            callback.onArrAdMidCalculated(String.valueOf(elapsedTime));
        };
        arrAddMidExecutor.execute(runnable);
    }

    public void arrRemoveMid() {
        Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
            list.remove(5000000);
            long elapsedTime = stopWatch.end();
            callback.onArrRemoveMidCalculated(String.valueOf(elapsedTime));
        };
        arrRemoveMidExecutor.execute(runnable);
    }

    public void arrSearchMid() {
        Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
            boolean x = list.contains(50);
            long elapsedTime = stopWatch.end();
            callback.onArrSearchMidCalculated(String.valueOf(elapsedTime));
        };
        arrSearchMidExecutor.execute(runnable);
    }


    public void linkedAddMid() {
         Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
                LinkedList<Integer> linkedList = new LinkedList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.add(5000000, 10);
             long elapsedTime = stopWatch.end();
            callback.onLinkAdMidCalculated(String.valueOf(elapsedTime));
        };
        linkAddMidExecutor.execute(runnable);
    }

    public void linkedRemMid() {
       Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            LinkedList<Integer> linkedList = new LinkedList<>();
            Random rand = new Random();
            int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.remove(5000000);
            long elapsedTime = stopWatch.end();
            callback.onLinkRemoveMidCalculated(String.valueOf(elapsedTime));
        };
        linkRemoveMidExecutor.execute(runnable);
    }

    @Override
    public void linkedSearch() {
        Runnable runnable = () -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            LinkedList<Integer> linkedList = new LinkedList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                linkedList.add(num);
            }
            boolean x = linkedList.contains(50);
            long elapsedTime = stopWatch.end();
            callback.onLinkSearchMidCalculated(String.valueOf(elapsedTime));
        };
        linkSearchMidExecutor.execute(runnable);

    }

    interface Callback {
        void onArrAdMidCalculated(String result);

        void onArrRemoveMidCalculated(String result);

        void onArrSearchMidCalculated(String result);

        void onLinkAdMidCalculated(String result);

        void onLinkRemoveMidCalculated(String result);

        void onLinkSearchMidCalculated(String result);
    }

}
