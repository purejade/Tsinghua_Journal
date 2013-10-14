package com.cn.thu.web;

import com.cn.thu.journal.journalManager;

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
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */
public class TimeSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  year = req.getParameter("year");
        Vector<String>  totalvolume = null;
        try {
            totalvolume = journalManager.getTotalVolume(year);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        req.setAttribute("year",year);
        req.setAttribute("totalvolume",totalvolume);
        req.getRequestDispatcher("full_book_view.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}
