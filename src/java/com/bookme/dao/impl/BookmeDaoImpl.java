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
import org.springframework.dao.DataAccessException;

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
      String name=null;
        try{
            name=jdbcTemplate.queryForObject("Select username from HETA.LOGIN where username=? and password=?", new Object[]{username, password}, String.class);
       }
       catch(DataAccessException e){
           name=null;
       }
       finally{
        }
        return name;
        
    }
    
    @Override 
    public int getuserid(String username, String password)
    {
        int id=0;
        try{
            id=jdbcTemplate.queryForObject("Select userid from HETA.LOGIN where username=? and password=?", new Object[]{username, password}, Integer.class);
        }
        catch(DataAccessException e){
            
        }
        return id;
    }
     
    @Override 
    public String getprofid(String profname)
    {
        String name=null;
        try{
            name=jdbcTemplate.queryForObject("Select pid from HETA.PROFESSOR where PNAME=?", new Object[]{profname}, String.class);

        }
         catch(DataAccessException e){
            
        }
        return name;
    }
    
    @Override
    public int addappointment(int USERID, String PID, java.sql.Date APDATE, String APTIME)
    {
        try
        {
            int maxid=jdbcTemplate.queryForObject("Select MAX(APID) from HETA.APPOINTMENT", Integer.class);

            
            jdbcTemplate.update("INSERT INTO HETA.APPOINTMENT (APID, USERID, PID, APDATE ,TIME) VALUES (" + ++maxid + "," + USERID+ ", '" + PID + "','"+ APDATE +"' , TIME('"+ APTIME +"'))");

        }
        catch(DataAccessException e)
        {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    
    @Override
    public List getAllProf(){
        String sql = "SELECT pname FROM HETA.PROFESSOR";

	List<String> professors = jdbcTemplate.queryForList(sql,String.class);
	
	return professors;
    }
}
