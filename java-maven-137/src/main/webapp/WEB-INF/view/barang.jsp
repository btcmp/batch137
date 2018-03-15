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
		$('#submit').on('click', function(){
			var barang = {
				namaBarang : $('#nama-barang').val(),
				kodeBarang : $('#kode-barang').val(),
				harga : $('#harga').val(),
				stock : $('#stock').val()
			};
			
			$.ajax({
				url: '${pageContext.request.contextPath}/barang/save',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(barang),
				success: function(data){
					window.location="${pageContext.request.contextPath}/barang";
				}, error : function(){
					alert('save failed');
				}
			});
		});
	});
</script>
</head>
<body>
<div class="container">
	<div id="save-form" style="margin-top: 20px; margin-bottom: 20px;">
		<form action="#">
			<input type="text" id="nama-barang" placeholder="Nama Barang"/><br/>
			<input type="text" id="kode-barang" placeholder="kode barang"/><br/>
			<input type="text" id="harga" placeholder="harga barang"/><br/>
			<input type="text" id="stock" placeholder="Stock Barang"/><br/>
			<input type="submit" id="submit" />
		</form>	
	</div>
</div>
</body>
</html>