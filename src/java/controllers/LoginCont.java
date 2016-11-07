/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Heta
 */

@Controller
public class LoginCont {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model){
        model.addAttribute("msg", "Please enter login Details");
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("LoginBean") LoginBean loginbean){
        if(loginbean != null && loginbean.getUserName() != null && loginbean.getPassword() !=null){
            if(loginbean.getUserName().equals("heta") && loginbean.getPassword().equals("heta123")){
                model.addAttribute("printme","Welcome Heta");
                return "index";
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
