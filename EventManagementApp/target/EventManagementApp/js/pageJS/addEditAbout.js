var eventDetails;


$( document ).ready(function() {
	//$("#loadingImage").show();
	populateEvents();
	
	$('#msg').hide();
	$('#about_us').on('change input', function(e) {
  	    $('#eventAboutForm').bootstrapValidator('revalidateField', 'about_us');
  	});
	
	$('#eventAboutForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	event_name: {
               validators: {               	  
                   notEmpty: {
                        message: 'This field is required and cannot be empty'
                   },
               }
           },
           about_us: {
        	   validators: {
        		   notEmpty: {
        			   message: 'This field is required and cannot be empty'
        		   },
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           contact_person: {
        	   validators: {
        		   notEmpty: {
        			   message: 'This field is required and cannot be empty'
        		   },
        		   stringLength: {
        			   max:50,
        			   message: 'The value of this field must be less than 50 characters'
        		   },            
        	   }
           },
           contact_no: {
        	   validators: {
        		   notEmpty: {
        			   message: 'This field is required and cannot be empty'
        		   },
        		   stringLength: {
        			   max:15,
        			   message: 'Enter valid contact no'
        		   },            
        	   }
           },
           contact_email: {
        	   validators: {
        		   notEmpty: {
        			   message: 'This field is required and cannot be empty'
        		   },
        		   stringLength: {
        			   max:50,
        			   message: 'Enter valid email id'
        		   },            
        	   }
           },
           facebook_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           twitter_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           linkedin_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           tumblr_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           blogger_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           google_plus_link: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           live_url: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           msg_sender_name: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           },
           msg_body: {
        	   validators: {
        		   stringLength: {
        			   max:1000,
        			   message: 'The value of this field must be less than 1000 characters'
        		   },            
        	   }
           }
		}
	});
 });

function populateEvents(){
	$.ajax({    
	    type: "GET",
	    url: "fetchallevents",             
	    dataType: "html",                  
	    success: function(response){                    
	        $("#editMenuTbody").html('');
	        response = JSON.parse(response);
	        var  menuHTML='';
	        var count =0;
	        for(var y=0; y<response.length; y++){
	           count++;
	           menuHTML=menuHTML+
	           			'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
	            		
	           			'<td width="2% !important">'+count  +'</td>'+
	            		
	           			'<td width="7% !important><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div style = "white-space: normal;width: 140px;" id="row_event_name_'+response[y].id+'"> '+  (response[y].event_name?response[y].event_name:'') +'</div></div></div></td>'+
	            		
	            		'<td width="9% !important><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div style = "white-space: normal;width: 153px;" id="row_about_us_'+response[y].id+'"> '+  (response[y].about_us?response[y].about_us:'') +'</div></div></div></td>'+
	            		
	            		'<td width="7% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_contact_person_'+response[y].id+'"> '+  (response[y].contact_person?response[y].contact_person:'') +'</div></div></div></td>'+
	            		
	            		'<td width="7% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_contact_no_'+response[y].id+'"> '+  (response[y].contact_no?response[y].contact_no:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_contact_no_'+response[y].id+'"> '+  (response[y].contact_email?response[y].contact_email:'') +'</div></div></div></td>'+
	            		
	            		'<td width="7% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_msg_sender_name_'+response[y].id+'"> '+  (response[y].msg_sender_name?response[y].msg_sender_name:'') +'</div></div></div></td>'+
	            		
	            		'<td width="8% !important><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div style = "white-space: normal;width: 153px;" id="row_msg_body_'+response[y].id+'"> '+  (response[y].msg_body?response[y].msg_body:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_facebook_link_'+response[y].id+'"> '+  (response[y].facebook_link?response[y].facebook_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_twitter_link_'+response[y].id+'"> '+  (response[y].twitter_link?response[y].twitter_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_linkedin_link_'+response[y].id+'"> '+  (response[y].linkedin_link?response[y].linkedin_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_blogger_link_'+response[y].id+'"> '+  (response[y].blogger_link?response[y].blogger_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_google_plus_link_'+response[y].id+'"> '+  (response[y].google_plus_link?response[y].google_plus_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="6% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_tumblr_link_'+response[y].id+'"> '+  (response[y].tumblr_link?response[y].tumblr_link:'') +'</div></div></div></td>'+
	            		
	            		'<td width="7% !important"><div class="form-group">'+
	            		'<div class="col-sm-12">'+
	            		'<div id="row_live_url_'+response[y].id+'"> '+  (response[y].live_url?response[y].live_url:'') +'</div></div></div></td>'+
	            		
	            		'<td width="4% !important">  <button type="button" class="btn btn-default btn-primary" onclick="highlight(this);editEventAboutDetails('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button></td>'+
	            		'</tr>';
	        }
	        $("#editMenuTbody").append(menuHTML);
	              
	        $("#eventId").empty();
	 	    $("#eventId").append('<option value="">Please Select...</option>');
	 	    var addOption='';
	 	    eventDetails = response;
	 	    $.each(response, function(response, i) {
	 	      	addOption = $('<option value="'+i.id+'">'+i.event_name+'</option>');	
	 			$("#eventId").append(addOption);
	 	    });
	    },
	    error: function(response){                    
	        console.log(response);
	    }
	});
}

function addEditAbout(){
	//$("#loadingImage").show();
	var a = $("#eventAboutForm").data("bootstrapValidator");
	
	if (a.validate(), a.isValid()) {
    	//var eventId= $("#eventId option:selected").val();
    	var data = {
    				"id" : $("#eventId").val(),
    				"about_us" : $("#about_us").val(),
    				"contact_person" : $("#contact_person").val(),
    				"contact_no" : $("#contact_no").val(),
    				"contact_email" : $("#contact_email").val(),
    				"msg_sender_name" : $("#msg_sender_name").val(),
    				"msg_body" : $("#msg_body").val(),
    				"facebook_link" : $("#facebook_link").val(),
    				"twitter_link" : $("#twitter_link").val(),
    				"linkedin_link" : $("#linkedin_link").val(),
    				"blogger_link" : $("#blogger_link").val(),
    				"google_plus_link" : $("#google_plus_link").val(),
    				"tumblr_link" : $("#tumblr_link").val(),
    				"live_url" : $("#live_url").val()
	         	   };
	 	$.ajax({        
	         type: "POST",
	         url: "updateEventAboutDetailById",  
	         headers: { 
		 			 "content-type": "application/json"
		 	 },
	         data: JSON.stringify(data),
	         success: function(response){
	        	 console.log(response);
	        	 if((''+response)===(''+1)){
	        	     $("#eventEditAlert").addClass("alert-success");
	        	     $("#eventEditAlert").html("Successfully updated ");	        	   
	             }else{
	            	 $("#eventEditAlert").addClass("alert-danger");
	            	 $("#eventEditAlert").html("Failed to update ");	        	   
	             } 
	        	 //$("#loadingImage").hide();
	             console.log(response);
	             populateEvents();
	            
	             $('#msg').show();
	             $("#editEventPanelFormHeading").html("Data saved successfully");
	            // $("#msg").fadeOut("slow");
	             $("#msg").delay(500).fadeOut("12000");
	             $('#eventAboutForm').bootstrapValidator('resetForm', true);  
	            // $('#eventAboutForm')[0].reset();
	             //$('#eventId').attr("disabled", false); 
	         },
	         error: function(response){ 
	         	console.log(response);
	         }
	    });
     }
}
 
function highlight(ctrl){
	var elements=document.getElementsByTagName('tr');
	for(var i=0;i<elements.length;i++)
	   elements[i].style.background='';
	var parent=ctrl.parentNode.parentNode;
	parent.style.background="#B0E0E6";
}

function editEventAboutDetails(id){
	var f = new FormData();
	f.append('id', ''+id);

	$.ajax({        
		type: "POST",
		url: "fetcheventdetailbyid",             
		data: f,
		processData: false,
		contentType: false,
		success: function(response){                    
		   $("#eventId").val(""+response[0].id).trigger("change");
		   $("#event_name").val(""+response[0].event_name).trigger("change");
		   $("#about_us").val(""+(response[0].about_us?response[0].about_us:"")).trigger("change");
		   $("#contact_person").val(""+(response[0].contact_person?response[0].contact_person:"")).trigger("change");
		   $("#contact_no").val(""+(response[0].contact_no?response[0].contact_no:"")).trigger("change");
		   $("#contact_email").val(""+(response[0].contact_email?response[0].contact_email:"")).trigger("change");
		   $("#msg_sender_name").val(""+(response[0].msg_sender_name?response[0].msg_sender_name:"")).trigger("change");
		   $("#msg_body").val(""+(response[0].msg_body?response[0].msg_body:"")).trigger("change");
		   $("#facebook_link").val(""+(response[0].facebook_link?response[0].facebook_link:"")).trigger("change"); 
		   $("#twitter_link").val(""+(response[0].twitter_link?response[0].twitter_link:"")).trigger("change"); 
		   $("#linkedin_link").val(""+(response[0].linkedin_link?response[0].linkedin_link:"")).trigger("change");
		   $("#blogger_link").val(""+(response[0].blogger_link?response[0].blogger_link:"")).trigger("change");
		   $("#google_plus_link").val(""+(response[0].google_plus_link?response[0].google_plus_link:"")).trigger("change");
		   $("#tumblr_link").val(""+(response[0].tumblr_link?response[0].tumblr_link:"")).trigger("change");
		   $("#live_url").val(""+(response[0].live_url?response[0].live_url:"")).trigger("change");
		   
		   
		   $('#eventAboutForm').bootstrapValidator('revalidateField', 'event_name');
		   $('#eventAboutForm').bootstrapValidator('revalidateField', 'about_us');
		   $('#eventAboutForm').bootstrapValidator('revalidateField', 'contact_person');
		   $('#eventAboutForm').bootstrapValidator('revalidateField', 'contact_no');
		   $('#eventAboutForm').bootstrapValidator('revalidateField', 'contact_email');
		   
		   console.log(response);
		   $('#eventId').attr("disabled", true); 
		},
		error: function(response){  
		   console.log(response);
		}
	});
}

