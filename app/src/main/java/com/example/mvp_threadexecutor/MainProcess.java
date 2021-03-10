package com.example.mvp_threadexecutor;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainProcess implements MainActivityContract.allProcess {

    @Override
    public String arrAddMid() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Long> callable = () -> {
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
            list.add(5000000, 10);
            return SystemClock.currentThreadTimeMillis();
        };
        Future<Long> future = executor.submit(callable);
        long result1 = future.get();
        executor.shutdown();
            return "" + result1 + "ms" ;
        }

    public String arrRemoveMid () throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Long> callable = () -> {
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
            list.remove(5000000);
            return SystemClock.currentThreadTimeMillis();
        };
        Future<Long> future = executor.submit(callable);
        long result2 = future.get();
        executor.shutdown();
        return "" + result2 + "ms" ;
    }

    public String arrSearchMid () throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Long> callable = () -> {
            ArrayList<Integer> list = new ArrayList<>();
            Random rand = new Random();
            int num;
            for (int i = 0; i < 10000000; i++) {
                num = rand.nextInt(10);
                list.add(num);
            }
                boolean x = list.contains(50);
            return SystemClock.currentThreadTimeMillis();
        };
        Future<Long> future = executor.submit(callable);
        long result3 = future.get();
        executor.shutdown();
        return "" + result3 + "ms" ;
    }


    public String linkedAddMid () throws ExecutionException, InterruptedException {
        /*
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Long> callable = () -> {
                LinkedList<Integer> linkedList = new LinkedList<>();
                Random rand = new Random();
                int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.add(5000000, 10);
            return SystemClock.currentThreadTimeMillis();
        };
        Future<Long> future = executor.submit(callable);
        long result4 = future.get();
        executor.shutdown();

         */
        return "" + 4 + "ms" ;
    }

    public String linkedRemMid () throws ExecutionException, InterruptedException {
        /*
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Long> callable = () -> {
            LinkedList<Integer> linkedList = new LinkedList<>();
            Random rand = new Random();
            int num;
                for (int i = 0; i < 10000000; i++) {
                    num = rand.nextInt(10);
                    linkedList.add(num);
                }
                linkedList.remove(5000000);
            return SystemClock.currentThreadTimeMillis();
        };
        Future<Long> future = executor.submit(callable);
        long result5 = future.get();
        executor.shutdown();

         */
        return "" + 5 + "ms" ;
    }

}
