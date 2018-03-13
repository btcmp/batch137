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
	});