<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>
<c:url var="urlAPI" value="/api-admin-member" />
<c:url var="userURL" value="/admin-member" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pixel Admin</title>
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
						<h4 class="page-title">Danh sách thành viên</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
						<a href='<c:url value="admin-member?type=addnew"/>' class="btn btn-sm btn-success">Thêm
							mới</a>
					</div>
				<!-- /row -->
				<div class="row">
					<div class="col-sm-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
								<strong>${messageResponse}</strong>
							</div>
						</c:if>
						<div class="white-box">
							<div class="table-responsive">
								<table class="table" id="example">
									<thead>
										<tr>
											<th>STT</th>
											<th>First Name</th>
											<th>Last Name</th>
											<th>Username</th>
											<th>Role</th>
											<th>Thao tác</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${listUser}" var="item" varStatus="loop">
										<tr>
											<td>${loop.count}</td>
											<td>${item.firstName}</td>
											<td>${item.lastName}</td>
											<td>${item.userName}</td>
											<td>${item.roleModel.name}</td>
											<td>
											<c:url var="editURL" value="/admin-member">
														<c:param name="type" value="addnew" />
														<c:param name="id" value="${item.id}" />
											</c:url> 
												<a href="${editURL}" class="btn btn-sm btn-primary">Sửa</a>
												<button class="btn btn-sm btn-danger btnDelete" user-id="${item.id}">xóa</button>
													<%-- <!-- Modal -->
														<div class="modal fade" id="exampleModal" tabindex="-1"
															role="dialog" aria-labelledby="exampleModalLabel"
															aria-hidden="true">
															<div class="modal-dialog" role="document">
																<div class="modal-content">
																	<div class="modal-body text-center">Bạn chắc chắn
																		muốn xóa ?</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-primary btnDelete"
																			value="${item.id}"></button>
																		<button type="button" class="btn btn-secondary"
																			data-dismiss="modal">Hủy</button>
																	</div>
																</div>
															</div>
														</div> --%>
														<a href="user-details.html" class="btn btn-sm btn-info">Xem</a> 
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	</div>
	<script type="text/javascript">
	$(".btnDelete").click(function(){
		var choice = confirm("Bạn chắc chắn muốn xóa ?");
		var data = {};
		if (choice) {
		var id = $(this).attr('user-id');
		data['id'] = id;
		deleteNew(data);
		}
		function deleteNew(data){
	$.ajax({
        url: '${urlAPI}',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(result){
            window.location.href = "${userURL}?type=list&message=delete_success";
        },
        error: function(error){
        	window.location.href = "${userURL}?type=list&message=error_system";
        },
    });
}
	});
	</script>
</body>
</html>