<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>View Patient Details</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 	Bootstrap v2.3.2 -->

<link rel="stylesheet" href="static/css/aws-bootstrap-2.3.2-min.css">
<link rel="stylesheet" href="static/css/aws-jquery-dynatable.css">
<link rel="stylesheet" href="static/css/welcome_custome.css">
<link rel="stylesheet" href="static/css/common-custom.css">
<!--  jQuery v3.0.0-beta1 -->
<script src="static/js/aws-jquery-beta-3.0.0.js"></script>
<!-- JS Pluging -->
<script src="static/js/aws-jquery-dynatable.js"></script>
<!-- <script src="static/js/jquery.min.js"></script> -->
<script src="static/js/bootstrap.min.js"></script>
<script>
	$(function() {
		//for deleting user details
		$("#delete-success-alert").show();
		window.setTimeout(function() {
			$("#delete-success-alert").slideUp(500, function() {
				$("#delete-success-alert").hide();
			});
		}, 5000);
		// for updating user details success
		$("#update_user-success-alert").show();
		window.setTimeout(function() {
			$("#update_user-success-alert").slideUp(500, function() {
				$("#update_user-success-alert").hide();
			});
		}, 5000);
		// for updating user details fail
		$("#update_user-fail-alert").show();
		window.setTimeout(function() {
			$("#update_user-fail-alert").slideUp(500, function() {
				$("#update_user-fail-alert").hide();
			});
		}, 5000);

	});
</script>

</head>
<body>
	<!-- <div class="container" id="delete-success-alert"> -->
	<%-- 		<% if(request.getAttribute("delete-msg") != null) { %> --%>
	<!-- 		<div class="alert alert-success text-center" style="margin-top:3px; margin-bottom:3px;"> -->
	<!-- 			<a href="#" class="close" data-dismiss="alert"> &times;</a> -->
	<%-- 			<%=request.getAttribute("delete-msg")%> --%>
	<!-- 		</div> -->
	<%-- 		<% request.removeAttribute("delete-msg"); } %> --%>
	<!-- </div> -->

	<!-- <div class="container" id="update_user-success-alert"> -->
	<%-- 		<% if(request.getAttribute("update-success-msg") != null) { %> --%>
	<!-- 		<div class="alert alert-success text-center" style="margin-top:3px; margin-bottom:3px;"> -->
	<!-- 			<a href="#" class="close" data-dismiss="alert"> &times;</a> -->
	<%-- 			<%=request.getAttribute("update-success-msg")%> --%>
	<!-- 		</div> -->
	<%-- 		<% request.removeAttribute("update-success-msg"); } %> --%>
	<!-- </div> -->

	<!-- <div class="container" id="update_user-fail-alert"> -->
	<%-- 		<% if(request.getAttribute("update-fail-msg") != null) { %> --%>
	<!-- 		<div class="alert alert-success text-center" style="margin-top:3px; margin-bottom:3px;"> -->
	<!-- 			<a href="#" class="close" data-dismiss="alert"> &times;</a> -->
	<%-- 			<%=request.getAttribute("update-fail-msg")%> --%>
	<!-- 		</div> -->
	<%-- 		<% request.removeAttribute("update-fail-msg"); } %> --%>
	<!-- </div> -->
	<%@include file="nav-bar-menu.jsp"%>
	<div class="wrapper d-flex align-items-stretch">

		<%@include file="commonMenu.jsp"%>
		<c:if test="${mode=='PATIENT_DETAILS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>All Patient Details</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered"
						id="allEventTable">
						<thead>
							<tr>

								<th>Patient Name</th>
								<th>Patient Email</th>
								<th>Patient Mob</th>
								<th>Patient Age</th>
								<th>Patient Gender</th>
								<th>Ref Doctor</th>
								<th>Patient Village</th>
								<th>District</th>
								<th>Sate</th>
								<th>Pincode</th>
								<th>Delete</th>
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="patient" items="${objListPatientDetails}">
								<tr>
									<td>${patient.patientName}</td>
									<td>${patient.patientEmail}</td>
									<td>${patient.patientMob}</td>
									<td>${patient.patientAge}</td>
									<td>${patient.patientGender}</td>
									<td>${patient.refDoctorName}</td>
									<td>${patient.patientAddress.villTown}</td>
									<td>${patient.patientAddress.district}</td>
									<td>${patient.patientAddress.state}</td>
									<td>${patient.patientAddress.pincode}</td>
									<td style="text-align:center !important;"><a href="/delete-patient?patineId=${patient.patineId}"><span 
											class="fa fa-trash"></span></a></td>
									<td><a href="/edit-patient?patineId=${patient.patineId}"><span 
											class="fa fa-pencil-square-o"></span></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script>
		$(document).ready(function() {
			$('#allEventTable').dynatable();
		});
	</script>
	<script src="static/js/popper.js"></script>
	<script src="static/js/main.js"></script>

</body>
</html>