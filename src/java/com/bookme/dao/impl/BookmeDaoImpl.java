/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.bookme.dao.impl;


import com.bookme.dao.BookmeDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import controllers.*;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Heta
 */
@Repository("bookmeDao")
public class BookmeDaoImpl implements BookmeDao {  
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public String validateLogin(String username, String password){
        String num=jdbcTemplate.queryForObject("Select count(*) from HETA.LOGIN where username='heta'", String.class);
        
        return num;
    }
    
    @Override
    public List getAllProf(){
        String sql = "SELECT pname FROM HETA.PROFESSOR";

	List<String> professors = jdbcTemplate.queryForList(sql,String.class);
	
	return professors;
    }
}
