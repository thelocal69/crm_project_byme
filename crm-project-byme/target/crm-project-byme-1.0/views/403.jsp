<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="16x16"
	href='<c:url value="template/assets/plugins/images/favicon.png"></c:url>'>
<title>403 - Forbidden</title>
<!-- Bootstrap Core CSS -->
<link
	href='<c:url value="template/bootstrap/dist/css/bootstrap.min.css" />'
	rel="stylesheet">

<!-- animation CSS -->
<link href='<c:url value="template/css/animate.css" />' rel="stylesheet">

<!-- Custom CSS -->
<link href='<c:url value="template/css/style.css" />' rel="stylesheet">

<!-- color CSS -->
<link href='<c:url value="template/css/colors/blue.css" />'
	rel="stylesheet">

</head>
<body>
	<div class="preloader">
		<div class="cssload-speeding-wheel"></div>
	</div>
	<section id="wrapper" class="error-page">
		<div class="error-box" style="margin-top: 16%">
			<div class="error-body text-center">
				<h1>403</h1>
				<h3 class="text-uppercase">Bạn không có quyền truy cập !</h3>
				<p class="text-muted m-t-30 m-b-30">YOU SEEM TO BE TRYING TO
					FIND HIS WAY HOME</p>
				<a href='<c:url value="trang-chu" />'
					class="btn btn-info btn-rounded waves-effect waves-light m-b-40">Về
					trang chủ</a>
			</div>
		</div>
	</section>
	<!-- jQuery -->
	<script
		src='<c:url value="template/plugins/bower_components/jquery/dist/jquery.min.js" />'></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src='<c:url value="template/bootstrap/dist/js/bootstrap.min.js" />'></script>
	<script type="text/javascript">
		$(function() {
			$(".preloader").fadeOut();
		});
	</script>
</body>
</html>