package com.hcc.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangchunchen
 * @date 2021/5/28 11:26
 * @description
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class rob2 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(1);
        node.left = node1;
        node.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;
        System.out.println(rob1(node));
    }

    //树的动态规划
    //每个节点可以选择偷或者不偷两种状态，相邻节点不能同时偷
    //1.当前节点选择偷时，两个子节点就不能偷了
    //2.当前节点选择不偷时，两个子节点取偷或不偷的最大值的之和
    //定义数量为2的数组  0代表不偷 1代表偷
    //转移方程：任意一个节点能偷到的最大金额的定义为：
    //          1.当前节点不偷： 当前节点能偷到的最大金额为 左节点偷或不偷的最大金额 + 右节点偷或不偷的最大金额
    //          root[0] = max(rob(root.left)[0] + rob(root.left)[1]) + max(rob(root.right)[0]+rob(root.right)[1])
    //          2.当前节点偷：  当前节点能偷到的最大金额为  左节点不偷的最大金额 + 右节点不偷的最大金额 + 当前节点的金额
    //          root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val
    public static int rob1(TreeNode root){
        int[] res = dfs1(root);
        return Math.max(res[0], res[1]);
    }

    public static int[] dfs1(TreeNode root){
        if (root == null) return new int[2];
        int[] temp = new int[2];
        int[] left = dfs1(root.left);
        int[] right = dfs1(root.right);

        temp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        temp[1] = left[0] + right[0] + root.val;
        return temp;
    }

    public static int rob(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Integer[] nums = list.toArray(new Integer[0]);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }

    //中序遍历  左->根->右
    public static void dfs(TreeNode root, List<Integer> list){
        if (root != null){
            if (root.left != null){
                dfs(root.left, list);
            }
            if (root.right != null){
                dfs(root.right, list);
            }
            list.add(root.val);
        }
    }
}
