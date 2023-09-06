<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include  file="/common/lib/taglib.jsp"%>
<c:url var="APIproject" value="/api-admin-project" />
<c:url var="URlproject" value="/admin-project" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
                        <h4 class="page-title">Thêm mới dự án</h4>
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
                                    <label class="col-md-12">Tên dự án</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="Tên công việc"
                                            class="form-control form-control-line" name="projectName" value="${model.projectName}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="dd/MM/yyyy"
                                            class="form-control form-control-line" name="startedDate" value="${model.startedDate}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="dd/MM/yyyy"
                                            class="form-control form-control-line" name="endedDate" value="${model.endedDate}"> </div>
                                </div>
                                <div class="form-group">
											<div class="col-sm-12">
											<c:if test="${empty model.id}">
												<input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm project" id="btnAddOrUpdateProject" />
											</c:if>
											<c:if test="${not empty model.id}">
												<input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật project" id="btnAddOrUpdateProject" />
											</c:if>
												<a href='<c:url value="/admin-project?type=list" />' class="btn btn-primary">Quay lại</a>
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
            <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <script type="text/javascript">
	
	$('#btnAddOrUpdateProject').click(function (e) {
		e.preventDefault;
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function(i, v){
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if(id == ""){
        	addProject(data);
        }else {
        	updateProject(data);
        }
	});
	
	function addProject(data){
		$.ajax({
            url: "${APIproject}",
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${URlproject}?type=list&id="+result.id+"&message=insert_success";
            },
            error: function(error){
            	window.location.href = "${URlproject}?type=list&message=error_system";
            },
        });
    }
	
	function updateProject(data){
        $.ajax({
            url: "${APIproject}",
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function(result){
            	window.location.href = "${URlproject}?type=list&id="+result.id+"&message=update_success";
            },
            error: function(error){
            	window.location.href = "${URlproject}?type=list&id=&message=error_system";
            },
        });
    }
	</script>
</body>
</html>