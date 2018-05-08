package ssm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ssm.entity.Book;
import ssm.entity.User;
import ssm.service.BookService;
import ssm.service.UserService;

@Controller
public class UserController {
	
private UserService userService;
@Autowired
public UserController(UserService userService) {
	this.userService = userService;
}

@RequestMapping(method=RequestMethod.GET, value="/users")
public String details(@PathVariable Long id, Model model){ 
	User user = userService.findOne(id);
	model.addAttribute("user",user);
	return "login";
}
	
	
}
