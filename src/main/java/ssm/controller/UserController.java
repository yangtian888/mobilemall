package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.entity.User;
import ssm.service.UserService;

@Controller
public class UserController {
	@Autowired
   private UserService userService;   
	
   @RequestMapping(method=RequestMethod.GET,value="/login")
   public String login( ){ 
	     return "login" ;
   }   
   @RequestMapping(method=RequestMethod.GET,value="/regist")
   public String reg(){
	   return  "reg" ;
   }
   @RequestMapping(method=RequestMethod.POST,value="regist")
   public String regist(@ModelAttribute User user){
	   userService.regist(user);
	   System.err.println(user);
	   return "redirect:/login" ;
   }
}   
    
	  
	  
