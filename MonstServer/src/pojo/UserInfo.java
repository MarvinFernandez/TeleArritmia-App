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
public class UserInfo implements Serializable {
    private String username;
    private String password;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserInfo() {
        this.username="";
        this.password=""; //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "username=" + username + ", password=" + password + '}';
    }
    
    
}
