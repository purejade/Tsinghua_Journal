<%@ page import="com.cn.thu.utility.PageControl" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-6-6
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <script src="js/TurnPage.js"></script>
</head>
<body>
每页<%=pageCtl.getRowsPerPage()%>行
共<%=pageCtl.getMaxRowCount()%>行
第<%=pageCtl.getCurPage()%>页
共<%=pageCtl.getMaxPage()%>页
<BR>
<%if(pageCtl.getCurPage()==1){ out.print(" 首页 上一页");   }else{  %>
<A HREF="javascript:gotoPage(1)">首页</A>
<A HREF="javascript:gotoPage(<%=pageCtl.getCurPage()-1%>)">上一页</A>
<%}%>
<%if(pageCtl.getCurPage()==pageCtl.getMaxPage()){ out.print("下一页 尾页");   }else{  %>
<A HREF="javascript:gotoPage(<%=pageCtl.getCurPage()+1%>)">下一页</A>
<A HREF="javascript:gotoPage(<%=pageCtl.getMaxPage()%>)">尾页</A>
<%}%>
转到第<SELECT name="jumpPage" onchange="Jumping()">
    <% for(int i=1;i<=pageCtl.getMaxPage();i++)  {
        if (i== pageCtl.getCurPage()){
    %>
    <OPTION selected value=<%=i%>><%=i%></OPTION>
    <%}else{%>
    <OPTION value=<%=i%>><%=i%></OPTION>
    <%}}%>
</SELECT>页
</body>
</html>

