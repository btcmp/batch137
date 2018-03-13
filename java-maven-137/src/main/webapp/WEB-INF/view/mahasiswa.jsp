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
		
		 $.fn.serializeObject = function() {
		        var o = {};
		        var a = this.serializeArray();
		        $.each(a, function() {
		            if (o[this.name]) {
		                if (!o[this.name].push) {
		                    o[this.name] = [o[this.name]];
		                }
		                o[this.name].push(this.value || '');
		            } else {
		                o[this.name] = this.value || '';
		            }
		        });
		        return o;
		    };
		
		//setup  datatable employee table
		$('#emp-tbl').DataTable({
			paging: 'true'
		});
		
		//event listener delete data employee
		$('.update').click(function(evt){
			evt.preventDefault();
			var id = $(this).attr('id');
			$.ajax({
				url : '${pageContext.request.contextPath}/mahasiswa/get-one/'+id,
				type : 'GET',
				success : function(mhs){
					setEditMahasiswa(mhs);
					$('#modal-mhs').modal();
				},
				error : function(){
					alert('failed getting data update');
				},
				dataType: 'json'
			});
		});
		
		//sette up data update
		function setEditMahasiswa(mhs){
			console.log(mhs);
			$('#input-id').val(mhs.id);
			$('#input-name').val(mhs.name);
			$('#jurusan').val(mhs.jurusan.id);
		}
		
		//execute btn update
		$('#btn-update').click(function(){
			var mhs = {
				id : $('#input-id').val(),
				name : $('#input-name').val(),
				jurusan : {
					id : $('#jurusan').val()
				}
			}	
			console.log(mhs);
			
			$.ajax({
				url : '${pageContext.request.contextPath}/mahasiswa/update',
				type : 'PUT',
				data : JSON.stringify(mhs),
				contentType: 'application/json',
				success : function(data){
					window.location = '${pageContext.request.contextPath}/mahasiswa';
				},
				error: function(){
					alert('update failed!!');
				}
			});
		});
		
		$('#add-mhs').click(function(){
			$('#save-mhs').modal();
		});
		
		$('#btn-entry').on('click', function(evt){
			evt.preventDefault();
			var form = $('#target');
			var valid = form.parsley().validate();
			
			var mhs = {
				name : $("#entry-name").val(),
				jurusan : {
					id : $("#entry-jurusan").val()
				}
			}
			if(valid == true){
				form.submit();
				/* $.ajax({
					url : '${pageContext.request.contextPath}/mahasiswa/save2',
					type: 'POST',
					contentType: 'application/json',
					data : JSON.stringify(mhs),
					success: function(data){
						window.location = '${pageContext.request.contextPath}/mahasiswa'
					},error : function(){
						alert('saving failed..');
					}
				}); */ 
			}
		});
	});
</script>
</head>
<body>
<div class="container">
	<div id="save-form" style="margin-top: 20px; margin-bottom: 20px;">
		<form:form action="${pageContext.request.contextPath }/mahasiswa/save" commandName="mahasiswa" method="POST">
			<form:errors style="color: red;" path="*" cssClass="errorblock" element="div"/>
			<div class="form-group">
				<label for="save-name">Name</label>
				<form:input type="text" class="form-control" id="save-name" placeholder="Enter Name" path="name" />	
			</div>
			<div class="form-group">
				<label for="save-jurusan">jurusan</label>
				<form:select path="jurusan.id" id="save-jurusan" class="form-control">
				<c:forEach var="jur" items="${jurusans}">
					<form:option value="${jur.id }">${jur.nameJurusan }</form:option>
				</c:forEach>
			</form:select>	
			</div>
			<form:button>Save</form:button>
		</form:form>
	</div>
	<p>
		<a href="#" id="add-mhs" class="btn btn-primary">Add Mahasiswa</a>
	</p>
	<table id="emp-tbl"  class="table table-striped table-bordered" cellspacing="0" width="100%">
		<thead>
			<th>Name</th>
			<th>Jurusan</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${mhss }" var="mhs">
				<tr>
					<td>${mhs.name }</td>
					<td>${mhs.jurusan.nameJurusan }</td>
					<td>
						<a id="${mhs.id }" class="delete btn btn-danger" href="#">Delete</a> | 
						<a id="${mhs.id }" class="update btn btn-warning" href="#">Edit</a>
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</div>
	<%@ include file="modal/edit-mhs.jsp" %>
	<%@ include file="modal/save-mhs.jsp" %>
	
</body>
</html>