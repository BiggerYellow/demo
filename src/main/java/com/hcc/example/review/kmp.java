package com.hcc.example.review;

/**
 * @author huangchunchen
 * @date 2021/1/7 10:15
 * @description
 *  * 实现 strStr() 函数。
 *  *
 *  * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *  *
 *  * 示例 1:
 *  *
 *  * 输入: haystack = "hello", needle = "ll"
 *  * 输出: 2
 *  * 示例 2:
 *  *
 *  * 输入: haystack = "aaaaa", needle = "bba"
 *  * 输出: -1
 *  * 说明:
 *  *
 *  * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *  *
 *  * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/implement-strstr
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class kmp {
    public static void main(String[] args) {
        String haystack = "aaaaa";
        String needle = "bba";
        System.out.println(strStr(haystack,needle));

    }

    public static int strStr(String haystack,String needle){
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        int j=0;
        for (int i=0;i<haystack.length();i++){
            while (j>0 && haystack.charAt(i) != needle.charAt(j)){
                j=next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j==needle.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] getNext(String needle){
        int[] next = new int[needle.length()];
        int j=0;
        next[0] = j;
        for (int i=1;i<needle.length();i++){
            while (j>0 && needle.charAt(i)!= needle.charAt(j)){
                j=next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }

}
