<%-- 
    Document   : index
    Created on : Oct 7, 2021, 2:52:17 AM
    Author     : a
--%>

<%@page import="com.mycompany.mavenproject1.Helper"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.mycompany.mavenproject1.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.mavenproject1.Dao.ProductDoa"%>
<%@page import="com.mycompany.mavenproject1.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sporty Shoes-Home</title>
        <%@include file="component/common_css_js.jsp" %>
    
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        <div class="row">
        <%
        ProductDoa doa = new ProductDoa(FactoryProvider.getFactory());
        List<Product>  list= doa.getAllProducts();


        %>
        
        <div class="col-md-8">
            <div class="row mt-4">
                
                <div class="col-md-12">
                
                    <div class="card-columns">  
                    <% 
                    for (Product p : list) {
                            
                        
                    
                    
                    %>
                    <div class="card" >
                        <img class="card-img-top" src="img/products/<%=p.getpPhoto() %>" alt="Card image cap">
                        <div  class="card-body">
                            
                            <h5  class="card-title"><%= p.getpName() %></h5>
                            <p class="card-text"><%= Helper.get10Words(p.getpDes() ) %></p>
                         
                        </div>
                            <div class="card-footer">
                                <button class="btn custom-bg text-white">Add to Cart</button>
                             <button class="btn btn-outline-success ">&#8377;<%=p.getpPrice() %></button>
                           
                            </div>
                        
                        
                        
                    </div>
                    
                    <%}%>
                    
                    </div>
                
                
                
                </div>
                
                
                
            </div>
        </div>
        </div>
         
    </body>
</html>
