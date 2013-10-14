<%@ page import="java.util.Vector" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-6-18
  Time: 下午6:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String year = (String) request.getAttribute("year");
%>
<p align="center"><b><font color="#008080" size="5"><%=year%></font><font color="#008080" size="5">
</font><font color="#008080" face="隶书" size="5">年</font></b></p>
<div align="left">
    <table border="0" cellpadding="7" width="680">
        <%
            //循环显示数据
            Vector<String> totalVolume = (Vector<String>)request.getAttribute("totalvolume"); // 取request里面的
          %>
        <tr>
            <td width="265" valign="top" align="left"><img border="0" src="6.jpg" align="left" width="272" height="409"></td>

            <td width="378" valign="top" align="left"><font color="#008080">
                <%
                    if(totalVolume.size() != 0) {
                        for(int i=0;i<totalVolume.size();i+=3){
                            pageContext.setAttribute("volume",totalVolume.get(i));
                            //保存到页面pageContext里面方便下面进行EL表达式调用
                %>
                <p>
                    <a href="/turnPage?totalvolume=78&pageno=1">总第<%=totalVolume.get(i)%>期</a>&nbsp;&nbsp;&nbsp;
                        <% if(i+1 < totalVolume.size()) {  %>
                    <a href="/turnPage?totalvolume=78&pageno=1">总第<%=totalVolume.get(i+1)%>期</a>&nbsp;&nbsp;&nbsp;
                        <% } %>
                     <% if(i+2 < totalVolume.size()) {  %>
                     <a href="/turnPage?totalvolume=78&pageno=1">总第<%=totalVolume.get(i+2)%>期</a>&nbsp;&nbsp;&nbsp;&nbsp;</font>
                <% } %>
                </p>
                    <%
            }
        }     else{
        %>                               S
        <p>数据库中没有数据！</p>
        <%
         }
        %>
           </td>
        </tr>

    </table>
</div>

</body>
</html>