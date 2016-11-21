/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookme.dao;

import java.util.List;

/**
 *
 * @author Heta
 */
public interface BookmeDao {
    
    public String validateLogin(String username, String password);
    
    public List getAllProf();
            
}
