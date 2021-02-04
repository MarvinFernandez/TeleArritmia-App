/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author danielmarchan
 */
public class Patient {
    
    public enum GENDER{male,female};
    
    private String name;
    private String surname;
    private String id;
    private String email;
    private Date dob;
    private GENDER sex; 
    private int ECG[][]; 
    private int EDA[][];

    public Patient(String name, String surname, String id, String email, Date dob, GENDER sex, int[][] ECG, int[][] EDA) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
        this.ECG = ECG;
        this.EDA = EDA;
    }

    public Patient() {
        this.name = null;
        this.surname = null;
        this.id = null;
        this.email = null;
        this.dob = null;
        this.sex = null;
        this.ECG = null;
        this.EDA = null;
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
        return id;
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

    public int[][] getECG() {
        return ECG;
    }

    public void setECG(int[][] ECG) {
        this.ECG = ECG;
    }

    public int[][] getEDA() {
        return EDA;
    }

    public void setEDA(int[][] EDA) {
        this.EDA = EDA;
    }

    @Override
    public String toString() {
        return "Patient{\n" + "name=" + name + "\n surname=" + surname + 
                "\n id=" + id + "\n email=" + email + "\n dob=" + dob.getDay()+
                "/"+dob.getMonth()+"/"+dob.getYear() + "\n sex=" + sex + "\n}";
    }
    
    
    
}
