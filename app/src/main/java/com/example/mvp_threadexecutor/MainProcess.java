package com.example.mvp_threadexecutor;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainProcess implements MainActivityContract.allProcess {

    long time;

    @Override
    public String arrAddiMid() {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    Random rand = new Random();
                    int num;
                    for (int i = 0; i < 6000000; i++) {
                        num = rand.nextInt(1);
                        arrayList.add(num);
                    }
                    arrayList.add(5000000, 10);
                    time = SystemClock.currentThreadTimeMillis();
                }
            });
            executorService.shutdownNow();
            return "" + time + "ms" ;
        }

    public String arrRemoveMid () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> list = new ArrayList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    list.add(num);
                }
                list.remove(5000000);
                time = SystemClock.currentThreadTimeMillis();
            }
        });
        executorService.shutdownNow();
        return "" + time + "ms" ;
    }

    public String arrSearchMid () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> list = new ArrayList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    list.add(num);
                }
                boolean x = list.contains(50);
                time = SystemClock.currentThreadTimeMillis();
            }
        });
        executorService.shutdownNow();
        return "" + time + "ms" ;
    }


    public String linkedAddMid () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<Integer> linkedList = new LinkedList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.add(5000000, 10);
                time = SystemClock.currentThreadTimeMillis();
            }
        });
        executorService.shutdownNow();
        return "" + time + "ms" ;
    }

    public String linkedRemMid () {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                LinkedList<Integer> linkedList = new LinkedList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.remove(5000000);
                time = SystemClock.currentThreadTimeMillis();
            }
        });
        executorService.shutdownNow();
        return "" + time + "ms" ;
    }

}
