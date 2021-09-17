package com.hcc.example.demo.aop;

/**
 * Created with IntelliJ IDEA
 *
 * @author : 18070910
 * @Date :   2019/7/24
 * @Time :  14:31
 * @Description :
 */
public enum DataSourceType {
    INSTANCE("instance"),SANDBOX("sandBox");

    DataSourceType(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
