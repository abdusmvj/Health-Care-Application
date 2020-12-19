



<!-- <div class="container"> -->
<div class="row">
	<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
		<div class="logo-area-menu">
			<a href="#"><img height=" 67px" width="109px"
				src="images/Webel_Logo_after_login.jpg" alt="logo"></a>

		</div>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
	<h1 style="color:#444479;">Event Management System</h1>
	</div>
	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12 user-details-header">
	<div class="row login-user-name">
		Welcome : ${sessionScope.userDetail.name}
		</div>
		<div class="row logout">
			<a href="logout">Logout</a>
		</div>
	
		</div>
	<!-- <div class="col-lg-1 col-md-1 col-sm-1 col-xs-12 logout">
		<a href="logout">Logout</a>
	</div> -->



</div>
<nav class="navbar navbar-inverse" id="myNavbar">
	<ul class="nav navbar-nav">
		<li ><a href="loginProcess">Home</a></li>
		
		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Event<span class="caret"></span></a>
	        <ul class="dropdown-menu cust-drop">
	         <li ><a href="addEditEvent">Create/Edit Event</a></li>
		     <li ><a href="splashImageUpload">Upload Event Screen</a></li>
		     <li ><a href="bannerImageUpload">Upload Event Images</a></li>
	        </ul>
        </li>
		
		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Menu<span class="caret"></span></a>
	       <ul class="dropdown-menu cust-drop">
	     	<li><a href="addEditMenu">Create/Edit Menu</a></li>		
            <li><a href="addEditFieldNameMenu">Create/Edit Menu Field Name</a></li>
                <li><a href="addEditMenuFieldValue">Create/Edit Menu Field Value</a></li>
            
	       </ul>
        </li>
        
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Manage Activity<span class="caret"></span></a>
	        <ul class="dropdown-menu cust-drop">
	       	<li><a href="addEditActivity">Create/Edit Activity</a></li>
		    <li><a href="userActivityMapping">Map User Activity</a></li>
	        </ul>
        </li>
				
		<li><a href="add-edit-user-profile">Create/Edit Participant</a></li>
		<!-- <li><a href="excelUploadForm">Upload Participant List</a></li> -->
	
        <li><a href="addEditSchedule">Create/Edit Schedule</a></li>
        <li ><a href="addEditAbout">Manage About</a></li>
	</ul>
</nav>
<!--   </div> -->
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
.dropdown-menu > li > a {
font-family:    Helvetica Neue, Helvetica, Arial, sans-serif !important;
    font-size: 13px !important;
/* font-size:      1.2em;
border-bottom:  1px solid #008eb7 ;
font-style: italic; */


} 

</style>
 <script >
$(function() {
	var e = window.location.href.substr(window.location.href.lastIndexOf("/") + 1);
	var f=e.slice(0,e.indexOf("?"));
	 $("#myNavbar ul li a").each(function() {
        $(this).attr("href") + "#", $(this).attr("href").indexOf(f) >= 0 || "" == $(this).attr("href") ? $(this).addClass("active") : $(this).removeClass("active")
    });
});
</script>