<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/mytag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<fmt:form modelAttribute="user" method="post" action="${ctx }/login/login.do">
	用户名 : <fmt:input path="userName" /><fmt:errors path="userName"></fmt:errors><br/>
	密    码 : <fmt:password path="passWord"/><fmt:errors path="passWord"></fmt:errors><br/>
	<input type="submit" value="登录">                                            
	<input type="button" onclick="toReg()" value="注册">
</fmt:form>
<script type="text/javascript">
function toReg(){
	window.location="${ctx}/login/add.do";
}
</script>
</body>
</html>