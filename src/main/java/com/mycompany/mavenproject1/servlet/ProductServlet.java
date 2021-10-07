
package com.mycompany.mavenproject1.servlet;

import com.mycompany.mavenproject1.Dao.ProductDoa;
import com.mycompany.mavenproject1.FactoryProvider;
import com.mycompany.mavenproject1.entity.Product;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import static java.lang.module.ModuleDescriptor.read;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 16177216)
public class ProductServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
             
            String pName=request.getParameter("pName");
             String pDes=request.getParameter("pDes");
               int pPrice=Integer.parseInt(request.getParameter("pPrice")); 
               int PQuantity=Integer.parseInt(request.getParameter("PQuantity"));
               Part p = request.getPart("pPhoto");
                
               Product p1 = new Product();
               p1.setpName(pName);
               p1.setpDes(pDes);
               p1.setpPrice(pPrice);
               p1.setPQuantity(PQuantity);
               p1.setpPhoto(p.getSubmittedFileName());
               
               ProductDoa pro= new ProductDoa(FactoryProvider.getFactory());
                       pro.saveProduct(p1);
                      
                       //pic upload 
                      try {
                 String path=request.getRealPath("img")+File.separator+"products"+File.separator+p.getSubmittedFileName();
                          System.out.println("Image path: "+path);
                      
                          FileOutputStream fileOutputStream =new FileOutputStream(path);
                      InputStream inputStream = p.getInputStream();
                      byte[]data= new byte[inputStream.available()];
                      inputStream.read();
                          System.out.println(data.toString());
                      fileOutputStream.write(data);
                              fileOutputStream.close(); 
                         
                                
                          
                          
                          
                          
                          
                          
                          
                          
                          
            } catch (Exception e) {
            e.printStackTrace();
            }
                               
                       
                       out.println("Product saved successfully!!!!");
               HttpSession se=request.getSession();
               se.setAttribute("message", "Product added successfully!!!");
               response.sendRedirect("admin.jsp");
               return;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
