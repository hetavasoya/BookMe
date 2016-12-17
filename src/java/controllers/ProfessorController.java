/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.bookme.dao.BookmeDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Heta
 */

@Controller
public class ProfessorController {
           
    @Autowired
    private BookmeDao bookmedao;
    
        @ModelAttribute("profList")
	public List getProf()
	{            
		//List profList = new ArrayList();
                
		//profList.add("Prof.Chung");
		//profList.add("Prof.Ghriga");
		//profList.add("Prof.Sameer");
                
               List profList=bookmedao.getAllProf();
		return profList;
	}
        
    @RequestMapping("/selectProf")
    public String dispList(Map model){
        System.out.println("DISPLIST HERE!!!!!!");
        Professor pr=new Professor();
        model.put("pr",pr);
        return "selectProf";
    }
    
    @RequestMapping(value = "/selectProf",method = RequestMethod.POST)
	public String processForm(HttpSession session, Model model, @Valid @ModelAttribute("pr") Professor pr1, BindingResult result,RedirectAttributes rdir) 
	{                
		if(result.hasErrors())
		{
			System.out.println("Validation Failed");
			return "selectProf";
		}
		else
		{
			System.out.println("Validated Successfully");
                        rdir.addFlashAttribute("profname", pr1.getPname());
                        model.addAttribute("profname",pr1.getPname());
                        String pid=bookmedao.getprofid(pr1.getPname());
                        session.setAttribute("profid",pid);
			return "redirect:./DisplayTime.htm";
		}
	}
    
}