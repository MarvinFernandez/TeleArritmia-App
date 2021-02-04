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

public class Window implements Serializable {
    public enum Windows_type {LOGIN,REGISTER,RECORDING,STOP,DEFAULT};
    Windows_type window;

    public Window(Windows_type window) {
        this.window = window;
    }
    
    public Window(){
        this.window = Windows_type.DEFAULT;
    }

    public Windows_type getWindow() {
        return window;
    }

    public void setWindow(Windows_type window) {
        this.window = window;
    }

    @Override
    public String toString() {
        return "Window{" + "window=" + window + '}';
    }
       
    
}
