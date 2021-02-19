<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<br><br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">${customer.customerName}'s Invoice</h3>
			<hr>
			<table class="table table-bordered table-stripped text-center">
				<thead>
					<tr>
						<th>Sl.No</th>
						<th>Item Description</th>
						<th>Unit</th>
						<th>Qty</th>
						<th>Price</th>
						<th>Cost</th>
					</tr>
				</thead>
				<tbody>
				<jsp:useBean id="invoicebean" class="com.fazil.bean.InvoiceBean"></jsp:useBean>
				<jsp:setProperty name="invoicebean" property="trxs" value="${invoice.trx }"/>
				<c:forEach var="item" items="${invoicebean.items }">
					<tr>
						<td>1</td>
						<td><c:out value="${item.itemdescription }"/></td>
						<td><c:out value="${item.unit }"/></td>
						<td>1</td>
						<td><c:out value="${item.price }"/></td>
						<td><c:out value="${item.price }"></c:out>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<p class="text-xl-right font-weight-bold">Total cost:     ${invoicebean.totalcost }</p>
			<hr>
			<form action="index.jsp">
				<button class="btn btn-danger">Login Page</button>
			</form>		
		</div>	
	</div>	
</body>
</html>