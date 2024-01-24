<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="Sun, 30 Mar 2020 00:00:00 GMT">
<title>User Sing Up</title>

<link href="static/css/Signup_custom.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>


<form action="updateUserDetails" action ="POST">
<input type="text" name="user_id" value="${userObj.user_id}" />
<input type="text" name="user_role_id" value="${userObj.user_role_id}" />
<div class="container register">
                <div class="row">
                    <div class="col-md-3 register-left">
                        <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
                        <h3>Welcome</h3>
                        <p>You are 30 seconds away from earning your own money!</p>
                        
                       
                        <input type="submit" name="" value="Login"/><br/>
                        <a href="login">Go to People List</a>
                    </div>
                    <div class="col-md-9 register-right">
                        <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Employee</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Hirer</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <h3 class="register-heading">Update User Details</h3>
                                <div class="row register-form">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="inst_name" placeholder="Institute Name *" value="${userObj.inst_name}" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="user_address" placeholder="Address *" value="${userObj.user_address}" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="user_password" placeholder="Password *" value="${userObj.user_password}" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name ="is_active_user"  placeholder="Is Active User *" value="${userObj.is_active_user}" />
                                        </div>
                                        
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="user_email" placeholder="Your Email *" value="${userObj.user_email}" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10" name="user_mob_no" class="form-control" placeholder="Your Phone *" value="${userObj.user_mob_no}" />
                                        </div>
                                        <div class="form-group">
                                             <select class="form-control" name = "userObj.user_role">
                                                <option class="hidden"  selected disabled>Select Role</option>
                                                <option value="User">User</option>
                                                <option value="Admin">Admin</option>
                                            </select>
                                        </div>
                                        
                                        <input type="submit" class="btnRegister"  value="Update"/>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                    </div>
                </div>

            </div>
         </form>