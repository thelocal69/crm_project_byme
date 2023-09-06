<%@include file="/common/lib/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="jobApi" value="/api-admin-job" />
<c:url var="JobURL" value="/admin-job" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- Page Content -->
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row bg-title">
				<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
					<h4 class="page-title">Thêm mới công việc</h4>
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
						<form class="form-horizontal form-material" id="formSubmit">
							<div class="form-group">
								<label class="col-md-12">Dự án</label>
								<div class="col-md-12">
									<select class="form-control form-control-line" id="projectId"
										name="projectId">
										<c:if test="${empty model.projectId}">
										<option>--Chọn dự án--</option>
											<c:forEach items="${projects}" var="item">
												<option value="${item.id}">${item.projectName}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.projectId}">
										<option>--Chọn dự án--</option>
											<c:forEach items="${projects}" var="item">
												<option value="${item.id}" <c:if test="${item.id == model.projectId}">selected="selected"</c:if>>
													${item.projectName}
												</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Tên công việc</label>
								<div class="col-md-12">
									<input type="text" placeholder="Tên công việc"
										class="form-control form-control-line" name="name" value="${model.name}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Content</label>
								<div class="col-md-12">
									<input type="text" placeholder="content"
										class="form-control form-control-line" name="content" value="${model.content}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Người thực hiện</label>
								<div class="col-md-12">
									<select class="form-control form-control-line" id="userId" name="userId">
										<c:if test="${empty model.userId}">
										<option>--Chọn người thực hiện--</option>
											<c:forEach items="${users}" var="item">
												<option value="${item.id}">${item.fullName}</option>
											</c:forEach>
										</c:if>
											<c:if test="${not empty model.userId}">
										<option>--Chọn người thực hiện--</option>
											<c:forEach items="${users}" var="item">
												<option value="${item.id}" <c:if test="${item.id == model.userId}">selected="selected"</c:if>>
													${item.fullName}
												</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày bắt đầu</label>
								<div class="col-md-12">
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="startedDate" value="${model.startedDate}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Ngày kết thúc</label>
								<div class="col-md-12">
									<input type="text" placeholder="dd/MM/yyyy"
										class="form-control form-control-line" name="endedDate" value="${model.endedDate}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-12">Status</label>
								<div class="col-md-12">
									<select class="form-control form-control-line" id="statusId" name="statusId">
										<c:if test="${empty model.statusId}">
										<option>--Chọn status--</option>
											<c:forEach items="${statuss}" var="item">
												<option value="${item.id}">${item.name}</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.statusId}">
										<option>--Chọn status--</option>
											<c:forEach items="${statuss}" var="item">
												<option value="${item.id}" <c:if test="${item.id == model.statusId}">selected="selected"</c:if>>
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
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm mới job" id="btnAddOrUpdateJob" />
									</c:if>
									<c:if test="${not empty model.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật job" id="btnAddOrUpdateJob" />
									</c:if>
									<c:if test="${model.userId == USERMODEL.id}">
										<a href='<c:url value="/admin-member?type=profile" />'
										class="btn btn-primary">Quay lại</a>
									</c:if>
									<c:if test="${model.userId != USERMODEL.id}">
										<a href='<c:url value="/admin-job?type=list" />'
										class="btn btn-primary">Quay lại</a>
									</c:if>
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
	</div>
	<script type="text/javascript">
	$('#btnAddOrUpdateJob').click(function (e) {
		e.preventDefault;
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function(i, v){
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if(id == ""){
        	addJob(data);
        }else {
        	updateJob(data);
        }
	});
	
	function addJob(data){
		$.ajax({
            url: "${jobApi}",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${JobURL}?type=list&message=insert_success";
            },
            error: function(error){
            	window.location.href = "${JobURL}?type=list&message=error_system";
            },
        });
    }
	
	function updateJob(data){
        $.ajax({
            url: "${jobApi}",
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${JobURL}?type=list&id="+result.id+"&message=update_success";
            },
            error: function(error){
            	window.location.href = "${JobURL}?type=list&id="+result.id+"&message=error_system";
            },
        });
    }
	</script>
</body>
</html>