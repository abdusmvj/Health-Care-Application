<!DOCTYPE html>
<html>
<head>

<title>Sign In</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="static/js/jquery-min-2.1.3.js" charset="utf-8"></script>
<script src="static/js/bootstrap.min.js"></script>
<style type="text/css">

fieldset.scheduler-border {
    border: 1px groove #ddd !important;
    padding: 0 1.4em 1.4em 1.4em !important;
    margin: 0 0 1.5em 0 !important;
    -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
}

    legend.scheduler-border {
        font-size: 1.2em !important;
        font-weight: bold !important;
        text-align: left !important;
        width:auto;
        padding:0 10px;
        border-bottom:none;
    }</style>

</head>

<body>

  <div class="container">
	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		
		<div class="panel panel-info">
			<div class="panel-heading">
			
				<div class="panel-title" style="text-align: center;">
				<img src="https://upload.wikimedia.org/wikipedia/commons/f/f4/Wm_Morrison_Supermarkets_logo.svg" alt="Morrison's Logo"/>
					Supplier PO Rollout Filter

					<div
						style="float: right; font-size: 80%; position: relative; top: -4px">
						<button type="button" class="btn btn-primary btn-sm">Home
						</button>
						<button type="button" class="btn btn-success btn-sm">Sign
							Out</button>
					</div>

				</div>
			</div>





			<div style="padding-top: 30px" class="panel-body">

				<div style="display: none" id="login-alert"
					class="alert alert-danger col-sm-12"></div>

				<form id="loginform" class="form-horizontal" role="form">
					
                   <fieldset class="scheduler-border">

						<legend class="scheduler-border">Select Action</legend>
						

					
					<div class="form-group">
						<label for="firstname"></label>

					</div>

					<div class="form-group">

						<label class="radio inline"> <input type="radio"
							name="user_gender" value="male" checked> <span>
								View </span>
						</label> <label class="radio inline"> <input type="radio"
							name="user_gender" value="addModify"> <span>Add/Modify
						</span>
						</label> <label class="radio inline"> <input type="radio"
							name="user_gender" value="Delete"> <span>Delete </span>
						</label>
						 <label class="radio inline"> <input type="radio"
							name="user_gender" value="uploadStatus"> <span>Upload Status </span>
						</label>
					</div>
      </fieldset>
<br>
<br>
 <fieldset>

						<legend>Filter Criteria</legend>
					
					
			<div class="row">
					<div class="col-md-6">
						<div class="form-group">
						<label for="form_lastname">Location Id</label> 
                                            <select class="form-control" name = "user_dept">
                                                <option class="hidden"  selected disabled>Location Id</option>
                                                <option value="ID1">ID1</option>
                                                <option value="ID1">ID2</option>
                                                <option value="ID1">ID3</option>
                                            </select>
                                        </div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="form_lastname">Product</label> <input
								type="text" name="patientEmail" id="patientEmail"
								class="form-control" placeholder="Please enter your Email *">
							
						</div>
					</div>

				</div>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="form_name">Effective Date</label> <input type="text"
								name="patientName" id="patientName" class="form-control"
								placeholder="Please enter your Name *" required="required"
								data-error="Firstname is required.">
							<div class="help-block with-errors"></div>
						</div>
					</div>
					

				</div>
		
 </fieldset>
				</form>



			</div>
		</div>
	</div>
	</div>
</body>
</html>
