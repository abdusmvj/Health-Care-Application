<html>
<head>
<%@include file="common/scriptTags.jsp"%> 
<script src="js/pageJS/userActivityMapping.js" type="text/javascript"></script>
<style>
.form-control-feedback {
   /*  padding-top: 0px !important;
    padding-right: 47px; */
}
</style>
<title>Map User Activity</title>
</head>
<body>
<div class="container">
<%@include file="common/menu.jsp"%>

		

		
	</div>
	<div class="wrapper-space">
  		<div class="container" id="edit-update-form" >

		<form:form  action="javascript:return;" method="post" modelAttribute="userActivityMappingId" id="userActivityMappingId" enctype="multipart/form-data">
		<div class="alert fade in alert-dismissable" id="eventEditAlert"></div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<label><span class="field-name">Map User Activity</span></label>
					
				</div>
				
				
				<div class="panel-body custom-event-form-design ">
				
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group left has-feedback">
							<div class="col-lg-3 ">
								<label class="control-label " for="eventId">Event <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-8">
								<select id="eventId" name="eventId" class="form-control inp ploaceholderinp" onchange="getActivityList();getParticipantList();">	
							<option value="">Select Event</option> 						           						
							</select>
									</div>
						</div>
				   </div>
				
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right has-feedback">
							<div class="col-lg-3">
								<label class="control-label" for="facebook_link">Activity <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-8">
								<select id="activityId" name="activityId" class="form-control inp ploaceholderinp" onchange="populateListBasedOnEventAndActivity();">
											<option value="">Select Activity</option> 
					    </select>			
							</div>
						 </div>
				   </div>
				   </div>
			  </br></br></br>	   		
<!-- <div class="col-sm-12"> 




              Event And Activity Dropdown 
             <div class="row" style="margin-bottom: 15px;">
                  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
				<div class="form-group selectEvent">
					<div class="col-lg-4 ">
							<label class="control-label " for="event_name">Event <span class="manadatory">*</span> :</label>
					</div>
					<div class="col-lg-6">
							<select id="eventId" name="eventId" class="form-control inp ploaceholderinp" onchange="getActivityList();getParticipantList();">	
							<option value="">Select Event</option> 						           						
							</select>
					</div>
				</div>
			  </div>			
		   </div>
  
			
			<div class="row" style="margin-bottom: 15px;">
                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
			<div class="form-group selectEvent">
				<div class="col-lg-4 ">
							<label class="control-label " for="activity_name" style="margin-right: 10px;">Activity<span class="manadatory">*</span> :</label>
				</div>
				<div class="col-lg-6">
						<select id="activityId" name="activityId" class="form-control inp ploaceholderinp" onchange="populateListBasedOnEventAndActivity();">
											<option value="">Select Activity</option> 
					    </select>	
				</div>
			</div>
		  </div>			
	   </div>
					
   </div>	 -->
				
		<!-- Respective value List in Table		 -->
		              <div  id="show-list-table-div"  class="col-sm-12">
                                         
  <table id="allEventTable" class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable table table-bordered">
    <thead>
      <tr>
        <th>#</th>
        <th>User Name<span class="js-sorter-desc  glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
        <th>Email<span class="js-sorter-desc  glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>       
                 
         <th></th>
        
        </tr>
      
      <tr>
				  <th></th>
          <th> <!-- input filter -->
            
            <input  class="js-filter  form-control" type="text" value="">
          </th>
          
                   <th>
                    <input  class="js-filter  form-control" type="text" value=""></th>
                   <th></th>
         </tr>
          
      
    </thead>
    <tbody id="editMenuFieldNameTbody" class="show-scroll">
       
    </tbody>
  </table>
  </div>	
  	
	<!-- 	Tajjjinder -->
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		<!-- 	Previous container	 -->
								
			 <!--    <div class="row">
                   <div class="col-lg-10 col-md-10 col-sm-10 col-xs-12"> 

					<div class="form-group ">
						<div class="col-lg-4 ">
								<label class="control-label " for="event_name">Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
								<select id="eventId" name="eventId" class="form-control inp ploaceholderinp" onchange="getActivityList();getParticipantList();">
											<option value="">Select Event</option> 
								</select>
						</div>
					</div>
				</div>
				
			
			</div>	
				<br>
				
					  <div class="row">
                   <div class="col-lg-10 col-md-10 col-sm-10 col-xs-12"> 
                   <div class="form-group">
						<div class="col-lg-4">
							<label class="control-label " for="activity_name" style="margin-right: 10px;">Activity<span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6" >						
								<select id="activityId" name="activityId" class="form-control inp ploaceholderinp">
											<option value="">Select Activity</option> 
								</select>	
					   </div>		
					</div>
					</div>
				</div>
				<br> 
				<div class="">	
					  <div class="row">
                   <div class="col-lg-10 col-md-10 col-sm-10 col-xs-12"> 
                   <div class="form-group" id="participantDiv">
						<div class="col-lg-4">
							<label class="control-label " for="participant_name" style="margin-right: 10px;">Participant<span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6" >						
								<select id="participantId" name="participantId" class="form-control inp ploaceholderinp">
											<option value="">Select Participant</option> 
								</select>	
					   </div>		
					</div>
					</div>
				</div>
				
				<br>
				 <div class="row">
                   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                   <div class="form-group">
						<div class="col-lg-12" style="text-align: center;">
							<input type="checkbox" name= "addAllPaticipants-checkbox" id="addAllPaticipants"  class="check-box-btn"/><label class="control-label " for="addAllPaticipants" style="color:green">&nbsp;Add All Paticipants</label> 
					   </div>		
					</div>
					</div>
				</div>
				 
		<div class="form-group">
						<div class="col-sm-12" style="text-align: center;">
								<button type="button" class="btn btn-default upload-btn" id="addParticipant" onclick="registerParticipantWithActivity();" style="margin-left: 0px !important;"><i class="fa fa-plus" aria-hidden="true"></i>  Add</button>
						</div>
			</div> 


				</div>-->
				<!-- 	Previous container	 -->
				</div>
			</div>
	</form:form>

</div>


<!-- second container -->
 <div   class="container" id="edit-update-menu-field-name">
 
 
<div class="alert fade in alert-dismissable" id="menuFieldNameEditAlert">
   
</div>
<div class="alert alert-success" id="msg" style="text-align: center;">
 					<strong id="successMsg"></strong>
</div> 
<div class="panel panel-default">

  <div class="panel-heading"></i><span id="editMenuPanelFormHeading"><strong></strong>Participant</span> </div>
  <!-- Sriparna css -->
  <div class="panel-body custom-event-form-design">
  <form class="form-inline" id="updateeditedmenufieldname" >
 <!-- <input type="hidden"  id="menu_field_name_id_hidden" name="menu_field_name_id_hidden" value="-1"/> -->
 <div class="col-sm-12">
<div class="col-sm-10"> 
 
    <div class="form-group  col-sm-12">
    <div class="col-lg-4 ">
     <label class="control-label " for="participant_name" style="margin-right: 10px;">Participant<span class="manadatory">*</span> :</label>
     </div>
      <div class="col-sm-6">
       <select id="participantId" name="participantId" class="form-control inp ploaceholderinp">
						<option value="0">Select Participant</option> 
	  </select>	  
      </div>
    </div>
 </div>
 
<!--  gjhjgf -->
<div class="col-sm-10"> 
 
    <div class="form-group  col-sm-12">
    <div class="col-lg-4 ">
    
     </div>
      <div class="col-sm-6" style="text-align: center;">
     <input type="checkbox" name= "addAllPaticipants-checkbox" id="addAllPaticipants"  class="check-box-btn"/><label class="control-label " for="addAllPaticipants" style="color:green">&nbsp;Add All Paticipants</label>
	  </select>	  
      </div>
    </div>
 </div>
 
 
 
	
<!--  ngnghnm -->
 

 
</div>
     <div class="col-sm-12 text-center" style="margin-top: 28px !important;">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">   	
       	<button type="button" class="btn btn-default upload-btn" id="addParticipant" onclick="registerParticipantWithActivity();" style="margin-left: 0px !important;"><i class="fa fa-plus" aria-hidden="true"></i>  Add</button>
      </div>
    </div>
</div>
 </form>

</div>
</div>
 </div>
  </div>


 <!-- Delete Modal -->
	<div class="modal fade" id="deleteUserMappingModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteUserMappingIdForModal"
					id="deleteUserMappingIdForModal" val="-1">
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Menu</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to delete mapping for "<span class="currentMenuFieldNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteUserMapping();">Delete</button>
				</div>				
			</div>
		</div>
	</div>
<%@include file="common/footer.jsp"%>
</body>
 <script src="js/dynamitable.jquery.min.js"/></script> 
</html>