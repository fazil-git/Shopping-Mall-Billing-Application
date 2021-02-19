<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>
	<br><br>
	<form action="invoice.do">
		<input type="hidden" name="formid" value="invoice">
		<jsp:useBean id="shopbean" class="com.fazil.bean.ShopBean"></jsp:useBean>
		
		<c:forEach var="shop" items="${shopbean.shops }">
			<h4>${shop.shopName }</h4>
			<c:forEach var="item" items="${shop.items }">
				<input type="checkbox" name="${item.itemId }" value="${item.itemId }">${item.itemdescription }<br>
			</c:forEach>
		</c:forEach>
		<input type="submit" value="Place Order">
	</form>
</body>
</html>