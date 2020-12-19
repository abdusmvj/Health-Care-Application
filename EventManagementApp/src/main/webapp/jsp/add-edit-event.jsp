<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create/Edit Event</title>
</head>
<%@include file="common/header.jsp"%>
 <script src="js/pageJS/addEditEvent.js" type="text/javascript"></script>
 

 
<body>


	<div class="container">
<%@include file="common/menu.jsp"%>
</div>
<div class="wrapper-space">
<div class="container">
		<div class="alert" id="eventEditAlert"></div>
		
		<!-- Sriparna issue log 27-12-2017 -->
		<div class="panel panel-default">
				<div class="panel-heading">
					<span id="editEventPanelFormHeading"><strong>Existing Events
							</strong></span>					
				</div>
		<div class="panel-body custom-event-form-design custom-body ">
 
 <div  id="show-list-table-div">
		<table
			class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable     table table-bordered"  >
			<thead>
				<tr>
					<th width="2%">#</th>
					<th  width="18%">Event Name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="15%">Venue<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<!-- <th  width="10%">About Us<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span></th>
					 -->
					<th  width="18%">Start Date<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="18%">Start Time<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="18%">End Date<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="10%">End Time<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					
					
					<!-- Sriparna issue log 27-12-2017 -->
					<th  width="6%">Active</th>
					<th  width="6%"></th>
					<th  width="4%"></th>
					
				</tr>
				  <tr>
				  <th></th>
          <th> <!-- input filter -->
            
            <input  class="js-filter  form-control form-square " type="text" value="">
          </th>
          <th><input class="js-filter  form-control form-square " type="text" value=""></th>
         <!--  <th><input class="js-filter  form-control" type="text" value=""></th> -->
          <th><input class="js-filter  form-control form-square " type="text" value=""></th>
          <th><input class="js-filter  form-control form-square " type="text" value=""></th>
            <th><input class="js-filter  form-control form-square " type="text" value=""></th>
              <th><input class="js-filter  form-control form-square " type="text" value=""></th>
                <th></th>
                  <th></th>
                  <th></th>
                  
        </tr>
        
			</thead>
			<tbody id="editMenuTbody">

			</tbody>
		</table>
		</div>
		</div>
		</div>
	<!-- </div>

	<div class="container" id="edit-update-form"> -->

		<form class="form-horizontal feedback" id="eventForm">
		<div id="msgEv" class="alert alert-success fade in">
           <center>  <font color="green"><strong><span class="editEventPanelFormHeading"></span></strong></font></center>
        </div>
			<div class="panel panel-default">
				<div class="panel-heading">
				
				<!-- Sriparna issue log 27-12-2017 -->
					<span> <!-- id="editEventPanelFormHeading" --><strong>Create / Edit
							Event</strong></span>
					<button type="button" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right"
						id="create_event" name="create_event"  onclick="createNewEvent();" ><i class="fa fa-plus" aria-hidden="true"></i> Create
						New</button>
				</div>

				<div class="panel-body custom-event-form-design ">
					<input type="hidden" id="event_id_hidden" name="event_id_hidden"
						value="-1" />
						
			    <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 

					<div class="form-group left">
						<div class="col-lg-4 ">
							<label class="control-label " for="event_name">Event
								Name <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="event_name"
								placeholder="Event Name" name="event_name" />
						</div>
					</div>
				</div>
				
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
				<div class="form-group right">
						<div class="col-lg-4">
							<label class="control-label" for="event_venue" >Event
								Venue <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="event_venue"
								placeholder="Event Venue" name="event_venue" />
						</div>
					</div>
				</div>
			</div>	
				<br>
				   <div class="row">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label " for="eventStartDate">Event
								Start Date <span class="manadatory">*</span>  :</label>
						</div>
						<div class="col-lg-6" >						
							<div class='input-group date'  id='eventStartDateDIV' >
			                    <input type='text' class="form-control"  id='eventStartDate' placeholder="Event Start Date" name="eventStartDate" onpaste="return false"/>
			                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                           </div>				
					   </div>		
					</div>
					</div>
					
					 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 					
					 <div class="form-group right">
					 <div class="col-lg-4">
                        <label class="control-label" for="eventStartTime">Event Start Time <span class="manadatory">*</span>  :</label>
                     </div>
                     <div class="col-lg-6" >
                      <div class='input-group date'  id='eventStartTimeDIV' >
                       <input type='text' class="form-control"  id="eventStartTime" placeholder="Event Start Time" name="eventStartTime" onpaste="return false"/>
                       <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                      </span>
                     
                     </div>
                    </div>
                  </div>
                 </div>
                 </div>
				<br>
					
				 <div class="row">                
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					<div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label" for="eventEndDate">Event
								End Date <span class="manadatory">*</span>  :</label>
						</div>
						<div class="col-lg-6">							
						  <div class='input-group date'  id='eventEndDateDIV'>
			                  <input type='text' class="form-control"  id='eventEndDate' placeholder="Event End Date"  name="eventEndDate" onpaste="return false"/>
			                  <span class="input-group-addon">
                              <span class="glyphicon glyphicon-calendar"></span>
                              </span>
                         </div>						
						</div>
					</div>					
				 </div>
				 
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					 <div class="form-group right">
					 <div class="col-lg-4">
                    <label class="control-label" for="eventEndTime"  >Event End Time <span class="manadatory">*</span>  :</label>
                    </div>
                    <div class="col-lg-6">
                      <div class='input-group date'  id='eventEndTimeDIV'>
	                    <input type='text' class="form-control"  id='eventEndTime' placeholder="Event End Time" name="eventEndTime" onpaste="return false" />
	                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                     </span>
                    </div>
                  </div>				
				</div>
				</div>
				</div>
					<br>
					
					 
				<!-- 	<div class="form-group">
						<div class="col-lg-4 ">
							<label class="control-label " for="about_us">About Us:</label>
						</div>
						<div class="col-lg-6">
							<textarea type="text" class="form-control" id="about_us"
								placeholder="About Us" name="about_us"> </textarea>
						</div>
					</div> -->
					
						
					
					<br>
					<div class="form-group pull-right">
						<div class="col-sm-offset-2 col-sm-10">  	<!-- 	Sriparna css -->
							<button type="button" class="btn btn-default btn-primary save-btn" id="update_event"
								name="update_event" style="margin-right: 650px;"
								" onclick="updateEditedEvent();">Save</button>
						</div>
					</div>


				</div>
			</div>
	</form>

</div>

</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">

				<input type="hidden" name="currentEventIdForActiveInModal"
					id="currentEventIdForActiveInModal" value="">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" onclick="returnOldEvents();">&times;</button> 
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>	Activate Event<!-- <span class="currentEvcentNameForModal"></span> --> </strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						 <strong><span class="currentEvcentNameForModal"></span> </strong>
						<!-- <strong>Do you want to make event "<span class="currentEvcentNameForModal"></span> " active ?</strong> -->
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;" onclick="returnOldEvents();">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="setActiveFromModal($('#currentEventIdForActiveInModal').val());" id="makeActive">Make
						Active</button>
				</div>
			</div>

		</div>
	</div>
	
	<!-- Sriparna issue log 27-12-2017 -->
	<!-- Modal -->
	<div class="modal fade" id="deleteModal" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteEventIdForModal"
					id="deleteEventIdForModal" val="-1">
					
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Event</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to delete event "<span class="currentEventNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentEvent();">Delete</button>
				</div>
				
			</div>

		</div>
	</div>
	
	
		<!-- Sriparna issue log 27-12-2017 -->
	<!-- Modal -->
	<div class="modal fade" id="popup" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">				
				<div class="modal-header">
				 <button type="button" class="close" data-dismiss="modal">&times;</button> 
					<h4 class="modal-title" style=" color: #0e537b;">						 
					<strong>Delete Event</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>		
						<strong>This is currently active event. Please make another event active to delete this one!</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
				</div>				
			</div>
		</div>
	</div>
	
	
	
		<!-- Sriparna issue log 28-12-2017 -->
	<!-- Modal -->
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
						onclick="resetForm();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="discardEditPopup" role="dialog">
		<div class="modal-dialog">
				<!-- Modal content-->
			<div class="modal-content cont">				
				<div class="modal-header">
				<input type="hidden" name="editCurrentEventIdForModal"
					id="editCurrentEventIdForModal" val="-1">
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
						onclick="editCurrentEvent();">Yes</button>
				</div>				
			</div>
		</div>
	</div>
	
<input type="hidden" name="currentlyActive"  id="currentlyActive"  value="-1"  />

<input type="hidden" name="resetData"  id="resetData"  value="-1"  />
<%@include file="common/footer.jsp"%>
</body>
<!--  <script src="js/jquery-1.11.3.min.js"></script>  -->

<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script> 
</html>


<!-- <style>
.show-scroll {
	max-height: 300px;
}
</style> -->