
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length = 100, name="user_name")
    private String username;
    @Column(length = 100, name="user_email")
     private String email;
     @Column(length = 100, name="user_password")
     private String password;
     @Column(length = 50 , name ="user_type")
     private String userType;

    public User(int userId, String username, String email, String password,String userType) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType=userType;
    }

    public User() {
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.userId;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
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
        final User other = (User) obj;
        return true;
    }

    public User(String username, String email, String password , String userType) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType=userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

  

}
