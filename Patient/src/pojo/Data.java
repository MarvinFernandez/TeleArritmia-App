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
public class Data implements Serializable {
    private ArrayList<Integer> ECG = new ArrayList();
    private ArrayList<Integer> time = new ArrayList();
    private ArrayList<Integer> EDA = new ArrayList();
    private Fecha dom;

    public Data(){
        this.dom = new Fecha();
    }
    
    public Data(Fecha dom) {
        this.dom = dom;
    }
    
    
    public void setDom(Fecha dom) {
        this.dom = dom;
    }

    public Fecha getDom() {
        return dom;
    }
    
    public ArrayList<Integer> getECG(){
        return this.ECG;
    }
    
    public void setECG(ArrayList<Integer> ecg){
        this.ECG = ecg;
    }
    
    public void addECG(int i){
        this.ECG.add(i);
    }
    
    public ArrayList<Integer> getEDA(){
        return this.EDA;
    }
    
    public void setEDA(ArrayList<Integer> eda){
        this.EDA = eda;
    }
    
    public void addEDA(int i){
        this.EDA.add(i);
    }
    
    public ArrayList<Integer> getTime(){
        return this.time;
    }
    
    public void setTime(ArrayList<Integer> time){
        this.time = time;
    }
    
    public void addTime(int i){
        this.time.add(i);
    }

    @Override
    public String toString() {
        return "Data{"+ "This data contains info of the date" + "dom=" + dom + '}';
    }
    
    
    
    
}
