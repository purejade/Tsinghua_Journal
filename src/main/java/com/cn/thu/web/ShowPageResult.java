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
 * Date: 13-6-6
 * Time: 下午4:11
 * To change this template use File | Settings | File Templates.
 */
public class ShowPageResult extends HttpServlet {
    public    int rows_per_page = Constant.rows_per_page;
    public  static  int click = 1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int jumpPage = 1;
        int maxRows =   0;
        Vector<Journal> journals  = null;
        String keyword = "";

        String action = req.getParameter("action");
        if ("initial".equals(action)) {
            // 第一次进入index.jsp页面时，查询出第一页
            // 设置分页的各个属性，参见PageUtil这个类
             jumpPage = 1;
                //journals = journalManager.simpleAll(jumpPage, rows_per_page);
                keyword = req.getParameter("keyword");

//            try {
//
//              //  maxRows = journalManager.getTotalRows();
//            } catch (SQLException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//            }

        } else if ("page".equals(action)) {
            // 点击分页请求时执行下一代码
            jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));

        }



        try {
            journals = journalManager.simpleSearch(keyword,jumpPage,rows_per_page,true);
            maxRows = journalManager.simpleSearch(keyword);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        PageControl  pageCtl =  new PageControl();
        pageCtl.setCurPage(jumpPage);
        pageCtl.setMaxRowCount(maxRows);
        pageCtl.setRowsPerPage(rows_per_page);
        pageCtl.countMaxPage();


//       System.out.println(journals.size());
//        System.out.println("))))))))))))))"+maxRows);
      //  pageCtl.setDatas(journals);

        req.setAttribute("journalvector", journals); //保存到request方便前台调用
        req.setAttribute("pageCtl",pageCtl);
        req.getRequestDispatcher("result.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req,resp);
    }
}
