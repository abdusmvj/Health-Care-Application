<%@include file="common/scriptTags.jsp"%>


<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.form-control-feedback {
  /*   padding-top: 0px !important;
    padding-right: 22px; */
}

</style>
<title>Upload Event Images</title>
</head>
<body>

	<div class="container">
<%@include file="common/menu.jsp"%>

		<div class="alert" id="eventEditAlert"></div>

		
	</div>
	<div class="wrapper-space">
  		<div class="container" id="edit-update-form">

		<form:form action="javascript:return;" method="post" modelAttribute="bannerUploadFileId" id="bannerUploadFileId" enctype="multipart/form-data">


			<div class="panel panel-default">
				<div class="panel-heading">
					<label><span class="field-name">Upload Event Images</span></label>
					
				</div>
				<div class="alert alert-success" id="msg" style="text-align: center;">
 					<strong id="successMsg"></strong>
	    	  	</div> 
				
				<div class="panel-body custom-event-form-design formAlign">
				
			<div class="uploadDiv">						
			    <div class="row">
                   <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12"> 

					<div class="form-group ">
						<div class="col-lg-4 ">
								<label class="control-label " for="event_name">Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
								<select id="eventId" name="eventId" class="form-control inp ploaceholderinp">
											<option value="">Select Event</option> 
											<option value="10">Event Testing</option> 
								</select>
						</div>
					</div>
				</div>
				
			
			</div>	
				<br>
				   <div class="row">
                   <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12"> 
                   <div class="form-group">
						<div class="col-lg-4">
							<label class="control-label " for="upload_image" style="margin-right: 10px;">File <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6" >	 <!-- Sriparna css upload--> 					
								<input type="file" name="file_upload_multiple" id="file_upload_multiple" class="form-control inp ploaceholderinp upload" multiple accept="image/*,.jpg,.gif,.png,.jpeg"/>	
					             <!-- Sriparna css --> 
					            <div class="recommend-text">(Recommended size: 1080px X 500px)</div>		
					   </div>		
					</div>
					</div>
				</div>
				<br>
				<div class="form-group">
							<div class="col-sm-offset-3 col-sm-10">
								<button type="button" class="btn btn-default upload-btn" id="uploadBannerbtn" onclick="uploadBannerImage();"><i class="fa fa-upload" aria-hidden="true"></i>  Upload</button>
						
						</div>
					</div>


					<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
						 <div style="color: brown;">(Note: Uploading new images will replace the existing images for that particular event)</div>
						</div>
					</div>

				</div>
				</div>
			</div>
	</form:form>

</div>
  </div>

<%@include file="common/footer.jsp"%>
</body>
</html>
<script>
$( document ).ready(function() {
	getEventDetails();
	/* callFunctionHeader(); */

	$("#bannerUploadFileId").bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
        	eventId: {
                 validators: {
                     notEmpty: {
                         message: 'Please select the event.'
                     }
                 }
             },
             file_upload_multiple: {
                 validators: {
                     notEmpty: {
                         message: "Please select file(s) to upload"
                     },
                     file: {
                         extension: "jpeg,jpg,gif,png",
                         message: "Please upload following file types: jpeg/jpg/gif/png.  "
                     }/* ,
                     imageDimensions: {
                         minWidth: 720,
                         minHeight: 1280,
                         message: "Image height and width  must be greater than the 720px * 1280px !",
                         messageBadImage: "BAD IMAGE!"
                     } */
                 }
             }
          
        }
    });
	

});

function getEventDetails(){
	   $.ajax({
	        url: "fetchallevents",
	        type: "GET"
	   }).done(function(e) {
	         $("#eventId").empty();
	      	 $("#eventId").append('<option value="">Please Select...</option>');
	      	 var addOption='';
	      	 $.each(e, function(e, i) {
	      		  addOption = $('<option value="'+i.id+'">'+i.event_name+'</option>');	
				 	  $("#eventId").append(addOption);
	      	 });
	        }).fail(function(a, b) {
	        	 alert("failure");
	        	 console.log(e);
	        	 });
	   
	}



 function uploadBannerImage(){
	
	 var a = $("#bannerUploadFileId").data("bootstrapValidator");
     if (a.validate(), a.isValid()) {
    	 $("#loadingImage").show();
			$.ajax({
		        url: "uploadBannerImages",
		        type: "POST",
		        data: new FormData(document.getElementById("bannerUploadFileId")),
		        enctype: "multipart/form-data",
		        processData: !1,
		        cache: !1,
		        contentType: !1
		    }).done(function(a) {
		    	$("#eventId").val("");
		     	$("#file_upload_multiple" ).val("");
		     	$("#loadingImage").hide();
		    	//$("#successMsg").html("The file has been uploaded successfully");
		    	$("#successMsg").empty();
      			$("#successMsg").html(a);
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
}; 


/* function callFunctionHeader() {
    "use strict";
    ! function(e) {
        e.fn.bootstrapValidator.i18n.imageDimensions = e.extend(e.fn.bootstrapValidator.i18n.imageDimensions || {}, {
            "default": "Please choose an image with right dimensions",
            badImage: "Please provide proper image file"
        }), e.fn.bootstrapValidator.validators.imageDimensions = {
            validate: function(a, i, o) {
                if (!window.FileReader || !i[0].files || !i[0].files[0]) return !0;
                var t = new FileReader;
                t.onload = function() {
                    var l = new Image;
                    l.onload = function() {
                        var t = l.naturalWidth || l.width,
                            n = l.naturalHeight || l.height;
                        void 0 !== o.minWidth && t < o.minWidth || void 0 !== o.maxWidth && t > o.maxWidth || void 0 !== o.minHeight && n < o.minHeight || void 0 !== o.maxHeight && n > o.maxHeight ? (a.updateStatus(i, "INVALID", "imageDimensions"), a.updateMessage(i, "imageDimensions", o.message || e.fn.bootstrapValidator.i18n.imageDimensions["default"])) : a.updateStatus(i, "VALID", "imageDimensions")
                    }, l.onerror = function() {
                        a.updateStatus(i, "INVALID", "imageDimensions"), a.updateMessage(i, "imageDimensions", o.messageBadImage || e.fn.bootstrapValidator.i18n.imageDimensions.badImage)
                    }, l.src = t.result
                }, t.readAsDataURL(i[0].files[0]), a.updateStatus(i, "VALIDATING", "imageDimensions")
            }
        }
    }(window.jQuery);
} */  
</script>