package com.cn.thu.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-4
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class Constant {
    public static int rows_per_page = 10;
    private Properties properties = new Properties();
    private static final Constant constantInstantce=new Constant();
    public static final String IMAGE_PATH="/images/";
    public  static  final  int ROWS_PER_PER = 10;
    private Constant(){
//        try {
//            properties.load(new FileInputStream("target/classes/thujournal.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
    }

    /**
     * get key-value
     * @param key
     * @return value
     */
    public String getProperty(String key){
        return this.properties.getProperty(key,"NULL");
    }

    /**
     *
     * @return constant instance
     */
    public static Constant getInstantce(){
        return constantInstantce;
    }

}

