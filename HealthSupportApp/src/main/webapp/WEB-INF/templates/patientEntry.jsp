
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<title>Patient Entry</title>


<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="static/css/welcome_custome.css">


 <script src="static/js/jquery.min.js"></script>


<script src="static/js/bootstrap.min.js"></script>
<script>
	$(function() {

		
		// fetching time only using javascript
		function checkTime(i) {
			if (i < 10) {
				i = "0" + i;
			}
			return i;
		}

		function startTime() {
			var today = new Date();
			var h = today.getHours();
			var m = today.getMinutes();
			var s = today.getSeconds();
			var ampm = today.getHours() >= 12 ? 'PM' : 'AM',
			// add a zero in front of numbers<10
			m = checkTime(m);
			s = checkTime(s);
			$('#visitingTime').val(h + ":" + m + ":" + s+" "+ampm);
			// document.getElementById('visitingTime').value =  h + ":" + m + ":" + s + " " + ampm;
					
			document.getElementById('showTime').innerHTML = "Visiting time :- "
					+ h + ":" + m + ":" + s + " " + ampm;
			t = setTimeout(function() {
				startTime()
			}, 500);

			
		}
		startTime();
		//end for time fetch 
		var todaysDate = getTodayDate();
		var sqlDate = new Date().toJSON().slice(0, 10)
		
		//document.getElementById('visitingDate').value = sqlDate;
		$('#visitingDate').val(sqlDate);
			 
		document.getElementById('showDate').innerHTML = "Visiting Date :- "
				+ todaysDate;
		
		function getTodayDate() {
			var tdate = new Date();
			var dd = tdate.getDate(); //yields day
			var MM = tdate.getMonth(); //yields month
			var yyyy = tdate.getFullYear(); //yields year
			var currentDate = dd + "/" + (MM + 1) + "/" + yyyy;
			return currentDate;
		}
		$('#SaveData').click(function() {
			alert("Hi ss");
		});

	});
</script>
</head>
<body>

	<%@include file="nav-bar-menu.jsp"%>
	<div class="wrapper d-flex align-items-stretch">
  
		<%@include file="commonMenu.jsp"%>
		
<div id="content" class="p-4 p-md-5 pt-5">
<!-- content body -->
		<div class="panel panel-primary">
			<div class="container text-left"
				style="border-bottom: 2px solid #dedede;">

				<h4>Patient Details</h4>
			</div>
		</div>
		<br>
		<div style="float: right;">


				<div id="showDate"></div>

			</div>
			<br>
			<div style="float: right;">
			<div id="showTime"></div>

			</div>

		<form id="contact-form" method="post" action="savePatientDetails"
			role="form">
       <input type="text" name="visitingDate" id="visitingDate" />
      <input type="text" name="visitingTime"  id="visitingTime" />


			

			<div id="datepicker" class="input-group date"
				data-date-format="dd-mm-yyyy">
				<input class="form-control" type="text" readonly /> <span
					class="input-group-addon"><i
					class="glyphicon glyphicon-calendar"></i></span>
			</div>


			<div class="controls">

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_name">Patient Name *</label> <input type="text"
								name="patientName" id="patientName" class="form-control"
								placeholder="Please enter your Name *" required="required"
								data-error="Firstname is required.">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_lastname">Patient Email *</label> <input
								type="text" name="patientEmail" id="patientEmail"
								class="form-control" placeholder="Please enter your Email *">
							<div class="help-block with-errors"></div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_email">Mobile No *</label> <input
								id="patientMob" type="text" name="patientMob"
								class="form-control" placeholder="Please enter your email *">

						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="form_need">Select Gender</label> <select
								id="patientGender" name="patientGender" class="form-control">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Other">Other</option>
							</select>

						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="form_email">Patient Age *</label> <input
								id="patientAge" type="text" name="patientAge"
								class="form-control"
								placeholder="Please enter your Patient Age*">

						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_email">Reference Doctor Name *</label> <input
								id="refDoctorName" type="text" name="refDoctorName"
								class="form-control"
								placeholder="Please enter your refrence Doctor Name *">

						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="form_need">Marital Status</label> <select
								id="patientMaritalStatus" name="patientMaritalStatus"
								class="form-control">
								<option value="">Select Marital Status</option>
								<option value="Single">Single</option>
								<option value="Married">Married</option>
								<option value="Other">Other</option>
							</select>

						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label for="form_need">Is Active</label> <select id="isActive"
								name="isActive" class="form-control">
								<option value="Y">Yes</option>
								<option value="N">No</option>
							</select>

						</div>
					</div>
				</div>
<!-- 				<div class="row"> -->
<!-- 					<div class="col-md-6"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="form_name">Visiting Date</label> <input type="date" -->
<!-- 								name="visitingDate" id="visitingDate" class="form-control" -->
<!-- 								placeholder="Please enter your Name "> -->

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-6"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<label for="form_lastname">Visiting Time *</label> <input -->
<!-- 								type="text" name="visitingTime" id="visitingTime" -->
<!-- 								class="form-control" placeholder="Please enter Visiting  Time *"> -->

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->

			</div>

			<!--Card content-->
			<div class="panel panel-primary">
				<div class="container text-left"
					style="border-bottom: 2px solid #dedede;">
					<h4>Patient Address</h4>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="villTown">Village/Town </label> <input type="text"
							name="villTown" id="villTown" class="form-control"
							placeholder="Please enter your Village *" required="required"
							data-error="Firstname is required.">

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="postOffice">Post Office *</label> <input type="text"
							name="postOffice" id="postOffice" class="form-control"
							placeholder="Please enter your post Office *">

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="policsStation">Police Station *</label> <input
							type="text" name="policsStation" id="policsStation"
							class="form-control"
							placeholder="Please enter your police Station *">

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="state">State </label> <input type="text" name="state"
							id="state" class="form-control"
							placeholder="Please enter your Village *" required="required"
							data-error="Firstname is required.">

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="district">District *</label> <input type="text"
							name="district" id="district" class="form-control"
							placeholder="Please enter your post Office *">

					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="pincode">Postal Code *</label> <input type="text"
							name="pincode" id="pincode" class="form-control"
							placeholder="Please enter your police Station *">

					</div>
				</div>
			</div>
			<input type="submit" id="SaveData" class="btnRegister" value="Save" />
			<div class="text-center">
				<button type="button" class="btn btn-primary">Save</button>
			</div>


		</form>
	</div>
	</div>
	<script src="static/js/popper.js"></script>
<script src="static/js/main.js"></script>
</body>

</html>




