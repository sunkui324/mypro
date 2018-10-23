package com.wolab.javaParser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java 解析语法树
 *
 * @author bruce.sun
 * @date 2018/7/27
 */
public class JavaParserUtil {


    private ExecutorService executor = Executors.newFixedThreadPool(4);


    private static Pattern p = Pattern
            .compile(
                    "(?i)(?<=(?:from|into|update|join)\\s{1,1000}"
                            + "(?:\\w*[\\.]?\\w*(?:\\s{0,1000},\\s{0,1000})?)?" // 重复这里, 可以多个from后面的表
                            + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"
                            + "(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"
                            + ")(\\w+)"
            );

    public HashSet loading(){
        int i=0;
        for (String file : Files.pathList) {
            System.out.println("文件数量:"+Files.pathList.size()+"解析第"+(i++)+"个");

            Runnable r=() ->{
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(new File(file));
                    CompilationUnit compilationUnit = JavaParser.parse(fileInputStream);
                    HashSet tables=new HashSet();
                    Matcher matcher = p.matcher(compilationUnit.toString());

                    while (matcher.find()) {
                        tables.add(matcher.group());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.submit(r);

        }
        return null;
    }

    public  HashSet matchSql(String sql) {
        return new HashSet();
    }

    private static class Files {

        private static ArrayList<String> pathList = new ArrayList<>();

        HashSet<String> tables = new HashSet<>();
        static {
            //D:\workspace\finance-report\frs-common
            //D:\workspace\finance-report\frs-core
            //D:\workspace\finance-report\frs-service
            //D:\workspace\finance-report\frs-web
            //D:\workspace\finance-report\payment
            //D:\workspace\finance-report\frs-service

            String path = "D:\\workspace\\finance-report\\frs-common\\src\\main\\java\\com\\welab\\finance";
            getAllJavaFiles(path);
        }

        private static void getAllJavaFiles(String path) {
            File file = new File(path);
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    pathList.add(files[i].toString());
                }
                if (files[i].isDirectory()) {
                    getAllJavaFiles(files[i].getPath());
                }
            }
        }
    }




    public static void main(String[] args){
        JavaParserUtil myJavaParser = new JavaParserUtil();
        HashSet hashSet=myJavaParser.loading();

        Iterator iter= hashSet.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
