
package com.mycompany.mavenproject1.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pName;
    @Column(length = 3000)
    private String pDes;
    private String pPhoto;
    private int pPrice;
    private int PQuantity;

    public Product(String pName, String pDes, String pPhoto, int pPrice, int PQuantity) {
        this.pName = pName;
        this.pDes = pDes;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.PQuantity = PQuantity;
    }

    public Product() {
    }

    public Product(int pid, String pName, String pDes, String pPhoto, int pPrice, int PQuantity) {
        this.pid = pid;
        this.pName = pName;
        this.pDes = pDes;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.PQuantity = PQuantity;
    }
 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.pid;
        hash = 97 * hash + Objects.hashCode(this.pName);
        hash = 97 * hash + Objects.hashCode(this.pDes);
        hash = 97 * hash + Objects.hashCode(this.pPhoto);
        hash = 97 * hash + this.pPrice;
        hash = 97 * hash + this.PQuantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.pid != other.pid) {
            return false;
        }
        if (this.pPrice != other.pPrice) {
            return false;
        }
        if (this.PQuantity != other.PQuantity) {
            return false;
        }
        if (!Objects.equals(this.pName, other.pName)) {
            return false;
        }
        if (!Objects.equals(this.pDes, other.pDes)) {
            return false;
        }
        if (!Objects.equals(this.pPhoto, other.pPhoto)) {
            return false;
        }
        return true;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDes() {
        return pDes;
    }

    public void setpDes(String pDes) {
        this.pDes = pDes;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getPQuantity() {
        return PQuantity;
    }

    public void setPQuantity(int PQuantity) {
        this.PQuantity = PQuantity;
    }
    
    
}
