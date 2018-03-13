<!-- Modal -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="save-mhs" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit Employee</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<form id="target" action="${pageContext.request.contextPath }/mahasiswa/save" method="POST">
		  <div class="form-group">
		    <label for="input-name">Name</label>
		    <input data-parsley-required="true" type="text" class="form-control" id="entry-name" name="name" aria-describedby="emailHelp" placeholder="Enter Your Name" />
		    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label for="input-address">Jurusan</label>
		   	<select name="jurusan.id" id="entry-jurusan">
		   		<c:forEach var="jur" items="${jurusans }">
		   			<option value="${jur.id }">${jur.nameJurusan }</option>
		   		</c:forEach>
		   	</select>
		  </div>
		  <input type="submit" />
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="btn-entry" class="btn btn-primary">Save</button>
      </div>
      
    </div>
  </div>
</div>