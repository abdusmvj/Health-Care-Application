<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create/Edit Schedule</title>
<style type="text/css">

thead.fixedHeader tr {
	
}

/* set THEAD element to have block level attributes. All other non-IE browsers            */
/* this enables overflow to work on TBODY element. All other non-IE, non-Mozilla browsers */

/* make the TH elements pretty */
thead.fixedHeader th {
	
}

html>body tbody.scrollContent {
	display: block;
	height: 262px;
	overflow: auto;
	width: 100%
}

html>body thead.fixedHeader {
	display: table;
	overflow: auto;
	width: 100%
}

/* make TD elements pretty. Provide alternating classes for striping the table */
/* http://www.alistapart.com/articles/zebratables/                             */
tbody.scrollContent td, tbody.scrollContent tr.normalRow td {
	
}



tbody.scrollContent tr.alternateRow td {
	
}
</style>
</head>

<%@include file="common/header.jsp"%>
 
<body>



<div class="container">
<%@include file="common/menu.jsp"%>

		<div class="alert" id="eventEditAlert"></div>
		
<div class="panel panel-default">				
 <div class="panel-body custom-event-form-design custom-body"> 	 
			   
			 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 

					<div class="form-group left">
					<!-- Sriparna css -->
					<div class="col-lg-1 " >
					</div>
						<div class="col-lg-2 " >
							<label class="control-label " for="event_name"> Event
								 <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-8">
							<!-- <input type="text" class="form-control" id="event_name"
								placeholder="Event Name" name="event_name" /> -->
							<select name="eventnameid" id="eventnameid" class="form-control" onchange="populateAllScheduleListData();" >
						         <option value="-1">Select Event Name</option>
			                     <c:forEach var="eventNameListValue" items="${eventNameListData}">
									<option value ="${eventNameListValue.id}"><c:out value="${eventNameListValue.event_name}"/></option>
								</c:forEach>
		                    </select>
						</div>
					</div>
				</div>   
				
				<br>
				<br>
					<br>
			   	
			   
  <div  id="show-list-table-div" class="table table-hover"> 
		<table
			class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable table table-bordered"  >
			<thead class="fixedHeader">
				<tr>
					<th width="1%">#</th>
					<!-- <th  width="18%">Event Id<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span></th> -->
					<th  width="12%">Schedule Name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="32%">Description<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="18%">Schedule Date<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th  width="12%">Start Time<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					
					<th  width="12%">End Time<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
				<!-- 	<th  width="6%">Is Active</th> -->
					<th  width="6%"></th>
					<th  width="4%"></th>
				</tr>
				  <tr>
				  <th></th>
          <th> <!-- input filter -->
            
            <input  class="js-filter  form-control form-square " type="text" value="">
          </th>
        <!--  <th><input class="js-filter  form-control" type="text" value=""></th>
           <th><input class="js-filter  form-control" type="text" value=""></th> -->
          <th><input class="js-filter  form-control form-square " type="text" value=""></th>
          <th><input class="js-filter  form-control form-square " type="text" value=""></th>
            <th><input class="js-filter  form-control form-square " type="text" value=""></th>
              <th><input class="js-filter  form-control form-square " type="text" value=""></th>
               
                  <th></th>
                  <th></th>
                  
        </tr>
        
			</thead>
			<tbody id="editMenuTbody" class="scrollContent">

			</tbody>
		</table>
		</div>
	</div>
	</div>
	 </div> 
	<!-- form container create here -->
	
		<div class="container" id="edit-update-form">

		<form class="form-horizontal feedback" id="participantScheduleForm" modelAttribute="scheduleModel">
		<div id="msg" class="alert alert-success fade in">
           <center>  <font color="green"><strong><span id="editEventPanelFormHeading"></span></strong></font></center>
        </div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<span> <!-- id="editEventPanelFormHeading" --><strong>Create / Edit
							Schedules</strong></span>
					<button type="reset" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right"
						id="create_event" name="create_event"  onclick="createNewSchedule();" ><i class="fa fa-plus" aria-hidden="true"></i> Create
						New</button>
				</div>

				<div class="panel-body custom-event-form-design ">
					<input type="hidden" id="participant_id_hidden" name="participant_id_hidden"
						value="-1" />
						<input type="hidden" id="event_Id_hidden" name="event_Id_hidden"
						value="-1" />
						
			    <div class="row">
                  
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
				<div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label" for="schedule_name" >Schedule Name
								 <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="schedule_name"
								placeholder="Schedule Name" name="schedule_name"/>
						</div>
					</div>
				</div>
				
				
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
                   <div class="form-group right">
						<div class="col-lg-4">
							<label class="control-label " for="schedule_date">Schedule Date <span class="manadatory">*</span>  :</label>
						</div>
						<div class="col-lg-6" >						
							<div class='input-group date'  id='schedule_dateDIV' >
			                    <input type='text' class="form-control"  id='schedule_date' placeholder="Schedule Date" name="schedule_date" />
			                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
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
                        <label class="control-label" for="schedule_starttime">Schedule Start Time <span class="manadatory">*</span>  :</label>
                     </div>
                     <div class="col-lg-6" >
                      <div class='input-group date'  id='schedule_starttimeDIV' >
                       <input type='text' class="form-control"  id="schedule_starttime" placeholder="Schedule Start Time" name="schedule_starttime"  onblur="enableDisable_Endtime();" />
                       <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                      </span>
                     
                     </div>
                     
                     
                    </div>
                  </div>
                 </div>
                 
                 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					 <div class="form-group right">
					 <div class="col-lg-4">
                    <label class="control-label" for="schedule_endtime"  >Schedule End Time <span class="manadatory">*</span>  :</label>
                    </div>
                    <div class="col-lg-6">
                      <div class='input-group date'  id='schedule_endtimeDIV'>
	                    <input type='text' class="form-control"  id='schedule_endtime' placeholder="Schedule End Time" name="schedule_endtime" />
	                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-time"></span>
                     </span>
                     
                    </div>
                    
                     <span  id="errormsg" style="color: #a94442;"></span>
                  </div>
                  
                  			
				</div>
				</div>
                 
                 </div>
				<br>
					
				 
				 
				 
				 <div class="row">           
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					<div class="form-group left">
						<div class="col-lg-4">
							<label class="control-label" for="description">Description  :</label>
						</div>
													
						  <div class="col-lg-6">
							<textarea type="text" class="form-control" id="description"
								placeholder="Schedule Description" name="description" ></textarea>
						</div>					
						
					</div>					
				 </div>
				 
				
				 
					
				</div>
					<br>
					
				
					
						
					
					<br>
					<div class="form-group pull-right">
						<div class="col-sm-offset-2 col-sm-10">  	<!-- 	Sriparna css -->
							<button type="button" class="btn btn-default btn-primary save-btn" id="update_schedule"
								name="update_schedule" style="margin-right: 650px;" onclick="updateEditedParticipant();">Save</button>
								
								
						
					</div>
                     
                     

				</div>
			</div>
			</div>
	</form>

</div>

<!-- Modal -->
	<div class="modal fade" id="deletetoScheduleModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteScheduleIdForModal"
					id="deleteScheduleIdForModal" val="-1">
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Schedule</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Are you sure you want to delete this record "<span class="currentScheduleNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentScheduleRecordRow($('#deleteScheduleIdForModal').val());">Delete</button>
				</div>				
			</div>
		</div>
	</div>

    <!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">

				<input type="hidden" name="currentEventIdForActiveInModal"
					id="currentEventIdForActiveInModal" value="-1">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>	Schedule Event<!-- <span class="currentEvcentNameForModal"></span> --> </strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to make event "<span class="currentEvcentNameForModal"></span> " active ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="setActiveFromModal($('#currentEventIdForActiveInModal').val());">Make
						Active</button>
				</div>
			</div>

		</div>
	</div>
	
<%@include file="common/footer.jsp"%>
</body>

<script src="js/pageJS/add-edit-schedule.js" type="text/javascript"></script>
 <script>
 
 /* $(document).ready(function () {
	    $('#schedule_dateDIV').datetimepicker({
	    	format: 'MM/DD/YYYY',
	        startDate: '-180d',
	        endDate: '+1d',
	        useCurrent: false,
	        autoclose: true
	    });
	}); */
	
	$('#schedule_endtimeDIV').click(function(){
		// alert("hhh11");
		  $(this).datetimepicker();
		  
		  if($('#schedule_starttime').val()==null || $('#schedule_starttime').val()=='')
		  {	 
			 
			  $('#schedule_endtime').attr('disabled', true);
			  $('#errormsg').html('Plase enter schedule start time first');
			 
		  }
		 else
			 {
			    $('#schedule_endtime').attr('disabled', false);
			    $('#errormsg').html('');
			 }
		});
	
	
	  function enableDisable_Endtime()
     {
    	 
    	 if($('#schedule_starttime').val()==null || $('#schedule_starttime').val()=='')
		  {	 
			 
			  $('#schedule_endtime').attr('disabled', true);
			 
		  }
		 else
			 {
			    $('#schedule_endtime').attr('disabled', false);
			    $('#errormsg').html('');
			 }
     } 
		
		/*   var start_time=$("#schedule_starttime").val();
		  var end_time=$("#schedule_endtime").val();
		 var dtStart_time = new Date("1/1/2011 " + start_time);
		 var dtEnd_time = new Date("1/1/2011 " + end_time);
		 var difference_in_milliseconds = dtEnd_time - dtStart_time;
		 if (difference_in_milliseconds <= 0)
		 {
			// document.getElementById("errormsg").innerHTML = "End time should be greater than start time !";
			// $("#schedule_endtimeDIV").bootstrapValidator('validate').has('.has-error').length === 1;
		 }
		 else
			 {
			     document.getElementById("errormsg").innerHTML = "";
			     $("#schedule_endtimeDIV").bootstrapValidator('validate').has('.has-error').length === 0;
			 }  */
		
		
     
 </script>
<!-- <script src="js/jquery-1.11.3.min.js"></script>  -->

<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script> 
</html>