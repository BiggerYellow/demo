package com.hcc.example.alg;

/**
 * @author huangchunchen
 * @date 2020/9/10 13:59
 * @description
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class longestPalindrome {
    public static void main(String[] args) {
//        String s = "caaaacb";
        String s = "caaacb";
//        char[] chars = s.toCharArray();
//        String longestPalindrome = getLongestPalindrome(chars);
//        String longestPalindrome1 = getLongestPalindrome1(chars);
//
//        System.out.println(longestPalindrome.length() > longestPalindrome1.length() ? longestPalindrome:longestPalindrome1);
        System.out.println(get(s));

    }

    public static String get(String s){
        int length = s.length();
        if (length<2) return s;

        int maxlen = 1;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i=0;i<length-1;i++){
            for (int j=i+1;j<length;j++){
                if (j-i+1>maxlen && vaild(chars, i, j)){
                    maxlen = j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }

    public static boolean vaild(char[] chars,int start, int end){
        while (start<end){
            if (chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }



    public static String getLongestPalindrome(char[] chars){
        String res = new String();
        String temp = new String();
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<=i;j++){

                if ((i+j) < chars.length && chars[i+j]==chars[i-j]){
                    if (j==0){
                        temp = String.valueOf(chars[i]);
                    }else {
                        temp = chars[i+j] + temp + chars[i-j];
                    }
                }else {
                    break;
                }
                if (temp.length()>res.length()){
                    res = temp;
                }
            }
        }
        return res;
    }

    public static String getLongestPalindrome1(char[] chars){
        String res = new String();
        String temp = new String();
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<=i;j++){

                if (j==0 && (i+1)<chars.length && chars[i]==chars[1+i]){
                    temp = String.valueOf(chars[i])+String.valueOf(chars[1+i]);
                }else{
                    if ((i+j+1) < chars.length && chars[i-j]==chars[i+j+1]){
                        temp = chars[i-j] + temp + chars[i+j+1];
                    }else {
                        break;
                    }
                }
                if (temp.length()>res.length()){
                    res = temp;
                }
            }
        }
        return res;
    }
}
