var participantList;
$(document).ready(function() {
  getEventDetails();
  $("#addAllPaticipants").on("click", function() {
    if (document.getElementById("addAllPaticipants").checked) {
    	$("#participantId").val("");
    	$("#participantId").prop("disabled", true);
    } else {
      $("#participantId").prop("disabled", false);
    }
  });
  
  
	$("#userActivityMappingId").bootstrapValidator({
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
             activityId: {
                validators: {
                    notEmpty: {
                    	message: 'Please select the Activity.'
                    }
                }
            },
            participantId: {
                validators: {
                    notEmpty: {
                    	message: 'Please select the Participant.'
                    }
                }
            }
          
        }
    }).on('click', '[name="addAllPaticipants-checkbox"]', function() {
    	           
    	if (document.getElementById("addAllPaticipants").checked) {
    		$("#participantDiv").hasClass("has-error")?$("#participantDiv").removeClass("has-error"):$("#participantDiv").addClass("has-success");
        	$("#participantDiv .help-block").hide();
        	$("#participantDiv .form-control-feedback").removeClass("glyphicon-remove").addClass("glyphicon-ok");
        	
    	  } else {
    		  	$('#userActivityMappingId').bootstrapValidator('revalidateField', 'participantId');  
    	  }
    	
    	});

});
function getEventDetails() {
  $.ajax({url:"fetchallevents", type:"GET"}).done(function(e) {
    console.log("Event List");
    console.log(e);
    $("#eventId").empty();
    $("#eventId").append('<option value="">Please Select...</option>');
    var addOption = "";
    $.each(e, function(e, i) {
      addOption = $('<option value="' + i.id + '">' + i.event_name + "</option>");
      $("#eventId").append(addOption);
    });
  }).fail(function(a, b) {
    alert("failure");
  });
}
function getParticipantList() {
  $("#editMenuFieldNameTbody").empty();
  var eventId = $("#eventId").val();
  $.ajax({url:"getParticipantListByEventId", data:{eventId:eventId}, type:"GET"}).done(function(e) {
    participantList = e;
    console.log("Participant List");
    console.log(e);
    $("#participantId").empty();
    $("#participantId").append('<option value="">Please Select...</option>');
    var addOption = "";
    $.each(e, function(e, i) {
      addOption = $('<option value="' + i.id + '">' + i.name + "</option>");
      $("#participantId").append(addOption);
    });
  }).fail(function(a, b) {
    alert("failure");
    console.log(e);
  });
}
function getActivityList() {
  $("#editMenuFieldNameTbody").empty();
  var eventId = $("#eventId").val();
  $.ajax({url:"getActivityListByEventId", data:{eventId:eventId}, type:"GET"}).done(function(e) {
    console.log("Activity List...");
    console.log(e);
    $("#activityId").empty();
    $("#activityId").append('<option value="">Please Select...</option>');
    var addOption = "";
    $.each(e, function(e, i) {
      addOption = $('<option value="' + i.id + '">' + i.activity_name + "</option>");
      $("#activityId").append(addOption);
    });
  }).fail(function(a, b) {
    alert("failure");
    console.log(e);
  });
}
function checkUserActivityExist() {
  var event_Id = $("#eventId").val();
  var activity_Id = $("#activityId").val();
  var participant_Id = $("#participantId").val();
  $.ajax({url:"checkUserActivityExist", type:"POST", data:new FormData(document.getElementById("userActivityMappingId")), enctype:"multipart/form-data", processData:!1, cache:!1, contentType:!1}).done(function(a) {
    $("#successMsg").html(a);
    $("#msg").fadeTo(2000, 500).slideUp(500, function() {
      $("#msg").slideUp(500);
    });
  }).fail(function(a, b) {
    $("#successMsg").html("Something Error Occured");
    $("#msg").fadeTo(2000, 500).slideUp(500, function() {
      $("#msg").slideUp(500);
    });
  });
}
function registerParticipantWithActivity() {
	$("#userActivityMappingId").bootstrapValidator("validate");
	
var a = $("#userActivityMappingId").data("bootstrapValidator");
if (a.validate(), a.isValid()) {
  var event_Id = $("#eventId").val();
  var activity_Id = $("#activityId").val();
  var participantId = $("#participantId").val();
  var a = [];
  if (document.getElementById("addAllPaticipants").checked) {
    $.each(participantList, function(participantList, i) {
      a.push(i.id);
    });
  } else {
    a.push(participantId);
  }
  var f = new FormData;
  f.append("participant_Id", a);
  f.append("eventId", event_Id);
  f.append("activity_Id", activity_Id);
  $.ajax({type:"POST", url:"registerparticipantwithactivity", data:f, processData:false, contentType:false, success:function(response) {
    
    console.log(response);
    if (response == "The participant is register Successfully.") {
      $("#msg").removeClass("alert-danger").addClass("alert-success");
    } else {
      $("#msg").removeClass("alert-success").addClass("alert-danger");
    }
    $("#successMsg").html(response);
    $("#msg").fadeTo(2000, 500).slideUp(500, function() {
      $("#msg").slideUp(500);
    });
    populateListBasedOnEventAndActivity();
  }, error:function(response) {
    console.log(response);
    $("#msg").removeClass("alert-success").addClass("alert-danger");
    $("#successMsg").html("Something Error Occured");
    $("#msg").fadeTo(2000, 500).slideUp(500, function() {
      $("#msg").slideUp(500);
    });
  }});
    }
}
;


function populateListBasedOnEventAndActivity(){
	var eventId=$("#eventId").val();
	var activityId=$("#activityId").val();
	
	 var f = new FormData();
		
		
		f.append('eventId',''+eventId);
		f.append('activityId',''+activityId);
		
		$.ajax({    //create an ajax request to display.php          
	        type: "POST",
	        url: "fetchParticipantDetailsByEventAndActivityId",             
	        data: f,
	        processData: false,
			contentType: false,
	        success: function(response){                    
	        	
	        	 $("#editMenuFieldNameTbody").html('');
	        	  var  menuHTML='';
	                var count =0;
	                
	                for(var y=0; y<response.length; y++){
	 	            count++;
	 	                 menuHTML=''+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
	 	                  '<td>'+count  +'</td>'+
	 	                  '<td><div id="row_menu_field_name_'+response[y].user_mapping_id +'"   >'+response[y].username  +'</td>'+
	 	                 '<td><div id="row_menu_field_name_'+response[y].user_mapping_id +'"   >'+response[y].email_id  +'</td>'+
	 	                 /* '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" onclick="editCurrentMenuFieldName('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button> '+
	 	                  '</div> </td>'+*/
	 	                 '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary"  data-toggle="modal" data-target="#deleteUserMappingModal" onclick="deleteUserMappingIdModal('+response[y].user_mapping_id+');"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> '+
	 	                  '</div> </td>'+
	 	                   ' </tr>';
	 	               $("#editMenuFieldNameTbody").append(menuHTML);
	 	               }
	            },
	        error: function(response){                    
	        	console.log(response);
	        }
		    });
}

function deleteUserMappingIdModal(userMappingId){
	 $('.currentMenuFieldNameForModal').html(""+$("#row_menu_field_name_"+userMappingId).html());	
	 $("#deleteUserMappingIdForModal").val(userMappingId);
}

function deleteUserMapping(){
	var userMappingId =  $('#deleteUserMappingIdForModal').val();
	
	 
	var	  f = new FormData();
	 f.append('userMappingId', ''+userMappingId);
	$.ajax({    //create an ajax request to display       
	        type: "POST",
	        url: "deleteuserMappingById",             
	        data: f,
	        processData: false,
			contentType: false,
	        success: function(response){                    
	       	 if((''+response)===(''+1)){
	   	 		 $("#eventEditAlert").show();
	   	 		$("#eventEditAlert").removeClass("alert-danger");
	   	        	   $("#eventEditAlert").addClass("alert-success");
	   	        	   $("#eventEditAlert").html("Successfully deleted!");	
	   	        	   $("#eventEditAlert").delay(1000).fadeOut("12000");	
	   	        	   populateListBasedOnEventAndActivity();
	   	        	 
	   	      }
	   	           else{
	   	      		 $("#eventEditAlert").show();
	   	      		$("#eventEditAlert").removeClass("alert-success");
	   	        	   $("#eventEditAlert").addClass("alert-danger");
	   	        	   $("#eventEditAlert").html("Failed to delete!");	
	   	        	   $("#eventEditAlert").delay(1000).fadeOut("12000");	
	   	            } 
	            console.log(response);
	            },
	        error: function(response){  
	       	 
		      		 $("#eventEditAlert").show();
		      		$("#eventEditAlert").removeClass("alert-success");
		        	   $("#eventEditAlert").addClass("alert-danger");
		        	   $("#eventEditAlert").html("Failed to delete! Unknown error...");	
		        	   $("#eventEditAlert").delay(1000).fadeOut("12000");	
		            
	       	 console.log(response);
	       	
	        }
		    });

	
	

}