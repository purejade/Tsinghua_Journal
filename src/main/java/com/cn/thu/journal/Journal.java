package com.cn.thu.journal;


import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-4
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
/*

篇名
副篇名
连载
第一作者
第二作者
发表时间
总期数
卷期
页码
分类号1
分类号2
主题词1
主题词2
主题词3
自由词
附注
 */
public class Journal {
    private int id;    // journal id
    private String label;
    private String  title;  // main name
    private String  subtitle; // sub name
    private String  serialno;
    private String   author1;  // author
    private String   author2;  // subauthor;
    private String  time;
    private String    totalvolume;
    private String    volume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotalvolume() {
        return totalvolume;
    }

    public void setTotalvolume(String totalvolume) {
        this.totalvolume = totalvolume;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public String getClassifyno1() {
        return classifyno1;
    }

    public void setClassifyno1(String classfyno1) {
        this.classifyno1 = classfyno1;
    }

    public String getClassifyno2() {
        return classifyno2;
    }

    public void setClassifyno2(String classfyno2) {
        this.classifyno2 = classfyno2;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getFreeword() {
        return freeword;
    }

    public void setFreeword(String freeword) {
        this.freeword = freeword;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private int    pageno;
    private String classifyno1;
    private String classifyno2;
    private String  subject1;
    private String  subject2;
    private String  subject3;
    private String  freeword;
    private String  comment;

    public Journal() {
    }

    public Journal(int id) {
        this.id = id;
    }

}
