/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author danielmarchan
 */
public class Patient implements Serializable {
    
    public enum GENDER{male,female};
    
    private String name;
    private String surname;
    private String id;
    private UserInfo userinfo;
    private String email;
    private Date dob;
   

    
    private GENDER sex; 
    
    

    public Patient(String name, String surname, String id, UserInfo userinfo, String email, Date dob, GENDER sex) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.userinfo = userinfo;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
    }

    public Patient() {
        this.name = null;
        this.surname = null;
        this.id = null;
        this.userinfo = new UserInfo();
        this.email = null;
        this.dob = null;
        this.sex = null;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return this.id;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }
    
    public String getUserusername(){
        return this.userinfo.getUsername();
    }
    
    public void setUserusername(String username){
        this.userinfo.setUsername(username);
    }
    
    public String getUserpassword(){
        return this.userinfo.getPassword();
    }
    
    public void setUserPassword(String password){
        this.userinfo.setPassword(password);
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public GENDER getSex() {
        return sex;
    }

    public void setSex(GENDER sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return "Patient{" + "name=" + name + "\n, surname=" + surname + ", "
                + "\nid=" + id + ", \nuserinfo=" + userinfo + ", \nemail=" + email + 
                ", \ndob=" + dob +  "\nsex=" + sex + '}';
    }
    

   
    
    
    
}
