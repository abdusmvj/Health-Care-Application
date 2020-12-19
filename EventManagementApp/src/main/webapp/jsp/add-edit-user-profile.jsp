<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Create/Edit Participant</title>
<%@include file="common/header.jsp"%>
  <script src="js/jQuery.print.js" type="text/javascript"></script>
</head>
<body>


<div class="container">
<%@include file="common/menu.jsp"%>
  
  <div class="panel panel-default">
				
 <div class="panel-body custom-event-form-design custom-body"> 
               
               <!-- <div class="col-sm-12">             
               <div class="form-horizontal">
                 <div class="control-group row-fluid form-inline">-->   
                 
                 <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					<div class="form-group ">
			
                 <div class="col-lg-2 "  style="    margin-left: 30px;">
			        <label for="menuEventSelect" class="control-label">Event <span class="manadatory">*</span> :</label>
			     </div>
			        <!-- <div class="controls"> -->
			        <div class="col-lg-8">
                       <select name="menuEventSelect" class="form-control inp ploaceholderinp" id="menuEventSelect" onchange="populateUsers();"> <option selected="selected" > Loading... Please wait</option> </select>
                    </div> 
                    <!-- </div> -->
                </div>
              </div>
             </div>
             <br>
             
        <div class="row">
          <div class="col-lg-10"> 
          </div>
             <div class="col-sm-2"><button type="button" class="btn btn-default btn-primary send-mail-btn"   onclick="sendMailToAllModal();"><i class="fa fa-envelope" aria-hidden="true"></i> Send e-mail</button></div><!-- Tajinder 08-01-2018 Start -->
           </div>
           <div  id="show-list-table-div"  class="col-sm-12">
                                         
  <table id="allEventTable" class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable     table table-bordered">
    <thead>
      <tr>
        <th width="2% !important">#</th>
        <th width="10% !important">Username<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
                
                <th width="10% !important">Name<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
              
                                <th width="10% !important">Email<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
                <th width="10% !important">Phone<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
                <th width="10% !important">Address<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
        <th width="10% !important">Category<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
         <th width="10% !important">Designation<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
         <th width="10% !important">Company<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
         
       	<th width="4% !important"></th><!-- Edit -->
  		<th width="5% !important"></th><!-- Delete -->
        <th width="4% !important"></th><!-- Print -->
        <th width="5% !important"></th><!-- Send Mail --><!-- Tajinder 08-01-2018 Start -->
      </tr>
    
      <tr>
				  <th width="2% !important"></th>
          <th width="10% !important"> <input  class="js-filter  form-control form-square" type="text" value=""> </th>
          <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
          <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
          <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
            <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
              <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  <th width="10% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  
              
                    <th width="4% !important"></th>   
                    <th width="5% !important"></th> 
                    <th width="4% !important"></th>   
                     <th width="5% !important"><input type="checkbox" id="checkAllBox" onclick="checkAll()" /></th><!-- Tajinder 08-01-2018 Start -->
                   <!-- /******* TAJINDER 04-01-2018 STARTS ********/ -->
          
                                              
        </tr>   
    </thead>
    <tbody id="editMenuTbody" class="show-scroll">    
    </tbody>
  </table>
  </div>
  </div>
  </div>
</div>

<div class="alert fade in alert-dismissable" id="userProfileEditAlert" style="text-align: center; width: 1140px; display: none; padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;"> 
</div>

<div class="alert alert-success alert-dismissable fade in" id="msg" style="text-align: center; width: 1140px; display: none; padding-right: 15px; padding-left: 15px; margin-right: auto; margin-left: auto;">
 					<strong id="successMsg"></strong>
	    	  	</div> 
<div class="container">
 <div class="panel panel-default">
  <ul class="nav nav-tabs panel panel-default panel-heading self-tab">
    <li class="active custom-tab"><a data-toggle="tab" href="#create-edit" >Create/Edit Participant</a></li>
    <li class="custom-tab"><a data-toggle="tab" href="#upload" >Upload Participant List</a></li>  
  </ul>


<div class="tab-content">
    <div id="create-edit" class="tab-pane fade in active">

<div class="container" id="edit-update-form">
<!-- <div class="alert fade in alert-dismissable" id="userProfileEditAlert">
   
</div> -->



<!--  <div class="panel panel-default">  -->
  <!-- <div class="panel-heading" style="padding: 23px 15px !important;padding-top: 9px !important;"></i>
  <span id="editEventPanelFormHeading"><strong>Create/Edit Participant</strong></span>  -->
   <button type="button" id="saveCurrentUserButton" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right self-create" onclick="createNewParticipant();"><i class="fa fa-plus" aria-hidden="true"></i>Create New</button>
    <!-- </div> -->
 
  <div class="panel-body">
  <form class="form-inline" id="updateediteduser" class="form-horizontal feedback">
 <input type="hidden"  id="user_id_hidden" name="user_id_hidden" value="-1"/>




<div class="col-sm-12">
<div class="col-sm-6"> 
<!-- <div class="form-group col-sm-12">
      <label class="control-label col-sm-3" for="user_name">User Name:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_name" placeholder="UserName" name="user_name"/>
      </div>
    </div> -->
    <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="name_of_user">Name <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="name_of_user" placeholder="Name of User" name="name_of_user" />  
      </div>
    </div>
    
    
</div>
<div class="col-sm-6"> 
 <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="user_email">Email <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
       <input type="hidden" class="form-control" id="user_email_hidden" placeholder="Email" name="user_email_hidden"/>
        <input type="text" class="form-control" id="user_email" placeholder="Email" name="user_email"/>
      </div>
    </div>

</div>
</div>
<div class="col-sm-12">

<div class="col-sm-6"> 
<!-- <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="user_pass">Password:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_pass" placeholder="Password" name="user_pass"/>
      </div>
    </div> -->
<div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="user_phone">Phone <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_phone" placeholder="Phone" name="user_phone" data-fv-stringlength="true"
                data-fv-stringlength-max="200"
                data-fv-stringlength-message="The bio must be less than 200 characters" />
      </div>
    </div>

</div>
<div class="col-sm-6">

<div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="user_address">Address <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_address" placeholder="Address" name="user_address"/>
      </div>
    </div>

</div>

</div>
<div class="col-sm-12">

<div class="col-sm-6"> 
 <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" style="padding-right: 6px;" for="user_designation">Designation <span class="manadatory">*</span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_designation" placeholder="Designation" name="user_designation"/>
      </div>
    </div>


</div>
<div class="col-sm-6">

 <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" for="user_company">Company <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_company" placeholder="Company" name="user_company"/>
      </div>
    </div>

</div>

</div>

<div class="col-sm-12">

<div class="col-sm-6"> 
 <div class="form-group  col-sm-12">
      <label class="control-label col-sm-3" style="padding-right: 6px;" for="user_category">Category <span class="manadatory">*</span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_category" placeholder="Category" name="user_category"/>
      </div>
    </div>
</div>
</div>
<!-- <div class="col-sm-12">
 <div class="form-group  col-sm-6">
      <label class="control-label col-sm-3" for="user_category">Category <span class="manadatory"> * </span>:</label>
      <div class="col-sm-9">
        <input type="text" class="form-control" id="user_company" placeholder="Company" name="user_company"/>
      </div>
    </div>
</div> -->


<div class="col-sm-12">

<div class="col-sm-6"> 

  

</div>
<div class="col-sm-6">




</div>

</div>
   
            
            
            
            
     <div class="col-sm-12 text-center" style="margin-top: 28px !important;">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default save-btn" id="update_user" name="update_user"  onclick="saveUser();" >Save</button>
      </div>
    </div>
</div>




</form>

</div>
<!-- </div> -->



   
  



</div>


</div>

<div id="upload" class="tab-pane fade">

 <input type="hidden" name="taskNow" id="taskNow" value="-1" />
  
<!-- ABDUS EXCEL UPLOAD -->
<div class="container" >
<form:form id="upload_excel" method="post" enctype="multipart/form-data"  action="javascript:return;">

	
					
    	  
			 <!-- <div class="panel panel-default">
				<div class="panel-heading">
					<span id="editEventPanelFormHeading"><strong>UPLOAD PARTICIPANT LIST
							</strong></span>
					
				</div>  -->
 				<!-- <div class="alert alert-success alert-dismissable fade in" id="msg" style="text-align: center">
 					<strong id="successMsg"></strong>
	    	  	</div>  -->
		<div class="panel-body custom-event-form-design ">
				
			<div class="uploadDiv">		
			
			  <!--   <div class="row">
			     
			    
			     
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
				<br> -->
				   <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group">
						<div class="col-lg-4">
							<label class="control-label " for="upload_image" style="margin-right: 10px;">File <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6" >	
							    <input type="hidden" name="eventid" id="eventid"/>								
								<input type="file" name="file" id="file" class="form-control inp ploaceholderinp upload"/>			
					   </div>		
					</div>
					</div>
				</div>
				<br>
				<div class="form-group ">
						<div class="col-sm-offset-2 col-sm-10"> <!--  upload-btn  -->
								<button type="button" class="btn btn-default upload-btn" id="uploadFilebtn" onclick="uploadParticipantList()"><i class="fa fa-upload" aria-hidden="true"></i> Upload</button>
						</div>
					</div>


				</div>
			</div>
		<!-- 	</div> -->
			</form:form>
			</div>
			</div>
			</div>
			</div>
			</div>
			</div>
			
<!-- ABDUS EXCEL UPLOAD -->

<!-- MOUSUMI START -->
<div style="display:none;">
<div id="printable" >
Your Content
</div>
</div>
<!-- MOUSUMI END -->

<!-- TAJINDER START -->

	<div class="modal fade" id="confirmActModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<!-- <input type="hidden" name="deleteActivityIdForModal"
					id="deleteActivityIdForModal" val="-1"> -->
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Confirm Send Mail </strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to Send Mail <span class="currentActivityNameForModal"></span> ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="sendMailToAll();">Confirm</button>
				</div>				
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="deleteModalId" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteUserIdForModal"
					id="deleteUserIdForModal" val="-1">
					
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Participant</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						  
						<strong>Do you want to delete User "<span class="currentUserNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentUserProfile();">Delete</button>
				</div>
				
			</div>

		</div>
	</div>
	
	
	<div class="modal fade" id="printModalId" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">	
			
					
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Print</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						  
						<strong>Participant has not been registered yet. </strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Close</button>
					
				</div>
				
			</div>

		</div>
	</div>
<!-- TAJINDER END -->

<!-- TAJINDER 09-01-2018 STARTS-->
	<div class="modal fade" id="discardPopup" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">				
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">						 
					<strong>Discard Changes</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>		
						<strong>Do you want to discard your changes ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">No</button>
				    <button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="resetFormForNewUser();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="discardEditPopup" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">				
				<div class="modal-header">
				<input type="hidden" name="editCurrentUserIdForModal"
					id="editCurrentUserIdForModal" val="-1">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">						 
					<strong>Discard Changes</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>		
						<strong>Do you want to discard your current changes and want to edit another one ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">No</button>
				    <button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="editCurrentUser();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
<!-- TAJINDER END -->
<%@include file="common/footer.jsp"%>
</body>
</html>



<script>



function resetFormForNewUser(){
	
	
/* 	$('#updateediteduser')[0].reset(); */
	$('#user_id_hidden').val('-1');
	$("#taskNow").val("N");
	 
	
	
	/* $("#user_name").trigger("change"); */
    
    $("#user_id_hidden").trigger("change");
    $("#name_of_user").trigger("change");
  /*   $("#user_pass").trigger("change"); */
    $("#user_email").trigger("change");
    
    $("#user_phone").trigger("change"); 
    $("#user_address").trigger("change"); 
    $("#user_designation").trigger("change");
    
    $("#user_company").trigger("change");
    $("#user_category").trigger("change");

    /*  Sriparna validation */
    $('#updateediteduser').bootstrapValidator('resetForm', true);
    
}

function newUserAlert(){
	
	/*  $("#userProfileEditAlert").show();
		$("#userProfileEditAlert").removeClass("alert-danger");
     	   $("#userProfileEditAlert").addClass("alert-success");
     	   $("#userProfileEditAlert").html("Please enter new user information!");	 */
	
}

 function saveUser(){
	
	 var a= ($("#menuEventSelect").val());
	 console.log("menu = "+a);
	 
 	console.log('checkIfFormIsValid'); 
	console.log(checkIfFormIsValid('updateediteduser')); 
	
	//let isValid=checkIfFormIsValid('updateediteduser');
	let currentTask=$("#taskNow").val();
	/* if(currentTask=='-1'){
		  $("#userProfileEditAlert").show();
	 		$("#userProfileEditAlert").removeClass("alert-danger");
	        	   $("#userProfileEditAlert").addClass("alert-success");
	        	   $("#userProfileEditAlert").html("Please fill mandatory fields"); 
		  return;
 	} */
	if(a != '-1'){	
		//alert("if");	
	if($("#user_id_hidden").val().trim()=='-1'){
	 		//create new
	 		createNewUser();
	 	}
		else{
			saveCurrentUser();
	 	}
	
	}
	else{
		//alert("else");
		 $("#userProfileEditAlert").show();
	 		$("#userProfileEditAlert").removeClass("alert-success");
	        	   $("#userProfileEditAlert").addClass("alert-danger");
	        	   $("#userProfileEditAlert").html("Please select an event first!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		  return;
		
		
	}
 }
 
 
 
 
 
 
 function createNewUser(){
	  $('#updateediteduser').bootstrapValidator('validate');
	   
	 var id='-1';
	 var eventID=$("#menuEventSelect").val();
	   
	  
	 if((''+eventID).trim()===('-1')){
		 
		 $("#userProfileEditAlert").show();
		 $("#userProfileEditAlert").removeClass("alert-success");
		 $("#userProfileEditAlert").addClass("alert-danger");
  	   $("#userProfileEditAlert").html("Please select an event first!");	
  	 $("#userProfileEditAlert").delay(1000).fadeOut("12000");
     return;
  	   
  	 /*  $("#userProfileEditAlert").addClass("alert-danger");
  	   $("#userProfileEditAlert").html("Failed to update &#39;"+$("#row_event_name_"+id).val()+"&#39;");	*/
	 }
	
	    var	f = new FormData();
	  	f.append('user_id_hidden', ''+id);
	   //	f.append('user_name', ''+$("#user_name").val());
	  	f.append('name_of_user', ''+$("#name_of_user").val());
	  //	f.append('user_pass', ''+$("#user_pass").val());
	   	f.append('user_email', ''+$("#user_email").val());
	  	f.append('user_phone', ''+$("#user_phone").val());
	  	f.append('user_address', ''+$("#user_address").val());
	  	f.append('user_designation', ''+$("#user_designation").val());
	  	f.append('user_company', ''+$("#user_company").val());
		f.append('user_category', ''+$("#user_category").val());	 
	  	f.append('user_event_id', ''+$("#menuEventSelect").val());
	      	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "createuserdetail",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        // alert(response);
	            
	        	  if((''+response)===(''+2)){
	        			 $("#userProfileEditAlert").show();
	        			 $("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("Username is taken. Try another!");	
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		        	   $("#taskNow").val('-1');
		           }
	        	  else  if((''+response)===(''+0)){
	        			 $("#userProfileEditAlert").show();
	        			 $("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("New User Registration Failed!");
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		        	   resetFormForNewUser();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#user_id_hidden').val('-1');
		           }
	        	  else  if((''+response)===(''+3)){
	        			 $("#userProfileEditAlert").show();
	        			 $("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("QR code generation failed. Please contact admininstrator!");
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		        	   resetFormForNewUser();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#user_id_hidden').val('-1');
		           }
	        	  else  if((''+response)===(''+4)){
	        			 $("#userProfileEditAlert").show();
	        			 $("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("Error occurred while generating username. Please contact admininstrator!");	
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		        	   resetFormForNewUser();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#user_id_hidden').val('-1');
		           }
		           else{
		      		 $("#userProfileEditAlert").show();
		      		$("#userProfileEditAlert").removeClass("alert-danger");
		        	   $("#userProfileEditAlert").addClass("alert-success");
		        	   $("#userProfileEditAlert").html("Successsfully added new user!");	    
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		        	   resetFormForNewUser();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#user_id_hidden').val('-1');
		           } 
	             console.log(response);
	             populateUsers();
	            },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	         	console.log(response);
	         }
	 	    });
	
	
	 
 }
 
function populateUsers(){
	
	// $('#editMenuTbody').html('<img src="http://preloaders.net/preloaders/287/Filling%20broken%20ring.gif"> loading...');
	
	
	 var	  f = new FormData();
	  	f.append('id', ''+$("#menuEventSelect").val().trim());
 
	 	 		  
	 $.ajax({    //create an ajax request to display.php
		 type: "POST",
         url: "fetchalluserdetails",             
         data: f,
         processData: false,
 		  contentType: false,              
	        success: function(response){ 
	        	
	        	//setTimeout(function (){
	        	
	        	
	             //alert(response);
	               console.log(response);
	                 $("#editMenuTbody").html('');
	             
	             // response = JSON.parse(response);
	              var  menuHTML='';
	                var count =0;
	                
	              for(var y=0; y<response.length; y++){
	            count++;
	                 menuHTML=''+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
	                  '<td style = "white-space: normal;width: 100px;">'+count  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].username  +'</td>'+
	                 /*  '<td>'+response[y].password  +'</td>'+ */
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].name  +'</td>'+
	                   
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].email_id  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].phone_number  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].address  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+(response[y].category)  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].designation  +'</td>'+
	                  '<td style = "white-space: normal;width: 140px;">'+response[y].company  +'</td>'+
	                  
	                 
	                  '<td style = "white-space: normal;width: 20px;"> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" onclick="editUserConfirmModal('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></div> </td> '+
	                  /* '</div> </td>'+
	                  '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default" onclick="sendMail('+response[y].id+');"><i class="fa fa-envelope" aria-hidden="true"></i>Sent Mail</button> '+
	                  '</div> </td>'+  */
	                  
	                  /* TAJINDER 04-01-2018  START*/
	                  '<td style = "white-space: normal;width: 20px;"> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default" data-toggle="modal" data-target="#deleteModalId" onclick="deleteCurrentUserModal('+response[y].id+',\''+response[y].name+'\');"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> '+
	                  '</div> </td>'+ 
	                  /* TAJINDER 04-01-2018  END*/
	                 
	                  '<td style = "white-space: normal;width: 20px;"> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" onclick="printParticipantDetails(\' '+response[y].id+'\',\''+response[y].name+'\',   \''+ response[y].designation+'\'    ,\''+response[y].company+'\',\''+response[y].qr_code_img_path+'\');"><i class="fa fa-print" aria-hidden="true"></i> Print</button> '+
	                  '</div> </td>'+ 
	              /*  Tajinder 08-01-2018 Start */
	                  '<td style = "white-space: normal;width: 140px;"><div class="checkbox">'+
	                  ' <label><input type="checkbox" style="margin-right: 50px;!important" value="'+ response[y].id +'"  class="is-active-class" onclick="showUsrId('+response[y].id+');"  id="check_'+response[y].id+'" /></label>'+
	                 '  </div></td>'+ 
	                 
	                 
	                   ' </tr>';
	               $("#editMenuTbody").append(menuHTML);
	                  
	               
	               
	               
	              }
	            //  $("#editMenuTbody").html(menuHTML);
	            if($("#taskNow").val()!='-1'  ){
	            	 
	            	$('#updateediteduser').bootstrapValidator('validate');
	            	$("#user_id_hidden").trigger("change");
			          $("#name_of_user").trigger("change");
			           $("#user_email").trigger("change");
			          
			          $("#user_phone").trigger("change"); 
			          $("#user_address").trigger("change"); 
			          $("#user_designation").trigger("change");
			          
			          $("#user_company").trigger("change");
			          $("#user_category").trigger("change");
	            }
	            
	            
	            
	            
	        	//}, 10000);
	           },
	        error: function(response){                    
	        	console.log(response);
	        	 $("#userProfileEditAlert").show();
		      		$("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("Error occurred while fetching user details!");	
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
	        }
	    });
	
	
	
	
}

function sendMail(userId){
	var eventId= ($("#menuEventSelect").val());
	
	
	if(eventId != '-1'){	
		$.ajax({    //create an ajax request to display       
	        type: "POST",
	        url: "sendInvitationMail?userId="+userId+"&eventId="+eventId,             
	        processData: false,
			  contentType: false,
	        success: function(response){                    
	        	$("#userProfileEditAlert").show();
 				$("#userProfileEditAlert").removeClass("alert-danger");
        	   $("#userProfileEditAlert").addClass("alert-success");
        	   $("#userProfileEditAlert").html("Mail sent successfully!");
        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
	         
	           },
	        error: function(response){  
	       		console.log(response);
	        }
		    });
	
	}
	else{
					 $("#userProfileEditAlert").show();
	 				$("#userProfileEditAlert").removeClass("alert-success");
	        	   $("#userProfileEditAlert").addClass("alert-danger");
	        	   $("#userProfileEditAlert").html("Please select an event first!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		  return;
		
		
	}

}

function editCurrentUser(){
	var id=$("#editCurrentUserIdForModal").val();
	$("#user_id_hidden").val(id);
	$("#taskNow").val("E");
			
		 var	  f = new FormData();
		 	
		 	
		 	f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "fetchuserdetailbyid",             
		         data: f,
		         processData: false,
		 		  contentType: false,
		         success: function(response){                    
		        // alert(response);
		            
		         /*  $("#user_name").val(""+response[0].username).trigger("change"); */
		          
		          $("#user_id_hidden").val(""+response[0].id).trigger("change");
		          $("#name_of_user").val(""+(response[0].name?response[0].name:"")).trigger("change");
		        /*   $("#user_pass").val(""+(response[0].password?response[0].password:"")).trigger("change"); */
		          $("#user_email").val(""+(response[0].email_id?response[0].email_id:"")).trigger("change");
		          $("#user_email_hidden").val(""+(response[0].email_id?response[0].email_id:""));
		          $("#user_phone").val(""+(response[0].phone_number?response[0].phone_number:"")).trigger("change"); 
		          $("#user_address").val(""+(response[0].address?response[0].address:"")).trigger("change"); 
		          $("#user_designation").val(""+(response[0].designation?response[0].designation:"")).trigger("change");
		          
		          $("#user_company").val(""+(response[0].company?response[0].company:"")).trigger("change"); 
		          $("#user_category").val(""+(response[0].category?response[0].category:"")).trigger("change");
		          
		          $("#saveCurrentUserButton").prop("disabled",false);
		             console.log(response);
		               
		            },
		         error: function(response){  
		        	console.log(response);
		         }
		 	    });
		
	}


function saveCurrentUser(){
	 var id=$("#user_id_hidden").val();
	 var eventId= ($("#menuEventSelect").val());
	  $('#updateediteduser').bootstrapValidator('validate');
	  console.log( $('#updateediteduser').bootstrapValidator('isValid'));
	  if (!$('#updateediteduser').bootstrapValidator('isValid')) {
           
		  $("#userProfileEditAlert").show();
	 		$("#userProfileEditAlert").removeClass("alert-danger");
	        	   $("#userProfileEditAlert").addClass("alert-success");
	        	   $("#userProfileEditAlert").html("Please put valid data in all the fields!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		  return;
      }
	  
	    var	f = new FormData();
	  	f.append('user_id_hidden', ''+id);

	  /*	f.append('user_name', ''+$("#user_name").val());*/
	  	f.append('name_of_user', ''+$("#name_of_user").val());
	  /* 	f.append('user_pass', ''+$("#user_pass").val()); */
	  	 
	  	f.append('user_email', ''+$("#user_email").val());
	  	f.append('user_phone', ''+$("#user_phone").val());
	  	f.append('user_address', ''+$("#user_address").val());
	  	f.append('user_designation', ''+$("#user_designation").val());
	  	f.append('user_company', ''+$("#user_company").val()); 
		f.append('user_category', ''+$("#user_category").val()); 
		f.append('user_email_hidden', ''+$("#user_email_hidden").val()); 
		f.append('eventId', ''+eventId);
		
     
	  	
	  	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updateuserdetailbyid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        // alert(response);
	            
	      if((''+response)===(''+1)){
	 		 $("#userProfileEditAlert").show();
	 		$("#userProfileEditAlert").removeClass("alert-danger");
	        	   $("#userProfileEditAlert").addClass("alert-success");
	        	   $("#userProfileEditAlert").html("Successfully updated!");	
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
	        	   resetFormForNewUser();
	        	   $("#taskNow").val('-1');
	        	    
	        		$('#user_id_hidden').val('-1');
	        		 
	        	   populateUsers();
	      }else if((''+response)===(''+5)){
	    	  $("#userProfileEditAlert").show();
	      		$("#userProfileEditAlert").removeClass("alert-success");
	        	   $("#userProfileEditAlert").addClass("alert-danger");
	        	   $("#userProfileEditAlert").html("EmailId already present!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
	        	   $("#update_user").prop("disabled",false);
	        	  /*  resetFormForNewUser();
	        	   $("#taskNow").val('-1');
	        	    
	        		$('#user_id_hidden').val('-1'); */
	      }
	           else{
	      		 $("#userProfileEditAlert").show();
	      		$("#userProfileEditAlert").removeClass("alert-success");
	        	   $("#userProfileEditAlert").addClass("alert-danger");
	        	   $("#userProfileEditAlert").html("Failed to update!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
	        	   resetFormForNewUser();
	        	   $("#taskNow").val('-1');
	        	    
	        		$('#user_id_hidden').val('-1');
	        		
	           } 
	    //  $("#user_id_hidden").val("-1");
          //$("#saveCurrentUserButton").prop("disabled",true);
	             console.log(response);
	              
	            },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	         $("#user_id_hidden").val("-1");
	        	
	        	console.log(response);
	         }
	 	    });
	
	
	
}


 
function populateExistingEvents(){
	
	 $.ajax({    //create an ajax request to  
	        type: "GET",
	        url: "fetchallevents",             
	        dataType: "html",   //expect html to be returned                
	        success: function(response){                    
	             //alert(response);
	              response = JSON.parse(response);
	              var  menuHTML='<option value="-1">Select Event</option>';
	              for(var y=0; y<response.length; y++){
	            
	                 menuHTML=menuHTML+'<option value="'+response[y].id+'">'+response[y].event_name+'</option>';
	            	 
	              }
	              $("#menuEventSelect").html(menuHTML);
	              console.log(response);
	              
	           },
	        error: function(response){                    
	        	console.log(response);
	        }
	    });
	
	
	
	
}

$( document ).ready(function() {
	 
  	populateExistingEvents();
	 
  	  
  	$('#name_of_user').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'name_of_user');
  	 });
  	$('#user_email').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_email');
  	 });
  	
  	$('#user_phone').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_phone');
  	 });
  	$('#user_address').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_address');
  	 });
  	
  	$('#user_designation').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_designation');
  	 });
  	$('#user_company').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_company');
  	 });
  	$('#user_category').on('change input', function(e) {
  	    $('#updateediteduser').bootstrapValidator('revalidateField', 'user_category');
  	 });
  	
  	
  	
  	
  	
  		$('#updateediteduser').bootstrapValidator({
  	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
  	        feedbackIcons: {
  	            valid: 'glyphicon glyphicon-ok',
  	            invalid: 'glyphicon glyphicon-remove',
  	            validating: 'glyphicon glyphicon-refresh'
  	        },
  	        fields: {
  	        	
  	      
  	            
  	            
  	            
  	          name_of_user: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The name of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The name must be less than 100 characters'
	                        
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z ]+$/,
	                        message: 'The name can only consist of alphabet and space'
	                    },               
	                }
	            } ,
	            
	            
	            user_email: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The email of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The email must be less than 100 characters'
	                        
	                    },
	                    regexp: {
	                        regexp: /^[^\s@]+@[^\s@]+\.[^\s@]+$/ ,
	                        message: 'Please enter a valid email address'
	                    },               
	                }
	            } ,
  	            
	            user_phone: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The phone of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:12,
	                        message: 'The phone must be less than 13 characters'
	                        
	                    },
	                    regexp: {
	                        regexp: /^\d+$/ ,
	                        message: 'The phone can only consist of numbers'
	                    },               
	                }
	            } ,
	            
	            user_address: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The address of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The address must be less than 100 characters'
	                        	
	                    },
	                    regexp: {
	                        regexp: /\S+/ ,
	                        message: 'Please enter a valid address'
	                    },
	                }
	            } ,
	          	
	            user_designation: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The  designation of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The designation of user must be less than 100 characters'
	                        
	                    }                
	                }
	            } ,
	            
	            user_company: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The  company of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The  company of user must be less than 100 characters'
	                        
	                    }                
	                }
	            } ,
	            
	            user_category: {
	                   validators: {
	                    notEmpty: {
	                        message: 'The category of user is required and cannot be empty'
	                    },
	                    stringLength: {
	                        max:100,
	                        message: 'The category of user must be less than 100 characters'
	                        
	                    }                
	                }
	            } ,
	          	
  	        
  	        
  			}
  				}) .on('success.form.bv', function(e) {
  		          
  	            e.preventDefault();

  	                    
  	        });
  	
	 
 });
 
function checkIfFormIsValid(formId){
	 	if($('#'+formId).bootstrapValidator('validate').has('.has-error').length === 0){
	 		return true;
	 		
	 	}
	 	else{
	 		return false;
	 	}
	 
 	return true;
 }
function validateForm(formId){
	$('#'+formId).bootstrapValidator('validate');
}








</script>
<!-- ABDUS UPLOAD FILE START -->
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
        	/* eventid: {
                 validators: {
                     notEmpty: {
                         message: 'Please select the event.'
                     }
                 }
             }, */
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
      	 $("#eventid").append('<option value="">Please Select...</option>');
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
	var eventId=$("#menuEventSelect").val();

	$("#eventid").val(eventId);
	 if(eventId != '-1'){	
			var a = $("#upload_excel").data("bootstrapValidator");
	      if (a.validate(), a.isValid()) {
	    	$("#loadingImage").show();
	 	$.ajax({
	        url: "uploadExcelFile?eventid="+eventid,
	        type: "POST",
	  	    data: new FormData(document.getElementById("upload_excel")),
	        //data: f,
	        enctype: "multipart/form-data",
	        processData: !1,
	        cache: !1,
	        contentType: !1
	    }).done(function(a) {
	    	$("#loadingImage").hide();
	        $("#successMsg").html("The file has been uploaded successfully");
	        $("#msg").fadeTo(2000, 500).slideUp(500, function(){
	   	    $("#msg").slideUp(500);
	   	});
	       /*  Tajinder 08-10-2017 Starts */
	      /*  	$("#eventid").val(""); */
	       	$("#file").val("");
	       	$('#upload_excel').bootstrapValidator('resetForm', true);
	       /*  Tajinder 08-10-2017 End */
	    }).fail(function(a, b) {
	    	$("#loadingImage").hide();
	    	$("#successMsg").html("The file has been not been uploaded successfully");
	        $("#msg").fadeTo(2000, 500).slideUp(500, function(){
	   	    $("#msg").slideUp(500);
	    });
	 }); 
	}
			}else{
						 $("#userProfileEditAlert").show();
		 				$("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("Please select an event first!");
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
			  return;
			
			
		}
}
function checkIsUserValidForPrint(userId){
	
	var data=0;
	$.ajax({
        url: "checkIsUserValidForPrint?userId="+userId,
        type: "GET",
        processData: !1,
        cache: !1,
        contentType: !1,
        async:false
    }).done(function(a) {
    	data=a;
  
    }).fail(function(a, b) {
   	
   	 console.log(e);
   	 });
	return data;
}

function printParticipantDetails(id,name,designation,company,QR_path){
	var isValidForPrint=checkIsUserValidForPrint(id);
	
	if(isValidForPrint==0){
		
		$('#printModalId').modal('show');
	}else{
	
			 var event_name=$("#menuEventSelect option:selected").text();
			 var path=accessFileUrl+QR_path;
		//alert(path);
			var html='<div class="container" id="printParticipantDetailsDiv"> '+
		'<div class="panel panel-default"> ' +
		' <div class="panel-heading" style="padding: 23px 15px !important;padding-top: 9px !important;"></i><span id="editEventPanelFormHeading" style="font-size: 250%;text-align: center;margin-left: 20px;"><strong></strong></span>   </div> '+
		' <div class="panel-body">'+
		' <div class="i-card" style="width: 1073px; height:1529px;text-align: center;margin: auto;"> '+
		'<label id="participant_eventName" class="eventName" style="font-size: 350%;text-align: center;margin: auto;color:#0d3793!important;font-weight: bold;border-style: solid;border-radius:15px;border-width:4px;padding:30px;border-color: #086bc6;margin-right:55px">'+event_name+'</label><br><br><br> '+
		'<label id="participant_eventName" style="font-size: 350%;text-align: center;color:#696969 !important;font-weight: bold;margin-top: 50px">Identity Card</label><br><br/><br> '+
		'<div  class="i-card" style="box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);transition: 0.3s;width:40%;height:30%;text-align: center;margin-left:300px;"> '+
		'	<img src="'+path+'" alt="John" style="width:100%;height:100%;"/> '+ 
		'</div><br><br> '+ 
		'<div class="col-sm-12"> '+
		' <div class="form-group  col-sm-12">'+
		    '<div class="col-sm-12">'+
		     ' <label id="participant_name" style="font-size: 400%;text-align: center;margin: auto;color:#0d3793!important;font-weight: bold;margin-top: 50px">'+name+'</label>'+
		     '</div>'+
		 '  </div>'+
		'</div>'+
		'<div class="col-sm-12"> '+
		'<div class="form-group  col-sm-12">'+
		   ' <div class="col-sm-12">'+
		    '   <label id="participant_company" style="font-size: 350%;text-align: center;margin: auto;color:#696969!important;font-weight: bold;">'+company+'</label>'+
		    ' </div>'+
		   '</div>'+
		'</div>'+
		'<div class="col-sm-12"> '+
		'<div class="form-group  col-sm-12">'+
		  ' <div class="col-sm-12">'+
		    ' <label id="participant_designation" style="font-size: 350%;text-align: center;margin: auto;color:#696969!important;font-weight: bold;">'+designation+'</label> '+
		    ' </div>'+
		  ' </div></div></div> </div>  </div></div>';
		 
		$("#printable").html(html);
		
		
			/*	var s = window.open("", "", "height=430,width=750");
				s.document.write("<html><head>");
				s.document.write('</head><body>');
				s.document.write(html);
				s.document.write("</body></html>");
				s.document.close();
				s.focus();
				s.print();
				s.close();
				return true; */
				/* $("#printable").print({
					mediaPrint : false,});   */
			$.print("#printable");
	
	}		
}


/*Sriparna 01-01-2018 checkbox starts*/
var ids=[];
function popFromArrayByValue(valu,  arr){
	var index = arr.indexOf((''+valu).trim());
	if (index > -1) {
		arr.splice(index, 1);
	}
	//alert("array after splice: "+arr);
}
 function showUsrId(id){
 	// alert("remove: "+id);
 	 id=(''+''+id).trim();
 	 if($('#check_'+id+':checkbox:checked').length > 0)
 	 {  

        if(ids.indexOf(''+id) > -1){//alert("checked and exists");
	      //alert("after individual check exists: "+id+"  "+ids);
         }
		else{ //alert("checked and does not exists");
		ids.push(id);
		//alert("just after");
		//alert("after individual check does not exist: "+id+"  "+ids);
		}
 	 }
 	 else{ 	 	
 		popFromArrayByValue(id,ids);
 		 $('#checkAllBox').prop( "checked",false );
 		// alert("after individual uncheck pop: "+id+"  "+ids);
 	 	 }	 
	
 }

 function checkAll(){
 if($('#checkAllBox:checkbox:checked').length > 0){
 	$("input:checkbox[id^='check_']").each(function(){
 	  $(this).prop( "checked",true );

 	   //ids.push( $(this).attr("id"));
   if($(this).is(':checked')){
 	   var i =  $(this).attr("id");
       i = (''+(''+i).split('_')[1]).trim();
       //alert("checkall before ins-del "+i+" " +ids.indexOf(''+i)+"  "+ids.length+"   "+ids[ids.length-1]+"  "+ids);
 	  if(ids.indexOf((''+i).trim()) > -1){
 		// alert("checkall exists "+i+" " +ids.indexOf(''+i)+"  "+ids);
 	 }
 	else{ ids.push(i);
	 //alert("checkall not exists "+i+" " +ids.indexOf(''+i)+"  "+ids);
 	 }
   }
   });
  }
 else{
 	$("input:checkbox[id^='check_']").each(function(){
 		   $(this).prop( "checked",false );
 	   });
 	ids=[];
 }

 }
 /*Sriparna 01-01-2018 checkbox ends*/
  /******* TAJINDER 04-01-2018 STARTS ********/
$('#confirmActModal').modal('hide');
 function sendMailToAllModal(){
	 var eventId=$("#menuEventSelect").val();
	 if(eventId != '-1'){	
				if(ids.length>0){
				$('#confirmActModal').modal('show');
			
				//sendMailToAll(eventId);
				}else{
					 $("#userProfileEditAlert").show();
		 				$("#userProfileEditAlert").removeClass("alert-success");
		        	   $("#userProfileEditAlert").addClass("alert-danger");
		        	   $("#userProfileEditAlert").html("Please select checkbox to Send Mail!");
		        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
			  //return;
				
				}
		}else{
					 $("#userProfileEditAlert").show();
	 				$("#userProfileEditAlert").removeClass("alert-success");
	        	   $("#userProfileEditAlert").addClass("alert-danger");
	        	   $("#userProfileEditAlert").html("Please select an event first!");
	        	   $("#userProfileEditAlert").delay(1000).fadeOut("12000");
		  return;
		
		
	}
 }
 
 function sendMailToAll(eventId){
	 var eventId=$("#menuEventSelect").val();
	  	$("#loadingImage").show();
  /* if(ids.length>0){
	  var eventId=$("#menuEventSelect").val(); */
	  var f = new FormData;
	  f.append("userIdList", ids);
	  f.append("eventId",eventId);
	  $.ajax({
		  type:"POST", 
		 url:"sendInvitationMailInGroup", 
		 data:f, 
		 processData:false, 
		 contentType:false, 
		 success:function(response) {
			 $("#loadingImage").hide();
			  var msg="";
			 for (var i = 0, keys = Object.keys(response), ii = keys.length; i < ii; i++) {
				 
				 if(keys[i]=="MAILID_LIST_SUCCESS_KEY"){
					 msg=" Mail sent successfully to " +response[keys[i]] +"<br>";
				 }
				 
				 if(keys[i]=="MAILID_LIST_FAILURE_KEY"){
					 if(response[keys[i]]!=""){
					 msg=msg +" Mail not sent successfully to "+ response[keys[i]] ;
					 }
				 } 
				  console.log('key : ' + keys[i] + ' val : ' + response[keys[i]]);
				}
			   $("#userProfileEditAlert").show();
			   $("#userProfileEditAlert").removeClass("alert-danger");
	     	   $("#userProfileEditAlert").addClass("alert-success");
	     	   $("#userProfileEditAlert").html(msg);
	     	   //$("#userProfileEditAlert").delay(100).fadeOut("120000");
	         
	  }, error:function(response) {
		  $("#loadingImage").hide();
	       console.log(response);
	   
	  }});
/* }else{
	alert("Please select checkbox to Send Mail");
	} */

}
 
 function deleteCurrentUserModal(userId,username){
		
	 $('.currentUserNameForModal').html(username);
	 $("#deleteUserIdForModal").val(userId);
	 }
 function deleteCurrentUserProfile(){
	 var id=$('#deleteUserIdForModal').val();
	 
	 	//$("#editEventPanelFormHeading").html("Currently editing event '"+name+"'. Click save when you are done!");
	 			
	 		 var f = new FormData();
	 		 f.append('id', ''+id);

	 		 	$.ajax({    //create an ajax request to display       
	 		         type: "POST",
	 		         url: "deleteUserProfileDetailById",             
	 		         data: f,
	 		         processData: false,
	 		 		 contentType: false,
	 		         success: function(response){                    
	 		        // alert(response);
	 		        console.log(response);
	 		        	/*  $('#eventForm')[0].reset(); */
	 		        	 populateUsers();
	 		            console.log(response);
	 		           
	 		     	  	f.append('event_id_hidden', '-1');
	 		            },
	 		         error: function(response){  
	 		        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	 		         	console.log(response);
	 		         }
	 		 	    });
	 }
 /******* TAJINDER 04-01-2018 END ********/
  /******* TAJINDER 08-01-2018 START ********/
 function createNewParticipant(){
 
 if(($("#name_of_user").val().trim()!='') || ($("#user_email").val().trim()!='') || ($("#user_phone").val().trim()!='') || ($("#user_address").val().trim()!='')
			   || ($("#user_designation").val().trim()!='') || ($("#user_company").val().trim()!='') || ($("#user_category").val().trim()!='')){
			$('#discardPopup').modal('show');
			return;
			
		}
	 }

 function editUserConfirmModal(id){//Tajinder 09-10-2018
	 if(($("#name_of_user").val().trim()!='') || ($("#user_email").val().trim()!='') || ($("#user_phone").val().trim()!='') || ($("#user_address").val().trim()!='')
			   || ($("#user_designation").val().trim()!='') || ($("#user_company").val().trim()!='') || ($("#user_category").val().trim()!='')){
				//$('#discardPopup').modal('show');
			$("#editCurrentUserIdForModal").val(id);
			$('#discardEditPopup').modal('show');
				return;
				
		}else{
			$("#editCurrentUserIdForModal").val(id);
			editCurrentUser();
		}
	}
 /******* TAJINDER 08-01-2018 END ********/ 
</script>
<!-- ABDUS UPLOAD FILE END -->
<script src="js/dynamitable.jquery.min.js" type="text/javascript"></script>
<style>

@media print {
#participant_eventName{
	color:blue!important
}
}
/* .show-scroll {
   height:300px;
    overflow-y:auto;
}
 */
</style>