/**
 * 
 */

function loadMenuByEventId(){
	var eventId=$("#menuEventSelect").val();
	$.ajax({   
        type: "POST",
        url: "fetchallmenusbyid?id="+eventId,             
        processData: false,
		  contentType: false,
        success: function(response){                    
        	 var  menuHTML='<option value="-1">Select Menu</option>';
            for(var y=0; y<response.length; y++){
               menuHTML=menuHTML+'<option value="'+response[y].id+'">'+response[y].menu_name+'</option>';
             }
            $("#allMenuSelect").html(menuHTML);
            $('#updateeditedmenufieldname').bootstrapValidator('resetForm', true);
          },
        error: function(response){                    
        	console.log(response);
        }
	    });
}


function showMenuDetails(){
	 
	 var menuId=$("#allMenuSelect").val();
		var eventId=$("#menuEventSelect").val();
	 $("#saveEventId").val(eventId);
	 
	 $("#saveMenuId").val(menuId);
	 
	 $("#editMenuFieldNameTHead").html('');

		var  headerHTML='';
		 headerHTML=
			 '<tr> '+
	       ' <th>#</th> ';
	       var  innerHTML='';
	      $.ajax({        
		        type: "POST",
		        url: "fetchmenudetailsbyid?id="+menuId,             
		        processData: false,
				  contentType: false,
		        success: function(response){                    
		        	 var count =0;
		             for(var y=0; y<response.length; y++){
		 	            count++;
		 	            
		 	           innerHTML=innerHTML+' <th>'+response[y].menu_field_name  +'<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right"></span> '+
		 		        ' <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right"></span> '+
		 		       ' </th> ';
		 	          } 
		        	  headerHTML=headerHTML+ innerHTML+ '<th></th><th></th> '+
		  	       /* ' <th></th> '+*/
		  	        '</tr> ' ;
		  		  $("#editMenuFieldNameTHead").append(headerHTML);
		            },
		        error: function(response){                    
		        	console.log(response);
		        }
			    });
	 }
function fetchMenuValueListByMenuId(){
	 
	 var menuId=$("#allMenuSelect").val();
	 $("#editMenuFieldNameTbody").html('');

		var  innerHTML='';
		
	      $.ajax({        
		        type: "POST",
		        url: "fetchMenuValueListByMenuId?menuId="+menuId,             
		        processData: false,
				  contentType: false,
		        success: function(response){   
		        	//alert(response)
		        	 var count =0;
		             for(var y=0; y<response.length; y++){
		 	            count++;
		 	           
		 	      	innerHTML=innerHTML+'<tr> <input type="hidden" class="row_id_hidden" name="row_"  id="row_" >'+
	                '<td>'+count  +'</td>';
		 	      	var menu_name_value_set_id='';
		 	            for(var z=0;z<response[y].length;z++){
		 	            
		 	            	innerHTML=innerHTML+ '<td>   <div class="col-sm-12"><div id="row_is_one_time_pass_'+response[y][z].menu_value+'" > '+response[y][z].menu_value +' </div></div></div></td>'
		 	            	;
		 	            	menu_name_value_set_id=response[y][z].menu_name_value_set_id;
			               // alert(response[y][z].menu_value);
		 	            }
		 	           innerHTML=innerHTML
			 	          +'<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default" onclick="editMenuFieldValue('+menu_name_value_set_id +' )"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Edit</button> '+
		                  '</div> </td>'
		                  
		                  +'<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default" onclick="deleteCurrentEvent('+menu_name_value_set_id +' )"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Delete</button> '+
		                  '</div> </td>'+
		 	           '</tr>';
		 	         
		 	          } 
		        	  
		  		  $("#editMenuFieldNameTbody").append(innerHTML);
		            },
		        error: function(response){                    
		        	console.log(response);
		        }
			    });
	 }
function createDynamicForm(){
	 $("#addEditMenuValueFormDiv").show();
	var menuId=$("#allMenuSelect").val();
	 $("#createDynamicForm").html('');

		
	       var  innerHTML='';
	      $.ajax({        
		        type: "POST",
		        url: "fetchmenudetailsbyid?id="+menuId,             
		        processData: false,
				  contentType: false,
		        success: function(response){                    
		        	 var count =0;
		             for(var y=0; y<response.length; y++){
		 	           
		 	            
		 	           innerHTML=innerHTML+' <div class="col-sm-12 form-group ">  '+
		 	          '<div class="col-sm-6"><label class="control-label " for="name_of_user">'+response[y].menu_field_name  +' <span class="manadatory">*</span>:</label>  </div>'+
		 	         '<div class="col-sm-6 ">  '+
		 	        '<input type="hidden" class="form-control menuFieldValueCss" id="menu_fields_value_id_'+response[y].id  +'"  name="menuFieldsValueModelList['+count+'].id"  /> '+
		 	           '<input type="hidden" class="form-control menuFieldValueCss" id="menu_fields_name_id_'+response[y].id  +'" value="'+response[y].id  +'" name="menuFieldsValueModelList['+count+'].menu_fields_name_id"  /> '+
		 	          ' <input type="text" class="form-control eventMenuValueInputDiv" id="menu_fields_value_'+response[y].id  +'" placeholder="Field Value" name="menuFieldsValueModelList['+count+'].menu_fields_value" />    '+
		 	        ' </div> '+
		 	      ' </div>';
		 	          count++;
		 	          } 
		        	 innerHTML;
		  		  $("#createDynamicForm").append(innerHTML);
		  		$('#saveUpdateMenuFieldValue').bootstrapValidator({
			          framework: 'bootstrap',
			         
			          icon: {
			              valid: 'glyphicon glyphicon-ok',
			              invalid: 'glyphicon glyphicon-remove',
			              validating: 'glyphicon glyphicon-refresh'
			          },
			          excluded: [':disabled'],
			          fields: {
			    
			        	  eventMenuValueInputDiv: {
			  	            selector: '.eventMenuValueInputDiv',
			  	           row: '.accordion',
			  	            validators: {
			  	            	/* notEmpty: {
				                        message: 'This field is required and cannot be empty'
				                    },*/
			  		            stringLength: {
			  	                    max: 1000,
			  	                    message: "The field length must be less than 1000 characters "
			  	                }
			  	           }
			  	        },
			          }
			      });
		  		/* $('.eventMenuValueInputDiv').on('change input', function(e) {
		  			// alert("eventMenuValueInputDiv save");
		           	    $('#saveUpdateMenuFieldValue').bootstrapValidator('revalidateField');
		           	 });*/
		            },
		        error: function(response){                    
		        	console.log(response);
		        }
			    });
	      
	      
	      
}




function saveMenuFieldValue(){
	
	var z = $("#saveUpdateMenuFieldValue").data("bootstrapValidator");
	if (z.validate(), z.isValid()) {
		$.ajax({    //create an ajax request to display       
	        type: "POST",
	        url: "saveUpdateMenuFieldValue",             
	        data: new FormData(document.getElementById("saveUpdateMenuFieldValue")),
	        processData: false,
			  contentType: false,
	        success: function(response){                    
	       // alert(response);
	       
	        $("#menuFieldNameEditAlert").show();
	 		$("#menuFieldNameEditAlert").removeClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").addClass("alert-success");
	        	   $("#menuFieldNameEditAlert").html("Data saved successfully!");
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
	        	   fetchMenuValueListByMenuId();
	        	   createDynamicForm();
		  return;
	     
	     },
	        error: function(response){  
	        	console.log(response);
	       }
		    });
		
     }

}
 function validateForm(){
	
 }
 function editMenuFieldValue(menu_field_value_set_id){
	// alert(menu_field_value_set_id);
	 $.ajax({        
	        type: "POST",
	        url: "fetchMenuValueDetailsBySetId?setId="+menu_field_value_set_id,             
	        processData: false,
			  contentType: false,
	        success: function(response){   
	        //	alert(response);
	        	 
	             for(var y=0; y<response.length; y++){
	 	           
	 	            $("#menu_fields_value_id_"+response[y].menu_fields_name_id).val(response[y].id);
	 	           $("#menu_fields_value_"+response[y].menu_fields_name_id).val(response[y].menu_fields_value).trigger("change");
	 	           
	 	           
	 	          } 
	             
	             $('.eventMenuValueInputDiv').on('change input', function(e) {
		      			// alert("eventMenuValueInputDiv edit");
		           	    $('#saveUpdateMenuFieldValue').bootstrapValidator('revalidateField','eventMenuValueInputDiv');
		           	 });
	          /*   $('#saveUpdateMenuFieldValue').bootstrapValidator({
			          framework: 'bootstrap',
			         
			          icon: {
			              valid: 'glyphicon glyphicon-ok',
			              invalid: 'glyphicon glyphicon-remove',
			              validating: 'glyphicon glyphicon-refresh'
			          },
			          excluded: [':disabled'],
			          fields: {
			    
			        	  eventMenuValueInputDiv: {
			  	            selector: '.eventMenuValueInputDiv',
			  	           row: '.accordion',
			  	            validators: {
			  		            stringLength: {
			  	                    max: 2,
			  	                    message: "The field length must be less than 1000 characters "
			  	                }
			  	           }
			  	        },
			          }
			      });*/
	            },
	        error: function(response){                    
	        	console.log(response);
	        }
		    });
	 
 }
 
 function deleteCurrentEvent(setId){
		$.ajax({    //create an ajax request to display       
			         type: "POST",
			         url: "deleteEventMenuValueBySetId?setId="+setId,             
			        
			         processData: false,
			 		 contentType: false,
			         success: function(response){                    
			       //  alert(response);
			         $("#menuFieldNameEditAlert").show();
			  		$("#menuFieldNameEditAlert").removeClass("alert-danger");
			         	   $("#menuFieldNameEditAlert").addClass("alert-success");
			         	   $("#menuFieldNameEditAlert").html("Deleted successfully!");
			         	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
			         	   fetchMenuValueListByMenuId();
			         	   createDynamicForm();
			            },
			         error: function(response){  
			        	console.log(response);
			         }
			 	    });
			
		}

/*function createNewMenuFieldName(){
	  $('#updateeditedmenufieldname').bootstrapValidator('validate');
	   
	 var id='-1';
	 var eventID=$("#menuEventSelect").val();
	   var menuId=$("#allMenuSelect").val();
	  
	 if((''+eventID).trim()===('-1')){
		 
		 $("#menuFieldNameEditAlert").show();
		 $("#menuFieldNameEditAlert").removeClass("alert-success");
		 $("#menuFieldNameEditAlert").addClass("alert-danger");
 	   $("#menuFieldNameEditAlert").html("Please select an event first!");	
 	  $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");        	   
    return;
 	   
   }
 if((''+menuId).trim()===('-1')){
		 
		 $("#menuFieldNameEditAlert").show();
		 $("#menuFieldNameEditAlert").removeClass("alert-success");
		 $("#menuFieldNameEditAlert").addClass("alert-danger");
 	   $("#menuFieldNameEditAlert").html("Please select a menu!");
 	  $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	        	   
    return;
 	   
   }
	    var	f = new FormData();
	  	f.append('menu_field_name_id_hidden', ''+id);
	   	f.append('menu_field_name', ''+$("#name_of_menu_field").val());
	   	f.append('menu_field_id', ''+$("#allMenuSelect").val());
	      	
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "createmenufieldnamebymenuid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        // alert(response);
	            
	        	  if((''+response)===(''+0)){
	        			 $("#menuFieldNameEditAlert").show();
	        			 $("#menuFieldNameEditAlert").removeClass("alert-success");
		        	   $("#menuFieldNameEditAlert").addClass("alert-danger");
		        	   $("#menuFieldNameEditAlert").html("New menu field name creation failed!");
		        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
		        	   resetFormForMenuFieldName();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#menu_field_name_id_hidden').val('-1');
		           }
	        	   
	        	 
		           else{
		      		 $("#menuFieldNameEditAlert").show();
		      		$("#menuFieldNameEditAlert").removeClass("alert-danger");
		        	   $("#menuFieldNameEditAlert").addClass("alert-success");
		        	   $("#menuFieldNameEditAlert").html("Successsfully added new menu field!");	    
		        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");    	   
		        	   resetFormForMenuFieldName();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#menu_field_name_id_hidden').val('-1');
		           } 
	             console.log(response);
	             showMenuDetails();
	            },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	         	console.log(response);
	         }
	 	    });
	
	 	
	 
}*/


function populateEvents(){
	
	 $.ajax({    //create an ajax request to display.php
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
	 
	 
	 $("#addEditMenuValueFormDiv").hide();
	populateEvents();
	 
	$('#name_of_menu_field').on('change', function(e) {
  	    $('#updateeditedmenufieldname').bootstrapValidator('revalidateField', 'name_of_menu_field');
  	 });
	
	
	
	 
	 
 });
 
 