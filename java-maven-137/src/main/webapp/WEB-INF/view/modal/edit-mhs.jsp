<!-- Modal -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="modal-mhs" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Edit Employee</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       	<form>
       	<input type="hidden" name="input-id" id="input-id" />
		  <div class="form-group">
		    <label for="input-name">Name</label>
		    <input type="email" class="form-control" id="input-name" aria-describedby="emailHelp" placeholder="Enter Your Name">
		    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label for="input-address">Jurusan</label>
		   	<select name="jurusan" id="jurusan">
		   		<c:forEach var="jur" items="${jurusans }">
		   			<option value="${jur.id }">${jur.nameJurusan }</option>
		   		</c:forEach>
		   	</select>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="btn-update" class="btn btn-primary">Update</button>
      </div>
    </div>
  </div>
</div>