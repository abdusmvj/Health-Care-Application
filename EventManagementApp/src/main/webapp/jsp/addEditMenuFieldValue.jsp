<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Create/Edit Menu Field Value</title>
 
<%@include file="common/header.jsp"%>
<script src="js/pageJS/addEditMenuFieldValue.js"/></script> 
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
								<select id="allMenuSelect" name="allMenuSelect" class="form-control inp ploaceholderinp" onchange="showMenuDetails();createDynamicForm();fetchMenuValueListByMenuId();">	
								<option>Select an event first</option>							           						
								</select>	
							</div>
						 </div>
				   </div>
				   </div>
				   
<!-- <div class="col-sm-12"> 





             
                   <div class="row"> 
					
						<div class="col-lg-2  ">
								<label class="control-label " for="menuEventSelect">Event <span class="manadatory">*</span> :</label>
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
								<select id="allMenuSelect" name="allMenuSelect" class="form-control inp ploaceholderinp" onchange="showMenuDetails();createDynamicForm();fetchMenuValueListByMenuId();">	
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
    <thead id="editMenuFieldNameTHead">
    
     </thead>
    <tbody id="editMenuFieldNameTbody" class="show-scroll">
       
    </tbody>
  </table>
  </div>
</div>
</div>


 <div class="row" id="addEditMenuValueFormDiv"> 
					
 <div   class="col-sm-12" id="edit-update-menu-field-name">
 
 
<div class="alert fade in alert-dismissable" id="menuFieldNameEditAlert">
   
</div>
<div class="panel panel-default">
  <div class="panel-heading" style="padding: 23px 15px !important;padding-top: 9px !important;"></i><span id="editMenuPanelFormHeading"><strong>Create/Edit Menu Field Value</strong></span>  <button type="button" id="saveCurrentMenuFieldNameButton" class="btn btn-default btn-default-custom-style btn-primary button-md pull-right" onclick="createDynamicForm();"><i class="fa fa-plus" aria-hidden="true"></i>Create New</button> </div>
  
  <div class="panel-body">
   <form class="form-inline"method="post"action="javascript:return;"  id="saveUpdateMenuFieldValue" >
<!--  <input type="hidden"  id="menu_field_name_id_hidden" name="menu_field_name_id_hidden" value="-1"/> -->
 <input type="hidden"  id="saveEventId" name="eventId" value="1"/>
 <input type="hidden"  id="saveMenuId" name="menuId" value="1"/>
 <div class="accordion" id="createDynamicForm">

 
</div>
     <div class="col-sm-12 text-center" style="margin-top: 28px !important;">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-default btn-primary save-btn" id="update_user" name="update_user"  onclick="saveMenuFieldValue();" >Save</button>
      </div>
    </div>
</div>
 </form> 

</div>
</div>
 </div>
 </div>
</div>
 
</body>


<!-- dynamitable --> 
 <script src="js/dynamitable.jquery.min.js"/></script> 
 
</html>