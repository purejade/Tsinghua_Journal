package com.cn.thu.web;

import com.cn.thu.utility.Constant;
import com.cn.thu.utility.FileUtil;
import com.cn.thu.utility.PageControl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-6-15
 * Time: 下午11:15
 * To change this template use File | Settings | File Templates.
 */
public class TurnPage extends HttpServlet {
    public static String filename = "!00001.JPG";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int jumpPage = 1;
        String totalvolume = req.getParameter("totalvolume");
        String pageno = req.getParameter("pageno");
//        String rand = req.getParameter("rand");
        String action = req.getParameter("action");

        jumpPage = Integer.valueOf(pageno);

       if ("image".equals(action)) {
            // 点击分页请求时执行下一代码
            jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));

        }
        pageno = String.valueOf(jumpPage);

        FileUtil fileUtil = new FileUtil();
     //   String filePath =  "D:\\pages\\"+totalvolume;
     //   String filePath ="\\images\\"+ totalvolume;
      //  String rootPath = getServletContext().getRealPath("/");
       String filePath = getServletContext().getRealPath("/") + "journal_images/"+ totalvolume;
//        String filePath =  "\\images\\"+ totalvolume;
        System.out.println(filePath);
        File file = new File(filePath);

        HashMap<Integer,String> fileNames = fileUtil.getFileNames(file);

        int preface = 0;

        preface = fileUtil.getPrefaceNumber(file);

        if(Integer.valueOf(pageno) == 0) {
            filename = filePath + "/" + fileNames.get(0);
        }else {
            filename = filePath + "/" + fileNames.get(Integer.valueOf(pageno)+preface-1);
        }
        if ("image".equals(action)) {
            // 点击分页请求时执行下一代码
        //    jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));
            filename = filePath + "/" + fileNames.get(Integer.valueOf(pageno)-1);

        }
        int maxRows = (int) fileUtil.getFileSize(file);

        if(Integer.valueOf(pageno) == 0)  {
            //    req.setAttribute("pageno",String.valueOf(Integer.valueOf(pageno)+1));
            jumpPage = Integer.valueOf(pageno)+1;
        }  else {
            //    req.setAttribute("pageno",String.valueOf(Integer.valueOf(pageno)+preface));
            jumpPage =  Integer.valueOf(pageno)+preface;
        }
        if ("image".equals(action)) {
            // 点击分页请求时执行下一代码
            //    jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));
           // req.setAttribute("pageno",pageno);
            jumpPage =  Integer.valueOf(pageno);

        }
        PageControl pageCtl =  new PageControl();
        pageCtl.setCurPage(jumpPage);
        pageCtl.setMaxRowCount(maxRows);       // maxRows
        pageCtl.setRowsPerPage(1);
        pageCtl.countMaxPage();

        //  req.setAttribute("journalvector", journals); //保存到request方便前台调用
        req.setAttribute("pageCtl",pageCtl);
        req.setAttribute("totalvolume",totalvolume);
        if(Integer.valueOf(pageno) == 0)  {
              req.setAttribute("pageno",String.valueOf(Integer.valueOf(pageno)+1));
        }  else {
              req.setAttribute("pageno",String.valueOf(Integer.valueOf(pageno)+preface));
        }
        if ("image".equals(action)) {
            // 点击分页请求时执行下一代码
            //    jumpPage  =  Integer.valueOf(req.getParameter("jumpPage"));
             req.setAttribute("pageno",pageno);
        }
        req.getRequestDispatcher("viewer.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
