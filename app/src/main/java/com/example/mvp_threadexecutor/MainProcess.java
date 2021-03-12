package com.example.mvp_threadexecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProcess implements MainActivityContract.allProcess {


    private final Callback callback;


    public MainProcess(Callback callback) {
        this.callback = callback;
    }

    public void startThreads() {

        ExecutorService executorFixedPool = Executors.newFixedThreadPool(9);

        executorFixedPool.execute(() -> {
            ArrayList<Byte> listAdd = new ArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            listAdd.add(listAdd.size() / 2, (byte)2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 11);
            listAdd.clear();
        });

        executorFixedPool.execute(() -> {
            ArrayList<Byte> listRem = new ArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            listRem.remove(listRem.size() / 2);
            long elapsedTime = stopWatch.end();
            listRem.clear();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 12);
        });

        executorFixedPool.execute(() -> {
            ArrayList<Byte> listSearch = new ArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            boolean x = listSearch.contains((byte)2);
            long elapsedTime = stopWatch.end();
            listSearch.clear();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 13);
        });

        executorFixedPool.execute(() -> {
            LinkedList<Byte> linkedAdd = new LinkedList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            linkedAdd.add(linkedAdd.size() / 2, (byte)2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 21);
            linkedAdd.clear();
        });

        executorFixedPool.execute(() -> {
            LinkedList<Byte> linkedRem = new LinkedList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            linkedRem.remove(linkedRem.size() / 2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 22);
            linkedRem.clear();
        });

        executorFixedPool.execute(() -> {
            LinkedList<Byte> linkedSearch = new LinkedList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            boolean x = linkedSearch.contains((byte)2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 23);
            linkedSearch.clear();
        });

        executorFixedPool.execute(() -> {
            CopyOnWriteArrayList<Byte> copyAdd = new CopyOnWriteArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            copyAdd.add(copyAdd.size() / 2, (byte)2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 31);
            copyAdd.clear();
        });

        executorFixedPool.execute(() -> {
            CopyOnWriteArrayList<Byte> copyRem = new CopyOnWriteArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            copyRem.remove(copyRem.size() / 2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 32);
            copyRem.clear();
        });

        executorFixedPool.execute(() -> {
            CopyOnWriteArrayList<Byte> copySearch = new CopyOnWriteArrayList<>(Collections.nCopies(2000000, (byte)1));
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            boolean x = copySearch.contains((byte)2);
            long elapsedTime = stopWatch.end();
            callback.getCalculatedResultPlace(elapsedTime + "ms", 33);
            copySearch.clear();
        });

        executorFixedPool.shutdown();
    }

    interface Callback {
        void getCalculatedResultPlace(String result, int place);
    }

}
