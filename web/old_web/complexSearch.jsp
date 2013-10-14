<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-6-16
  Time: 下午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<BODY background="WB00531_.gif">


<FORM ACTION="/showComplexResult" METHOD="post" id=form1 name=form1>
    <input type="hidden" name="action" value="complex">
    <p align="center"><b><font color="#006666" size="5">复杂检索</font></b></p>

    <TABLE  border=0 cellpadding=3 align="center" width="607">
        <TR>
            <TD align=CENTER width="186"> <font size="3" color="#006666">栏目名称</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的栏目名称<br><INPUT NAME="theme" SIZE="40" MAXLENGTH="100" ></font></TD>
            <TD width="64"> 　
                <p> <SELECT NAME="ioper1" SIZE="1" ><OPTION selected>与<OPTION >或</OPTION></SELECT></p>
            </TD>
        </TR>


        <TR>
            <TD align=CENTER width="186" bordercolor="#800000"> <font size="3" color="#006666">题名</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的题目 <br><INPUT NAME="title" SIZE="40" MAXLENGTH="100" ></font></TD>
            <TD width="64">　
                <p><SELECT NAME="ioper2" SIZE="1"><OPTION selected>与<OPTION>或</OPTION></SELECT></p>
            </TD>
        </TR>

        <TR>
            <TD align=CENTER width="186"> <font color="#006666" size="3">作者</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的作者 <br><INPUT NAME="author" SIZE="40" MAXLENGTH="100" ></font></TD>
            <TD width="64">　
                <p><SELECT NAME="ioper3" SIZE="1"><OPTION SELECTED>与<OPTION>或</OPTION></SELECT></p>
            </TD>

        </TR>

        <TR>
            <TD align=CENTER width="186"> <font color="#006666" size="3">发表时间</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的发表时间<br><INPUT NAME="pub_time" SIZE="40" MAXLENGTH="100"></font></TD>
            <TD width="64">　
                <p><SELECT NAME="ioper4" SIZE="1"><OPTION SELECTED>与<OPTION>或</OPTION></SELECT></p>
            </TD>
        </TR>

        <TR>
            <TD align=CENTER width="186"> <font color="#006666" size="3">总期数</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的总期数<br><INPUT NAME="total_id" SIZE="40" MAXLENGTH="100"></font></TD>
            <TD width="64">　
                <p><SELECT NAME="ioper5" SIZE="1"><OPTION>或<OPTION SELECTED>与</OPTION></SELECT></p>
            </TD>
        </TR>

        <TR>
            <TD align=CENTER width="186"> <font color="#006666" size="3">自由词</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的自由词<br><INPUT NAME="free_word" SIZE="40" MAXLENGTH="100"></font></TD>
            <TD width="64">　
                <p><SELECT NAME="ioper6" SIZE="1"><OPTION>或<OPTION SELECTED>与</OPTION></SELECT></p>
            </TD>
        </TR>

        <TR>
            <TD align=CENTER width="186"> <font color="#006666" size="3">分类号</font></TD>
            <TD width="284"><font color="#006666">请输入您想查询的文章的分类号<br><INPUT NAME="class_no" SIZE="40" MAXLENGTH="100"></font></TD>
        </TR>


    </TABLE>
    <P align="center"><INPUT type=submit value=开始查询 name=iact style="LEFT: 7px; TOP: 885px">&nbsp;</P>
</FORM>

</body>
</html>