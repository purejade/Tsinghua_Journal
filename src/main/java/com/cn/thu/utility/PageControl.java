package com.cn.thu.utility;

import com.cn.thu.journal.Journal;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-6
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */


public class PageControl {

    private int curPage ; //当前是第几页
    private int maxPage ; //一共有多少页

    public  int getCurPage() {
        return curPage;
    }

    public  void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public  int getMaxPage() {
        return maxPage;
    }

    public  void setMaxPage(int maxPage) {
       this.maxPage = maxPage;
    }

    public  int getMaxRowCount() {
        return maxRowCount;
    }

    public  void setMaxRowCount(int maxRowCount) {
        this.maxRowCount = maxRowCount;
    }

    public  int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
       this.rowsPerPage = rowsPerPage;
    }

    public int maxRowCount ; //一共有多少行
    public   int rowsPerPage ; //每页有多少行



//    public Vector<Journal> datas ;//装载每页的数据

    public void countMaxPage() {   //根据总行数计算总页数
        if (this.maxRowCount % this.rowsPerPage==0){
            this.maxPage = this.maxRowCount/this.rowsPerPage;
        }else{
            this.maxPage = this.maxRowCount/this.rowsPerPage + 1;
        }
    }
//    public  void setDatas(Vector<Journal> journals) {
//        if(journals == null || journals.size() == 0) {
//            datas = null;
//        }
//        datas = new Vector<Journal>();
//        for(int i = 0;i< journals.size();i++) {
//              datas.add(journals.get(i));
//        }
//    }
    public PageControl() {
    }

}
