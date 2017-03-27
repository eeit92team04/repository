<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Uncle Su</title>
<jsp:include page="navigation.jsp" />
</head>
<body>
<div >
<!-- 	<h3>Login</h3> -->
<!-- 	<table> -->
<!-- 	<thead> -->
<!-- 		<tr> -->
<!-- 			<th>桌號</th> -->
<!-- 			<th>名稱</th> -->
<!-- 			<th>數量</th> -->
<!-- 			<th>備註</th>		 -->
<!-- 		</tr> -->
<!-- 		</thead> -->
<!-- 		</table> -->
<!-- 		</div> -->
	
<%-- 	<h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3> --%>

<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Make</th>
		<th>Expire</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="bean" items="${select}">
		<c:url value="/pages/product.jsp" var="path">
			<c:param name="id" value="${bean.id}" />
			<c:param name="name" value="${bean.name}" />
			<c:param name="price" value="${bean.price}" />
			<c:param name="make" value="${bean.make}" />
			<c:param name="expire" value="${bean.expire}" />
		</c:url>
	<tr>
		<td><a href="${path}">${bean.id}</a></td>
		<td>${bean.name}</td>
		<td>${bean.price}</td>
		<td>${bean.make}</td>
		<td>${bean.expire}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
	
	
	
	
</body>
</html>