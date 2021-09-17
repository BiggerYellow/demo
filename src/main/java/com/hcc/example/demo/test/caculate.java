package com.hcc.example.demo.test;

import java.util.Stack;

/**
 * @author huangchunchen
 * @date 2020/7/7 11:47
 * @description
 */
public class caculate {
    public static void main(String[] args) {
//        String a = "19+78=";  //97
//        String a = "78-67*2=";  //-56
        String a = "7*6-2=";  //84
//        String a = "(1+76)/7*(2+3)=";  //55
//        String a = "(1+76)/7*(=";

        //检查表达式
        if (!check(a)){
            System.out.println("the expression is error");
            return;
        }

        //存放操作数栈
        Stack<Double> val = new Stack<>();
        //存放运算符栈
        Stack<String> opt = new Stack<>();
        String tmp = "";
        for (int i=0;i<a.length();i++){
            String param = String.valueOf(a.charAt(i));
            //当遇到+和-时，执行opt栈中上一个操作，并将当前运算符压栈
            if (param.equals("+") || param.equals("-") ){
                if (!opt.isEmpty()){
                    if (opt.peek().equals("*") || opt.peek().equals("/") || opt.peek().equals("%") || opt.peek().equals("+") || opt.peek().equals("-")){
                        Double value = calcuate(val.pop(), val.pop(), opt.pop());
                        val.push(value);
                    }
                }
                opt.push(param);
            }
            //当遇到*、/或%时，只有opt栈中上一个操作是*、/或%时才操作，并压栈
            else if (param.equals("*") || param.equals("/") || param.equals("%")){
                if (!opt.isEmpty()){
                    if (opt.peek().equals("*") || opt.peek().equals("/") || opt.peek().equals("%")){
                        Double value = calcuate(val.pop(), val.pop(), opt.pop());
                        val.push(value);
                    }
                }
                opt.push(param);
            }
            //当遇到=时，表示结束 opt中有运算符则计算
            else if (param.equals("=")){
                if (!opt.isEmpty()){
                    Double value = calcuate(val.pop(), val.pop(), opt.pop());
                    val.push(value);
                }
            }
            //遇到右括号时，表示一对括号结束，要计算括号内的表达式，计算完后看opt中顶部是否是左括号，是则弹出左括号，不是则继续计算直到弹出左括号
            else if (param.equals(")")){
                Double value = calcuate(val.pop(), val.pop(), opt.pop());
                val.push(value);
                if (opt.peek().equals("(")){
                    opt.pop();
                }
            }
            //当遇到左括号时直接压栈
            else if (param.equals("(")){
                opt.push(param);
            }
            //当数字的下个字符是运算符时才表明这是完整的一个数字，并且opt中有运算符就计算
            else {
                if (String.valueOf(a.charAt(i+1)).equals("+") || String.valueOf(a.charAt(i+1)).equals("-") || String.valueOf(a.charAt(i+1)).equals("*") || String.valueOf(a.charAt(i+1)).equals("/")|| String.valueOf(a.charAt(i+1)).equals("%") || String.valueOf(a.charAt(i+1)).equals("=") || String.valueOf(a.charAt(i+1)).equals(")")){
                    tmp +=param;
                    if (tmp.length() >= 100){
                        System.out.println("the max of num is 100");
                        break;
                    }
                    val.push(Double.valueOf(tmp));
                    if (!opt.isEmpty()){
                        if (opt.peek().equals("*") || opt.peek().equals("/") || opt.peek().equals("%")){
                            Double value = calcuate(val.pop(), val.pop(), opt.pop());
                            val.push(value);
                        }
                    }
                    tmp = "";
                }else {
                    tmp +=param;
                }
            }
        }
        System.out.println(val.pop());
    }

    private static Double calcuate(Double second, Double first, String opt){
        if (opt.equals("+")){
            return first + second;
        }
        if (opt.equals("-")){
            return first - second;
        }
        if (opt.equals("*")){
            return first * second;
        }
        if (opt.equals("/")){
            return first / second;
        }
        if (opt.equals("%")){
            return first % second;
        }
        return null;
    }

    private static Boolean check(String input){
        if(!input.matches("[\\d\\+\\-\\*/()=]*")){
            return false;
        }
        return true;
    }

}
