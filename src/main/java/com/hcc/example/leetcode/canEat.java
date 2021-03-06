package com.hcc.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/6/1 9:58
 * @description
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组 answer 。
 *
 *  
 *
 * 示例 1：              0 1  2  3  4          prefix[queries[i][0]] >= queries[i][1] &&   prefix[queries[i][0]] <=queries[i][2] * queries[i][1]
 *                      7 11 16 19 27
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 *
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class canEat {
    public static void main(String[] args) {
//        int[] candiesCount = {7,4,5,3,8};
        int[] candiesCount = {5,2,6,4,1};
//        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};
        int[][] queries = {{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}};
        boolean[] booleans = canEat(candiesCount, queries);
        System.out.println(booleans);
    }

    //首先先求出candiesCount的前缀和  prifx[]
    //从第0天开始吃糖果，对于第 i 个询问 我们可以吃 favoriteDayi+1天的糖果
    //第i个询问，我们吃的糖果区间为 [favoriteDayi+1, (favoriteDayi+1)*dailyCapi]
    //那么只要上面的区间包含一颗第favoriteTypei的糖果即可
    //favoriteTypei对应的糖果区间为 [prefix[favoriteTypei-1]+1, prefix[favoriteTypei]]  当favoriteTypei为0时左端点为1
    //只要两个区间有交集 即可证明可以吃到  取无交集的相反 [x1,y1] [x2,y2] 即  x1>y2 或 y1<x2
    public static boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int[] prefix = new int[n];
        prefix[0] = candiesCount[0];
        for (int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i=0;i<queries.length;i++){
            int[] temp = queries[i];
            int favoriteTypei = temp[0], favoriteDayi = temp[1], dailyCapi = temp[2];
            long  x1 = favoriteDayi + 1;
            long  y1 = (long)(favoriteDayi+1)*dailyCapi;
            long  x2 = favoriteTypei==0?1 : prefix[favoriteTypei-1]+1;
            long  y2 = prefix[favoriteTypei];
            res[i] = !(x1>y2 || y1<x2);
        }
        return res;
    }
}
