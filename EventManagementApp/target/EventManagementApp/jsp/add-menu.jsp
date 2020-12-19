<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create/Edit Menu</title>

<%@include file="common/header.jsp"%>
</head>

  
 

 
<body>


	<div class="container">
<%@include file="common/menu.jsp"%>

<div class="panel panel-default">
				
 <div class="panel-body custom-event-form-design custom-body"> 

<!-- <div class="col-sm-12"> 

<div class="form-horizontal">
    <div class="control-group row-fluid form-inline">
        <label for="menuEventSelect" class="control-label"> Select Events:</label>
        <div class="controls">
           <select name="menuEventSelect" id="menuEventSelect" onchange="loadMenuByEventId();"> <option selected="selected" > Loading... Please wait</option> </select>
        </div>
    </div>
</div>
   </div> -->
   
   
   
               <div class="row" style="margin-bottom: 15px;">
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
					<div class="form-group ">
					<!-- Sriparna css -->
						<div class="col-lg-2 " style="margin-left: 29px;">
								<label class="control-label " for="menuEventSelect">Event <span class="manadatory">*</span> :</label>
						</div>
						<div class="col-lg-8">
								<select id="menuEventSelect" name="menuEventSelect" class="form-control inp ploaceholderinp" onchange="loadMenuByEventId();">	
								<option selected="selected" > Loading... Please wait</option>								           						
								</select>
						</div>
					</div>
				  </div>			
			   </div>
   

 

	       
 <div  id="show-list-table-div"  class="col-sm-12">
                                         
  <table id="allEventTable" class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable     table table-bordered">
    <thead>
      <tr>
        <th>#</th>
        <th>Menu Name<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
                
           <th>Restricted Access<span class="js-sorter-desc     glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span>
                                <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>       
         <th></th>
         <th></th>
        </tr>
      
      <tr>
				  <th></th>
          <th> <!-- input filter -->
            
            <input  class="js-filter  form-control" type="text" value="">
          </th>
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
 <div   class=" container" id="edit-update-menu-field-name">
 
 
<div class="alert fade in alert-dismissable" id="menuFieldNameEditAlert">
   
</div>
<div class="panel panel-default">
  <!-- Sriparna css -->
  <div class="panel-heading"> <!-- style="padding: 23px 15px !important;padding-top: 9px !important;" --></i><span id="editMenuPanelFormHeading"><strong>Create/Edit Menu</strong></span>  <button type="button" id="saveCurrentMenuFieldNameButton" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right" onclick="resetFormForMenuFieldName();newMenuFieldNameAlert();"><i class="fa fa-plus" aria-hidden="true"></i>Create New</button> </div>
  
  <!-- Sriparna css -->
  <div class="panel-body custom-event-form-design">
  <form class="form-inline" id="updateeditedmenufieldname" >
 <input type="hidden"  id="menu_field_name_id_hidden" name="menu_field_name_id_hidden" value="-1"/>
 <div class="col-sm-12">
<div class="col-sm-10"> 
 
    <div class="form-group  col-sm-12">
      <label class="control-label col-sm-2" for="name_of_menu_field">Menu Name <span class="manadatory">*</span>:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="name_of_menu_field" placeholder="Name of Menu" name="name_of_menu_field" />  
      </div>
    </div>
 </div>
 
</div>


 <div class="col-sm-12">
<div class="col-sm-10"> 
 
    <div class="form-group  col-sm-12">
     	<label class="control-label col-sm-2 " for="is_restriction_acccess" >Restricted Access
								 <span class="manadatory">*</span>  :</label>
      <div class="col-sm-6">
       <div class="radioStyle col-lg-4" style="margin: 18px -15px 0px !important;">
							<input type="radio"  id="is_restriction_acccess"
								name="is_restriction_acccess" 							
								value="1">YES
							<!-- 	Sriparna css -->
								<input type="radio"  id="is_restriction_acccess" 
								name="is_restriction_acccess" 							
								value="0">NO	
						</div>	 
      </div>
    </div>
 </div>
 
</div>


     <div class="col-sm-12 text-center" style="margin-top: 28px !important;">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
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
	<div class="modal fade" id="deleteMenuModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content cont">	
			<input type="hidden" name="deleteMenuIdForModal"
					id="deleteMenuIdForModal" val="-1">
					
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style=" color: #0e537b;">
						 
					<strong>Delete Menu</strong>
					</h4>
				</div>
				<div class="modal-body" style=" color: #063d5f;">
					<p>
						
						<strong>Do you want to delete menu "<span class="currentMenuNameForModal"></span> " ?</strong>
					</p>
				</div>
				<div class="modal-footer foot">
					<button type="button" class="btn btn-default" data-dismiss="modal" style="float: left;color: #e2d0d0; background-color: #0e537b;border-color: #ccc;">Dismiss</button>
					<button type="submit" class="btn btn-default" data-dismiss="modal"
						onclick="deleteCurrentMenu($('#deleteMenuIdForModal').val());">Delete</button>
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
     	   $("#menuFieldNameEditAlert").html("Please enter new menu field name information!");	
     	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	
	
} 
function loadMenuByEventId(){

var	  f = new FormData();
	
	f.append('id', ''+$("#menuEventSelect").val());

	$.ajax({    //create an ajax request to display       
        type: "POST",
        url: "fetchmenudetailbyeventid",             
        data: f,
        processData: false,
		  contentType: false,
        success: function(response){                    
        	 //alert(response);
    console.log("response");
    console.log(response);
            $("#editMenuFieldNameTbody").html('');
      	  	var  menuHTML='';
            var count =0;
            var is_restrctn_acccess='';
           
              
      	 for(var y=0; y<response.length; y++){
      		 if(response[y].is_restricted_access==1){
           	    is_restrctn_acccess = "Yes";
           	} else{
                  is_restrctn_acccess = "No";
              }
	            count++;
	                 menuHTML=''+'<tr> <input type="hidden" class="row_id_hidden" name="row_'+ response[y].id +'"  id="row_'+ response[y].id +'" >'+
	                  '<td>'+count  +'</td>'+
	                  '<td> <div id="row_menu_name_'+response[y].id +'"   >'+response[y].menu_name  +'</td>'+
	                  '<td> <div id="row_restr_access_'+response[y].id +'"   >'+(is_restrctn_acccess) +' </td>'+
	                  '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" onclick="editCurrentMenuName('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</button> '+
	                  '</div> </td>'+
	                  '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#deleteMenuModal" onclick="deleteMenuIdtoModal('+response[y].id+');"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</button> '+
 	                  '</div> </td>'+
	                   ' </tr>';
	               $("#editMenuFieldNameTbody").append(menuHTML);
	               } 
      	$('#updateeditedmenufieldname').bootstrapValidator('resetForm', true);
           },
        error: function(response){                    
        	console.log(response);
        }
	    });
	 
}
function showMenuDetails(){
 
	 var id=$("#menuEventSelect").val();
	
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
	 	                  '<td>'+response[y].menu_field_name  +'</td>'+
	 	                  
	 	                  '<td> <div class="btn-group" role="group" aria-label="User Action"> <button type="button" class="btn btn-default" onclick="editCurrentMenuFieldName('+response[y].id+');"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>Edit</button> '+
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


function editCurrentMenuName(id){//change
	
		$("#menu_field_name_id_hidden").val(id);
		$("#taskNow").val("E");
			 	 var	  f = new FormData();
			  	f.append('id', ''+id);
	  	$.ajax({    //create an ajax request to display       
			         type: "POST",
			         url: "fetchmenunamedetailbyid",             
			         data: f,
			         processData: false,
			 		  contentType: false,
			         success: function(response){                    
			        // alert(response);
			          $("#menu_field_name_id_hidden").val(""+response[0].id).trigger("change");
			          $("#name_of_menu_field").val(""+(response[0].menu_name?response[0].menu_name:"")).trigger("change");
			          var is_restrctn_acccess = response[0].is_restricted_access ;
			        	if(is_restrctn_acccess == '1'){
			        		$('input:radio[name=is_restriction_acccess]')[0].checked = true;
			        	}
			        	else{
			        		$('input:radio[name=is_restriction_acccess]')[1].checked = true;
			        	}
			        	  $("#is_restriction_acccess").trigger("change");
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
function deleteCurrentMenu(id){

	$('#menu_field_name_id_hidden').val(id);
 	 var	  f = new FormData();
	  	f.append('id', ''+id);
	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "deletemenubyid",             
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
	    	          		loadMenuByEventId();
	    	          	    resetFormForMenuFieldName();
	    	      }   else{
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
	   	f.append('menu_field_id', ''+$("#menuEventSelect").val());

	   	if($('input:radio[name=is_restriction_acccess]')[0].checked == true){http://192.168.1.60:8080/EventManagementApp/addEditMenu
			f.append('is_restriction_acccess', ''+$('#is_restriction_acccess:checked').val());	
			
		} else{
		    f.append('is_restriction_acccess','0');	
		   
	    }
	    	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "updatemenunamebymenuid",             
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
	        		 
	        		loadMenuByEventId();
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
	   
	  
	 if((''+eventID).trim()===('-1')){
		 
		 $("#menuFieldNameEditAlert").show();
		 $("#menuFieldNameEditAlert").removeClass("alert-success");
		 $("#menuFieldNameEditAlert").addClass("alert-danger");
 	   $("#menuFieldNameEditAlert").html("Please select an event first!");	
 	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");	        	   
    return;
 	   
   }
 
	    var	f = new FormData();
	  	f.append('menu_field_name_id_hidden', ''+$("#name_of_menu_field").val());
	   	f.append('menu_field_id', ''+$("#menuEventSelect").val());
	   	if($('input:radio[name=is_restriction_acccess]')[0].checked == true){//Tajinder Changes Done
			f.append('is_restriction_acccess', ''+$('#is_restriction_acccess:checked').val());	
			
		} else{
		    f.append('is_restriction_acccess','0');	
		   
	    }
	 	$.ajax({    //create an ajax request to display       
	         type: "POST",
	         url: "createmenubyeventid",             
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
		        	   $("#menuFieldNameEditAlert").html("Successsfully added new menu field name!");
		        	   $("#menuFieldNameEditAlert").delay(1000).fadeOut("12000");		        	   
		        	   resetFormForMenuFieldName();
		        	   $("#taskNow").val('-1');
		        	    
		        		$('#menu_field_name_id_hidden').val('-1');
		           } 
	             console.log(response);
	             loadMenuByEventId();
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
    /* $('#updateeditedmenufieldname').bootstrapValidator('validate');
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
                        message: 'The name of menu is required and cannot be empty'
                    },
                    stringLength: {
                        max:100,
                        message: 'The name must be less than 100 characters'
                        
                    } ,               
                }
            } ,
            is_restriction_acccess: {//Tajinder Changes Done
                validators: {
                    notEmpty: {
                        message: 'This field is required and cannot be empty'
                    }          
                }
            },
             	}
				}) .on('success.form.bv', function(e) {
		          
	            e.preventDefault();
 	         
	        });

 });

function deleteMenuIdtoModal(mid){
	 $('.currentMenuNameForModal').html(""+$("#row_menu_name_"+mid).html());	
	 $("#deleteMenuIdForModal").val(mid);
}
 
  </script>
<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script> 
 
</html>