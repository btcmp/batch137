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
		$('#dt-brg').DataTable({
			searching: false
		});
		
		$('#btn-search').on('click', function(){
			var word = $('#search').val();
			window.location="${pageContext.request.contextPath}/menu/src?search="+word;
		});
		
		$('.btn-beli').on('click', function(){
			var idCustomer = $('#id-customer').val();
			var idBarang = $(this).attr('id');
			var element = $(this).parent().parent();
			var select = element.find('td').eq(2).find('select').val();
			
			var penjualan = {
				customer : {
					id : idCustomer
				},
				barang : {
					id : idBarang
				},
				jumlahBeli : select
			};
			
			//ajax
			$.ajax({
				url : '${pageContext.request.contextPath}/menu/order',
				type: 'POST',
				data : JSON.stringify(penjualan),
				contentType: "application/json",
				success: function(data){
					alert('berhasil dipesan');
				}, error : function(){
					alert('order barang gagal');
				}
			});
		});
	});
</script>
</head>
<body>

<div class="container">
	<p>
		<div>
		pilih customer : 
		<select id="id-customer">
			<c:forEach items="${daftarCustomer}" var="customer">
				<option value="${customer.id }">${customer.email }</option>
			</c:forEach>
		</select>
		</div>
	</p>
	<div id="search-box">
		<span>Search</span>
		<span><input type="text" id="search" /></span>
		<span><a id="btn-search" href="#" class="btn btn-primary">Search</a></span>
	</div>
	
	<div id="daftar-barang">
		<table id="dt-brg" class="table table-striped table-bordered" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Nama Barang</th>
				<th>Harga</th>
				<th>Jumlah</th>
				<th>Beli</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${daftarBarang }" var="barang">
				<tr>
					<td>${barang.namaBarang }</td>
					<td>${barang.harga }</td>
					<td>
						<% int jml = 1; %>
						<select class="jml-items">
						<c:forEach begin="0" end="${barang.stock - 1}">
							<option value="<%=jml%>" ><%=jml++%></option>
					   </c:forEach>
						</select>
					</td>
					<td><a href="#" id="${barang.id }" class="btn-beli btn btn-info">beli</a></td>
				</tr>
			</c:forEach>
		</tbody>	
		</table>
	</div>
</div>
</body>
</html>