/**
 *  Sriparna 26-12-2017 ---- 27-12-2017
 */

$( document ).ready(function() {
	getEventDetails();
	
	$('#activity_name').on('change', function(e) {
  	    $('#activityForm').bootstrapValidator('revalidateField', 'activity_name');
  	 });
	$('#venue').on('change input', function(e) {
  	    $('#activityForm').bootstrapValidator('revalidateField', 'venue');
  	 });
	$('#is_prtcpt_auth_req').on('change input', function(e) {
  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_prtcpt_auth_req');
  	 });
	$('#is_one_time_pass').on('change input', function(e) {
  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_one_time_pass');
  	 });
	$('#is_reset_on_exit').on('change input', function(e) {
  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_reset_on_exit');
  	 });
	
	$('#activityForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {       
        	activity_name: {
                   validators: {               	  
                    notEmpty: {
                        message: 'Activity name is required and cannot be empty'
                    },
                    stringLength: {
                        max:100,
                        message: 'The name must be less than 100 characters'
                        
                    },
                   /* regexp: {
                        regexp: /^[a-zA-Z ]+$/,
                        message: 'The name can only consist of alphabet and space'
                    },   */            
                }
            },
        
            venue: {
            validators: {
                notEmpty: {
                    message: 'Venue is required and cannot be empty'
                },
                stringLength: {
                    max:100,
                    message: 'The venue must be less than 100 characters'
                    
                },
               /* regexp: {
                    regexp: /^[a-zA-Z0-9-, ]+$/,
                    message: 'The name can only consist of alphabet,numbers,hypen,comma and space '
                },    */           
            }
        },
        
        
        is_prtcpt_auth_req: {
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                }          
            }
        },
        is_one_time_pass: {
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                }          
            }
        },
        is_reset_on_exit: {
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                }          
            }
        },
     
              }
	     
		
			});
	 
});

function getEventDetails(){
	   $.ajax({
	        url: "fetchallevents",
	        type: "GET"
	   }).done(function(e) {
	         $("#event_Id").empty();
	      	 $("#event_Id").append('<option value="0">---- Please Select Event ----</option>');
	      	 var addOption='';
	      	 $.each(e, function(e, i) {
	      		  addOption = $('<option value="'+i.id+'">'+i.event_name+'</option>');	
				 	  $("#event_Id").append(addOption);
	      	 });
	        }).fail(function(a, b) {
	        	// alert("failure");
	        	 console.log(e);
	        	 });	   
	}

/*function selectedactivity(){
	    var a = $("#event_Id").val();
	//	alert("selected event =" +a);
		populateActivities(a);
}*/
 
function populateActivities(){
		   
	 var eventId = $("#event_Id").val();

	 $.ajax({ 
		   //create an ajax request to display.php
	        type: "GET",
	        url: "fetchactivitiesbyeventId",  
	        data: {id:eventId},
	        dataType: "html",   //expect html to be returned                
	        success: function(response){                    
	             //alert(response);
	        	$("#editMenuTbody").html('');
	              response = JSON.parse(response);
	              var is_prtcpt_auth_req='';
	              var is_one_time_pass='';
	              var is_reset_on_exit='';
	                           
	              var  menuHTML='';
	                var count =0;	               
	              for(var y=0; y<response.length; y++){
	            count++;	          
	           
	            if(response[y].is_prtcpt_auth_req==1){
	            	is_prtcpt_auth_req = "Yes";
	            }
                else{
            	    is_prtcpt_auth_req = "No";
                }
	            
	            if(response[y].is_one_time_pass==1){
	            	is_one_time_pass = "Yes";
	            }
                else{
                	is_one_time_pass = "No";
                }
	            
	            if(response[y].is_reset_on_exit==1){
	            	is_reset_on_exit = "Yes";
	            }
                else{
                	is_reset_on_exit = "No";
                }
	          	            
	            menuHTML=menuHTML+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
                '<td>'+count  +'</td>'+
                
                 
                
                '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div style = "white-space: normal;width: 140px;" id="row_activity_name_'+response[y].id+'"   > '+  (response[y].activity_name?response[y].activity_name:'') +'</div></div></div></td>'+                             
                
                '<td>   <div class="col-sm-12"><div style = "white-space: normal;width: 140px;" id="row_venue_'+response[y].id+'" > '+(response[y].venue?response[y].venue:'') +' </div></div></div></td>'+
                   
                '<td>   <div class="col-sm-12"><div style = "white-space: normal;width: 140px;" id="row_is_prtcpt_auth_req_'+response[y].id+'" > '+(is_prtcpt_auth_req) +' </div></div></div></td>'+
                
                '<td>   <div class="col-sm-12"><div style = "white-space: normal;width: 140px;" id="row_is_one_time_pass_'+response[y].id+'" > '+(is_one_time_pass) +' </div></div></div></td>'+
                
                '<td>   <div class="col-sm-12"><div style = "white-space: normal;width: 140px;" id="row_is_reset_on_exit_'+response[y].id+'" > '+(is_reset_on_exit) +' </div></div></div></td>'+
                                            
              
              
                '<td>  <button type="button" class="btn btn-default btn-primary" onclick="highlight(this);editActivityConfirmModal('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button>   </td>'+
                  '<td>  <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#deleteActModal" onclick="deleteActIdtoModal('+response[y].id+')"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> </td>'+
              
              
              ' </tr>';
	            	 
	                
	                  
	              }
	              $("#editMenuTbody").append(menuHTML);
	              console.log(response);
	              
	           },
	        error: function(response){ 
	        
	        	console.log(response);
	        }
	    });
	
}


function highlight(ctrl){
	   var elements=document.getElementsByTagName('tr');
	    for(var i=0;i<elements.length;i++)
	        elements[i].style.background='';
	   var parent=ctrl.parentNode.parentNode;
	   parent.style.background="#B0E0E6";
	   
	}


function editCurrentActivity(){
	var id=$("#editCurrentActivityIdForModal").val();
	$("#activity_id_hidden").val(id);
	
		 var f = new FormData();	 	
		 f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "fetchactivitydetailbyid",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){                    
		        // alert(response);
		        // console.log("auth req ="+response[0].is_prtcpt_auth_req); 
		            var is_prtcpt_auth_req = response[0].is_prtcpt_auth_req ;
		        	if(is_prtcpt_auth_req == '1'){
		        		$('input:radio[name=is_prtcpt_auth_req]')[0].checked = true;
		        	}
		        	else{
		        		$('input:radio[name=is_prtcpt_auth_req]')[1].checked = true;
		        	}	
		        	
		        	var is_one_time_pass = response[0].is_one_time_pass ;
		        	if(is_one_time_pass == '1'){
		        		$('input:radio[name=is_one_time_pass]')[0].checked = true;
		        	}
		        	else{
		        		$('input:radio[name=is_one_time_pass]')[1].checked = true;
		        	}	 
		        	
		        	var is_reset_on_exit = response[0].is_reset_on_exit ;
		        	if(is_reset_on_exit == '1'){
		        		$('input:radio[name=is_reset_on_exit]')[0].checked = true;
		        	}
		        	else{
		        		$('input:radio[name=is_reset_on_exit]')[1].checked = true;
		        	}	 
			         		        	 
		          $("#activity_name").val(""+response[0].activity_name).trigger("change");		      
		          $("#activity_id_hidden").val(""+response[0].id);
		          $("#venue").val(""+(response[0].venue?response[0].venue:"")).trigger("change");
		          $("#is_prtcpt_auth_req").trigger("change");
		          $("#is_one_time_pass").trigger("change");
		          $("#is_reset_on_exit").trigger("change");
		       		        	
		          console.log(response);
		     	  
		     	  f.append('activity_id_hidden', '-1');
		     	/* $("#is_prtcpt_auth_req").prop("checked", true);
	        	 $("#is_one_time_pass").prop("checked", true);
	        	 $("#is_reset_on_exit").prop("checked", true);*/

		     	  	
		            },
		         error: function(response){  		        
		         	console.log(response);
		         }
		 	    });
		
	}


function saveUpdateActivity(){
	var a = $("#activityForm").data("bootstrapValidator");
    if (a.validate(), a.isValid()) {
   	 
	var eventId = $("#event_Id").val();
	
	/*var a = $("#activityForm").data("bootstrapValidator");
    if (a.validate(), a.isValid()) {*/
   	 
	 var a = $("#activity_id_hidden").val()
   	 console.log("hidden activity id = "+a);
   	 
   	 var e = $("#event_Id_hidden").val(eventId)
   	 console.log("hidden event_Id = "+e);
   
    if(($("#event_Id_hidden").val()) != 0){
	 if(a == -1){
		 
		 //alert("event id ="+($("#event_Id_hidden").val()));
		
		// alert("inside if=create");
		 var f = new FormData();
		 f.append('activity_id_hidden', '-1');
		
		 
	    var id="";
	    f.append('event_Id_hidden', ''+$("#event_Id_hidden").val());
	    f.append('activity_name', ''+$("#activity_name").val());
		f.append('venue', ''+$("#venue").val());
		/*f.append('is_prtcpt_auth_req', ''+$("#is_prtcpt_auth_req").val());	
		f.append('is_one_time_pass', ''+$("#is_one_time_pass").val());
		f.append('is_reset_on_exit', ''+$("#is_reset_on_exit").val());*/ 
		
	
    		if($('input:radio[name=is_prtcpt_auth_req]')[0].checked == true){
    			f.append('is_prtcpt_auth_req','1');	
    		}    	
    	   else{
    		    f.append('is_prtcpt_auth_req','0');	
    	    }	
    		if($('input:radio[name=is_one_time_pass]')[0].checked == true){
    			f.append('is_one_time_pass','1');	
    		}    	
    	   else{
    		    f.append('is_one_time_pass','0');	
    	    }	
    		if($('input:radio[name=is_reset_on_exit]')[0].checked == true){
    			f.append('is_reset_on_exit','1');	
    		}    	
    	   else{
    		    f.append('is_reset_on_exit','0');	
    	    }	
		
		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "createactivity",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){                    
		        // alert(response);
		            		         
		             console.log(response);
		             populateActivities();
		             $('#msg').show();
		             $("#editActivityPanelFormHeading").html("Data saved successfully");	             
		             $("#msg").delay(500).fadeOut("12000");	
		           //  $("#activity_id_hidden").val(-1);
		            /* $('#activityForm')[0].reset();
		             $('#activityForm').bootstrapValidator('validate');
		      	   
		 	 	    $('#activityForm').bootstrapValidator('revalidateField', 'activity_name');
		     	    $('#activityForm').bootstrapValidator('revalidateField', 'venue');
		      	    $('#activityForm').bootstrapValidator('revalidateField', 'is_prtcpt_auth_req');	
		 	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_one_time_pass');
		 	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_reset_on_exit');*/
		 	  
		 	     	 /*  Sriparna validation */
		 	  	    $('#activityForm').bootstrapValidator('resetForm', true);
		 	  	 $("#is_prtcpt_auth_req").prop("checked", true);
	        	 $("#is_one_time_pass").prop("checked", true);
	        	 $("#is_reset_on_exit").prop("checked", true);

		            },
		         error: function(response){  
		        	 $('#msg').show();
		             $("#editActivityPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
		             $("#msg").delay(1000).fadeOut("12000");
		         	console.log(response);
		         }
		 	    });	 
	 } 
	 else{
		// alert("inside else=update");
		var id=$("#activity_id_hidden").val();
		
	    var	f = new FormData();
		f.append('activity_id_hidden', ''+id);
	    f.append('event_Id_hidden', ''+$("#event_Id_hidden").val());
	    f.append('activity_name', ''+$("#activity_name").val());
		f.append('venue', ''+$("#venue").val());
		/*f.append('is_prtcpt_auth_req', ''+$("#is_prtcpt_auth_req").val());	 
		f.append('is_one_time_pass', ''+$("#is_one_time_pass").val());
		f.append('is_reset_on_exit', ''+$("#is_reset_on_exit").val());*/
		
		if($('input:radio[name=is_prtcpt_auth_req]')[0].checked == true){
			f.append('is_prtcpt_auth_req','1');	
		}    	
	   else{
		    f.append('is_prtcpt_auth_req','0');	
	    }	
		if($('input:radio[name=is_one_time_pass]')[0].checked == true){
			f.append('is_one_time_pass','1');	
		}    	
	   else{
		    f.append('is_one_time_pass','0');	
	    }	
		if($('input:radio[name=is_reset_on_exit]')[0].checked == true){
			f.append('is_reset_on_exit','1');	
		}    	
	   else{
		    f.append('is_reset_on_exit','0');	
	    }	
	
	  	
 	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updateactivitydetailbyid",             
	         data: f,
	         processData: false,
	 		 contentType: false,
	         success: function(response){                    
	        // alert(response);
	            	   
	             console.log(response);
	             populateActivities();
	             f.append('activity_id_hidden', '-1');	             
	             $('#msg').show();
	             $("#editActivityPanelFormHeading").html("Data saved successfully");	             
	             $("#msg").delay(1000).fadeOut("12000");
	             $("#activity_id_hidden").val(-1);
	           /*  $('#activityForm')[0].reset();
	             $('#activityForm').bootstrapValidator('validate');
	      	   
	 	 	    $('#activityForm').bootstrapValidator('revalidateField', 'activity_name');
	     	    $('#activityForm').bootstrapValidator('revalidateField', 'venue');
	      	    $('#activityForm').bootstrapValidator('revalidateField', 'is_prtcpt_auth_req');	
	 	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_one_time_pass');
	 	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_reset_on_exit');*/
	 	  
	 	  	 /*  Sriparna validation */
	 	  	    $('#activityForm').bootstrapValidator('resetForm', true);
	 	  	 $("#is_prtcpt_auth_req").prop("checked", true);
        	 $("#is_one_time_pass").prop("checked", true);
        	 $("#is_reset_on_exit").prop("checked", true);
	             
	            },
	         error: function(response){  
	        	 $('#msg').show();
	             $("#editActivityPanelFormHeading").html("Error Ocurred.. Try Again !!");	             
	             $("#msg").delay(500).fadeOut("12000");
	         }
	 	    });
	 }
  }
    else{
    	 $('#msg').show();
         $("#editActivityPanelFormHeading").html("Please select an event to proceed !!");	             
         $("#msg").delay(1000).fadeOut("12000");
    }
}
}    

function createNewActivity(){	
	 $('#msg').hide();	 
	  /*window.location.reload();*/
	 /*  $('#activityForm')[0].reset();*/
	   
	 //  $("#activityForm").valid();
	 /*  $('#activityForm').bootstrapValidator('validate');
	   
	 	    $('#activityForm').bootstrapValidator('revalidateField', 'activity_name');
    	    $('#activityForm').bootstrapValidator('revalidateField', 'venue');
     	    $('#activityForm').bootstrapValidator('revalidateField', 'is_prtcpt_auth_req');	
	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_one_time_pass');
	  	    $('#activityForm').bootstrapValidator('revalidateField', 'is_reset_on_exit');*/
	  
	  	  /*  Sriparna validation */
 	  	    $('#activityForm').bootstrapValidator('resetForm', true);
 	  	 $("#is_prtcpt_auth_req").prop("checked", true);
    	 $("#is_one_time_pass").prop("checked", true);
    	 $("#is_reset_on_exit").prop("checked", true);

	  var f = new FormData();	  
	  $("#activity_id_hidden").val("-1");
	  var a = $("#activity_id_hidden").val();
	 console.log("hidden id = "+a);
   }



function deleteCurrentActivity(id){
	$("#activity_id_hidden").val(id);
		 var f = new FormData();		 	
		 f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "deleteactivitydetailbyid",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){  
		        	/* $('#activityForm')[0].reset();*/
		        	 populateActivities();
		             console.log(response);
		           
		     	  	 f.append('activity_id_hidden', '-1');
		     	  	 $("#activity_id_hidden").val("-1");
		     	  	 /*  Sriparna validation */
			 	  	    $('#activityForm').bootstrapValidator('resetForm', true);
			 	  	 $("#is_prtcpt_auth_req").prop("checked", true);
		        	 $("#is_one_time_pass").prop("checked", true);
		        	 $("#is_reset_on_exit").prop("checked", true);

		            },
		         error: function(response){  		        	
		         	console.log(response);
		         }
		 	    });
		
	}
function deleteActIdtoModal(aid){
	 $('.currentActivityNameForModal').html(""+$("#row_activity_name_"+aid).html());	
	 $("#deleteActivityIdForModal").val(aid);
}
/**************TAJINDER 09-1-2018 STARTS********************/
function createNew(){
	/* if(($("#activity_name").val().trim()!='') || ($("#venue").val().trim()!='') || ($("#is_prtcpt_auth_req").val().trim()!='') || ($("#is_one_time_pass").val().trim()!='')
				   || ($("#is_reset_on_exit").val().trim()!='')){*/
	 if(($("#activity_name").val().trim()!='') || ($("#venue").val().trim()!='')){
				$('#discardPopup').modal('show');
				return;
			}
		 }

function editActivityConfirmModal(id){
	 if(($("#activity_name").val().trim()!='') || ($("#venue").val().trim()!='')){
			$("#editCurrentActivityIdForModal").val(id);
			$('#discardEditPopup').modal('show');
				return;
				
		}else{
			$("#editCurrentActivityIdForModal").val(id);
			editCurrentActivity();
		}
	}

/**************TAJINDER 09-1-2018 END********************/