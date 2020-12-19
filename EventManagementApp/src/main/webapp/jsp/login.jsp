<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Event Management System</title>
</head>


 <div class="col-md-2 col-sm-2 col-xs-12">
<div class="logo-area">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href="#"><img src="images/Webel_Logo.jpg" alt="logo"></a>
</div>
</div>


<header class="main-header">
<%@include file="common/scriptTags.jsp"%>

<style>
.form-control-feedback {
      padding-top: 20px !important;
   padding-right: 22px; 
}
</style>
<div class="container">
	<div class="col-md-10 col-sm-10 col-xs-12">
	 	<div class="clearfix"></div>
	</div>
</div>
</header>



 <body>
<!--main-body-->
<section id="login-wrapper">

   <div class="login-middle" style="width: 400px;">
      <c:if test = "${not empty errorMsg}">
		 <div class="alert alert-danger alert-dismissable fade in custom-error" id="dangerMsg">
    	   <strong>${errorMsg}</strong> 
         </div>
      </c:if>
   <h2 style="text-align: center;    color: #062544d9;">LOGIN</h2>
 
   <form:form id="loginForm" action="loginProcess" method="POST" modelAttribute="loginForm" >
  <div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
   <div class="form-group">
   		<div><strong>Username</strong>   
           	 <form:input path="username"  type="text" class="form-control" name="username" placeholder="Enter username" required=""/>
    	</div>
   </div>  
    <div class="form-group"> 
    	<div><strong>Password</strong>    
            <form:input path="password"  type="password" class="form-control"  name="password" placeholder="Enter password" required=""/>
    	</div>
    </div>
  
   <div class="log-panel">
      <button type="submit" value="" class="main-button cart-button">LOG IN</button>
    </div>
                
   </div>
    </div>
  </form:form>
   </div>
  </section>
  <%@include file="common/footer.jsp"%>
</body>
<script>
$( document ).ready(function() {
	$("#dangerMsg").fadeTo(1000, 500).slideUp(500, function(){
	    $("#dangerMsg").slideUp(500);
	});

	$("#loginForm").bootstrapValidator({
        feedbackIcons: {
            valid: "glyphicon glyphicon-ok",
            invalid: "glyphicon glyphicon-remove",
            validating: "glyphicon glyphicon-refresh"
        },
        fields: {
            username: {
                validators: {
                    notEmpty: {
                        message: "The username is required and cannot be empty"
                    },
                    stringLength: {
                        max: 20,
                        message: "The user name must be less than 20 characters"
                    },
                   /*  regexp: {
                        regexp: "^[a-zA-Z 0-9_]+$",
                        message: "The user name can be consist of alphabate,numbers and underscore"
                    } */
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max:10,
                        message: 'The password must have minimum 6 characters and maximum 10 characters'
                        
                    }
                    
                }
            }
        }
    });
	
});

</script>
</html>
