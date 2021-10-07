<%-- 
    Document   : login
    Created on : Oct 7, 2021, 4:57:00 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login -Sporty Shoes</title>
         <%@include file="component/common_css_js.jsp" %>
    </head>
    <body>
         <%@include file="component/navbar.jsp" %>
        <div class="container">
            
            <div class="row">
                <div class="col-md-6 offset-md-3">
                <div class="card mt-3">
                <div class="card-header custom-bg text-black">
                     <%@include file="component/message.jsp" %>%>
                    <h3>Login here</h3>
                <div class="card-body">
                
                    <form action="LoginServlet" method="post">
  <div class="form-group">
    <label for="email">Email </label>
    <input name ="email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email">
   
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input name="password" type="password" class="form-control" id="password" placeholder="Password">
  </div>
                        <a href="register.jsp"> If not register then click here</a>
                     <div class="container text-center">
                          <button type="submit" class="btn btn-primary">Submit</button>
                     </div>
</form>
                
           
                
                
            </div>
                
                
            </div>
                
                
            </div>
            
            
        </div>
        
        
        
        
    </body>
</html>
