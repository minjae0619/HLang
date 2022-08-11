package com.mj.h.utils;

import com.mj.h.HLanguage;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resource {

    private static final String FILE_NAME = "HLanguage.hlang";

    public static InputStream getResource(String path){
        return HLanguage.class.getResourceAsStream(path);
    }

    public static String getText(InputStream inputStream){
        String text = "";
        try {
            char[] c = new char[1024];
            int count = 0;
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                text += str + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static String getJavaCode() {
        String str = "";
        try {
            File file = new File(HLanguage.PROJECT_PATH + "\\" + FILE_NAME);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                str += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static BufferedReader getJavaCodeReader() {
        String str = "";
        try {
            File file = new File(HLanguage.PROJECT_PATH + "\\" + FILE_NAME);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeJavaCode(String javaCode){
        try {
            File file = new File(HLanguage.PROJECT_PATH + "\\" + FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
            InputStream inputStream = new ByteArrayInputStream(javaCode.getBytes(StandardCharsets.UTF_8));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){e.printStackTrace();}
    }
    public static OutputStream error;
    public static URLClassLoader urlClassLoader;
    public static OutputStream readCode(){
        try {
            BufferedReader bufferedReader = getJavaCodeReader();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            return error;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return error;
    }
    public static OutputStream readJavaCode(){
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            File file = new File(HLanguage.PROJECT_PATH + "\\" + FILE_NAME);
            Path path = Paths.get(file.toURI());
            error = new ByteArrayOutputStream();
            compiler.run(null, null, error, path.toString());
            URL classPath = path.toAbsolutePath().getParent().toUri().toURL();
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{ classPath });
            urlClassLoader = classLoader;
            Class<?> clazz = Class.forName("HLanguage", true, classLoader);
            clazz.newInstance();
            return error;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return error;
    }
    public static Class<?> getJavaCodeClass(){
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            File file = new File(HLanguage.PROJECT_PATH + "\\" + FILE_NAME);
            Path path = Paths.get(file.toURI());
            error = new ByteArrayOutputStream();
            compiler.run(null, null, error, path.toString());
            URL classPath = path.toAbsolutePath().getParent().toUri().toURL();
            URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{ classPath });
            return Class.forName("HLanguage", true, classLoader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
