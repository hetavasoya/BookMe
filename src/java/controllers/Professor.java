/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Heta
 */
public class Professor {
    
    private String pid;
    private String pname;
    
    public void setId(String pid){
        this.pid=pid;
    }
    public String getId(){
        return pid;
    }
    public void setPname(String pname){
        this.pname=pname;
    }
    public String getPname(){
        return pname;
    }
    
}
