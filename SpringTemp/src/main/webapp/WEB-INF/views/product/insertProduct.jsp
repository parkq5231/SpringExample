<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 id="top">상품 등록</h3>
	<form:form modelAttribute="productVO" action="insertProduct" method="post" name="frm">
		PRODUCT_ID : <form:input path="product_id" /><br>
		PRODUCT_NAME : <form:input path="product_name" /><br>
		PRODUCT_PRICE : <form:input path="product_price" /><br>
		PRODUCT_INFO : <form:input path="product_info" /><br>
		PRODUCT_DATE : <form:input path="product_date" /><br>
		COMPANY : <form:input path="company" /><br>
		MANAGER_ID : <form:input path="manager_id" /><br>
		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form:form>
</body>
</html>