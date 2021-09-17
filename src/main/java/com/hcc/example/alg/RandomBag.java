package com.hcc.example.alg;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author huangchunchen
 * @date 2020/9/2 9:00
 * @description
 * 随机背包。随机背包能够存储一组元素并支持表1.3.10中的API:
 * 表1.3.10泛型随机背包的API
 * public class RandomBag<Item> implements Iterable<Item>
 *      RandomBag()//创建一个空随机背包
 *      boolean isEmpty()//背包是否为空
 *      int size()//背包中的元素数量
 *      void add(Item item)//添加一个元素
 * 编写一个RandomBag类来实现这份API。请注意，除了形容词随机之外，这份API和Bag的API是相同的，这意味着迭代应该随机访问背包中的所有元素(对于每次迭代，所有的N!种排列出现的可能性均相同)。
 * 提示：用数组保存所有元素并在迭代器构造函数中随机打乱它们的顺序。
 */
public class RandomBag<Item> implements Iterable<Item>{

    private Item[] bag = (Item[]) new Object[1];
    private int n = 0;

    public RandomBag(){}

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void add(Item item){
        if (item == null) throw new RuntimeException();
        if (n == bag.length){
            resizing(2*bag.length);
        }
        bag[n++] = item;
    }

    public void resizing(int capacity){
        Item[] temp = (Item[])new Object[capacity];
        for (int i = 0;i<bag.length; i++){
            temp[i] = bag[i];
        }
        bag = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        public ListIterator(){
            for (int i = 0;i<bag.length;i++){
                int r = i + (int) (Math.random()*(n-i));
                Item temp = bag[i];
                bag[i] = bag[r];
                bag[r] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return n != 0;
        }

        @Override
        public Item next() {
            return bag[--n];
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Item> action) {

        }
    }

    public static void main(String[] args) {
        RandomBag<Integer> randomBag = new RandomBag<Integer>();
        for (int i=0; i<20;i++){
            randomBag.add(i);
        }

        for (Integer num:randomBag){
            System.out.println(num + "       ");
        }
    }
}
