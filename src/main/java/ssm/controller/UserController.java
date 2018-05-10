package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ssm.entity.User;
import ssm.service.UserService;

@Controller
public class UserController {
   private UserService userService;    
   @RequestMapping(method=RequestMethod.GET,value="/login")
   public String login( ){ 
	     return "login" ;
   }   



}   
    
	  
	  
