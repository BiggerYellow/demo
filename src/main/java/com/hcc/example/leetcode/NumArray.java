package com.hcc.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/3/1 9:07
 * @description
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *  
 *
 * 示例：
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 *
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    public static void main(String[] args) {

    }

    static  int[] sums;
    //先求出每个位置的前缀和 公式为 sums[i+1]=nums[i]+sums[i]
    public NumArray(int[] nums) {
        sums = new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            sums[i+1] = nums[i]+sums[i];
        }
    }

    //指定范围即求 sum[j+1]-sum[i]要包含i和j
    public static int sumRange(int i, int j) {
        return sums[j+1]-sums[i];
    }
}
