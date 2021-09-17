package com.hcc.example.test;

import org.springframework.transaction.annotation.Transactional;

import java.io.*;

/**
 * @author huangchunchen
 * @date 2020/9/24 10:25
 * @description
 */
public class tt {
    public static void main(String[] args) throws IOException {
        InputStream fileInputStream = new FileInputStream("C:\\Users\\huangchunchen\\Desktop\\application.properties");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int read;
        try {
            while ((read = dataInputStream.read()) >0){
                System.out.println((char) read);
            }
        }finally {
         dataInputStream.close();
        }
    }
}
