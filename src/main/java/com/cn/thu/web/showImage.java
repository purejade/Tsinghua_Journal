package com.cn.thu.web;

import com.cn.thu.utility.FileUtil;
import com.cn.thu.utility.PageControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: wangjiayu
 * Date: 13-5-19
 * Time: 下午8:22
 * To change this template use File | Settings | File Templates.
 */
public class showImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //To change body of overridden methods use File | Settings | File Templates.
        try{
           //  FileInputStream hFile = new FileInputStream(filePath+"\\"+pageno+".JPG"); // 以byte流的方式打开文件 d:\1.gif

            String totalvolume = req.getParameter("totalvolume");
            String pageno = req.getParameter("pageno");
            String rand = req.getParameter("rand");


            FileInputStream hFile = new FileInputStream(TurnPage.filename);


            System.out.println(TurnPage.filename);

            int fileSize = hFile.available(); //得到文件大小
            byte data[]=new byte[fileSize];
            hFile.read(data); //读数据
            hFile.close();
            resp.setContentType("image/*"); //设置返回的文件类型
            OutputStream toClient=resp.getOutputStream(); //得到向客户端输出二进制数据的对象
            toClient.write(data); //输出数据
            toClient.close();

        } catch(IOException e) //错误处理
        {
            PrintWriter toClient = resp.getWriter(); //得到向客户端输出文本的对象
            resp.setContentType("text/html;charset=utf-8");
            toClient.write("无法打开图片!");
            toClient.close();
        }



//



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
