<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 15%">
			<div class="col-md-5 m-auto mt-5">
				<h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
				<div class="p-4 border mt-4">
					<form action='<c:url value="/login" />' method="post">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">
								<strong>${messageResponse}</strong>
							</div>
						</c:if>
						<div class="form-group">
							<label>Email</label> <input type="email" class="form-control"
								name="email">
						</div>
						<div class="form-group">
							<label>Mật khẩu</label> <input type="password"
								class="form-control" name="pass">
						</div>
						<input type="hidden" value="login" name="action" /> 
						<button type="submit" class="btn btn-primary">Đăng nhập</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>