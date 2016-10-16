<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/mytag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<fmt:form modelAttribute="user" method="post">
<!--  
序号:<fmt:input path="userId"/><fmt:errors path="userId"/><br/>
-->
<fmt:hidden path="userId"/>
账号:<fmt:input path="userName"/><fmt:errors path="userName"/><br/>
密码:<fmt:input path="passWord"/><fmt:errors path="passWord"/>
<!--  密码框修改操作不能赋值
<fmt:password path="passWord"/><fmt:errors path="passWord"/>
-->
<br/>
状态:<fmt:select path="userState">
	<fmt:option  value="1">可用</fmt:option>
	<fmt:option value="0">禁用</fmt:option>
</fmt:select><fmt:errors path="userState"/><br/>

<input type="submit" value="submit"/>
</fmt:form>
</body>
</html>