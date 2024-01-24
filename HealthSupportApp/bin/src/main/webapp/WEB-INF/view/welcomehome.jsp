<!doctype html>
<html lang="en">
  <head>
  	<title>Welcome home page</title>


  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

		<link rel="stylesheet" href="static/css/welcome_custome.css">

		
<script src="static/js/jquery.min.js" ></script>

  
      <script>
  $(function(){

	  	 $('#SaveData').click(function(){  
		     alert("Hi ss");
		  });
		  	
	  
	});


 




 
 

  </script>
  </head>

  
  <body>
		
        <%@include file="nav-bar-menu.jsp"%> 
		<div class="wrapper d-flex align-items-stretch">
		
		<%@include file="commonMenu.jsp"%> 

        <!-- Page Content Start -->
      <div id="content" class="p-4 p-md-5 pt-5">
          <div id="dashboard"><%@include file="dashboard.jsp"%></div>
          
        
      </div>
      
       <!-- Page Content End  -->
		</div>

    <script src="static/js/popper.js"></script>
<script src="static/js/main.js"></script> 
   
  </body>
</html>