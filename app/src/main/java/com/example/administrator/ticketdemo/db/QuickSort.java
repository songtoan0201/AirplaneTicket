package com.example.administrator.ticketdemo.db;

import android.util.Log;

import com.example.administrator.ticketdemo.bean.Ticket;

/**
 *
 *
 */

public class QuickSort {

    private static String TAG = "QuickSort";
    /**
     *
     * @param ints
     * @param start
     * @param end
     */
    public static void sort(Ticket[] ints, int start, int end,String condition){

        if(start < end){

            int mid = partition(ints, start, end,condition);

            sort(ints, start, mid - 1,condition);

            sort(ints, mid + 1, end,condition);
        }
    }


    public static int partition(Ticket[]  ints, int start, int end,String condition){
        Ticket base = ints[start];

        while(start < end){
            switch (condition){
                case "depart earliest to latest":

                    while(start < end && ints[end].getTime() >= base.getTime()){
                        //向左移动一位
                        end--;
                    }

                    ints[start] = ints[end];

                    while(start < end && ints[start].getTime() <= base.getTime()){
                        //向右移动一位
                        start++;
                    }

                    ints[end] = ints[start];
                    break;
                case "depart latest to earliest":
                    while(start < end && ints[end].getTime() <= base.getTime()){
                        end--;
                    }
                    ints[start] = ints[end];
                    while(start < end && ints[start].getTime() >= base.getTime()){
                        start++;
                    }
                    ints[end] = ints[start];
                    break;
                case "price expensive to cheap":
                    while(start < end && ints[end].getMoney() <= base.getMoney()){
                        end--;
                    }
                    ints[start] = ints[end];
                    while(start < end && ints[start].getMoney() >= base.getMoney()){
                        start++;
                    }
                    ints[end] = ints[start];
                    break;
                case "price cheap to expensive":
                    while(start < end && ints[end].getMoney() >= base.getMoney()){
                        end--;
                    }
                    ints[start] = ints[end];
                    while(start < end && ints[start].getMoney() <= base.getMoney()){
                        start++;
                    }
                    ints[end] = ints[start];
                    break;

            }
           }
        ints[start] = base;
        return start;
    }

}
