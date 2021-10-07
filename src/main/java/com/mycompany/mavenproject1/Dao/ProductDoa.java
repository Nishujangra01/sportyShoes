/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.Dao;

import com.mycompany.mavenproject1.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ProductDoa {


private SessionFactory factory;
 public ProductDoa(SessionFactory factory){
 this.factory=factory;
 }
public boolean saveProduct(Product product){
boolean f=false;
    try {
        Session session = this.factory.openSession();
        Transaction tx= session.beginTransaction()  ;
        
        
        session.save(product);
        
        tx.commit();
        session.close();
        f=true;
    } catch (Exception e) {
        e.printStackTrace();
        f=false;
    }
    
   
return f;
}

public List<Product> getAllProducts(){
    List<Product> li = new ArrayList<Product>();
    try {
         Session ss=this.factory.openSession();
    ss.beginTransaction();
    
    Query   qu=  ss.createQuery("from Product");
    li =qu.list();
    
    ss.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
   
    
    return li;
    
}


    
}
