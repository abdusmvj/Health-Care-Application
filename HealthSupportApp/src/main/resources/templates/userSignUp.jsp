<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Sing Up</title>
<link href="static/css/Signup_custom.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script>
$(function() {
    console.log( "ready!" );
    $("#success-alert").show();
    window.setTimeout(function () {
        $("#success-alert").slideUp(500, function () {
             $("#success-alert").hide();
         });
    }, 5000);

    
    $("#failure-alert").show();
    window.setTimeout(function () {
        $("#failure-alert").slideUp(500, function () {
             $("#failure-alert").hide();
         });
    }, 5000);

   
});

</script>
<div class="container" id ="success-alert">
		<% if(request.getAttribute("reg-success-alert") != null) { %>
		<div class="alert alert-danger text-center" style="margin-top:5px; margin-bottom:5px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=request.getAttribute("reg-success-alert")%>
		</div>
		<% request.removeAttribute("reg-success-alert"); } %>
</div>

<div class="container" id ="failure-alert">
		<% if(request.getAttribute("reg-fail-alert") != null) { %>
		<div class="alert alert-danger text-center" style="margin-top:5px; margin-bottom:5px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=request.getAttribute("reg-fail-alert")%>
		</div>
		<% request.removeAttribute("reg-fail-alert"); } %>
</div>
<form action="saveUserRegistration">
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome</h3>
                        <p>Please Register before login!</p>
                       
<!--                         <div class="text-center"> -->
<!--   <a href="" class="btn btn-default btn-rounded" data-toggle="modal" data-target="#elegantModalForm">Launch -->
<!--      Login</a> -->
<!-- </div> -->
                        <input type="submit" name="" value="Login"/><br/>
                        <a href="login">Go back to Login</a>
                    </div>
                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">User</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Admin</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Signup User</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="user_name" placeholder="First Name *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="user_address" placeholder="Address *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="user_password" placeholder="Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name ="is_active_user"  placeholder="Is Active User *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="user_gender" value="male" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="user_gender" value="female">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="user_email" placeholder="Your Email *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="user_mob_no" class="form-control" placeholder="Your Phone *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <select class="form-control" name = "user_dept">
                                                <option class="hidden"  selected disabled>Please select Department</option>
                                                <option value="A1">A1</option>
                                                <option value="A2">A2</option>
                                                <option value="A3">A3</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control"  placeholder="User role id" value="" />
                                        </div>
                                        <input type="submit" class="btnRegister"  value="Register"/>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>

            </div>
         </form>