<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<spring:url value="/resources/js/jquery-3.3.1.min.js" var="jq"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Employee</title>
<!-- <link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" /> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css" />
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
<script type="text/javascript" src="${jq }"></script>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		//setup  datatable employee table
		$('#emp-tbl').DataTable({
			paging: 'true'
		});
		
		//event listener delete data employee
		$('.delete').on('click', function(){
			var id = $(this).attr('id');
			var conf = confirm("are your sure delete this ?");
			if(conf == true){
				//will delete
				window.location="${pageContext.request.contextPath}/employee/delete/"+id;
			} 
				return false;
		});
		
		//on click untuk submit via ajax 
		$('#save').on('click',function(evt){
			evt.preventDefault();
			var name = $('#name').val();
			var email = $('#email').val();
			var address = $('#address').val();
			var employee = {
				'name' : name,
				'email' : email,
				'address' : address
			};
			console.log(employee);
			//ajax
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/ajax-emp/save',
				data: JSON.stringify(employee),
				contentType: 'application/json',
				success : function(){
					window.location = '${pageContext.request.contextPath}/ajax-emp'
				}, error : function(){
					alert('save failed');
				}
			});
			
		});
		
		//script update modal
		$('.update').on('click', function(evt){
			evt.preventDefault();
			var id = $(this).attr('id');
			
			//ajax prepared
			$.ajax({
				url : '${pageContext.request.contextPath}/ajax-emp/get-one/'+ id,
				type : 'GET',
				success: function(employee){
					$('#input-name').val(employee.name);
					$('#input-address').val(employee.address);
					$('#input-email').val(employee.email);
					$('#input-id').val(employee.id);
					//call modal
					$('#modal-emp').modal();
				}, 
				error : function(){
					alert('failed getting data..');
				},
				dataType: 'json'
			});
			
			
		});
		//script untuk exekusi update
		$('#btn-update').on('click', function(){
			var employee = {
				name : $('#input-name').val(),
				address : $('#input-address').val(),
				email : $('#input-email').val(),
				id : $('#input-id').val()
			}
			//new emp after update
			console.log(employee);
			
			$.ajax({
				url : '${pageContext.request.contextPath}/ajax-emp/update',
				type: 'PUT',
				data: JSON.stringify(employee),
				contentType: 'application/json',
				success: function(data){
					window.location='${pageContext.request.contextPath}/ajax-emp'
				},
				error : function(){
					alert('update failed');
				}
			});
		});
	});
</script>
</head>
<body>
<div class="container">
	<form action="#" method="POST">
		<input type="text" id="name" name="name" placeholder="name"/><br/>
		<input type="text" id="email" name="email" placeholder="email"/><br/>
		<input type="text" id="address" name="address" placeholder="address" /><br/>
		<input type="submit" id="save" name="save" value="save" />
	</form>
	<table id="emp-tbl"  class="table table-striped table-bordered" cellspacing="0" width="100%">
		<thead>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${employees }" var="emp">
				<tr>
					<td>${emp.name }</td>
					<td>${emp.email }</td>
					<td>${emp.address }</td>
					<td>
						<a id="${emp.id }" class="delete btn btn-danger" href="#">Delete</a> | 
						<a id="${emp.id }" class="update btn btn-warning" href="#">Edit</a>
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</div>
	
	<%@ include file="modal/edit-emp.html" %>
</body>
</html>