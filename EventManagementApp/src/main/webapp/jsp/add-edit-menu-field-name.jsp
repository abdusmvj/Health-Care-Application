<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create/Edit Menu Field Name</title>

<%@include file="common/header.jsp"%>
</head>
 
<body>


	<div class="container">
<%@include file="common/menu.jsp"%>

<div class="panel panel-default">				
<div class="panel-body custom-event-form-design custom-body"> 

<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group left has-feedback">
							<div class="col-lg-2 ">
								<label class="control-label " for="eventId">Event <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-8">
								<select id="menuEventSelect" name="menuEventSelect" class="form-control inp ploaceholderinp" onchange="loadMenuByEventId();">	
								<option selected="selected" > Loading... Please wait</option>								           						
								</select>
									</div>
						</div>
				   </div>
				
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right has-feedback">
							<div class="col-lg-2">
								<label class="control-label" for="facebook_link">Menu <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-8">
								<select id="allMenuSelect" name="allMenuSelect" class="form-control inp ploaceholderinp" onchange="showMenuDetails();">	
								<option>Select an event first</option>							           						
								</select>		
							</div>
						 </div>
				   </div>
				   </div>
				   
				   
				   
  <!--  <div class="col-sm-12"> 





             
                   <div class="row"> 
					
						<div class="col-lg-2 " >
								<label class="control-label "  for="menuEventSelect">Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-3">
								<select id="menuEventSelect" name="menuEventSelect" class="form-control inp ploaceholderinp" onchange="loadMenuByEventId();">	
								<option selected="selected" > Loading... Please wait</option>								           						
								</select>
						</div>
					
				  <div class="col-lg-1  ">
				  </div>
                  
						<div class="col-lg-2 ">
								<label class="control-label " for="allMenuSelect">Menu<span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-3">
								<select id="allMenuSelect" name="allMenuSelect" class="form-control inp ploaceholderinp" onchange="showMenuDetails();">	
								<option>Select an event first</option>							           						
								</select>
						</div>
					
				 		 <div class="col-lg-1  ">
				  </div>	
			   </div>
					
   </div> -->
  </br></br></br>
	       
                     <div  id="show-list-table-div"  class="col-sm-12">
                                         
  <table id="allEventTable" class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable     table table-bordered">
    <thead>
      <tr>
        <th>#</th>
        <th>Field Name<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
                
                 
         <th></th>
         <th></th>
        </tr>
      
      <tr>
				  <th></th>
          <th> <!-- input filter -->
            
            <input  class="js-filter  form-control" type="text" value="">
          </th>
                   <th></th>
                   <th></th>
         </tr>
          
      
    </thead>
    <tbody id="editMenuFieldNameTbody" class="show-scroll">
       
    </tbody>
  </table>
  </div>
</div>
</div>
</div><!-- Sriparna css -->

<!-- Sriparna css -->
 <div   class="container" id="edit-update-menu-field-name">
 
 
<div class="alert fade in alert-dismissable" id="menuFieldNameEditAlert">
   
</div>
<div class="panel panel-default">
<!-- Sriparna css -->
  <div class="panel-heading"></i><span id="editMenuPanelFormHeading"><strong>Create/Edit Menu Field Name</strong></span>  <button type="button" id="saveCurrentMenuFieldNameButton" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right" onclick="resetFormForMenuFieldName();newMenuFieldNameAlert();"><i class="fa fa-plus" aria-hidden="true"></i>Create New</button> </div>
  <!-- Sriparna css -->
  <div class="panel-body custom-event-form-design">
  <form class="form-inline" id="updateeditedmenufieldname" >
 <input type="hidden"  id="menu_field_name_id_hidden" name="menu_field_name_id_hidden" value="-1"/>
 <div class="col-sm-12">
<div class="col-sm-10"> 
 
    <div class="form-group  col-sm-12">
      <label class="control-label col-sm-2" for="name_of_user">Field Name <span class="manadatory">*</span>:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="name_of_menu_field" placeholder="Field Name of Menu" name="name_of_menu_field" />  
      </div>
    </div>
 </div>
 
</div>
     <div class="col-sm-12 text-center" style="margin-top: 28px !important;">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">   	<!-- 	Sriparna css -->
        <button type="submit" class="btn btn-default save-btn" id="update_user" name="update_user"  onclick="saveMenuFieldName();" >Save</button>
      </div>
    </div>
</div>
 </form>

</div>
</div>
 </div>

 <input type="hidden" name="taskNow" id="taskNow" value="-1" />
 
 
  <!-- Delete Modal -->
	<div class="modal fade" id="deleteMenuFieldModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteMenuFieldIdForModal"
					id="deleteMenuFieldIdForModal" val="-1">
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Menu</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to delete menu field "<span class="currentMenuFieldNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentMenuFieldName($('#deleteMenuFieldIdForModal').val());">Delete</button>
				</div>				
			</div>
		</div>
	</div>
	<%@include file="common/footer.jsp"%>
</body>

<script>
//alert("Hii");
function newMenuFieldNameAlert(){
	
	 $("#menuFieldNameEditAlert").show();
		$("#menuFieldNameEditAlert").removeClass("alert-danger");
     	   $("#menuFieldNameEditAlert").addClass("alert-success");
     	   $("#menuFieldNameEditAlert").html("Please enter new user information!");	
     	  $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
	
}
function loadMenuByEventId(){

var	  f = new FormData();
	
	
	f.append('id', ''+$("#menuEventSelect").val());

	$.ajax({    //create an ajax request to display       
        type: "POST",
        url: "fetchallmenusbyid",             
        data: f,
        processData: false,
		  contentType: false,
        success: function(response){                    
        	 //alert(response);
           
            var  menuHTML='<option value="-1">Select Menu</option>';
            for(var y=0; y<response.length; y++){
               menuHTML=menuHTML+'<option value="'+response[y].id+'">'+response[y].menu_name+'</option>';
             }
            $("#allMenuSelect").html(menuHTML);
            showMenuDetails();
            console.log(response);
            $('#updateeditedmenufieldname').bootstrapValidator('resetForm', true);
              
           },
        error: function(response){                    
        	console.log(response);
        }
	    });
	 
}
function showMenuDetails(){
 
	 var id=$("#allMenuSelect").val();
	
	 var	  f = new FormData();
		
		
		f.append('id',''+id);

		$.ajax({    //create an ajax request to display.php          
	        type: "POST",
	        url: "fetchmenudetailsbyid",             
	        data: f,
	        processData: false,
			  contentType: false,
	        success: function(response){                    
	        	 //alert(response);
	        	 $("#editMenuFieldNameTbody").html('');
	        	  var  menuHTML='';
	                var count =0;
	                
	        	 for(var y=0; y<response.length; y++){
	 	            count++;
	 	                 menuHTML=''+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
	 	                  '<td>'+count  +'</td>'+
	 	                  '<td><div id="row_menu_field_name_'+response[y].id +'"   >'+response[y].menu_field_name  +'</td>'+
	 	                  
	 	                  '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" onclick="editCurrentMenuFieldName('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button> '+
	 	                  '</div> </td>'+
	 	                 '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#deleteMenuFieldModal" onclick="deleteMenuFieldIdtoModal('+response[y].id+');"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> '+
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


function editCurrentMenuFieldName(id){
	
	 
		
		$("#menu_field_name_id_hidden").val(id);
		$("#taskNow").val("E");
			 	 var	  f = new FormData();
			  	f.append('id', ''+id);
	  	$.ajax({    //create an ajax request to display       
			         type: "POST",
			         url: "fetchmenufieldnamedetailbyid",             
			         data: f,
			         processData: false,
			 		  contentType: false,
			         success: function(response){                    
			        // alert(response);
			          $("#menu_field_name_id_hidden").val(""+response[0].id).trigger("change");
			          $("#name_of_menu_field").val(""+(response[0].menu_field_name?response[0].menu_field_name:"")).trigger("change");
			          
			          $("#saveCurrentMenuFieldNameButton").prop("disabled",false);
			             console.log(response);
			               
			            },
			         error: function(response){  
			        	console.log(response);
			         }
			 	    });
			
		 

	
}
function saveMenuFieldName(){
//	 console.log('checkIfFormIsValid'); 
	//console.log(checkIfFormIsValid('updateediteduser')); 
	
	let isValid=checkIfFormIsValid('updateeditedmenufieldname');
	let currentTask=$("#taskNow").val();
	/* if(currentTask=='-1'){
		 $("#menuFieldNameEditAlert").show();
	 		$("#menuFieldNameEditAlert").removeClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").addClass("alert-success");
	        	   $("#menuFieldNameEditAlert").html("Please press 'Create New' for new menu field, and 'Edit' for editing existing menu field info!");
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
	      		  return;
	} */
	if(isValid){
		
		if($("#menu_field_name_id_hidden").val().trim()=='-1'){
	 		//create new
	 		createNewMenuFieldName();
	 	}
		else{
			saveCurrentMenuFieldName();
	 	}
	}
	else{
		  $("#menuFieldNameEditAlert").show();
	 		$("#menuFieldNameEditAlert").removeClass("alert-success");
	        	   $("#menuFieldNameEditAlert").addClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").html("Please put valid data in all the fields!");
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
		  return;
		
		
	}
}
 
 
function saveCurrentMenuFieldName(){
	 var id=$("#menu_field_name_id_hidden").val();
	 
	  $('#updateeditedmenufieldname').bootstrapValidator('validate');
	  console.log( $('#updateeditedmenufieldname').bootstrapValidator('isValid'));
	  if (!$('#updateeditedmenufieldname').bootstrapValidator('isValid')) {
          
		  $("#menuFieldNameEditAlert").show();
	 		$("#menuFieldNameEditAlert").removeClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").addClass("alert-success");
	        	   $("#menuFieldNameEditAlert").html("Please put valid data in all the fields!");
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
		  return;
     }
	  
	    var	f = new FormData();
	  	f.append('menu_field_name_id_hidden', ''+id);
 
	  		f.append('menu_field_name', ''+$("#name_of_menu_field").val());
	   	f.append('menu_field_id', ''+$("#allMenuSelect").val());
	   	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updatemenufieldnamebymenuid",             
	         data: f,
	         processData: false,
	 		  contentType: false,
	         success: function(response){                    
	        // alert(response);
	            
	      if((''+response)===(''+1)){
	 		 $("#menuFieldNameEditAlert").show();
	 		$("#menuFieldNameEditAlert").removeClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").addClass("alert-success");
	        	   $("#menuFieldNameEditAlert").html("Successfully updated!");	
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
	        	   resetFormForMenuFieldName();
	        	   $("#taskNow").val('-1');
	        	    
	        		$('#menu_field_name_id_hidden').val('-1');
	        		 
	        		showMenuDetails();
	      }
	           else{
	      		 $("#menuFieldNameEditAlert").show();
	      		$("#menuFieldNameEditAlert").removeClass("alert-success");
	        	   $("#menuFieldNameEditAlert").addClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").html("Failed to update!");	
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");
	        	   resetFormForMenuFieldName();
	        	   $("#taskNow").val('-1');
	        	    
	        		$('#menu_field_name_id_hidden').val('-1');
	        		
	           } 
	      $("#menu_field_name_id_hidden").val("-1");
         //$("#saveCurrentUserButton").prop("disabled",true);
	             console.log(response);
	              
	            },
	         error: function(response){  
	        	// $("#editEventPanelFormHeading").html("Error while fetching details of '"+editEventPanelFormHeading+"' event.Please try again!");
	         $("#menu_field_name_id_hidden").val("-1");
	        	
	        	console.log(response);
	         }
	 	    });
	
	
	
}
function createNewMenuFieldName(){
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
	
	 	
	 
}
function resetFormForMenuFieldName(){
	
	
	$('#updateeditedmenufieldname')[0].reset();
	$('#menu_field_name_id_hidden').val('-1');
	$("#taskNow").val("N");
	 
	  
    $("#name_of_menu_field").trigger("change");

    /*  Sriparna validation */
    $('#updateeditedmenufieldname').bootstrapValidator('resetForm', true);
   /*  $('#updateeditedmenufieldname').bootstrapValidator('validate');
    $('#updateeditedmenufieldname').bootstrapValidator('revalidateField', 'name_of_menu_field'); */
}

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
function checkIfFormIsValid(formId){
 	if($('#'+formId).bootstrapValidator('validate').has('.has-error').length === 0){
 		return true;
 		
 	}
 	else{
 		return false;
 	}
 
	return true;
}
function validateForm(formId){
$('#'+formId).bootstrapValidator('validate');
}

function addmorefields(){
	
	 var html = $(".copy-fields").html();
     $(".after-add-more").after(html);
	
	
}

function removethesefields(t){

	  t.parents(".control-group").remove();

}
function deleteCurrentMenuFieldName(id){
	$('#menu_field_name_id_hidden').val(id);
	 
	 var	  f = new FormData();
 	f.append('id', ''+id);
$.ajax({    //create an ajax request to display       
        type: "POST",
        url: "deletemenufieldnamebyid",             
        data: f,
        processData: false,
		  contentType: false,
        success: function(response){                    
       	 if((''+response)===(''+1)){
   	 		 $("#menuFieldNameEditAlert").show();
   	 		$("#menuFieldNameEditAlert").removeClass("alert-danger");
   	        	   $("#menuFieldNameEditAlert").addClass("alert-success");
   	        	   $("#menuFieldNameEditAlert").html("Successfully deleted!");	
   	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
   	        	   showMenuDetails();
   	        	  resetFormForMenuFieldName();
   	      }
   	           else{
   	      		 $("#menuFieldNameEditAlert").show();
   	      		$("#menuFieldNameEditAlert").removeClass("alert-success");
   	        	   $("#menuFieldNameEditAlert").addClass("alert-danger");
   	        	   $("#menuFieldNameEditAlert").html("Failed to delete!");	
   	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
   	            } 
            console.log(response);
            },
        error: function(response){  
       	 
	      		 $("#menuFieldNameEditAlert").show();
	      		$("#menuFieldNameEditAlert").removeClass("alert-success");
	        	   $("#menuFieldNameEditAlert").addClass("alert-danger");
	        	   $("#menuFieldNameEditAlert").html("Failed to delete! Unknown error...");	
	        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
	            
       	 console.log(response);
       	
        }
	    });


}


$( document ).ready(function() {
	 
	 
	 
	populateEvents();
	 
	$('#name_of_menu_field').on('change', function(e) {
  	    $('#updateeditedmenufieldname').bootstrapValidator('revalidateField', 'name_of_menu_field');
  	 });
	
		$('#updateeditedmenufieldname').bootstrapValidator({
	        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	
	        	name_of_menu_field: {
                   validators: {
                    notEmpty: {
                        message: 'The name of menu field is required and cannot be empty'
                    },
                    stringLength: {
                        max:100,
                        message: 'The name must be less than 100 characters'
                        
                    } ,               
                }
            } ,
             	}
				}) .on('success.form.bv', function(e) {
		          
	            e.preventDefault();
 	         
	        });
	
	 
	 
 });
function deleteMenuFieldIdtoModal(mid){
	 $('.currentMenuFieldNameForModal').html(""+$("#row_menu_field_name_"+mid).html());	
	 $("#deleteMenuFieldIdForModal").val(mid);
}
 
 
  </script>
<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script> 
 
</html>