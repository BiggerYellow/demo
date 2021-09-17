package com.hcc.example.demo.aop;

/**
 * Created with IntelliJ IDEA
 *
 * @author : 18070910
 * @Date :   2019/7/24
 * @Time :  9:38
 * @Description :
 */
public class HandleDataSource {
    // 数据源名称线程池
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String datasource) {
        holder.set(datasource);
    }

    public static String getDataSource() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
