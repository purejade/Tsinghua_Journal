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
 * Date: 13-6-18
 * Time: 下午4:55
 * To change this template use File | Settings | File Templates.
 */
public class SortSearch  extends HttpServlet {
    public    int rows_per_page = Constant.rows_per_page;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String  sort = "";
        int jumpPage = 1;
        int maxRows =   0;
        Vector<Journal> journals  = null;
        String action = req.getParameter("action");
        if ("initial".equals(action)) {
            jumpPage = 1;
            sort = req.getParameter("sort");
        } else if ("page".equals(action)) {
            jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));
        }   else{
            jumpPage = 1;
            sort = req.getParameter("sort");
            System.out.println(sort);
        }

        try {
            journals = journalManager.getSortJournal(sort, jumpPage, rows_per_page);
            maxRows = journalManager.getSortJournal(sort);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        PageControl pageCtl =  new PageControl();
        pageCtl.setCurPage(jumpPage);
        pageCtl.setMaxRowCount(maxRows);
        pageCtl.setRowsPerPage(rows_per_page);
        pageCtl.countMaxPage();

        req.setAttribute("journalvector", journals); //保存到request方便前台调用
        req.setAttribute("pageCtl",pageCtl);
        req.getRequestDispatcher("result.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
