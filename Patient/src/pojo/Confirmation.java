/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;

/**
 *
 * @author danielmarchan
 */
public class Confirmation implements Serializable{
    Boolean confirm;

    public Confirmation(){
        this.confirm = false;
    }
    
    public Confirmation(Boolean confirm) {
        this.confirm = confirm;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "Confirmation{" + "confirm=" + confirm + '}';
    }
    
    
    
    
}
