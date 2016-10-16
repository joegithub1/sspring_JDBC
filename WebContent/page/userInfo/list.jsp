<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/mytag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
<div style="height:120px;width:100%;border:0px solid;">
<a href="${ctx }/login/loginout.do">退出</a>
</div>
<table>
	<tr>
		<td>序号</td>
		<td>账号</td>
		<td>状态</td>
		<td></td>
		<td></td>
		<td>
		<!-- <a href="${ctx }/user/add.do">添加</a> -->
		</td>
		
	</tr>
	<c:forEach items="${users }" var="u">
	<tr>
	<td><c:out value="${u.userId }"></c:out></td>
	<td><c:out value="${u.userName }"></c:out></td>
	<td>
	<c:if test="${u.userState == '1'}">可用</c:if>
	<c:if test="${u.userState == '0'}">禁用</c:if>
	</td>
	
	
	<td><a href="${ctx }/user/update/${u.userId}.do">修改</a></td>
	<td><a href="${ctx }/user/show/${u.userId}.do">查看</a></td>
	<td><a href="${ctx }/user/delete/${u.userId}.do">删除</a></td>
	</tr>
</c:forEach>
</table>
<br/>
<br/>
<table>
	<tr>
		<td>序号</td>
		<td>账号</td>
		<td>状态</td>
		<td><input type="button" value="修改"></td>
		<td><input type="button" value="查看"></td>
		<td><input type="button" value="删除"></td>
		<td><input type="button" value="增加"></td>
		
	</tr>
	<c:forEach items="${users }" var="u">
	<tr>
	<td>
	<input type="checkbox" name="itemId" value="${u.userId}"/>
	</td>
	<td><c:out value="${u.userId }"></c:out></td>
	<td><c:out value="${u.userName }"></c:out></td>
	<td>
	<c:if test="${u.userState == '1'}">可用</c:if>
	<c:if test="${u.userState == '0'}">禁用</c:if>
	</td>
	
	
	
	</tr>
</c:forEach>
</table>

<script type="text/javascript">
	function query(){
		var arrId=$("[name=itemId]");
		var f=0;
		for(var i=0;i<arrId.length;i++){
			if(arrId[i].checked == true){
				f++;
			}
		}
		var index=0;
		if(f == 1){
			for(var i=0;i<arrId.length;i++){
				if(arrId[i].checked == true){
					index=i;
				}
			}
			var id=$(arrId[index]).val();
			
			/**
			$.get("${ctx}/user/show/"+id+".do",function(r){
				console.log("result");
			});*/
		}else if(f > 1){
			alert("只能选择一项");
		}else{
			alert("请选择一项查看");
		}
		
	}
</script>
</body>
</html>