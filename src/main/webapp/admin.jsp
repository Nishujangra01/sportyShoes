
<%@page import="com.mycompany.mavenproject1.entity.User"%>
<%
    
    User user=(User)session.getAttribute("current-user");

    if (user==null) {
            session.setAttribute("message","You are not logged in !! First login please");
            response.sendRedirect("login.jsp");
            return;
        }
        else{
    
        if (user.getUserType().equalsIgnoreCase("normal")) {
                session.setAttribute("message", "You are not Admin !! Donot access please");
                 response.sendRedirect("login.jsp");
            return;
            }
    }
%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
          <%@include file="component/common_css_js.jsp" %>
    </head>
    <body>
         <%@include file="component/navbar.jsp" %>
        
         <div class="container" >
             <div class="row">
                 <!-- first -->
                 <div class="col-md-4" >
                     <div class="card">
                          <div class="card-body  text-center">
                              <div class="container">
                                  <img style="max-width: 150px" class="img-fluid rounded-circle" src="img/man.png" alt="user_icon"/> 
                              </div> 
                               <h1>324</h1>
                         <h1 class="text-uppercase text-muted">User</h1>
                         
                     </div>
                         
                     </div>
                  
                 </div>
                 <!-- second -->
                 <div class="col-md-5" >
                      <div class="card">
                          <div class="card-body text-center">
                              
                                <div class="container">
                              <img style="max-width: 150px" class="img-fluid rounded-circle" src="img/delivery-box.png" alt="product_icon"/> 
                              </div> 
                              <h1>453</h1>
                              
                              <h1 class="text-uppercase text-muted">Products</h1>
                         
                     </div>
                         
                     </div>
                  
                 </div>
                <!-- third -->
                 <div class="col-md-6">
                      <div class="card" data-toggle="modal" data-target="#add-product-modal">
                          <div class="card-body text-center">
                              
                                <div class="container">
                                    <img style="max-width: 150px" class="img-fluid rounded-circle" src="img/add-to-basket.png" alt="product_icon"/> 
                              </div> 
                              <p class="mt-2">Click here to add products</p>
                              
                              <h1 class="text-uppercase text-muted">Add Products</h1>
                         
                     </div>
                         
                     </div>
                  
                 </div>
                
                 
             </div>
             
             
             
         </div>
         
         <!-- product model -->


<div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Product details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <form action="ProductServlet" method="post" enctype="multipart/form-data">
              <div class="form-group">
                  <input type="text" class="form-control" placeholder="Enter title of product" name="pName" >
              </div>
              <div class="form-group">
                  <textarea style="height:  100px;" class="form-control" placeholder="Enter product description" name="pDes" ></textarea>
              </div> 
               <div class="form-group">
              <input type="number" class="form-control" placeholder="Enter price of product" name="pPrice" required >
              </div>
               <div class="form-group">
              <input type="number" class="form-control" placeholder="Enter product Quantity" name="PQuantity" required >
              </div>
              <div class="form-group">
                   <label for="pPhoto" >Select photo of product </label><br>
                   <input type="file" id="pPhoto" name="pPhoto" >
                     </div>
              
                   <div class="container text-center">
                        <button class="btn btn-outline-success">Add Product </button>
                       
                   </div>
                  
              
              
          </form>
          
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>
         
         
         
         
         

         
          <!--End product model -->
         
    </body>
</html>
