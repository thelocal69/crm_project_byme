<%@include file="/common/lib/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin-member" />
<c:url var="UserURL" value="/admin-member" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm thành viên</title>
</head>
<body>
	<!-- Preloader -->
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row bg-title">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Thêm mới thành viên</h4>
					</div>
				</div>
				<!-- /.row -->
				<!-- .row -->
				<div class="row">
					<div class="col-md-2 col-12"></div>
					<div class="col-md-8 col-xs-12">
						<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										<strong>${messageResponse}</strong>
									</div>
						</c:if>
						<div class="white-box">
							<form class="form-horizontal form-material row" id="formSubmit">
								<div class="form-group">
									<label class="col-md-12">Avatar</label>
									<div class="col-md-12">
										<input type="text"
											class="form-control form-control-line" id="avatar" name="avatar" value="${model.avatar}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">First Name</label>
									<div class="col-md-12">
										<input type="text"
											class="form-control form-control-line" id="firstName" name="firstName" value="${model.firstName}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-12">Last Name</label>
									<div class="col-md-12">
										<input type="text"
											class="form-control form-control-line" id="lastName" name="lastName" value="${model.lastName}">
									</div>
								</div>
								<div class="form-group">
											<label class="col-md-12">Full Name</label>
											<div class="col-md-12">
												<input type="text"
													class="form-control form-control-line" id="fullName" name="fullName" value="${model.fullName}">
											</div>
										</div>
										<div class="form-group">
											<label for="example-email" class="col-md-12">Email</label>
											<div class="col-md-12">
												<input type="email"
													class="form-control form-control-line" id="email" name="email" value="${model.email}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-md-12">Password</label>
											<div class="col-md-12">
												<input type="password"
													class="form-control form-control-line" id="pass" name="pass" value="${model.pass}">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-12">User Name</label>
											<div class="col-md-12">
												<input type="text"
													class="form-control form-control-line" id="userName" name="userName" value="${model.userName}">
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-12">Phone No</label>
											<div class="col-md-12">
												<input type="text"
													class="form-control form-control-line" id="phone" name="phone" value="${model.phone}">
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-12">Select Role</label>
											<div class="col-sm-12">
												<select class="form-control form-control-line" id=roleId name="roleId">
												<c:if test="${empty model.roleId}">
													<option>Chọn quyền</option>
													<c:forEach items="${roles}" var="item">
														<option value="${item.id}">${item.name}</option>
													</c:forEach>
												</c:if>
												
												<c:if test="${not empty model.roleId}">
													<option>Chọn quyền</option>
													<c:forEach items="${roles}" var="item">
														<option value="${item.id}" <c:if test="${item.id == model.roleId}">selected="selected"</c:if>>
															${item.name}
														</option>
													</c:forEach>
												</c:if>
												</select>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-sm-12">
											<c:if test="${empty model.id}">
												<input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới thành viên" id="btnAddOrUpdateUser" />
											</c:if>
											<c:if test="${not empty model.id}">
												<input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật thành viên" id="btnAddOrUpdateUser" />
											</c:if>
												<a href='<c:url value="admin-member?type=list" />'
													class="btn btn-primary">Quay lại</a>
											</div>
										</div>
										<input type="hidden" value="${model.id}" id="id" name="id" />
							</form>
						</div>
					</div>
					<div class="col-md-2 col-12"></div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	
	<script type="text/javascript">
	
	$('#btnAddOrUpdateUser').click(function (e) {
		e.preventDefault;
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function(i, v){
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if(id == ""){
        	addUser(data);
        }else {
        	updateUser(data);
        }
	});
	
	function addUser(data){
		$.ajax({
            url: "${APIurl}",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${UserURL}?type=list&&message=insert_success";
            },
            error: function(error){
            	window.location.href = "${UserURL}?type=list&message=error_system";
            },
        });
    }
	
	function updateUser(data){
        $.ajax({
            url: "${APIurl}",
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${UserURL}?type=list&id="+result.id+"&message=update_success";
            },
            error: function(error){
            	window.location.href = "${UserURL}?type=list&id=&message=error_system";
            },
        });
    }
	</script>
</body>
</html>