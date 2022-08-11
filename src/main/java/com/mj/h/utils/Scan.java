package com.mj.h.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Scan {




    public static void run(){
        BufferedReader bufferedReader = Resource.getJavaCodeReader();
        String str = "";
        String line;
        try{
            while ((line = bufferedReader.readLine()) != null){
                str += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
