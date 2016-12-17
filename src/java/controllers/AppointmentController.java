/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.bookme.dao.BookmeDao;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Heta
 */
@Controller 
public class AppointmentController {
    
    @Autowired
    private BookmeDao bookmedao;
    
        
    @RequestMapping(value="/DisplayTime", method = RequestMethod.POST)
    public String booked(Model model, @RequestParam("l1") String aptime,@RequestParam("datePicker") String apdate, HttpSession session) throws ParseException 
    {
      //  String aptime="9 am";
      int uid =(Integer)session.getAttribute("userid");
      String profid=(String)session.getAttribute("profid");
      java.sql.Date sdate;
      java.util.Date fdate;
      
      SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
      fdate=dateformat.parse(apdate);
       sdate=new java.sql.Date(fdate.getTime()); 
       int ins=bookmedao.addappointment(uid, profid, sdate, aptime);
       model.addAttribute("printme", "Your Appointment is booked!!");
       
        
       return "index";
    }
    @RequestMapping(value="/DisplayTime", method = RequestMethod.GET)
    public String disp(Model model)
    {
       return "DisplayTime";
    }
}
