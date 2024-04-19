
<html>
<head>

<title>Sign In</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/static/css/LoginCustom.css" rel="stylesheet">
<link href="resources/static/css/background_image.css" type="text/css" rel="stylesheet">


<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="resources/static/js/jquery-min-2.1.3.js" charset="utf-8"></script>
<script src="resources/static/js/bootstrap.min.js"></script>
<script src="resources/static/js/clockpicker/jquery-clockpicker.js"></script>
<script src="resources/static/js/clockpicker/bootstrap-clockpicker.js"></script>
<script src="resources/static/js/datepicker/Bootstrap_date_picker.js"></script>
<script>
$(function() {
    console.log( "ready!" );
    $("#failure-alert").show();
    window.setTimeout(function () {
        $("#failure-alert").slideUp(500, function () {
             $("#failure-alert").hide();
         });
    }, 5000);

    $("#logout-alert").show();
    window.setTimeout(function () {
        $("#logout-alert").slideUp(500, function () {
             $("#logout-alert").hide();
         });
    }, 5000);
});


</script>

</head>
<div class="container" id ="failure-alert">
		<% if(session.getAttribute("failure-msg") != null) { %>
		<div class="alert alert-danger text-center" style="margin-top:5px; margin-bottom:5px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=session.getAttribute("failure-msg")%>
		</div>
		<% session.removeAttribute("failure-msg"); } %>
</div>

<div class="container" id ="logout-alert">
		<% if(session.getAttribute("logout-msg") != null) { %>
		<div class="alert alert-info text-center" style="margin-top:5px; margin-bottom:5px;">
			<a href="#" class="close" data-dismiss="alert"> &times;</a>
			<%=session.getAttribute("logout-msg")%>
		</div>
		<% session.removeAttribute("logout-msg"); } %>
</div>
<body background="${pageContext.request.contextPath}/static/images/Doctor_lab.jpg">

  <form action="userLogin" id="login-form" method ="post">
      <h1>Welcome Health Care</h1>
      <div class="input-box">
          <input type="text" name="user_email"  name="user_email" placeholder="Enter Email">
         
      </div>

      <div class="input-box">
          <input type="password"  name="user_password"  name="user_password" placeholder="Enter Password">
         
      </div>

      <label>
        <input type="checkbox" name="remember"> Remember me
      </label>

      <button type="submit" class="login-btn">Login</button>

      <div class="bottom-links">
        <strong>Create account? <a href="signIn">Sign up</a></strong>
      </div>
      
      
      
 

  </form>
</body>
</html>
