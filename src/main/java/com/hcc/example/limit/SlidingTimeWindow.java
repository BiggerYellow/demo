package com.hcc.example.limit;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author huangchunchen
 * @date 2020/12/9 10:59
 * @description
 */
public class SlidingTimeWindow {
    public final int limit=100;
    Long counter = 0L;
    LinkedList<Long> slots = new LinkedList<>();
    int split = 10;
    boolean isLimited=false;

    private void doCheck() throws InterruptedException {
        while (true){
            slots.addLast(counter);
            if (slots.size() > split){
                slots.removeFirst();
            }

            if ((slots.peekLast() - slots.peekFirst()) > limit){
                System.out.println("is Limited");
                isLimited = true;
            }else {
                isLimited = false;
            }
            Thread.sleep(10000/split);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingTimeWindow slidingTimeWindow = new SlidingTimeWindow();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    slidingTimeWindow.doCheck();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        while (true){
            if (!slidingTimeWindow.isLimited){
                slidingTimeWindow.counter++;
                System.out.println("未限流");
                Thread.sleep(new Random().nextInt(5));
            }else {
                System.out.println("被限流");
            }
        }
    }
}
