package com.cn.thu.web;

import com.cn.thu.journal.Journal;
import com.cn.thu.journal.journalManager;
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
 * User: jiayu
 * Date: 13-10-13
 * Time: 下午9:44
 * To change this template use File | Settings | File Templates.
 */
public class showDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       Journal journal  = null;


        String id = req.getParameter("id");

        try {
            journal = journalManager.searchById(id);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        req.setAttribute("journal", journal); //保存到request方便前台调用

        req.getRequestDispatcher("details.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
