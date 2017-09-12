<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登录</title>
</head>

<body>
	<form id="login" action="login" method="post">
	<font color="red">${requestScope.message }</font>
	<table>
	<tr>
		<td>登录帐号</td>
		<td><input id="loginName" type="text" name="loginName"></input>
	</td>
    </tr>
    <tr>
	  <td>登录密码</td>
	  <td><input id="password" type="password" name="password"></input>
	</td>
    </tr>
    <tr>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
    </tr>
    <tr>
	  <td>
			<input id="btnLogin" type="submit" value="登录"  >
	        <input type="reset" value="重置">
	  </td>
    </tr>
	</table>
	</form>
</body>
</html>