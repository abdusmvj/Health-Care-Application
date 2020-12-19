
<html>
<head>
<%@include file="common/scriptTags.jsp"%> 
<style>
.form-control-feedback {
    padding-top: 0px !important;
    padding-right: 22px;
}
</style>
</head>
<body>


	<div class="container">
<%@include file="common/menu.jsp"%>


		
	</div>

	<div class="container" id="edit-update-form">

		<form:form id="upload_excel" method="post" enctype="multipart/form-data"  action="javascript:return;">

	
					
    	  
			<div class="panel panel-default">
				<div class="panel-heading">
					<span id="editEventPanelFormHeading"><strong>UPLOAD PARTICIPANT LIST
							</strong></span>
					
				</div>
 				<div class="alert alert-success alert-dismissable fade in" id="msg" style="text-align: center">
 					<strong id="successMsg"></strong>
	    	  	</div> 
		<div class="panel-body custom-event-form-design ">
				
			<div class="uploadDiv">		
			
			    <div class="row">
			     
			    
			     
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 

					<div class="form-group ">
						<div class="col-lg-4 ">
								<label class="control-label " for="event_name">Select Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
								<select id="eventid" name="eventid" class="form-control inp ploaceholderinp">
											<option value="">Select Event</option> 
											<option value="10">Event Testing</option> 
								</select>
						</div>
					</div>
				</div>
				
			
			</div>	
				<br>
				   <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group">
						<div class="col-lg-4">
							<label class="control-label " for="upload_image" style="margin-right: 10px;">Upload File <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6" >						
								<input type="file" name="file" id="file" class="form-control inp ploaceholderinp"/>			
					   </div>		
					</div>
					</div>
				</div>
				<br>
				<div class="form-group ">
						<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-default upload-btn" id="uploadFilebtn" onclick="uploadParticipantList()"><i class="fa fa-upload" aria-hidden="true"></i> Upload</button>
						</div>
					</div>


				</div>
			</div>
			</div>
	</form:form>

</div>




<script>


$( document ).ready(function() {
	getEventDetails();

	$("#upload_excel").bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	eventid: {
                 validators: {
                     notEmpty: {
                         message: 'Please select the event.'
                     }
                 }
             },
             file: {
                validators: {
                    notEmpty: {
                        message: "Please select file to upload"
                    },
                    file: {
                        extension: "xls,xlsx",
                        message: "Please upload following file types: xls,xlsx. "
                    }
                }
            }
          
        }
    })
	
});

 function getEventDetails(){
   $.ajax({
        url: "fetchallevents",
        type: "GET"
   }).done(function(e) {
         $("#eventid").empty();
      	 $("#eventid").append('<option value="0">Please Select...</option>');
      	 var addOption='';
      	 $.each(e, function(e, i) {
      		  addOption = $('<option value="'+i.id+'">'+i.event_name+'</option>');	
			 	  $("#eventid").append(addOption);
      	 });
        }).fail(function(a, b) {
        	 alert("failure");
        	 console.log(e);
        	 });
   
}




function uploadParticipantList(){
var a = $("#upload_excel").data("bootstrapValidator");
      if (a.validate(), a.isValid()) {
	$.ajax({
        url: "uploadExcelFile",
        type: "POST",
        data: new FormData(document.getElementById("upload_excel")),
        enctype: "multipart/form-data",
        processData: !1,
        cache: !1,
        contentType: !1
    }).done(function(a) {
        $("#successMsg").html("The file has been uploaded successfully");
        $("#msg").fadeTo(2000, 500).slideUp(500, function(){
   	    $("#msg").slideUp(500);
   	});
    }).fail(function(a, b) {
    	$("#successMsg").html("The file has been not been uploaded successfully");
        $("#msg").fadeTo(2000, 500).slideUp(500, function(){
   	    $("#msg").slideUp(500);
    });
 });
}
}
</script>



<%@include file="common/footer.jsp"%>
</body>
 
</html>