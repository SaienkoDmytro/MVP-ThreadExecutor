package com.example.mvp_threadexecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProcess implements MainActivityContract.allProcess {

    private final ExecutorService arrAddMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService arrRemoveMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService arrSearchMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService linkAddMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService linkRemoveMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService linkSearchMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService copyAddMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService copyRemoveMidExecutor = Executors.newSingleThreadExecutor();
    private final ExecutorService copySearchMidExecutor = Executors.newSingleThreadExecutor();

    private final Callback callback;


    public MainProcess(Callback callback) {
        this.callback = callback;
    }


    @Override
    public void arrAddMid() {
        arrAddMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> listAdd = new ArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                listAdd.add(listAdd.size() / 2, 10);
                long elapsedTime = stopWatch.end();
                callback.onArrAdMidCalculated(elapsedTime + "ms");
                listAdd.clear();
            }
        });
    }


    public void arrRemoveMid() {
        arrRemoveMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> listRem = new ArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                listRem.remove(listRem.size()/2);
                long elapsedTime = stopWatch.end();
                listRem.clear();
                callback.onArrRemoveMidCalculated(elapsedTime +"ms");
            }
        });
    }

    public void arrSearchMid() {
        arrSearchMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> listSearch = new ArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                boolean x = listSearch.contains(50);
                long elapsedTime = stopWatch.end();
                listSearch.clear();
                callback.onArrSearchMidCalculated(elapsedTime +"ms");
            }
        });
    }


    public void linkedAddMid() {
        linkAddMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<Integer> linkedAdd = new LinkedList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                linkedAdd.add(linkedAdd.size()/2, 10);
                long elapsedTime = stopWatch.end();
                callback.onLinkAdMidCalculated(elapsedTime +"ms");
                linkedAdd.clear();
            }
        });
    }

    public void linkedRemMid() {
        linkRemoveMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<Integer> linkedRem = new LinkedList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                linkedRem.remove(linkedRem.size()/2);
                long elapsedTime = stopWatch.end();
                callback.onLinkRemoveMidCalculated(elapsedTime +"ms");
                linkedRem.clear();
            }
        });
    }

    @Override
    public void linkedSearch() {
        linkSearchMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<Integer> linkedSearch = new LinkedList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                boolean x = linkedSearch.contains(50);
                long elapsedTime = stopWatch.end();
                callback.onLinkSearchMidCalculated(elapsedTime +"ms");
                linkedSearch.clear();
            }
        });
    }

    @Override
    public void copyAddMid() {
        copyAddMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CopyOnWriteArrayList<Integer> copyAdd = new CopyOnWriteArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                copyAdd.add(copyAdd.size()/2, 10);
                long elapsedTime = stopWatch.end();
                callback.onCopyAdMidCalculated(elapsedTime +"ms");
                copyAdd.clear();
            }
        });
    }

    @Override
    public void copyRemMid() {
        copyRemoveMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CopyOnWriteArrayList<Integer> copyRem = new CopyOnWriteArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                copyRem.remove(copyRem.size()/2);
                long elapsedTime = stopWatch.end();
                callback.onCopyRemoveMidCalculated(elapsedTime +"ms");
                copyRem.clear();
            }
        });
    }

    @Override
    public void copySearch() {
        copySearchMidExecutor.execute(new Runnable() {
            @Override
            public void run() {
                CopyOnWriteArrayList<Integer> copySearch = new CopyOnWriteArrayList<>(Collections.nCopies(1000000, 1));
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                boolean x = copySearch.contains(50);
                long elapsedTime = stopWatch.end();
                callback.onCopySearchMidCalculated(elapsedTime +"ms");
                copySearch.clear();
            }
        });
    }

    interface Callback {
        void onArrAdMidCalculated(String result);

        void onArrRemoveMidCalculated(String result);

        void onArrSearchMidCalculated(String result);

        void onLinkAdMidCalculated(String result);

        void onLinkRemoveMidCalculated(String result);

        void onLinkSearchMidCalculated(String result);

        void onCopyAdMidCalculated(String result);

        void onCopyRemoveMidCalculated(String result);

        void onCopySearchMidCalculated(String result);
    }

}
