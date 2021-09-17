package com.hcc.example.demo.tuple;

import org.apache.commons.collections.IteratorUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2020/7/2 14:47
 * @description
 */
public class test {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        List list = IteratorUtils.toList(iterator);

        String a ="1";
        Long s = 1l;
        System.out.println(a.equals(s));
    }
}
