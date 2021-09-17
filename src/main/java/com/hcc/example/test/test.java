package com.hcc.example.test;

/**
 * @author huangchunchen
 * @date 2020/9/18 9:03
 * @description
 */
public class test {
    public static void main(String[] args) {
        int len = 5;
        Object[][] objects = new Object[10][10];
        for (int i=1;i<len;i++){
            for (int j=i+1;j<len;j++){
                objects[i][j] = j;
            }
        }
        System.out.println(objects);
        String s = "";
        System.out.println(s.replace("\"","'"));
    }

}
