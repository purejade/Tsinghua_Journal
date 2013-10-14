<%--
  Created by IntelliJ IDEA.
  User: wangjiayu
  Date: 13-5-19
  Time: 下午7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>清华周刊</title>
    <script language="javascript">
//        function isEmpty() {
//            if(document.upform.keyword.value == "") {
//                alert("关键字不能为空");
//            }
//        }
    </script>

  </head>

  <body>

  <h1 align="center"><strong>清 华 周 刊</strong></h1>
  <table width="652" border="1">
      <tr>
          <td width="300"><img src="file:///D|/Program Files/wamp/www/wangjue/4-2.jpg" alt="" width="300" height="439" /></td>
          <td width="336"><p align="left"><strong>清华周刊数据库查询系统</strong></p>
              <p align="left">查询清华周刊数据库，包括简单查询和复杂查询，并且可以查看查询结果的全文</p>
              <p align="left"><strong>简单查询</strong>(请在此处输入关键词进行查找)</p>
              <p>
              <form name="upform" action="/Tsinghua_Journal/showPageResult" method="POST">
                  <input type="hidden" name="action" value="initial">
                  <input type="text" name="keyword" value="">
                  <input type="submit" value="提交" /><br/>
              </form>
              </p>
              <p align="left"><a href="complexSearch.jsp"><strong>复杂查询</strong></a></p>
              <p align="left">　</p>
              <p align="left"><strong><a href="full_book.jsp">清华周刊全文浏览</a></strong></p>
              <p align="left">在此可以按年代顺序浏览全文</p>
              <p align="left"><strong><a href="sortSearch.jsp">清华周刊分类浏览</a></strong></p>
              <p align="left">在此可以按常见的几种分类浏览全文</p>
              <p align="left"><strong><a href="xu.jsp">清华周刊及其价值</a>          </strong></p>
              <p align="left"><strong><a href="shuoming.jsp">编制说明</a></strong></p>
              <p align="left">&nbsp;</p></td>
      </tr>
  </table>
  <p align="center">&nbsp;</p>
  <p align="left">&nbsp;</p>

  </body>
</html>

