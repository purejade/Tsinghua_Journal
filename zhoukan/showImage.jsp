<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-6-7
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title></title>

</head>

<body onmousemove=HideMenu() 
oncontextmenu="return false" 
ondragstart="return false" 
onselectstart ="return false" 
onselect="document.selection.empty()"
oncopy="document.selection.empty()" 
onbeforecopy="return false" 
onmouseup="document.selection.empty()">

      <%
          request.setCharacterEncoding("utf-8");
          String totalvolume = new String(request.getParameter("totalvolume").getBytes("iso-8859-1"), "utf-8");
         // out.println(totalvolume);
          int pageno =Integer.valueOf(new String(request.getParameter("pageno").getBytes("iso-8859-1"),"utf-8"));
         // out.println(pageno);
          String rand = "aaa";
//          totalvolume = String.valueOf(78);
//          pageno = 1;

      %>
      <table >
          <tr>
              <td>
                  <img  width="400" height="600"  src="/Tsinghua_Journal/showImage?totalvolume=<%=totalvolume%>&pageno=<%=pageno%>&rand=<%=rand%>">
              </td>
          </tr>

      </table>


      <%
          PageControl pageCtl = (PageControl)request.getAttribute("pageCtl");
      %>
      <%if(pageCtl.getMaxPage() > 1){%>
      <form name="PageForm"  action="/Tsinghua_Journal/turnPage?totalvolume=<%=totalvolume%>&pageno=<%=pageno%>" method="post">
          <input type="hidden" name="action" value="image">
          <%@ include file="pageman.jsp"%>
      </form>
      <%}%>

</body>
</html>