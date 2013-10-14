<%@ page import="com.cn.thu.journal.Journal" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.cn.thu.utility.PageControl" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-6-4
  Time: 下午8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" width="100%" style="align:center;">
    <tr bgcolor="ff9900" style="font-weight:bold;">
      <th>类别</th><th>标题</th><th >作者</th><th>初版时间
    </th><th width="100" colspan="2"></th> </tr>
    <%
        //循环显示数据
        Vector<Journal> journals = (Vector<Journal>)request.getAttribute("journalvector"); // 取request里面的
        if(journals.size() != 0) {
            for(int i=0;i<journals.size();i++){
                pageContext.setAttribute("journal",journals.get(i));
                //保存到页面pageContext里面方便下面进行EL表达式调用
    %>
    <tr>
        <td>${journal.label }</td>
        <td>${journal.title}</td>
        <td>${journal.author1}</td>
        <td>${journal.time}</td>
        <%--<td><a href="showImage.jsp?totalvolume=${journal.totalvolume}&pageno=${journal.pageno}">阅读</a></td>--%>
        <%--<td> <a href="/turnPage?totalvolume=${journal.totalvolume}&pageno=${journal.pageno}"> 阅读</a></td>--%>
        <td> <a href="/turnPage?totalvolume=78&pageno=3"> 阅读</a></td>
        <%--<input type="hidden" name="action" value="submit>--%>
    </tr>
    <%
        }
    }else{
    %>                               S
    <tr><td colspan="6">数据库中没有数据！</td></tr>
    <%
        }
    %>
</table>
<br/>
请选择一下页
<%
    PageControl pageCtl = (PageControl)request.getAttribute("pageCtl");
%>
<%if(pageCtl.getMaxPage() > 1){%>
<form name="PageForm"  action="/showPageResult" method="post">
    <input type="hidden" name="action" value="page">
    <%@ include file="pageman.jsp"%>
</form>
<%}%>
</body>
</html>