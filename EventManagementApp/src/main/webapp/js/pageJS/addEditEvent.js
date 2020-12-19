/**
 * 
 */

 function updateEditedEvent(){
	 
	 var a = $("#eventForm").data("bootstrapValidator");
     if (a.validate(), a.isValid()) {
    	 
    	 var a = $("#event_id_hidden").val()
    	 console.log("hidden id = "+a);
    	 
   
	 if(a == -1){
		 
		 var f = new FormData();
		  	f.append('event_id_hidden', '-1');
		  	
		  /*	if($("#event_name").val().trim() == ""){
		  		alert("Required");
		  		return;
		  	}
		  		
		  	*/
	    var id="";
	    f.append('event_name', ''+$("#event_name").val());
		f.append('about_us', ''+$("#about_us").val());
		f.append('event_venue', ''+$("#event_venue").val());
		 
		f.append('event_sdate', ''+$("#eventStartDate").val());
		f.append('event_stime', ''+$("#eventStartTime").val());
		f.append('event_edate', ''+$("#eventEndDate").val());
		f.append('event_etime', ''+$("#eventEndTime").val());
		
		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "createeventdetail",             
		         data: f,
		         processData: false,
		 		  contentType: false,
		         success: function(response){                    
		        // alert(response);
		            
		         
		             console.log(response);
		             populateEvents();
		             $('#msgEv').show();
		             $('.editEventPanelFormHeading').html("Data saved successfully");
		             
		             $("#msgEv").delay(500).fadeOut("12000");
		             $("#resetData").val("-1");
		             /*Sriparna issue log 27-12-2017*/
		             
		             /*Sriparna validation*/
		         	 $('#eventForm').bootstrapValidator('resetForm', true); 
		        	/* $('#eventForm')[0].reset();
		        	 
		        	 $('#eventForm')[0].reset();
					 $('#eventForm').bootstrapValidator('revalidateField', 'event_name');
					 $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
					 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
					 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
					 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
					 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');*/
		            },
		         error: function(response){  
		        	 $('#msgEv').show();
		             $('.editActivityPanelFormHeading').html("Error Ocurred.. Try Again !!");	             
		             $("#msgEv").delay(500).fadeOut("12000");
		         	console.log(response);
		         }
		 	    });
		
		 
	 }
	 
	 
	 else{
	    var id=$("#event_id_hidden").val();
	
	    var	f = new FormData();
	  	f.append('event_id_hidden', ''+id);

	  	f.append('event_name', ''+$("#event_name").val());
	  	f.append('about_us', ''+$("#about_us").val());
	  	f.append('event_venue', ''+$("#event_venue").val());
	  	 
	  	f.append('event_sdate', ''+$("#eventStartDate").val());
	  	f.append('event_stime', ''+$("#eventStartTime").val());
	  	f.append('event_edate', ''+$("#eventEndDate").val());
	  	f.append('event_etime', ''+$("#eventEndTime").val());
	  	
  	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updateeventdetailbyid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        // alert(response);
	            
	     /* if((''+response)===(''+1)){
	        	   
	        	   $("#eventEditAlert").addClass("alert-success");
	        	   $("#eventEditAlert").html("Successfully updated &#39;"+$("#row_event_name_"+id).val()+"&#39;");	        	   
	           }
	           else{
	        	   
	        	   $("#eventEditAlert").addClass("alert-danger");
	        	   $("#eventEditAlert").html("Failed to update &#39;"+$("#row_event_name_"+id).val()+"&#39;");	        	   
	             
	           } */
		    
	             console.log(response);
	             populateEvents();
	             f.append('event_id_hidden', '-1');
	             $('#msgEv').show();
	           //  $("#editEventPanelFormHeading").show();
	             $('.editEventPanelFormHeading').html("Data saved successfully");
	             $("#msgEv").delay(500).fadeOut("12000");
	             
	             /*Sriparna issue log 27-12-2017*/
	        	/* $('#eventForm')[0].reset();*/
	        	 $("#resetData").val("-1");
	        	 
	        	 /*Sriparna validation*/
	         	 $('#eventForm').bootstrapValidator('resetForm', true); 
	        	// $('#eventForm')[0].reset();
			/*	 $('#eventForm').bootstrapValidator('revalidateField', 'event_name');
				 $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
				 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
				 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
				 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
				 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');*/
	            },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	        	 $('#msgEv').show();
	             $('.editActivityPanelFormHeading').html("Error Ocurred.. Try Again !!");	             
	             $("#msgEv").delay(500).fadeOut("12000");
	        	 console.log(response);
	         }
	 	    });
	 }
     }
}
 
 
function populateEvents(){
	
	 $.ajax({    //create an ajax request to display.php
	        type: "GET",
	        url: "fetchallevents",             
	        dataType: "html",   //expect html to be returned                
	        success: function(response){                    
	             //alert(response);
	        	$("#editMenuTbody").html('');
	              response = JSON.parse(response);
	              var  menuHTML='';
	                var count =0;
	                var event_start_date='';
	              for(var y=0; y<response.length; y++){
	            count++;
	            event_start_date='';
	            if(response[y].event_start_date!=null){
	            	event_start_date=response[y].event_start_date;
	            }
	            
	           
	          /*  var starttime = response[y].event_start_time;
	        	arr= starttime.split(":");
	        	start_time_hhmm = $.trim(arr[0]) + ":" + $.trim(arr[1]);
	        	
	        	var endtime = response[y].event_end_time;
	        	ar= endtime.split(":");
	        	end_time_hhmm = $.trim(ar[0]) + ":" + $.trim(ar[1]);*/
	        		            
	            
	            menuHTML=menuHTML+'<tr class="table-height"> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
                '<td>'+count  +'</td>'+
                
                 
                
                '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div     style="width: 152px;white-space: normal;" id="row_event_name_'+response[y].id+'"   > '+  (response[y].event_name?response[y].event_name:'') +'</div></div></div></td>'+
                
                
                
                '<td>   <div class="col-sm-12"><div  style = "white-space: normal;width: 153px;"     id="row_event_venue_'+response[y].id+'" > '+(response[y].event_venue?response[y].event_venue:'') +' </div></div></div></td>'+
              
                
      /*          '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div     id="row_event_aboutus_'+response[y].id+'"   > '+  (response[y].about_us?response[y].about_us:'') +'</div></div></div></td>'+*/
                
                   
                '<td><div class="form-group"><div class="input-group" id="eventStartDateDIV_'+response[y].id+'" >'+
                ' <div class="col-sm-12">'+
              '  <div id="row_event_start_'+response[y].id+'" > '+  (moment(response[y].event_start_date).format("DD-MM-YYYY")?moment(response[y].event_start_date).format("DD-MM-YYYY"):'') +'</div></div> '+
              '</div> </div></td>'+
                
              '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div type="time" id="row_event_start_time_'+response[y].id+'"  >'+  (response[y].event_start_time) +'</div></div> '+  
              '</div></td>'+
               
          
              '<td><div class="form-group"><div class="input-group" id="eventEndDateDIV_'+response[y].id+'" >'+ 
                ' <div class="col-sm-12">'+
              '  <div  id="row_event_end_'+response[y].id+'" > '+  (moment(response[y].event_end_date).format("DD-MM-YYYY")?moment(response[y].event_end_date).format("DD-MM-YYYY"):'') +'</div></div> '+
              '</div> </div></td>'+
              
          
              '<td><div class="form-group">'+
                ' <div class="col-sm-12">'+
              '  <div  type="time" id="row_event_end_time_'+response[y].id+'">'+  (response[y].event_end_time) +'</div></div></div></td>'+
                
                
                '<td><div class="checkbox">'+    /*Sriparna css*/
               ' <label><input type="checkbox" style="margin-left: -6px;" '+((''+response[y].is_event_active).trim()===(''+1)?'checked=true':'')+' value="'+ response[y].id +'"   data-backdrop="static" data-keyboard="false" class="is-active-class" onclick="uncheckOthers($(this),'+response[y].id+');" data-toggle="modal" data-target="#myModal" id="is_active_check_'+response[y].id+'"></label>'+
              '  </div></td>'+
              
              
              
              '<td>  <button type="button" class="btn btn-default btn-primary" onclick="highlight(this);editEventConfirmModal('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button>   </td>'+
             /*Sriparna issue log 27-12-2017*/
              '<td>   <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#deleteModal" onclick="deleteIdtoModal('+response[y].id+')"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> </td>'+
              
              
              ' </tr>';
	            
	            if(((''+response[y].is_event_active).trim()===(''+1))){	            	
		            $("#currentlyActive").val(""+response[y].id);	            		            	
	            }
           }
	              $("#editMenuTbody").append(menuHTML);
	              console.log(response);
	              
	           },
	        error: function(response){                    
	        	console.log(response);
	        }
	    });
	
}



function saveCurrentEvent(id,name){
	  var	  f = new FormData();
	  	f.append('id', ''+id);

	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updateeventdetailbyid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        	 if((''+response)===(''+1)){
		        	   
		        	   $("#eventEditAlert").addClass("alert-success");
		        	   $("#eventEditAlert").html("Successfully updated &#39;"+$("#row_event_name_"+id).val()+"&#39;");	        	   
		           }
		           else{
		        	   
		        	   $("#eventEditAlert").addClass("alert-danger");
		        	   $("#eventEditAlert").html("Failed to update &#39;"+$("#row_event_name_"+id).val()+"&#39;");	        	   
		             
		           } 
	           },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	         	console.log(response);
	         }
	 	    });
	
}

function uncheckOthers(t,eid){
	
	var id=""+t.attr('id');
	 $('input.is-active-class').not(t).prop('checked', false);  
	 if(document.getElementById(''+id).checked) {
		 $('.currentEvcentNameForModal').html("Do you want to make event '"+$("#row_event_name_"+eid).html()+ " ' active ?");
		   // $("#currentEventIdForActiveInModal").val(eid);
		 $("#makeActive").show();
	 } else {
		 $('.currentEvcentNameForModal').html("One Event should be active.");
		 $("#makeActive").hide();
	 }
	 $("#currentEventIdForActiveInModal").val(eid);
}



function setActiveFromModal(id){
	
	 var	  f = new FormData();
	 	f.append('id', ''+id);

	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "seteventactivebyid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	         	 //alert(response);
	            
	             if((''+response)===(''+1)){
		        	   
		        	   $("#eventEditAlert").addClass("alert-success");
		        	   $("#eventEditAlert").html("Successfully activated &#39;"+$("#row_event_name_"+id).html()+"&#39;");	        	   
		           }
		           else{
		        	   
		        	   $("#eventEditAlert").addClass("alert-danger");
		        	   $("#eventEditAlert").html("Failed to activate &#39;"+$("#row_event_name_"+id).html()+"&#39;");	        	   
		             
		           } 
	             
	             
	             populateEvents();
	             
		          console.log(response);
	               
	            },
	         error: function(response){  
	        	 populateEvents();
	         	console.log(response);
	         }
	 	    });
	
}

function enableStartEndDate(s,e){
	
	$('#'+s).datetimepicker({format: 'DD-MM-YYYY', minDate : 'now', useCurrent: false //Important! See issue #1075
		});
    $('#'+e).datetimepicker({format: 'DD-MM-YYYY',
        useCurrent: false //Important! See issue #1075
    });
    $("#"+s).on("dp.change", function (ev) {
        $('#'+e).data("DateTimePicker").minDate(ev.date);
    });
    $("#"+e).on("dp.change", function (ev) {
        $('#'+s).data("DateTimePicker").maxDate(ev.date);
    });
	
}
function enableTimePicker(s){
	
	 $('#'+s).datetimepicker({format: 'LT',
        useCurrent: false //Important! See issue #1075
       
    });
     
	
}

function returnOldEvents(){
	
 $("#is_active_check_"+$("#currentlyActive").val().trim()).prop("checked", true).trigger("change");
 $("#is_active_check_"+$("#currentlyActive").val().trim()).attr('checked', true).trigger("change");
 
 uncheckOthers($("#is_active_check_"+$("#currentlyActive").val().trim()),$("#currentlyActive").val().trim());
  
}



function highlight(ctrl){
	   var elements=document.getElementsByTagName('tr');
	    for(var i=0;i<elements.length;i++)
	        elements[i].style.background='';
	   var parent=ctrl.parentNode.parentNode;
	   parent.style.background="#B0E0E6";
	   
	}

function editCurrentEvent(name){
	var id=$("#editCurrentEventIdForModal").val();
	$("#event_id_hidden").val(id);
	console.log("hidden id edit = "+id);
	//$("#editEventPanelFormHeading").html("Currently editing event '"+name+"'. Click save when you are done!");
			
		 var f = new FormData();		 	
		 f.append('id', ''+id);
		 $("#resetData").val("E");
		  var reset = $("#resetData").val();
	 	 console.log("hidden reset = "+reset);
	 	 $("#eventStartDateDIV").datetimepicker();
         $("#eventEndDate").datetimepicker();
        
        
         /*Sriparna issue log 27-12-2017*/
	    /*if(reset != 'EditPrevious'){
    	 if(($("#event_name").val().trim()!='') || ($("#event_venue").val().trim()!='') || ($("#eventStartDate").val().trim()!='') || ($("#eventStartTime").val().trim()!='')
    			   || ($("#eventEndDate").val().trim()!='') || ($("#eventEndTime").val().trim()!='')){
    			$('#discardPopup').modal('show');			     		
    				     			
    		} 
	 	 }*/
	 	
		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "fetcheventdetailbyid",             
		         data: f,
		         processData: false,
		 		  contentType: false,
		         success: function(response){                    
		        // alert(response);
		        	
			     		 
		        	 
		        	/* var starttime = response[0].event_start_time;
			        	arr= starttime.split(":");
			        	start_time_hhmm = $.trim(arr[0]) + ":" + $.trim(arr[1]);
			        	
			        	var endtime = response[0].event_end_time;
			        	ar= endtime.split(":");
			        	end_time_hhmm = $.trim(ar[0]) + ":" + $.trim(ar[1]);
			        		   */         
		        	//alert(response[0].event_start_date) ;
		        	//var timestamp = moment.utc(response[0].event_start_date*1000);
		        //	console.log("timestamp ="+timestamp);
		        	 var sDate = moment(response[0].event_start_date).format("DD-MM-YYYY");
		        	 console.log("sDate ="+sDate);
		        	//$("#eventStartDate").datetimepicker("setDate", sDate);
		        //	$('#eventStartDate').data("DateTimePicker").setDate(timestamp);
		        //	$('#eventStartDate').datetimepicker('update', sDate);
		        	//$('#eventStartDate').datetimepicker('update');
		        	//$('#eventStartDate').datetimepicker('update', sDate);
		        	//$('#eventStartDate').datetimepicker("setDate", '1d');
		        	 
		        	// $('#eventStartDate').data('datetimepicker').setDate("2018-01-01");
		        	 
		        	 
		        	 
		          $("#event_name").val(""+response[0].event_name).trigger("change");		      
		          $("#event_id_hidden").val(""+response[0].id);
		          $("#about_us").val(""+(response[0].about_us?response[0].about_us:"")).trigger("change");
		          $("#event_venue").val(""+(response[0].event_venue?response[0].event_venue:"")).trigger("change");
		          $("#eventStartDate").val(""+(sDate));
		          
		          $("#eventStartTime").val(""+(response[0].event_start_time)).trigger("change"); 
		          $("#eventEndDate").val(""+(moment(response[0].event_end_date).format("DD-MM-YYYY")?moment(response[0].event_end_date).format("DD-MM-YYYY"):"")); 
		          $("#eventEndTime").val(""+(response[0].event_end_time)).trigger("change");
		          
		         // $("#eventStartDate").trigger("change");
		          //$("#eventEndDate").trigger("change");
		          
		          
		          $('#eventForm').bootstrapValidator('revalidateField', 'event_name');
		     	 $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
		     	 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
		     	 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
		     	 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
		     	 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');
		             console.log(response);
		           
		     	  	f.append('event_id_hidden', '-1');
	     		
		            },
		         error: function(response){  
		        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
		         	console.log(response);
		         }
		 	    });
		
	}


/*Sriparna issue log 27-12-2017*/
/*function deleteCurrentEvent(id){

	$("#event_id_hidden").val(id);
	//$("#editEventPanelFormHeading").html("Currently editing event '"+name+"'. Click save when you are done!");
			
		 var f = new FormData();
		 	
		 	
		 	f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "deleteeventdetailbyid",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){                    
		        // alert(response);
		        	 
		        	 Sriparna issue log 27-12-2017
		        	 $('#eventForm')[0].reset();
		        	 
		        	 populateEvents();
		            console.log(response);
		           
		     	  	f.append('event_id_hidden', '-1');
		            },
		         error: function(response){  
		        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
		         	console.log(response);
		         }
		 	    });
		
	}
*/

$( document ).ready(function() {
	populateEvents();
	  
	enableStartEndDate('eventStartDateDIV','eventEndDateDIV');
	enableTimePicker('eventEndTimeDIV');
	 
	enableTimePicker('eventStartTimeDIV');
	
	/*var time_pattern = /^[0-2][0-3]:[0-5][0-9]+$/;*/

	/* var formmodified=0;
	    $('#event_name').change(function(){
	    	alert("form data change");
	        formmodified=1;
	    });*/
	
	
	$('#event_name').on('change input', function(e) {	
  	    $('#eventForm').bootstrapValidator('revalidateField', 'event_name'); 	    
  	 });
	$('#event_venue').on('change input', function(e) {
  	    $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
  	 });
	/*$('#about_us').on('change input', function(e) {
  	    $('#eventForm').bootstrapValidator('revalidateField', 'about_us');
  	 });
	*/
	/*$('#eventStartDateDIV').datetimepicker().on('changeDate', function(e) {
   	    $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
   	 });*/

	
	$('#eventStartDateDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
	});
	$('#eventStartTimeDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
	});
	$('#eventEndDateDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
	});
	$('#eventEndTimeDIV').datetimepicker().on('dp.change', function (e) {		
		 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');
	});
	
/*	$('#eventStartDateDIV')
    .datetimepicker({
        format: 'YYYY-MM-DD',
        startDate: '2000-01-01',
        endDate: new Date(),
        autoclose: true
        
    }).on('changeDate', function(e) {
        // Revalidate the date field
    	 $('#eventForm')
         // Get the bootstrapValidator instance
         .data('bootstrapValidator')
         // Mark the field as not validated, so it'll be re-validated when the user change date
         .updateStatus('eventStartDate', 'NOT_VALIDATED', null)
         // Validate the field
         .validateField('eventStartDate');
    });
	*/
	
	
	$("#eventStartTime").keypress(function(e){
	       e.preventDefault();
	    });
	$("#eventStartDate").keypress(function(e){
	       e.preventDefault();
	    });
	$("#eventEndTime").keypress(function(e){
	       e.preventDefault();
	    });
	$("#eventEndDate").keypress(function(e){
	       e.preventDefault();
	    });
	
	$("#eventEndTime").keydown(function(e) {
		if (e.keyCode == 8) e.preventDefault(); 
		});
	$("#eventEndDate").keydown(function(e) {
		if (e.keyCode == 8) e.preventDefault(); 
		});
	$("#eventStartTime").keydown(function(e) {
		if (e.keyCode == 8) e.preventDefault(); 
		});
	$("#eventStartDate").keydown(function(e) {
		if (e.keyCode == 8) e.preventDefault(); 
		});
	
	$('#deleteModal').on('show.bs.modal', function (e) {
		  /*var button = e.relatedTarget;
		  if($(button).hasClass('no-modal')) {
		    e.stopPropagation();
		  }  */
		//alert($("#currentlyActive").val().trim()+"   "+(''+$("#deleteEventIdForModal").val().trim()));
		if($("#currentlyActive").val().trim()==(''+$("#deleteEventIdForModal").val().trim())){
			e.preventDefault();
			 e.stopPropagation();
		 	return;
			
		}
	
	});
	$('#eventForm').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	 
                
        	event_name: {
                   validators: {               	  
                    notEmpty: {
                        message: 'Event name is required and cannot be empty'
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
        
        event_venue: {
            validators: {
                notEmpty: {
                    message: 'Event venue is required and cannot be empty'
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
        
        
    /*    about_us: {
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                },
                stringLength: {
                    max:100,
                    message: 'The value of this field must be less than 100 characters'
                    
                },            
            }
        },*/
       
        eventStartTime:{
            validators: {
                notEmpty: {
                    message: 'This field is required and cannot be empty'
                },
                                 
            }
        },
          
        eventStartDate:{
	        	 validators: {
                     notEmpty: {
                         message: 'Start date is required and cannot be empty'
                     },
                     date: {
                         format: 'DD-MM-YYYY',
                         message: 'The start date is not valid',
                        
                     },
                  /*   callback: {
                         message: 'Wrong answer',
                         callback: function (value, validator, $field) {                       
                        	    var todayDate = new Date();
                        	    var inputDate = $('#eventStartDate').val();    
                        	       
                        	    var todayMonth = todayDate.getMonth() + 1;
                        	    var todayDay = todayDate.getDate();
                        	    var todayYear = todayDate.getFullYear();
                        	    
                        	    var todayDateText = todayYear + "-" + todayMonth + "-" + todayDay;
                        	    
                        	    var inputToDate = Date.parse(inputDate);
                        	    var todayToDate = Date.parse(todayDateText);
                        	    
                        	    if (inputToDate < todayToDate) {                      	    	
                        	    	return {
                                        valid: false,
                                        message: 'The input date is earlier than today'
                                    }; 
                        	    	}
                        	    else{
                        	    	return {
                                        valid: true,
                                     
                                    }; 
                        	    	
                        	    }
                   	        
                     }   
                     }*/
                 }
	      }, 
	      eventEndTime:{
	            validators: {
	                notEmpty: {
	                    message: 'This field is required and cannot be empty'
	                }, 
	                
	                callback: {
                        message: 'Event end time should be greater than start time',
                       
                        callback: function(value, validator, $field) {
                        	
                        
                        	
                        	var from_date = moment($('#eventStartDate').val(), 'DD-MM-YYYY');
                        	var to_date = moment($('#eventEndDate').val(), 'DD-MM-YYYY');
                        	
                        	var sss1=moment(from_date).format("MM/DD/YYYY");
                        	var sss2=moment(to_date).format("MM/DD/YYYY");
                        	var str_start_date=sss1.concat(' ');
                        	var str_end_date=sss2.concat(' ');
                        	
                            var startTime = validator.getFieldElements('eventStartTime').val();
                            var endTime = validator.getFieldElements('eventEndTime').val();
                          
                            
                            var dtStart_time = new Date(str_start_date+startTime);
                   		    var dtEnd_time = new Date(str_end_date+endTime);
                   		    var difference_in_milliseconds = dtEnd_time - dtStart_time;
                   		  if (difference_in_milliseconds > 1)
                   		 {
                   			 //document.getElementById("errormsg").innerHTML = "End time should be greater than start time !";
                   			 validator.updateStatus('eventStartTime', validator.STATUS_VALID, 'callback');
                             return true;
                   		 }
                   		
                   		
                            return false;
                        }
	                }
	                                  
	            }
	        },
	            
	      
	      eventEndDate:{
	        	 validators: {
                  notEmpty: {
                      message: 'End date is required and cannot be empty'
                  },
                  date: {
                      format: 'DD-MM-YYYY',
                      message: 'The end date is not valid'
                  },
              /*    callback: {
                      message: 'Wrong answer',
                      callback: function (value, validator, $field) {                       
                     	    var todayDate = new Date();
                     	    var inputDate = $('#eventEndDate').val();    
                     	       
                     	    var todayMonth = todayDate.getMonth() + 1;
                     	    var todayDay = todayDate.getDate();
                     	    var todayYear = todayDate.getFullYear();
                     	    
                     	    var todayDateText = todayYear + "-" + todayMonth + "-" + todayDay;
                     	    
                     	    var inputToDate = Date.parse(inputDate);
                     	    var todayToDate = Date.parse(todayDateText);
                     	    
                     	    if (inputToDate < todayToDate) {                      	    	
                     	    	return {
                                     valid: false,
                                     message: 'The input date is earlier than today'
                                 }; 
                     	    	}
                     	    else{
                     	    	return {
                                     valid: true,
                                  
                                 }; 
                     	    	
                     	    }               	        
                  }   
                  }*/
              }
	      }, 
		}
			});
		
	
	 
	
 });

function createNewEvent(){	
	// $('#msg').hide();
	//window.location.reload();
	 $("#resetData").val("N");
	  var reset = $("#resetData").val();
	 console.log("hidden reset = "+reset);
	 
	 /*Sriparna issue log 27-12-2017*/
	 if(($("#event_name").val().trim()!='') || ($("#event_venue").val().trim()!='') || ($("#eventStartDate").val().trim()!='') || ($("#eventStartTime").val().trim()!='')
			   || ($("#eventEndDate").val().trim()!='') || ($("#eventEndTime").val().trim()!='')){
			$('#discardPopup').modal('show');
			return;
			
		} 
		  
	 
	  /*window.location.reload();*/
	// $('#eventForm').bootstrapValidator('validate');
	 
	 /*Sriparna issue log 27-12-2017*/
	/* $('#eventForm')[0].reset();
	 $('#eventForm').bootstrapValidator('revalidateField', 'event_name');
	 $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
	 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
	 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
	 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
	 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');*/
	 
	 /*Sriparna validation*/
 	 $('#eventForm').bootstrapValidator('resetForm', true); 
	
	  var f = new FormData();
	  
	  $("#event_id_hidden").val("-1");
	  var a = $("#event_id_hidden").val();
 	 console.log("hidden id = "+a);
 	 
 	
 	 
    }


/*Sriparna issue log 27-12-2017*/
function deleteCurrentEvent(){
	
	var id=$('#deleteEventIdForModal').val();
/*	if($(this).prop("checked") == true){
        alert("Checkbox is checked.");
    }
    else if($(this).prop("checked") == false){
        alert("Checkbox is unchecked.");
    }
*/
		
	$("#event_id_hidden").val(id);
	//$("#editEventPanelFormHeading").html("Currently editing event '"+name+"'. Click save when you are done!");
			
		 var f = new FormData();
		 f.append('id', ''+id);

		 	$.ajax({    //create an ajax request to display       
		         type: "POST",
		         url: "deleteeventdetailbyid",             
		         data: f,
		         processData: false,
		 		 contentType: false,
		         success: function(response){                    
		        // alert(response);
		        	/* $('#eventForm')[0].reset();*/
		        	 /*Sriparna validation*/
		         	 $('#eventForm').bootstrapValidator('resetForm', true); 
		        	 
		        	 populateEvents();
		            console.log(response);
		           
		     	  	f.append('event_id_hidden', '-1');
		            },
		         error: function(response){  
		        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
		         	console.log(response);
		         }
		 	    });
		
	}
function deleteIdtoModal(eid){
	
	/* var f = new FormData(); 	
	 f.append('id', ''+id);*/
	 $('.currentEventNameForModal').html(""+$("#row_event_name_"+eid).html());
	 $("#deleteEventIdForModal").val(eid);
 if($("#currentlyActive").val().trim()==(''+eid)){
		
		//alert("This is currently active event. Please make another event active to delete this one! ");
		$('#popup').modal('show');	
		return;	
	}
}
/*Sriparna issue log 27-12-2017*/
function resetForm(){
      var f = new FormData();    
	  var reset = $("#resetData").val();
	  console.log("hidden reset = "+reset);
		
		if(reset == 'N'){			
			 /*Sriparna validation*/
        	 $('#eventForm').bootstrapValidator('resetForm', true); 
			/* $('#eventForm')[0].reset();
			 $('#eventForm').bootstrapValidator('revalidateField', 'event_name');
			 $('#eventForm').bootstrapValidator('revalidateField', 'event_venue');
			 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartDate');
			 $('#eventForm').bootstrapValidator('revalidateField', 'eventStartTime');
			 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndDate');
			 $('#eventForm').bootstrapValidator('revalidateField', 'eventEndTime');*/
			
			 $("#event_id_hidden").val("-1");
			  var a = $("#event_id_hidden").val();
			  console.log("hidden id = "+a);
		}
	    if(reset == 'E'){
	    	 $("#resetData").val("EditPrevious");
			 console.log("hidden reset = "+reset);
	    }
	  
}	  

function editEventConfirmModal(id){//Tajinder 09-10-2018
	if(($("#event_name").val().trim()!='') || ($("#event_venue").val().trim()!='') || ($("#eventStartDate").val().trim()!='') || ($("#eventStartTime").val().trim()!='')
			   || ($("#eventEndDate").val().trim()!='') || ($("#eventEndTime").val().trim()!='')){
			//$('#discardPopup').modal('show');
		$("#editCurrentEventIdForModal").val(id);
		$('#discardEditPopup').modal('show');
			return;
			
	}else{
		$("#editCurrentEventIdForModal").val(id);
		editCurrentEvent();
	}
}
