package com.hcc.example.alg;

import java.util.ArrayList;

/**
 * @author huangchunchen
 * @date 2020/9/4 8:47
 * @description
 */
public class joesphus {
    public static void main(String[] args) {
      joesphus(10,2);
        System.out.println(f(10,2));
    }

    public static void joesphus(int m, int n){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i=0;i<m;i++){
            integers.add(i);
        }

        int start = 0;
        while (integers.size()>1){
            start = (start + n - 1)%integers.size();
            System.out.println(integers.remove(start));
        }
        System.out.println(integers.get(0));
    }

    public static int f(int n, int m){
        if (n==1) return n;
        return (f(n-1,m) + m-1)%n+1;
    }
}
