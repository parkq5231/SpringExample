<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>상품목록</h3>
		<c:forEach items="${list}" var="product">
			상품명: <a href="#">${product.product_name}</a>
			상품가격:${product.product_price}<br>
			상품정보:${product.product_info}<br>
			상품날짜:${product.product_date}<br>
			회사:${product.company}<br>
			관리자:${product.manager_id}<hr>
	</c:forEach>
	</div>
</body>
</html>