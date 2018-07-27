package com.wolab.javaParser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * java 解析语法树
 * @author bruce.sun
 * @date 2018/7/27
 *
 */
public class MyJavaParser {

    public void loading() throws Exception {
        for(String file:Files.pathList){
            FileInputStream fileInputStream=new FileInputStream(new File(file));
            try {
                CompilationUnit compilationUnit= JavaParser.parse(fileInputStream);
                System.out.println(compilationUnit.toString());
            }finally {
                fileInputStream.close();
            }

        }
    }

    private static class Files{

        private static ArrayList<String> pathList = new ArrayList<>();

        static{
            String path="D:\\workspace\\mypro\\src\\main\\java\\com\\wolab";
            getAllJavaFiles(path);
        }

        private static void getAllJavaFiles(String path){
            File file=new File(path);
            File[] files=file.listFiles();
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


    public static void main(String[] args) {
        MyJavaParser parser=new MyJavaParser();
        try {
            parser.loading();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
