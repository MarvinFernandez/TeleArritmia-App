/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author diego
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(){
        this.dia=0;
        this.mes=0;
        this.año=0;
    }
    
    public Fecha(int day, int month, int year){
        this.dia=day;
        this.mes=month;
        this.año=year;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    
}
