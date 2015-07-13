<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015-07-13
  Time: 오후 6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="../customer/joinProcess" method="POST">
<table border="1">
  <tr>
    <td>아이디</td>
    <td><input type="text" name="id"></td>
  </tr>
  <tr>
    <td>비밀번호</td>
    <td><input type="text" name="password"></td>
  </tr>
</table>
  <input type="submit" value="가입">
</form>
</body>
</html>
