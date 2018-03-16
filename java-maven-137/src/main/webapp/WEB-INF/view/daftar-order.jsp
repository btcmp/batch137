<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="jq"></spring:url>
<spring:url value="/resources/js/parsley.min.js" var="parsley"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Employee</title>
<style>
	input.parsley-error
{
  color: #B94A48 !important;
  background-color: #F2DEDE !important;
  border: 1px solid #EED3D7 !important;
}
</style>
<!-- <link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" /> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
<script type="text/javascript" src="${jq }"></script>
<script type="text/javascript" src="${parsley }"></script>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>

<div class="container">
	<div style="padding: 20px 0 20px 0;" id="info-pembelian">
		<table>
			<tr><th>Name</th><td>:</td><td>${customer.name }</td></tr>
			<tr><th>Email</th><td>:</td><td>${customer.email }</td></tr>
			<tr><th>Total Harga</th><td>:</td><td>${totalHarga }</td></tr>
			<tr><th>Total Item</th><td>:</td><td>${totalItem }</td></tr>
		</table>
	</div>
	<div id="daftar-order">
		<table id="dt-brg" class="table table-striped table-bordered" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Nama Barang</th>
				<th>Harga</th>
				<th>Jumlah</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders }" var="order">
				<tr>
					<td>${order.barang.namaBarang }</td>
					<td>${order.barang.harga }</td>
					<td>${order.jumlahBeli }</td>
					<td><a href="#" id="${order.id }" class="btn-beli btn btn-info">cancel</a></td>
				</tr>
			</c:forEach>
		</tbody>	
		</table>
		<a href="#" id="go-bayar" class="btn btn-primary">Bayar</a>
	</div>
</div>
</body>
</html>