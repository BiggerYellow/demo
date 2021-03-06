package com.hcc.example.leetcode;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2020/12/21 15:04
 * @description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsVaild {
    public static void main(String[] args) {
//        String s = "()";
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
        String s = "{[]}";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s){
        Stack<String> opt = new Stack<>();
        boolean flag = true;
        for (char c:s.toCharArray()){
            if (c == ')'){
                if (opt.isEmpty()){
                    flag=false;
                }else {
                    String pop = opt.pop();
                    if (!pop.equals("(")){
                        flag = false;
                    }
                }
            }
            if (c == ']'){
                if (opt.isEmpty()){
                    flag=false;
                }else {
                    String pop = opt.pop();
                    if (!pop.equals("[")){
                        flag = false;
                    }
                }
            }

            if (c == '}'){
                if (opt.isEmpty()){
                    flag=false;
                }else {
                    String pop = opt.pop();
                    if (!pop.equals("{")){
                        flag = false;
                    }
                }
            }
            if (c == '(' || c == '[' || c == '{'){
                opt.push(String.valueOf(c));
            }
        }
        if (!opt.isEmpty()){
            flag=false;
        }
        return flag;
    }
}
