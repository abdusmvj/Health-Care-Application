<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage About</title>
</head>
<div id="loadingImage" style="display: none;" class="inbox-loader">
		<img src="images/loader.gif" alt="Loding" class="loader">
</div>

<style>
.inbox-loader{
height: 100px;
   width: 100px;
   position: fixed;
   z-index: 1000;
   left: 50%;
   top: 50%;
   margin: -25px 0 0 -25px;
}

</style>


<%@include file="common/header.jsp"%>
<script src="js/pageJS/addEditAbout.js" type="text/javascript"></script>
<!-- <script src="js/dynamitable.jquery.min.js"/></script>  -->
<body>
<div class="container">
<%@include file="common/menu.jsp"%>

	<div class="alert" id="eventEditAlert"></div>
	
	<div class="panel panel-default">
	
	<div class="panel-body custom-event-form-design custom-body ">
		
 	<div  id="show-list-table-div">
		<table class="show-list table table-striped table-bordered table-hover table-condensed show-scroll js-dynamitable     table table-bordered"  >
			 <thead id = "editMenuThead">
				<tr>
					<th width="2% !important">#</th>
					<th width="7% !important">Event Name<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="9% !important">About <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="7% !important">Contact Person <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="7% !important">Contact No.  <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">Contact Email  <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="7% !important">Email Sender Name  <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="8% !important">Email Body  <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">Facebook Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">Twitter Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">LinkedIn Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">Blogger Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">GooglePlus Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="6% !important">Tumblr Link<span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="7% !important">Video Link <span class="js-sorter-desc glyphicon glyphicon-chevron-down pull-right custom-glyphicon"></span> <span class="js-sorter-asc     glyphicon glyphicon-chevron-up pull-right custom-glyphicon"></span></th>
					<th width="4% !important">Edit</th>
				</tr>
				<tr>
				 	<th width="2% !important"></th>
		            <th width="7% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="9% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="7% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="7% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="7% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="8% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="6% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="7% !important"><input class="js-filter  form-control form-square" type="text" value=""></th>
		            <th width="4% !important"></th>
                </tr>
			</thead> 
			<tbody id="editMenuTbody"></tbody>
		</table>
	</div>
</div>
</div>
</div>
</div>


<div class="container" id="edit-update-form">
	<form class="form-horizontal" id="eventAboutForm" name ="eventAboutForm">
		<div id="msg" class="alert alert-success fade in">
           <center><font color="green"><strong><span id="editEventPanelFormHeading"></span></strong></font></center>
        </div>
		<div class="panel panel-default">
			<div class="panel-heading"><span><strong>Manage About</strong></span></div>

			<div class="panel-body custom-event-form-design ">
				<input type="hidden" id="event_id_hidden" name="event_id_hidden" value="-1" />
			    <div class="row">
			      <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12"> 
                   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group left">
							<div class="col-lg-4 ">
								<label class="control-label " for="eventId">Event Name <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-6">
								<input type="hidden" class="form-control" id="eventId" name="eventId" /> 
								<input type="text" class="form-control" id="event_name" placeholder="Event Name" name="event_name" readonly="true"/> 
								<!-- <select class="form-control" id = "eventId" name = "eventId" disabled> </select> -->
							</div>
						</div>
				   </div>
				
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="facebook_link" >Facebook Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="facebook_link"
										placeholder="Facebook Link" name="facebook_link" />
							</div>
						 </div>
				   </div>
				   </div>
				   
				   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group left">
							<div class="col-lg-4 ">
								<label class="control-label " for="about_us">About<span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-6">
								<textarea  class="form-control" id="about_us" placeholder="About Event" name="about_us" ></textarea>
							</div>
						</div>
				   </div>
				   
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="twitter_link" >Twitter Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="twitter_link"
										placeholder="Twitter Link" name="twitter_link" />
							</div>
					    </div>
				   </div>
				   </div>
				   
				   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="contact_person" >Contact Person <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="contact_person"
										placeholder="Contact Person" name="contact_person" />
							</div>
					    </div>
				   </div>
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="linkedin_link" >LinkedIn Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="linkedin_link"
										placeholder="Linkedin Link" name="linkedin_link" />
							</div>
						 </div>
				   </div>
				   </div>
				    
				   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="contact_no" >Contact No. <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="contact_no"
										placeholder="Contact No" name="contact_no" />
							</div>
					    </div>
				   </div>
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="blogger_link" >Blogger Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="blogger_link"
										placeholder="Blogger Link" name="blogger_link" />
							</div>
					    </div>
				   </div>
				   </div>
				     
				     <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="contact_email" >Contact Email <span class="manadatory">*</span> :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="contact_email"
										placeholder="Contact Email" name="contact_email" />
							</div>
					    </div>
				   </div>
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="tumblr_link" >Tumblr Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="tumblr_link"
										placeholder="Tumblr Link" name="tumblr_link" />
							</div>
					    </div>
				   </div>
				   </div>
				    
				   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="msg_sender_name" >Email Sender Name :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="msg_sender_name"
										placeholder="Message Sender Name" name="msg_sender_name" />
							</div>
					    </div>
				   </div>
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="google_plus_link" >GooglePlus Link :</label>
							</div>
							<div class="col-lg-6">
									<input type="text" class="form-control" id="google_plus_link"
										placeholder="GooglePlus Link" name="google_plus_link" />
							</div>
					    </div>
				   </div>
				   </div>   
				    
				   <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="msg_body" >Email Body :</label>
							</div>
							<div class="col-lg-6">
									<textarea class="form-control" id="msg_body" rows="10"
										placeholder="Message Body" name="msg_body" ></textarea>
							</div>
					    </div>
				   </div>
				   <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"> 
						<div class="form-group right">
							<div class="col-lg-4">
								<label class="control-label" for="live_url" >Video Link :</label>
							</div>
							<div class="col-lg-6">
									<textarea class="form-control" id="live_url" rows="10"
										placeholder="Live URL" name="live_url" ></textarea>
							</div>
							
					    </div>
				   </div>
				   </div>
				    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" >
				   		<div class="recommend-text-commaSepartor">(Comma separator recomended </br> for multiple URL)</div>
				   </div> 
				   </div>
				   <div class="form-group pull-right">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-default btn-primary save-btn" id="update_about"
								name="update_about" style='margin-right: 650px;' onclick="addEditAbout();">Save</button>
					</div>
				</div>
				   </div>
			    </div>	
				<br>
				<br>
				
			</div>
		</div>
	</form>
</div>
<script src="js/dynamitable.jquery.min.js"/></script> 
<%@include file="common/footer.jsp"%>
<%-- <%@include file="common/footer.jsp"%> --%>
</body>

</html>
