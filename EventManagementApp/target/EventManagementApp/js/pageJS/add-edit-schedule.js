
$( document ).ready(function() {
	// populateAllScheduleListData();
	enableStartEndDate('schedule_dateDIV','schedule_dateDIV');
	enableTimePicker('schedule_endtimeDIV');
	 
	enableTimePicker('schedule_starttimeDIV');
	
	
	$('#schedule_name').on('change input', function(e) {
  	    $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_name');
  	 });
	
/*	$('#description').on('change input', function(e) {
  	    $('#participantScheduleForm').bootstrapValidator('revalidateField', 'description');
  	 });*/
	
	
	$('#schedule_dateDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_date');
	});
	
	$('#schedule_starttimeDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_starttime');
	});
	
	$('#schedule_endtimeDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_endtime');
	});
	
	
	$("#schedule_starttime").keypress(function(e){
	       e.preventDefault();
	    });
	$("#schedule_date").keypress(function(e){
	       e.preventDefault();
	    });
	$("#schedule_endtime").keypress(function(e){
	       e.preventDefault();
	    });
	
	
	
	$('#participantScheduleForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	 
                
        	/*event_id: {
                   validators: {               	  
                    notEmpty: {
                        message: 'Please select atleast one Event name'
                    },
                    
                             
                }
            },*/
        
           schedule_name: {
            validators: {
                notEmpty: {
                    message: 'Schedule name is required and cannot be empty'
                },
                stringLength: {
                    max:100,
                    message: 'The Schedule name be less than 100 characters'
                    
                },
                         
            }
        },
        
        
      
       
        schedule_starttime:{
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                },
                                 
            }
        },
          
        schedule_date:{
	        	 validators: {
                     notEmpty: {
                         message: 'Schedule date is required and cannot be empty'
                     },
                     date: {
                         format: 'YYYY-MM-DD',
                         message: 'The schedule date is invalid',
                        
                     },
                  
                 }
	      }, 
	      schedule_endtime:{
	            validators: {
	                notEmpty: {
	                    message: 'This field is required and cannot be empty'
	                },
	                                  
	            }
	        },
	            
	      
	     /*   description:{
	        	 validators: {
                  notEmpty: {
                      message: 'This field is required and cannot be empty'
                  },
             
              }
	      }, */
		}
			})
	           .on('success.form.bv', function(e) {
			        
			        e.preventDefault();
			      
			    }).on('error.form.bv', function(e) {
			          
			        e.preventDefault();
			      
			          });
	
	
 
	
});



function highlight(ctrl){
	   var elements=document.getElementsByTagName('tr');
	    for(var i=0;i<elements.length;i++)
	        elements[i].style.background='';
	   var parent=ctrl.parentNode.parentNode;
	   parent.style.background="#B0E0E6";
	   
	}



function deleteCurrentScheduleRecordRow(id){
	
	//var confirm_delete =  confirm('Are you sure you want to delete this record?');
  //  if(confirm_delete == true){
      // do your code
	
     
	$("#participant_id_hidden").val(id);
	//$("#editEventPanelFormHeading").html("Currently editing event '"+name+"'. Click save when you are done!");
			
		 var f = new FormData();
		  f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "deleteScheduleModelDetailById",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){  
		        	 
		        // alert(response);
		        	populateAllScheduleListData();
		        	$('#participantScheduleForm').bootstrapValidator('resetForm', true);     //reset schedule form after delete row
		            console.log(response);
		           
		     	  	f.append('participant_id_hidden', '-1');
		     	   $("#participant_id_hidden").val("-1");
		            },
		         error: function(response){  
		        	 $('#msg').show();
		             $("#editEventPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
		             $("#msg").delay(2000).fadeOut("12000");
		         	 console.log(response);
		         }
		 	});
		 	
  }


function editCurrentScheduleModel(id,name){

	$("#participant_id_hidden").val(id);
	 var  f = new FormData();
		 	f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "fetchScheduleModelDetailById",             
		         data: f,
		         processData: false,
		 		  contentType: false,
		         success: function(response){                    
		      
		            
		        	 
		       //   $("#event_id").val(""+response[0].event_id).trigger("change");		      
		          $("#participant_id_hidden").val(""+response[0].id);
		         //  $("#about_us").val(""+(response[0].about_us?response[0].about_us:"")).trigger("change");
		          $("#schedule_name").val(""+(response[0].schedule_name?response[0].schedule_name:"")).trigger("change");
		          $("#schedule_date").val(""+(response[0].schedule_date?response[0].schedule_date:"")).trigger("change");
		          
		          $("#schedule_starttime").val(""+(response[0].schedule_starttime)).trigger("change"); 
		          $("#description").val(""+(response[0].description?response[0].description:"")).trigger("change"); 
		          $("#schedule_endtime").val(""+(response[0].schedule_endtime)).trigger("change");
		          
		           //  $('#participantScheduleForm').bootstrapValidator('validate');
		      	   
		     	   // $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_name');
		     	    $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_date');
		     	    $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_starttime');	
		     	    $('#participantScheduleForm').bootstrapValidator('revalidateField', 'schedule_endtime');
		     	 //   $('#participantScheduleForm').bootstrapValidator('revalidateField', 'description');
		          
		          
		             console.log(response);
		           
		     	  	f.append('participant_id_hidden', '-1');
		            },
		         error: function(response){  
		        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
		        	 $('#msg').show();
		             $("#editEventPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
		             $("#msg").delay(2000).fadeOut("12000");
		         	 console.log(response);
		         }
		 	    });
		
	}


function updateEditedParticipant(){
	
	
	 
	 var a = $("#participantScheduleForm").data("bootstrapValidator");
	 
     // if (a.validate(), a.isValid()) {        //if form is valid den only form will be submitted
	
   	 if($("#participantScheduleForm").bootstrapValidator('validate').has('.has-error').length === 0){
	 
   		 
   		 var a = $("#participant_id_hidden").val()
   	   	 console.log("participant_id_hidden = "+a);
   		 
   		 var eventId = $("#eventnameid").val();	
   		 
   		 
      	 var e = $("#event_Id_hidden").val(eventId);
      	
      	 var e=eventId;
       	 console.log("event_Id_hidden = "+$("#event_Id_hidden").val());
       
        if($("#event_Id_hidden").val() != '-1'){
    		 
   	
   	 
  
	 if(a == -1){
		 
		 var f = new FormData();
		  	f.append('participant_id_hidden', '-1');
		 
	    var id="";
	    f.append('event_Id_hidden', ''+$("#event_Id_hidden").val());
		
		f.append('schedule_name', ''+$("#schedule_name").val());
		 
		f.append('schedule_date', ''+$("#schedule_date").val());
		f.append('schedule_starttime', ''+$("#schedule_starttime").val());
		f.append('description', ''+$("#description").val());
		f.append('schedule_endtime', ''+$("#schedule_endtime").val());
		
		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "saveParticipantData",             
		         data: f,
		         processData: false,
		 		  contentType: false,
		         success: function(response){                    
		        
		            
		         
		             console.log(response);
		            // $('#participantScheduleForm')[0].reset();
		             populateAllScheduleListData();
		             
		             $('#participantScheduleForm').bootstrapValidator('resetForm', true);     //reset schedule form after save or update
		             $('#msg').show();
		             $("#editEventPanelFormHeading").html("Data saved successfully");
		             
		             $("#msg").delay(2000).fadeOut("12000");
		            },
		         error: function(response){  
		        	 $('#msg').show();
		             $("#editEventPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
		             $("#msg").delay(2000).fadeOut("12000");
		         	 console.log(response);
		         }
		 	    });
		
		 
	 }
	 
	 
	 else{
	    var id=$("#participant_id_hidden").val();
	
	    var	f = new FormData();
	  	f.append('participant_id_hidden', ''+id);

         f.append('event_Id_hidden', ''+$("#event_Id_hidden").val());
		
		f.append('schedule_name', ''+$("#schedule_name").val());
		 
		f.append('schedule_date', ''+$("#schedule_date").val());
		f.append('schedule_starttime', ''+$("#schedule_starttime").val());
		f.append('description', ''+$("#description").val());
		f.append('schedule_endtime', ''+$("#schedule_endtime").val());
	  	
 	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updateScheduleModelDataById",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	       
	            
	      /*if((''+response)===(''+1)){
	        	   
	        	   $("#eventEditAlert").addClass("alert-success");
	        	   $("#eventEditAlert").html("Successfully updated &#39;"+$("#row_event_name_"+id).val()+"&#39;");	     
	        	   $("#participant_id_hidden").val(-1);
	           }
	           else{
	        	   
	        	   $("#eventEditAlert").addClass("alert-danger");
	        	   $("#eventEditAlert").html("Failed to update &#39;"+$("#row_event_name_"+id).val()+"&#39;");	        	   
	             
	           } */
		    
	             console.log(response);
	             
	             populateAllScheduleListData();
	             $('#participantScheduleForm').bootstrapValidator('resetForm', true);    //reset schedule form after save or update
	             $("#participant_id_hidden").val(-1);
	             f.append('participant_id_hidden', '-1');
	             $('#msg').show();
	             $("#editEventPanelFormHeading").html("Data updated successfully");
	             $("#msg").delay(2000).fadeOut("12000");
	            },
	         error: function(response){  
	        	 $('#msg').show();
	             $("#editEventPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
	             $("#msg").delay(2000).fadeOut("12000");
	         	 console.log(response);
	         }
	 	    });
	 }
	 
        }
        else{
        	 $('#msg').show();
             $("#editEventPanelFormHeading").html("Please select an Event Name to proceed !!");	             
             $("#msg").delay(3000).fadeOut("12000");
        }
	 
	 
	 
    }
}


function enableStartEndDate(s,e){
	
	$('#'+s).datetimepicker({format: 'YYYY-MM-DD',useCurrent: false //Important! See issue #1075
		});
    $('#'+e).datetimepicker({format: 'YYYY-MM-DD',
        useCurrent: false //Important! See issue #1075
    });
    
    /*  $("#"+s).on("dp.change", function (ev) {
        $('#'+e).data("DateTimePicker").minDate(ev.date);
    });
   
   $("#"+e).on("dp.change", function (ev) {
        $('#'+s).data("DateTimePicker").maxDate(ev.date);
    });*/
	
}
function enableTimePicker(s){
	
	 $('#'+s).datetimepicker({format: 'LT',
        useCurrent: false //Important! See issue #1075
       
    });
     
	
}



function populateAllScheduleListData(){  //pass id in this function
	
	var eventId = $("#eventnameid").val();
	
	
	 $.ajax({    //create an ajax request to display.php
	        type: "GET",
	        url: "fetchallScheduleList",   
	        data: {id:eventId},
	        dataType: "html",   //expect html to be returned                
	        success: function(response){                    
	             //alert(response);
	        	$("#editMenuTbody").html('');
	              response = JSON.parse(response);
	                var  menuHTML='';
	                var count =0;
	                var schedule_date='';
	              for(var y=0; y<response.length; y++){
	            count++;
	            schedule_date='';
	            if(response[y].schedule_date!=null){
	            	schedule_date=response[y].schedule_date;
	            }
	            
	           
	            var starttime = response[y].schedule_starttime;   
	        	arr= starttime.split(":");
	        	start_time_hhmm = $.trim(arr[0]) + ":" + $.trim(arr[1]);
	        	
	        	var endtime = response[y].schedule_endtime;
	        	ar= endtime.split(":");
	        	end_time_hhmm = $.trim(ar[0]) + ":" + $.trim(ar[1]);
	        		            
	            
	            menuHTML=menuHTML+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
                '<td>'+count  +'</td>'+
                
                 
              /*  
                '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div     id="row_event_name_'+response[y].id+'"   > '+  (response[y].event_id?response[y].event_id:'') +'</div></div></div></td>'+
                
                */
                
                '<td>   <div class="col-sm-12"><div id="row_schedule_name_'+response[y].id+'" > '+(response[y].schedule_name?response[y].schedule_name:'') +' </div></div></div></td>'+
              
                
                '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div  id="row_event_aboutus_'+response[y].id+'"   > '+  (response[y].description?response[y].description:'') +'</div></div></div></td>'+
               
                
                   
                '<td><div class="form-group"><div class="input-group" id="eventStartDateDIV_'+response[y].id+'" >'+
                ' <div class="col-sm-12">'+
              '  <div id="row_event_start_'+response[y].id+'" > '+  (response[y].schedule_date?response[y].schedule_date:'') +'</div></div> '+
              '</div> </div></td>'+
                
              '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div type="time" id="row_schedule_starttime_'+response[y].id+'"  >'+  (start_time_hhmm) +'</div></div> '+
              '</div></td>'+
              
               
            
              
              
          
              '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div  type="time" id="row_schedule_endtime_'+response[y].id+'">'+  (end_time_hhmm) +'</div></div></div></td>'+
                
                
               /* '<td><div class="checkbox">'+
               ' <label><input type="checkbox" style="margin-left: 0px;" '+((''+response[y].is_event_active).trim()===(''+1)?'checked':'')+' value="'+ response[y].id +'" class="is-active-class" onclick="uncheckOthers($(this),'+response[y].id+');" data-toggle="modal" data-target="#myModal" id="is_active_check_'+response[y].id+'"></label>'+
              '  </div></td>'+*/
              
              
              
              '<td>  <button type="button" class="btn btn-default btn-primary" onclick="highlight(this);editCurrentScheduleModel('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button>   </td>'+
              '<td>   <button type="button" class="btn btn-default btn-primary" data-toggle="modal"  data-target="#deletetoScheduleModal" onclick="deleteActIdtoModal('+response[y].id+');"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> </td>'+
              
              
              ' </tr>';
	            	 
	                
	                  
	              }
	              $("#editMenuTbody").append(menuHTML);
	              console.log(response);
	              
	              $('#participantScheduleForm').bootstrapValidator('resetForm', true);   //Sriparna 03-01-2018
	              
	           },
	        error: function(response){                    
	        	console.log(response);
	        }
	    });

}


function createNewSchedule(){	
	 $('#msg').hide();
	 $('#participantScheduleForm').bootstrapValidator('resetForm', true);     //reset schedule form after button click
	
   }

function deleteActIdtoModal(aid){
	
	 $('.currentScheduleNameForModal').html(""+$("#row_schedule_name_"+aid).html());	
	 $("#deleteScheduleIdForModal").val(aid);
}