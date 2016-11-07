/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Heta
 */
public class LoginBean {
    private String userName;
    private String password;
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUserName(String name){
        userName=name;
    }
    
    public void setPassword(String pwd){
        password = pwd;
    }
}
