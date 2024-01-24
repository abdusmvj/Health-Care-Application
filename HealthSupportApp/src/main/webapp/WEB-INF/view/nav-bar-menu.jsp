
<style>


.topnav {
  overflow: hidden;
  background-color: #007bff;
  border-radius: 0.30rem;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.topnav-right{
float: right;
}
</style>

<!-- <div> -->
<%--             <% String email = (String) session.getAttribute("user_email"); %> --%>
<%--             <% if (email != null) {%> --%>
<!--             <div class="alert alert-success disappear"> -->
<%--                 <strong>Hello </strong> <font><%=email%></font> --%>
<!--             </div> -->
<%--             <% session.removeAttribute("user_email"); } %> --%>
                                  
<!--         </div> -->
<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#news">News</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
  <div class="topnav-right">
    <a href="#search">Search</a>
    <% String email = (String) session.getAttribute("user_email"); %>
     <% if (email != null) {%>
            <a href="#about"><strong>Hello </strong> <font><%=email%></font></a>
            <%  } %>
    
  </div>
</div>



