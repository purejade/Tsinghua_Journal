package com.cn.thu.logic;

import com.cn.thu.journal.Journal;
import com.cn.thu.journal.journalManager;
import com.cn.thu.messenger.JSONHelper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

/**
* Created with IntelliJ IDEA.
* User: wangjiayu
* Date: 13-6-4
* Time: 下午2:54
* To change this template use File | Settings | File Templates.
*/
public class Mediator {
    public Mediator() {
    }
    public static Vector<String> simpleSearch(String keyword,int cur_page,int rows_per_page,boolean flag) throws SQLException {
        Vector<Journal> journals = journalManager.simpleSearch(keyword,cur_page,rows_per_page,flag);
        Vector<String>  journalArray = new Vector<String>();
        for(int i= 0;i<journals.size();i++) {
              journalArray.add(JSONHelper.getJSONHelperInstance().convertToString(convertJournalToMap(journals.get(i))));
          //  System.out.println(JSONHelper.getJSONHelperInstance().convertToString(convertJournalToMap(journals.get(i))));
        }
        return journalArray;
    }

   private  static  HashMap<String,String> convertJournalToMap(Journal journal) {
       HashMap<String,String> journal_map = new HashMap<String, String>();
       journal_map.put("id",String.valueOf(journal.getId()));
       journal_map.put("label",journal.getAuthor1());
       journal_map.put("title",journal.getTitle());
       journal_map.put("subtitle",journal.getSubtitle());
       journal_map.put("serialno",journal.getSerialno());
       journal_map.put("author1",journal.getAuthor1());
       journal_map.put("author2",journal.getAuthor2());
       journal_map.put("time",journal.getTime());
       journal_map.put("totalvolume",journal.getTotalvolume());
       journal_map.put("volume",journal.getVolume());
       journal_map.put("pageno",String.valueOf(journal.getPageno()));
       journal_map.put("classifyno1",journal.getClassifyno1());
       journal_map.put("classifyno2",journal.getClassifyno2());
       journal_map.put("subject1",journal.getSubject1());
       journal_map.put("subject2",journal.getSubject2());
       journal_map.put("subject3",journal.getSubject3());
       journal_map.put("freeword",journal.getFreeword());
       journal_map.put("comment",journal.getComment());

       return journal_map;
     //  journal_map.put()
   }
}
