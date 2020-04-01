<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SQL-Injection Test</title>
  </head>
  <body>
    <form name="regForm" action="TestServlet" method="post" >
      <table border="0" width="800" cellspacing="0" cellpadding="0">
        username:<br>
        <input type="text" name="username" value="">
        <br>
        password:<br>
        <input type="password" name="password" value="">
        <br><br>
        <input type="submit" value="Submit">
      </table>
    </form>
  </body>
</html>