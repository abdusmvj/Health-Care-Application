<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View User</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- 	Bootstrap v2.3.2 -->

<link rel="stylesheet" href="resources/static/css/aws-bootstrap-2.3.2-min.css">
<link rel="stylesheet" href="resources/static/css/aws-jquery-dynatable.css">
<link rel="stylesheet" href="resources/static/css/welcome_custome.css">
<link rel="stylesheet" href="resources/static/css/common-custom.css">
<!--  jQuery v3.0.0-beta1 -->
<script src="resources/static/js/aws-jquery-beta-3.0.0.js"></script>
<!-- JS Pluging -->
<script src="resources/static/js/aws-jquery-dynatable.js"></script>
<!-- <script src="static/js/jquery.min.js"></script> -->
<script src="resources/static/js/bootstrap.min.js"></script>

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

	function deleteUserRow()
	{
		alert("hi delete by id");
		var res = confirm("Are you sure you want to delete this row?");
		if(res)
		return true;
		else 
			return false;
	}

	//$("#userId").click(function() {
// 	$("#userId").on('click', function(event) {
// 	    event.preventDefault();
// 	alert("hi delete by id");
// 	confirm("Are you sure you want to delete this row?");
	
// });

// 	$("#userId").on('click', function(event) {
// 	    event.preventDefault();
// 	alert("hi delete class");
// 	confirm("Are you sure you want to delete this row?");
	
// });

	
</script>

</head>
<body>
	<div class="container" id="delete-success-alert">
		<%
			if (request.getAttribute("delete-msg") != null) {
		%>
		<div class="alert alert-success text-center"
			style="margin-top: 3px; margin-bottom: 3px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=request.getAttribute("delete-msg")%>
		</div>
		<%
			request.removeAttribute("delete-msg");
			}
		%>
	</div>

	<div class="container" id="update_user-success-alert">
		<%
			if (request.getAttribute("update-success-msg") != null) {
		%>
		<div class="alert alert-success text-center"
			style="margin-top: 3px; margin-bottom: 3px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=request.getAttribute("update-success-msg")%>
		</div>
		<%
			request.removeAttribute("update-success-msg");
			}
		%>
	</div>

	<div class="container" id="update_user-fail-alert">
		<%
			if (request.getAttribute("update-fail-msg") != null) {
		%>
		<div class="alert alert-success text-center"
			style="margin-top: 3px; margin-bottom: 3px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=request.getAttribute("update-fail-msg")%>
		</div>
		<%
			request.removeAttribute("update-fail-msg");
			}
		%>
	</div>
	<%@include file="nav-bar-menu.jsp"%>
	<div class="wrapper d-flex align-items-stretch">

		<%@include file="commonMenu.jsp"%>
	<c:if test="${mode=='ALL_DETAILS'}">
		<div class="container text-center" id="tasksDiv">
			<h3>View Register User</h3>
			<hr>
			<div class="table-responsive">
				<table class="table table-striped table-bordered" id="allEventTable">
					<thead>
						<tr>

							<th>UserName</th>
							<th>User Email</th>
							<th>User Mob</th>
							<th>User Address</th>
							<th>User Dept</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${objListUserDetails}">
							<tr>
								<td>${user.user_name}</td>
								<td>${user.user_email}</td>
								<td>${user.user_mob_no}</td>
								<td>${user.user_address}</td>
								<td>${user.user_dept}</td>
								<td  style="text-align: center !important;"><a  href="/delete-user?user_id=${user.user_id}" onclick="deleteUserRow();"><span 
										class="fa fa-trash"></span></a></td>
								<td ><a href="/edit-user?user_id=${user.user_id}"><span 
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
	<script src="resources/static/js/popper.js"></script>
	<script src="resources/static/js/main.js"></script>
</body>
</html>