package com.cn.thu.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: jiayu
 * Date: 13-9-30
 * Time: 下午10:55
 * To change this template use File | Settings | File Templates.
 */
public class DataConnection {

    private DataConnection() {
            loadDriver();
    }
//    public static void main(String[] args) {
//        new DataConnection().loadDriver();
//    }

    /**
     *
     * @return DBUtil instance
     */
    public static  DataConnection getDBUtil(){

        return DBUtilInstance;
    }

    public void loadDriver() {

        proper = new Properties();
        try {
                fr = new FileReader("src/main/resources/conData.properties");
                proper.load(fr);
            Class.forName(proper.getProperty("DRIVERLOAD"));
            System.out.println("驱动加载成功！！！");
            this.conData();
        } catch (FileNotFoundException fe) {
            System.out.println("指定路径的文件不存在或者无权限访问！！！");
            fe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("无法找到所加载的驱动，或是驱动文件不存在！！！");
            e.printStackTrace();
        }finally{
            try {
                fr.close();
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void conData(){
        try {
            conn = DriverManager.getConnection(proper.getProperty("URL"), proper.getProperty("USER"), proper.getProperty("PASSWORD"));
            System.out.println("数据库连接成功！！！");
        } catch (SQLException e) {
            System.out.println("不能连接到指定的数据库，请检查相应的基本信息！！！");
            e.printStackTrace();
        }
    }

    /**
     * deal with query operate to database
     * @param SQLCommand
     * @return result set of query
     * @throws SQLException
     */
    public ResultSet executeQuery(String SQLCommand) throws SQLException {
        if(conn == null){    //Failed at connection step (DBUtil Construction)
            System.out.println("Ever failed at connection step");
            throw new SQLException();
        }
        Statement statement = null;
        ResultSet rs = null;
        statement = conn.createStatement();
        System.out.println(SQLCommand); //
        rs = statement.executeQuery(SQLCommand);
        return rs;

    }

    /**
     * deal with update delete add operates to database
     * @param SQLCommand
     * @return result set contains ID
     * @throws SQLException
     */
    public ResultSet executeUpdate(String SQLCommand) throws SQLException {
        ResultSet result ;
        if(conn == null){    //Failed at connection step (DBUtil Construction)
            System.out.println("Ever failed at connection step");
            throw new SQLException();
        }
        Statement statement = conn.createStatement();
        statement.executeUpdate(SQLCommand);
        result = statement.getGeneratedKeys();
        return result;
    }
    public void close() throws SQLException {
        conn.close();
    }
    private Properties proper;
    private FileReader fr;
    private Connection conn=null;
    private static final DataConnection DBUtilInstance = new DataConnection();
}

