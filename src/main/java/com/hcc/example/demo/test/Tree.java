package com.hcc.example.demo.test;

/**
 * @author huangchunchen
 * @date 2020/8/20 8:58
 * @description
 */
public class Tree {
    private Tree left;
    private Tree right;
    private String data;

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
