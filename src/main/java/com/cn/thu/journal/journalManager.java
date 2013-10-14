package com.cn.thu.journal;


import  com.cn.thu.dao.DBUtil;
import com.cn.thu.messenger.JSONHelper;
import com.cn.thu.utility.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-4
 * Time: 下午2:28
 * To change this template use File | Settings | File Templates.
 */
public class journalManager {
    private static  Vector<Journal> journals = new Vector<Journal>();
    private  static  Vector<String> totalVolume = new Vector<String>();
    private static final String tableName ="journal";
    public journalManager() {
    }
           // 简单查询，返回总数
    /*
    *  function : get the number of the records
    *  paras: keyword
     */
    public  static  int simpleSearch(String keyword) throws SQLException {

        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        String SQLCommand = null;

        SQLCommand = "select count(*) totalCount from " + tableName + " where subject1 like binary  '%"+ keyword +"%' or subject2 like binary '%"+keyword+"$' or subject3 like binary '%"+keyword+"%' or freeword like binary '%"+ keyword+"%'";
        //  System.out.println(SQLCommand);
        // SQLCommand = "select * from " + tableName + " where id = 50";
        rs = du.executeQuery(SQLCommand);
        rs.last(); //移到最后一行
        //  int rowCount = rs.getRow(); //得到当前行号，也就是记录数
        int rowCount = rs.getInt("totalCount");
        // du.close();
        return  rowCount;
    }

    // 简单查询，根据关键字来查询到期刊信息,返回当前页记录【 主要包含主题词1,2,3 和自由词】
    public static Vector<Journal> simpleSearch(String keyword,int curpage,int rows_per_page,boolean flag  ) throws SQLException {
      //  Vector<Journal> journals = new Vector<Journal>();
        journals.clear();
        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        String SQLCommand = null;

        int prepage = (curpage - 1) * rows_per_page;
        int nextpage = curpage * rows_per_page;

//        if(Util.isEmpty(keyword))
//            throw  new TextFormatException("keyword is null");
        SQLCommand = "select * from " + tableName + " where subject1 like binary  '%"+ keyword +"%' or subject2 like binary '%"+keyword+"$' or subject3 like binary '%"+keyword+"%' or freeword like binary '%"+ keyword+"%'";
        if(flag) {
            SQLCommand = SQLCommand + " LIMIT " + prepage +"," + rows_per_page;
        }
      //  System.out.println(SQLCommand);
       // SQLCommand = "select * from " + tableName + " where id = 50";
        rs = du.executeQuery(SQLCommand);
     //   System.out.println(rs.next());
        while (rs != null && rs.next()) {
            Journal journal = new Journal(rs.getInt("id"));
            journal.setAuthor1(rs.getString("author1"));
            journal.setAuthor2(rs.getString("author2"));
            journal.setClassifyno1(rs.getString("classifyno1"));
            journal.setClassifyno2(rs.getString("classifyno2"));
            journal.setSubject1(rs.getString("subject1"));
            journal.setSubject2(rs.getString("subject2"));
            journal.setSubject3(rs.getString("subject3"));
            journal.setTitle(rs.getString("title"));
            journal.setSubtitle(rs.getString("subtitle"));
            journal.setComment(rs.getString("comment"));
            journal.setTotalvolume(rs.getString("totalvolume"));
            journal.setVolume(rs.getString("volume"));
            journal.setPageno(rs.getInt("pageno"));
            journal.setFreeword(rs.getString("freeword"));
            journal.setSerialno(rs.getString("serialno"));
            journal.setLabel(rs.getString("label"));
            journal.setTime(rs.getString("time"));

            journals.add(journal);

        //   System.out.println(rs.getString("label"));
        }
        return journals;
    }

    // 复杂查询，参数较多，还需要改进 ，返回记录数
    public  static  int complexSearch(String theme,int flag1,String title,int flag2,String author,int flag3,String pub_time,int flag4,String total_id,int flag5,String free_word,int flag6,String class_no) throws SQLException {
        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        String SQLCommand = null;

        String sql = "";
        if(!Util.isEmpty(theme)) {
            sql = "select count(*) totalCount from "+ tableName + " where label like '%"+theme+"%'";
        } else {

            sql = "select count(*) totalCount from "+ tableName + " where label like '%"+theme+ "%'";
        }


        if(!Util.isEmpty(title)) {
            if(flag1 == 0) {
                sql = sql + " and title like '%"+title+"%'";
            } else {
                sql = sql + " or title like '%"+title+"%'";
            }
        }
        if(!Util.isEmpty(author)) {
            if(flag2 == 1) {
                sql = sql + " and author1 like '%"+author+"%'";
            } else {
                sql = sql + " or author1 like '%"+author+"%'";
            }
        }
        if(!Util.isEmpty(pub_time)) {
            if(flag3 == 0) {
                sql = sql + " and time like '%"+pub_time+"%'";
            } else {
                sql = sql + " or time like '%"+pub_time+"%'";
            }
        }
        if(!Util.isEmpty(total_id)) {
            if(flag4 == 0) {
                sql = sql + " and totalvolume like '%"+total_id+"%'";
            } else {
                sql = sql + " or totalvolume like '%"+total_id+"%'";
            }
        }
        if(!Util.isEmpty(free_word)){
            if(flag5 == 0) {
                sql = sql + " and freeword like '%"+free_word+"%'";
            } else {
                sql = sql + " or freeword like '%"+free_word+"%'";
            }
        }
        if(!Util.isEmpty(class_no)) {
            if(flag6 == 0) {
                sql = sql + " and classifyno1 like '%"+class_no+"%'" ;
            } else {
                sql = sql + " or classifyno1 like '%"+class_no+"%'";
            }
        }
        //  System.out.println(SQLCommand);
        // SQLCommand = "select * from " + tableName + " where id = 50";
        rs = du.executeQuery(sql);
        rs.last(); //移到最后一行
        //  int rowCount = rs.getRow(); //得到当前行号，也就是记录数
        int rowCount = rs.getInt("totalCount");
        // du.close();
        return  rowCount;
    }
    // 复杂查询，返回记录，当前页记录数
    public  static  Vector<Journal> complexSearch(String theme,int flag1,String title,int flag2,String author,int flag3,String pub_time,int flag4,String total_id,int flag5,String free_word,int flag6,String class_no,int curpage,int rows_per_page) throws SQLException {
        String sql = "";
        if(!Util.isEmpty(theme)) {
            sql = "select * from "+ tableName + " where label like '%"+theme+"%'";
        } else {

            sql = "select * from "+ tableName + " where label like '%"+theme+ "%'";
        }


        if(!Util.isEmpty(title)) {
            if(flag1 == 0) {
                sql = sql + " and title like '%"+title+"%'";
            } else {
                sql = sql + " or title like '%"+title+"%'";
            }
        }
        if(!Util.isEmpty(author)) {
            if(flag2 == 1) {
                sql = sql + " and author1 like '%"+author+"%'";
            } else {
                sql = sql + " or author1 like '%"+author+"%'";
            }
        }
        if(!Util.isEmpty(pub_time)) {
            if(flag3 == 0) {
                sql = sql + " and time like '%"+pub_time+"%'";
            } else {
                sql = sql + " or time like '%"+pub_time+"%'";
            }
        }
        if(!Util.isEmpty(total_id)) {
            if(flag4 == 0) {
                sql = sql + " and totalvolume like '%"+total_id+"%'";
            } else {
                sql = sql + " or totalvolume like '%"+total_id+"%'";
            }
        }
        if(!Util.isEmpty(free_word)){
            if(flag5 == 0) {
                sql = sql + " and freeword like '%"+free_word+"%'";
            } else {
                sql = sql + " or freeword like '%"+free_word+"%'";
            }
        }
        if(!Util.isEmpty(class_no)) {
            if(flag6 == 0) {
                sql = sql + " and classifyno1 like '%"+class_no+"%'" ;
            } else {
                sql = sql + " or classifyno1 like '%"+class_no+"%'";
            }
        }
        int prepage = (curpage - 1) * rows_per_page;
        int nextpage = curpage * rows_per_page;
        sql  = sql + " LIMIT " + prepage +"," + rows_per_page;
        Vector<Journal> journals = new Vector<Journal>();
        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        rs = du.executeQuery(sql);
        while (rs != null && rs.next()) {
            Journal journal = new Journal(rs.getInt("id"));
            journal.setAuthor1(rs.getString("author1"));
            journal.setAuthor2(rs.getString("author2"));
            journal.setClassifyno1(rs.getString("classifyno1"));
            journal.setClassifyno2(rs.getString("classifyno2"));
            journal.setSubject1(rs.getString("subject1"));
            journal.setSubject2(rs.getString("subject2"));
            journal.setSubject3(rs.getString("subject3"));
            journal.setTitle(rs.getString("title"));
            journal.setSubtitle(rs.getString("subtitle"));
            journal.setComment(rs.getString("comment"));
            journal.setTotalvolume(rs.getString("totalvolume"));
            journal.setVolume(rs.getString("volume"));
            journal.setPageno(rs.getInt("pageno"));
            journal.setFreeword(rs.getString("freeword"));
            journal.setSerialno(rs.getString("serialno"));
            journal.setLabel(rs.getString("label"));
            journal.setTime(rs.getString("time"));
            journals.add(journal);

            //   System.out.println(rs.getString("label"));
        }
        return journals;
    }

    // 得到总行数，用于测试
    public  static  int getTotalRows() throws SQLException {

        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        String SQLCommand = null;

        SQLCommand = "select count(*) totalCount from " + tableName ;
        //  System.out.println(SQLCommand);
        // SQLCommand = "select * from " + tableName + " where id = 50";
        rs = du.executeQuery(SQLCommand);
        rs.last(); //移到最后一行
      //  int rowCount = rs.getRow(); //得到当前行号，也就是记录数
        int rowCount = rs.getInt("totalCount");
       // du.close();
        return  rowCount;
    }

    // 得到所有记录，当前页显示
    public static Vector<Journal> simpleAll(int curpage,int rows_per_page) throws SQLException {

        journals.clear();
             // 释放vector空间
//        System.out.println("go in to !");

        ResultSet rs = null;
        DBUtil du = DBUtil.getDBUtil();
        String SQLCommand = null;
//        if(Util.isEmpty(keyword))
//            throw  new TextFormatException("keyword is null");
        int prepage = (curpage - 1) * rows_per_page;
        int nextpage = curpage * rows_per_page;
//        System.out.println(prepage+nextpage);
        SQLCommand = "select * from " + tableName + " where id > " + prepage + "  and id <= " + nextpage;
       // SQLCommand = "select * from " + tableName;
          System.out.println(SQLCommand);
        // SQLCommand = "select * from " + tableName + " where id = 50";
        rs = du.executeQuery(SQLCommand);
       // du.close();
     //  System.out.println(rs.next());           执行一次rs.next() 会把上一行删掉
        while (rs != null && rs.next()) {
            Journal journal = new Journal(rs.getInt("id"));
            journal.setAuthor1(rs.getString("author1"));
            journal.setAuthor2(rs.getString("author2"));
            journal.setClassifyno1(rs.getString("classifyno1"));
            journal.setClassifyno2(rs.getString("classifyno2"));
            journal.setSubject1(rs.getString("subject1"));
            journal.setSubject2(rs.getString("subject2"));
            journal.setSubject3(rs.getString("subject3"));
            journal.setTitle(rs.getString("title"));
            journal.setSubtitle(rs.getString("subtitle"));
            journal.setComment(rs.getString("comment"));
            journal.setTotalvolume(rs.getString("totalvolume"));
            journal.setVolume(rs.getString("volume"));
            journal.setPageno(rs.getInt("pageno"));
            journal.setFreeword(rs.getString("freeword"));
            journal.setSerialno(rs.getString("serialno"));
            journal.setLabel(rs.getString("label"));
            journal.setTime(rs.getString("time"));
            journals.add(journal);

            System.out.println(rs.getInt("id"));
        }
        return journals;
    }

    // 得到分类后记录数
      public  static  int getSortJournal(String sort) throws SQLException {

          DBUtil du = DBUtil.getDBUtil();
          ResultSet rs = null;
          String SQLCommand = " select count(*) totalCount from " + tableName + " where classifyno1 like '%"+ sort + "%' or classifyno2 like '%" +sort+"%'";
          rs = du.executeQuery(SQLCommand);
          rs.last(); //移到最后一行
          //  int rowCount = rs.getRow(); //得到当前行号，也就是记录数
          int rowCount = rs.getInt("totalCount");
          // du.close();
          return  rowCount;

      }

     //得到分类后当前页记录
      public  static  Vector<Journal> getSortJournal(String sort,int curpage,int rows_per_page) throws SQLException {

          journals.clear();

          DBUtil du = DBUtil.getDBUtil();
          ResultSet rs = null;
          String SQLCommand = " select * from " + tableName + " where classifyno1 like '%"+ sort + "%' or classifyno2 like '%" +sort+"%'";
          int prepage = (curpage - 1) * rows_per_page;
          int nextpage = curpage * rows_per_page;
          SQLCommand  = SQLCommand + " LIMIT " + prepage +"," + rows_per_page;
          rs = du.executeQuery(SQLCommand);
          // du.close();
          //  System.out.println(rs.next());           执行一次rs.next() 会把上一行删掉
          while (rs != null && rs.next()) {
              Journal journal = new Journal(rs.getInt("id"));
              journal.setAuthor1(rs.getString("author1"));
              journal.setAuthor2(rs.getString("author2"));
              journal.setClassifyno1(rs.getString("classifyno1"));
              journal.setClassifyno2(rs.getString("classifyno2"));
              journal.setSubject1(rs.getString("subject1"));
              journal.setSubject2(rs.getString("subject2"));
              journal.setSubject3(rs.getString("subject3"));
              journal.setTitle(rs.getString("title"));
              journal.setSubtitle(rs.getString("subtitle"));
              journal.setComment(rs.getString("comment"));
              journal.setTotalvolume(rs.getString("totalvolume"));
              journal.setVolume(rs.getString("volume"));
              journal.setPageno(rs.getInt("pageno"));
              journal.setFreeword(rs.getString("freeword"));
              journal.setSerialno(rs.getString("serialno"));
              journal.setLabel(rs.getString("label"));
              journal.setTime(rs.getString("time"));
              journals.add(journal);

            //  System.out.println(rs.getInt("id"));
          }
          return journals;
      }

     // 日期处理
    public static Date getDateFromString(String ymd) {
        Date d=new Date();
            try {
                d= new SimpleDateFormat("yyyy年MM月dd").parse(ymd);
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        return d;

    }

    public  static  Vector<String> getTotalVolume(String year) throws SQLException {


        totalVolume.clear();

        ResultSet rs = null;
        DBUtil du  = DBUtil.getDBUtil();
        String SQLCommand = null;
        SQLCommand ="select distinct totalvolume from " + tableName + " where substr(time,1,4) = " + year+" order by totalvolume";
        rs = du.executeQuery(SQLCommand);
        while (rs != null && rs.next()) {
            String totalvolume =  rs.getString("totalvolume");
            if(Util.isContainSpace(totalvolume)) {
                System.out.println(totalvolume);
                String[] str = totalvolume.split(" ");
                totalVolume.add(str[0]+"-"+str[1]);
                System.out.println(str[0]+"-"+str[1]);
            } else {
                totalVolume.add(totalvolume);
            }
        }
       return totalVolume;
    }
        public  static  Journal searchById(String id) throws SQLException {

            DBUtil du = DBUtil.getDBUtil();
            ResultSet rs = null;
            String SQLCommand = " select * from " + tableName + " where id =" + id ;
            rs = du.executeQuery(SQLCommand);
            if(rs != null && rs.next()) {
            Journal journal = new Journal(rs.getInt("id"));
            journal.setAuthor1(rs.getString("author1"));
            journal.setAuthor2(rs.getString("author2"));
            journal.setClassifyno1(rs.getString("classifyno1"));
            journal.setClassifyno2(rs.getString("classifyno2"));
            journal.setSubject1(rs.getString("subject1"));
            journal.setSubject2(rs.getString("subject2"));
            journal.setSubject3(rs.getString("subject3"));
            journal.setTitle(rs.getString("title"));
            journal.setSubtitle(rs.getString("subtitle"));
            journal.setComment(rs.getString("comment"));
            journal.setTotalvolume(rs.getString("totalvolume"));
            journal.setVolume(rs.getString("volume"));
            journal.setPageno(rs.getInt("pageno"));
            journal.setFreeword(rs.getString("freeword"));
            journal.setSerialno(rs.getString("serialno"));
            journal.setLabel(rs.getString("label"));
            journal.setTime(rs.getString("time"));
             return  journal;
            }   else {
                return null;
            }

        }
}
