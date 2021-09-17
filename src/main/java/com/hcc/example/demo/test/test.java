package com.hcc.example.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.hcc.example.demo.vo.User;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * @author huangchunchen
 * @date 2020/5/29 15:16
 * @description
 */
public class test {
    public static void main(String[] args) throws ParseException {
        Short s = 0;
        // int a = 0;
        // int b = a;
        // System.out.println(a + "---" + b);
        // a = 1;
        // System.out.println(a + "---" + b);
//        ArrayList<User> users = new ArrayList<>();
//        User user = new User();
//        user.setId(1);
//        User user2 = new User();
//        user2.setId(2);
//        User user3 = new User();
//        user3.setId(3);
//        User user4 = new User();
//        user4.setId(4);
//        users.add(user);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User next = iterator.next();
//            if (next.getId() == 1) {
//                continue;
//            }
//            System.out.println(next.getId());
//        }
        // System.out.println("--------------------");
        //
        // Iterator<User> iterator1 = users.iterator();
        // while (iterator1.hasNext()){
        // User next = iterator1.next();
        // System.out.println(next.getId());
        // }
        //
        // HashSet<Object> objects = new HashSet<>();
        // objects.add(1);
        // objects.add(2);
        //
        // ArrayList<Object> objects3 = new ArrayList<>();
        // objects3.add(1);
        // objects3.add(2);
        //
        // ArrayList<Object> objects1 = new ArrayList<>();
        // objects.add(1);
        //
        // objects1.addAll(objects3);
        // System.out.println(objects1);

//        int a = 10;
//        System.out.println(10 >>> 5);
//
////        boolean b =false;
////        while (b){
////            //A do something
////        }
//        String aa ="GYBBER & MUMU Inertia Cars Truck Toy for Kids Toddlers";
//        System.out.println(aa.length());
//        String tempPath = System.getProperty("E:\\CMS\\pic");
//        System.out.println(tempPath);

//        Calendar cale = Calendar.getInstance();
//        System.out.println(cale);
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy hh:mm:ss",
//                Locale.ENGLISH);
//        System.out.println(sdf.format(date));
//        System.out.println(sdf.format(cale.getTime()));
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
//        Date parse = sdf1.parse(date.toString());
//        System.out.println(parse);
//
//        Integer integer = new Integer("1");
//        Short a = 1;
//        Short b = 1;
//        System.out.println(a == b);
//        System.out.println(integer.equals(Integer.valueOf(a.toString())));

//        User user = new User();
//        user.setId(1);
//        user.setRealName("haha");
//
//        User user1 = new User();
//        user1.setId(1);
//        user1.setRealName("qweq");
//        ArrayList<User> users = new ArrayList<>();
//        users.add(user);
//        users.add(user1);
//
////        Map<Integer, String> collect = users.stream().collect(Collectors.toMap(User::getId, User::getRealName, (e1, e2)->e1));
//        System.out.println(JSONObject.toJSONString(users));
//        String a ="[{\"id\":1,\"realName\":\"haha\"},{\"id\":1,\"realName\":\"qweq\",\"aaa\":\"aaa\"}]\n";
//        List<User> users1 = JSONObject.parseArray(a, User.class);
//        System.out.println(user);

//        String a = "artice 123 1 1 123";
//        String replace = a.replace(" ", "-");
//        System.out.println(replace);
//        String substring = a.substring(0, a.indexOf("-"));
//        System.out.println(substring);

//        String a ="/E:/code/2020.30/jeecms/jeecms-front/target/classes/WEB-INF/t/cms/www";
//        File file = new File(a);
//        File[] files = file.listFiles();
//        System.out.println(files.length);
//        FTPUtil ftpCli = FTPUtil.createFtpCli("192.168.28.191", "myuser", "myuser", "/opt/jeecms/apache-ftpserver-1.0.6/res/home");
//        System.out.println(ftpCli.isConnected());
//        String url = "doba4-doba4-1a1";
//        String substring = url.substring(0, url.indexOf("-"));
//        int page = 1;
//        try {
//            String substring1 = url.substring(url.lastIndexOf("-")+1);
//            page = Integer.valueOf(substring1).intValue();
//
//        }catch (Exception e){
//            System.out.println("异常");
//        }
//
//        System.out.println(substring);
//        System.out.println(page);
//        String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
//        String regEx="[?#%]";
//        String newString = url.replaceAll(regEx,"");//不想保留原来的字符串可以直接写成 “str = str.replaceAll(regEX,aa);”
//        System.out.println(newString);


        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy",
                Locale.ENGLISH);
        System.out.println(sdf.format(new Date()));
    }
}
