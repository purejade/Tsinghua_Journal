package com.cn.thu.utility;

import java.io.File;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-15
 * Time: 下午9:19
 * To change this template use File | Settings | File Templates.
 */
public class FileUtil {

    public FileUtil() {
    }

    public long getFileSize(File f){//递归求取目录文件个数

        long size = 0;
        File files[] = f.listFiles();
        size = files.length;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                size = size + getFileSize(files[i]);
                size--;
            } else {
                  if(!files[i].getName().matches(".*\\.(?i)png")){
                        size--;
                  }
            }
        }
        return size;
    }
    // old function
    public HashMap<Integer,String> getFileNames_1(File file) {
        HashMap<Integer,String> fileNames = new HashMap<Integer, String>();
        File files[] = file.listFiles();
        long size = files.length;
        int preface = 0;
        for(int i = 0;i < size;i++) {
            if(files[i].getName().toCharArray()[0] == '!') {
                preface++;
            }
        }
        fileNames.put(0,files[0].getName());
        for(int j = 1; j <= size-preface;j++) {
            fileNames.put(j,files[j + preface -1].getName()) ;
        }
        return fileNames;
    }

    public int getPrefaceNumber(File file) {
        File files[] = file.listFiles();
        long size = files.length;
        int preface = 0;
        for(int i = 0;i < size;i++) {
            if(files[i].getName().toCharArray()[0] == '!') {
                preface++;
            }

        }
        return preface;
    }
    public HashMap<Integer,String> getFileNames(File file) {
        HashMap<Integer,String> fileNames = new HashMap<Integer, String>();
        File files[] = file.listFiles();
        long size = files.length;
        int preface
                = 0;
        for(int i = 0;i < size;i++) {
            if(files[i].getName().toCharArray()[0] == '!') {
                preface++;
            }
            if(files[i].getName().matches(".*\\.(?i)png")) {
                fileNames.put(i,files[i].getName());
            }
        }

        return fileNames;
    }

}
