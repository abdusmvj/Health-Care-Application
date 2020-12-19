<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <%@include file="common/scriptTags.jsp"%>  --%>
<title>Create/Edit Activity</title>
</head>
<%@include file="common/header.jsp"%>
<script src="js/pageJS/addEditActivity.js" type="text/javascript"></script>
 
<body>

<div class="container">
<%@include file="common/menu.jsp"%>

<div class="alert" id="eventEditAlert"></div>

<form:form action="javascript:return;" method="get" id="activity">

<div class="panel panel-default">
				
 <div class="panel-body custom-event-form-design custom-body"> 
			    <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <!-- Sriparna css -->
					<div class="form-group selectEvent">
					<div class="col-lg-1 ">
					</div>
						<div class="col-lg-3 ">
								<label class="control-label " for="event_name">  Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-8">
								<select id="event_Id" name="event_Id" class="form-control inp ploaceholderinp" onchange="populateActivities();">									           						
								</select>
						</div>
					</div>
				  </div>			
			   </div>	
			   <br>
			   
			  
			   
			   
	    <div  id="show-list-table-div"><!-- show-list-table-div -->
		<table class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable table table-bordered">
			<thead>
				<tr>
					<th width="2% !important">#</th>
					<th  width="18% !important">Activity Name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="15% !important">Venue<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>			
					<th  width="22% !important">Authentication Req<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="18% !important">One-Time Pass<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="18% !important">Reset on Exit<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>				
					<th  width="6% !important">Edit</th>
					<th  width="4% !important">Delete</th>
				</tr>
			 <tr>
				  <th width="2% !important"></th>
				 <!--  input filter -->
                  <th width="18% !important"><input  class="js-filter  form-control form-square" type="text" value=""></th>
                  <th width="15% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  <th width="22% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  <th  width="18% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  <th width="18% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
                  <th width="6% !important"></th>
                  <th width="4% !important"></th>            
                  </tr>     
			</thead>
			<tbody id="editMenuTbody">
			</tbody>
		</table>
		</div>
 </div> 
</div>
</form:form>
</div>

	<div class="container" id="edit-update-activity-form">

		<form class="form-horizontal feedback" id="activityForm">
		<div id="msg" class="alert alert-success fade in">
           <center>  <font color="green"><strong><span id="editActivityPanelFormHeading"></span></strong></font></center>
        </div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<span> <!-- id="editEventPanelFormHeading" --><strong>Create / Edit
							Activity</strong></span>
					<button type="button" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right"
						id="create_activity" name="create_activity"  onclick="createNew();" ><i class="fa fa-plus" ></i> Create
						New</button>
				</div>

				<div class="panel-body custom-event-form-design ">
					<input type="hidden" id="activity_id_hidden" name="activity_id_hidden"
						value="-1" />
					<input type="hidden" id="event_Id_hidden" name="event_Id_hidden"
						value="-1" />
						
			    <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 

					<div class="form-group left">
						<div class="col-lg-4 ">
							<label class="control-label " for="activity_name">Activity
								Name <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="activity_name"
								placeholder="Activity Name" name="activity_name" />
						</div>
					</div>
				</div>
				
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
				<div class="form-group right">
						<div class="col-lg-4">
							<label class="control-label" for="venue" >
								Venue <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="venue"
								placeholder="Event Venue" name="venue" />
						</div>
					</div>
				</div>
			</div>	
				<br>
				   <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group left">
						<div class="col-lg-7">
							<label class="control-label " for="is_prtcpt_auth_req" >Participant Authentication Required
								 <span class="manadatory">*</span>  :</label>
						</div>
						<div class="radioStyle col-lg-4" style="margin: -24px 380px 0px !important;">
							<input type="radio"  id="is_prtcpt_auth_req"
								name="is_prtcpt_auth_req" 							
								value="1" 
checked="checked">YES
							<!-- 	Sriparna css -->
								<input type="radio"  id="is_prtcpt_auth_req" 
								name="is_prtcpt_auth_req" 							
								value="0">NO	
						</div>		
					</div>
					</div>
					
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label " for="is_one_time_pass">One-Time Pass
								 <span class="manadatory">*</span>  :</label>
						</div>
						<div class="radioStyle col-lg-6">
							<input type="radio"  id="is_one_time_pass"
								name="is_one_time_pass" 							
								value="1" 
checked="checked">YES
								<!-- 	Sriparna css -->
								<input type="radio"  id="is_one_time_pass"
								name="is_one_time_pass" 							
								value="0">NO	
						</div>		
					</div>
					</div>
					
                 </div>
				<br>
					
				 <div class="row">                
				 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label " for="is_reset_on_exit">Reset on Exit
								 <span class="manadatory">*</span>  :</label>
						</div>
						<div class="radioStyle col-lg-6">
							<input type="radio"  id="is_reset_on_exit"
								name="is_reset_on_exit" 							
								value="1" 
checked="checked">YES
								<!-- 	Sriparna css -->
								<input type="radio"  id="is_reset_on_exit"
								name="is_reset_on_exit" 							
								value="0">NO	
						</div>		
					</div>
					</div>
				    </div>
					<br>
									
					<br>
					<div class="form-group pull-right">
						<div class="col-sm-offset-2 col-sm-10">
					<!-- 	Sriparna css -->
							<button type="button" class="btn btn-default btn-primary save-btn" id="update_activity"
								name="update_activity" style="margin-right: 650px;"
								" onclick="saveUpdateActivity();">Save</button>
						</div>
					</div>


				</div>
			</div>
	</form>

</div>


<!-- Modal -->
	<div class="modal fade" id="deleteActModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteActivityIdForModal"
					id="deleteActivityIdForModal" val="-1">
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Activity</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to delete activity "<span class="currentActivityNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentActivity($('#deleteActivityIdForModal').val());">Delete</button>
				</div>				
			</div>
		</div>
	</div>
	
	<!-- ***********   Tajinder 09-01-2018 STARTS ********************-->
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
						onclick="createNewActivity();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
	
		<div class="modal fade" id="discardEditPopup" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">				
				<div class="modal-header">
				<input type="hidden" name="editCurrentActivityIdForModal"
					id="editCurrentActivityIdForModal" val="-1">
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
						onclick="editCurrentActivity();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
	
	<!-- ***********   Tajinder 09-01-2018 END ********************-->
<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script>
 <%@include file="common/footer.jsp"%>
</body>
</html>