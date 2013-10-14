package com.cn.thu.web;

import com.cn.thu.journal.Journal;
import com.cn.thu.journal.journalManager;
import com.cn.thu.utility.Constant;
import com.cn.thu.utility.PageControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-17
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class ShowComplexResult extends HttpServlet {
    public    int rows_per_page = Constant.rows_per_page;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int jumpPage = 1;
        String action = req.getParameter("action");
        Vector<Journal> journals = null;
        int maxRows = 0;
        String theme = null;
        String ioper1 = null;
        String title = null;
        String ioper2 = null;
        String author = null;
        String ioper3 = null;
        String pub_time = null;
        String ioper4 = null;
        String total_id = null;
        String ioper5 = null;
        String free_word = null;
        String ioper6 = null;
        String class_no = null;
        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;
        int flag4 = 0;
        int flag5 = 0;
        int flag6 = 0;

        if ("complex".equals(action)) {
            jumpPage = 1;
            theme = req.getParameter("theme");
            ioper1 = req.getParameter("ioper1");
            title =  req.getParameter("title");
            ioper2 = req.getParameter("ioper2");
            author = req.getParameter("author");
            ioper3 = req.getParameter("ioper3");
            pub_time = req.getParameter("pub_time");
            ioper4 = req.getParameter("ioper4");
            total_id  = req.getParameter("total_id");
            ioper5  = req.getParameter("ioper5");
             free_word = req.getParameter("free_word");
             ioper6 = req.getParameter("ioper6");
             class_no = req.getParameter("class_no");

            if(ioper1.equals("或")) {
                flag1 = 1;
            }
            if(ioper2.equals("或")){
                flag2 = 1;
            }
            if(ioper3.equals("或")){
                flag3 = 1;
            }
            if(ioper4.equals("或")){
                flag4 = 1;
            }
            if(ioper5.equals("或")){
                flag5 = 1;
            }
            if(ioper6.equals("或")){
                flag6 = 1;
            }


        } else if ("page".equals(action)) {
            // 点击分页请求时执行下一代码
            jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));

        }

        try {
            journals = journalManager.complexSearch(theme, flag1, title, flag2, author, flag3, pub_time, flag4, total_id, flag5, free_word, flag6, class_no,jumpPage,rows_per_page);
            maxRows = journalManager.complexSearch(theme, flag1, title, flag2, author, flag3, pub_time, flag4, total_id, flag5, free_word, flag6, class_no);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        PageControl pageCtl =  new PageControl();
        pageCtl.setCurPage(jumpPage);
        pageCtl.setMaxRowCount(maxRows);
        pageCtl.setRowsPerPage(rows_per_page);
        pageCtl.countMaxPage();


//       System.out.println(journals.size());
//        System.out.println("))))))))))))))"+maxRows);
        //  pageCtl.setDatas(journals);

        req.setAttribute("journalvector", journals); //保存到request方便前台调用
        req.setAttribute("pageCtl",pageCtl);
        req.getRequestDispatcher("showResult.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}
