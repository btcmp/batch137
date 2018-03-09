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
<script type="text/javascript" src="${jq }"></script>
<script type="text/javascript">
	$(function(){
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
					alert('save '+ name + " berhasil");
				}, error : function(){
					alert('save failed');
				}
			});
			
		});
	});
</script>
</head>
<body>
	<form action="#" method="POST">
		<input type="text" id="name" name="name" placeholder="name"/><br/>
		<input type="text" id="email" name="email" placeholder="email"/><br/>
		<input type="text" id="address" name="address" placeholder="address" /><br/>
		<input type="submit" id="save" name="save" value="save" />
	</form>
	<table>
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
						<a id="${emp.id }" class="delete" href="#">Delete</a> | 
						<a id="${emp.id }" class="update" href="${pageContext.request.contextPath }/employee/editpage/${emp.id}">Edit</a>
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</body>
</html>