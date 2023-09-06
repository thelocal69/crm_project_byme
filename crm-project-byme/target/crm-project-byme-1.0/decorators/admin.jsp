<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/lib/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-member" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/png" sizes="16x16" href='<c:url value="/temmplate/plugins/images/favicon.png" />'>
<title><dec:title default="Trang chủ" /></title>
<!-- Bootstrap Core CSS -->
<link
	href='<c:url value="/template/admin/bootstrap/dist/css/bootstrap.min.css" />'
	rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<!-- Menu CSS -->
<link
	href='<c:url value="/template/admin/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" />'
	rel="stylesheet">
<!-- toast CSS -->
<link
	href='<c:url value="/template/admin/plugins/bower_components/toast-master/css/jquery.toast.css" />'
	rel="stylesheet">
<!-- morris CSS -->
<link
	href='<c:url value="/template/admin/plugins/bower_components/morrisjs/morris.css" />'
	rel="stylesheet">
<!-- animation CSS -->
<link href='<c:url value="/template/admin/css/animate.css" />'
	rel="stylesheet">
<!-- Custom CSS -->
<link href='<c:url value="/template/admin/css/style.css" />'
	rel="stylesheet">
<!-- color CSS -->
<link href='<c:url value="/template/admin/css/colors/blue-dark.css" />'
	rel="stylesheet">
<link href='<c:url value="/template/admin/css/custom.css" />'
	rel="stylesheet">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>

	<%@include file="/common/admin/header.jsp"%>
	
	<%@include file="/common/admin/menu.jsp"%>
	
	<dec:body />

	<%@include file="/common/admin/footer.jsp"%>

	<!-- jQuery -->
	<script
		src='<c:url value="/template/admin/plugins/bower_components/jquery/dist/jquery.min.js" />'></script>
	<!-- Bootstrap Core JavaScript -->
	<script
		src='<c:url value="/template/admin/bootstrap/dist/js/bootstrap.min.js" />'></script>
	<!-- Menu Plugin JavaScript -->
	<script
		src='<c:url value="/template/admin/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js" />'></script>
	<!--slimscroll JavaScript -->
	<script src='<c:url value="/template/admin/js/jquery.slimscroll.js" />'></script>
	<script src='<c:url value="/template/admin/js/jquery.dataTables.js" />'></script>
	
	<!--Wave Effects -->
	<script src='<c:url value="/template/admin/js/waves.js" />'></script>
	<!--Counter js -->
	<script
		src='<c:url value="/template/admin/plugins/bower_components/waypoints/lib/jquery.waypoints.js" />'></script>
	<script
		src='<c:url value="/template/admin/plugins/bower_components/counterup/jquery.counterup.min.js" />'></script>
	<!--Morris JavaScript -->
	<script
		src='<c:url value="/template/admin/plugins/bower_components/raphael/raphael-min.js" />'></script>
	<script
		src='<c:url value="/template/admin/plugins/bower_components/morrisjs/morris.js" />'></script>
	<!-- Custom Theme JavaScript -->
	<script src='<c:url value="/template/admin/js/custom.min.js" />'></script>
	<script src='<c:url value="/template/admin/js/dashboard1.js" />'></script>
	<script
		src='<c:url value="/template/admin/plugins/bower_components/toast-master/js/jquery.toast.js" />'></script>
		<script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</body>
</html>