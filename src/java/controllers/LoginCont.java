/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.bookme.dao.BookmeDao;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Heta
 */

@Controller
public class LoginCont {
    
    @Autowired
    private BookmeDao bookmedao;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model){
        model.addAttribute("msg", "Please enter login Details");
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit1(Model model, @ModelAttribute("LoginBean") LoginBean loginbean, RedirectAttributes rdir,HttpSession session){
        if(loginbean != null && loginbean.getUserName() != null && loginbean.getPassword() !=null){
            String uname=bookmedao.validateLogin(loginbean.getUserName(),loginbean.getPassword());
             if(uname != null){            
               rdir.addFlashAttribute("printme", uname);
               int id=bookmedao.getuserid(loginbean.getUserName(), loginbean.getPassword());
               session.setAttribute("userid",id);
               return "redirect:./Home.htm";
            }
            else{ 
               
                model.addAttribute("error","Invalid Details");
                return "login";
            }
                
        }
        else {            
            model.addAttribute("error","Please enter all Details");            
                return "login";
        }
    }
    
}
