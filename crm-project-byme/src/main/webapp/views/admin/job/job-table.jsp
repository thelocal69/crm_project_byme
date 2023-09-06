<%@include file="/common/lib/taglib.jsp" %>
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
                        <h4 class="page-title">Danh sách công việc</h4>
                    </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                        <a href='<c:url value="/admin-job?type=addnew" />' class="btn btn-sm btn-success">Thêm mới</a>
                    </div>
                    <!-- /.col-lg-12 -->
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
                                            <th>Tên Công Việc</th>
                                            <th>Dự Án</th>
                                            <th>Người Thực Hiện</th>
                                            <th>Ngày Bắt Đầu</th>
                                            <th>Ngày Kết Thúc</th>
                                            <th>Trạng Thái</th>
                                            <th>Hành Động</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${listJob}" var="item" varStatus="loop">
                                        <tr>
                                        
                                            <td>${loop.count}</td>
                                            <td>${item.name}</td>
                                            <td>${item.projectModel.projectName}</td>
                                            <td>${item.userModel.fullName}</td>
                                            <td>${item.startedDate}</td>
                                            <td>${item.endedDate}</td>
                                            <td>${item.statusModel.name}</td>
                                            <td>
                                            <c:url var="editURL" value="/admin-job">
                                            	<c:param name="type" value="addnew" />
                                            	<c:param name="id" value="${item.id}" />
                                            </c:url>
                                            <c:url var="detailURL" value="/admin-job">
                                            	<c:param name="type" value="detail" />
                                            	<c:param name="id" value="${item.id}" />
                                            </c:url>
                                                <a href="${editURL}" class="btn btn-sm btn-primary">Sửa</a>
												<button class="btn btn-sm btn-danger btnDelete" job-id="${item.id}">xóa</button>
                                                <a href="${detailURL}" class="btn btn-sm btn-info">Xem</a>
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
        </div>
        <script type="text/javascript">
	$(".btnDelete").click(function(){
		var choice = confirm("Bạn chắc chắn muốn xóa ?");
		var data = {};
		if (choice) {
		var id = $(this).attr('job-id');
		data['id'] = id;
		deleteNew(data);
		}
		function deleteNew(data){
	$.ajax({
        url: '${jobApi}',
        type: 'DELETE',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function(result){
            window.location.href = "${JobURL}?type=list&message=delete_success";
        },
        error: function(error){
        	window.location.href = "${JobURL}?type=list&message=error_system";
        },
    });
}
	});
	</script>
</body>
</html>