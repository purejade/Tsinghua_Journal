package com.cn.thu.web;

import com.cn.thu.journal.Journal;
import com.cn.thu.journal.journalManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

/**
* Created with IntelliJ IDEA.
* User: wangjiayu
* Date: 13-6-4
* Time: 下午8:36
* To change this template use File | Settings | File Templates.
*/
public class ShowResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            Vector<Journal>  journals = journalManager.simpleSearch("校外活动",1,10,true);
            req.setAttribute("journalvector", journals); //保存到request方便前台调用
            req.getRequestDispatcher("showResult.jsp").forward(req,resp);
          //  req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
    }
}
