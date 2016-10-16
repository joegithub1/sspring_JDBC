<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/mytag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
</head>
<body>
序号:${user.userId }<br/>
账号:${user.userName }<br/>
密码:${user.passWord }<br/>
状态:<c:if test="${user.userState  ==1}">可用</c:if>
<c:if test="${user.userState ==0}">禁用</c:if>
<br/><br/><br/>
<a href="${ctx }/user/list.do">返回</a>
</body>
</html>