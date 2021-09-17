package com.hcc.example.demo.test;

import java.util.LinkedList;

/**
 * @author huangchunchen
 * @date 2020/8/20 9:03
 * @description
 */
public class TreeTest {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.setData("a");
        Tree tree2 = new Tree();
        tree2.setData("b");
        tree1.setLeft(tree2);
        Tree tree3 = new Tree();
        tree3.setData("c");
        tree1.setRight(tree3);
        Tree tree4 = new Tree();
        tree4.setData("d");
        tree2.setLeft(tree4);
        Tree tree5 = new Tree();
        tree5.setData("e");
        tree3.setLeft(tree5);
        Tree tree6 = new Tree();
        tree6.setData("f");
        tree3.setRight(tree6);

        //先序
        StringBuilder preorder = preorder(tree1, new StringBuilder());
        System.out.println(preorder.toString());
        //中序
        StringBuilder inorder = inorder(tree1, new StringBuilder());
        System.out.println(inorder.toString());
        //后序
        StringBuilder postorder = postorder(tree1, new StringBuilder());
        System.out.println(postorder.toString());
        //层序
        LinkedList<Tree> trees = new LinkedList<Tree>();
        trees.add(tree1);
        StringBuilder stringBuilder = new StringBuilder();
        dolevelorder(trees, stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 先序遍历：根节点--左节点--右节点  ABDCEF
     * @param tree
     * @param stringBuilder
     * @return
     */
    public static StringBuilder preorder(Tree tree, StringBuilder stringBuilder){
        if (tree != null){
            stringBuilder.append(tree.getData());
            if (tree.getLeft() != null){
                preorder(tree.getLeft(), stringBuilder);
            }
            if (tree.getRight() != null){
                preorder(tree.getRight(), stringBuilder);
            }
        }
        return stringBuilder;
    }

    /**
     * 中序遍历：左节点--根节点--右节点  DBAECF
     * @param tree
     * @param stringBuilder
     * @return
     */
    public static StringBuilder inorder(Tree tree, StringBuilder stringBuilder){
        if (tree != null){
            if (tree.getLeft() != null){
                inorder(tree.getLeft(), stringBuilder);
            }
            stringBuilder.append(tree.getData());
            if (tree.getRight() != null){
                inorder(tree.getRight(), stringBuilder);
            }
        }
        return stringBuilder;
    }

    /**
     * 后序遍历：左节点--右节点--根节点
     * @param tree
     * @param stringBuilder
     * @return
     */
    public static StringBuilder postorder(Tree tree, StringBuilder stringBuilder){
        if (tree != null){
            if (tree.getLeft() != null){
                postorder(tree.getLeft(), stringBuilder);
            }
            if (tree.getRight() != null){
                postorder(tree.getRight(), stringBuilder);
            }
            stringBuilder.append(tree.getData());
        }
        return stringBuilder;
    }

    /**
     * 层序遍历
     * 思路：使用队列先进先出的思想，首先将第一层的节点放进去，然后放入该节点的左右节点，并去除队列中头部的节点，递归操作，当队列为空时即操作结束
     * @param queue
     * @param stringBuilder
     */
    public static void dolevelorder(LinkedList queue, StringBuilder stringBuilder){
        if (queue.size() == 0){
            return;
        }
        Tree head = (Tree) queue.pollFirst();
        if (head.getLeft() != null){
            queue.add(head.getLeft());
        }
        if (head.getRight() != null){
            queue.add(head.getRight());
        }
        stringBuilder.append(head.getData());
        dolevelorder(queue, stringBuilder);
    }
}
