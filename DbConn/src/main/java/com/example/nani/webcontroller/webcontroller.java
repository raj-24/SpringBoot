package com.example.nani.webcontroller;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.nani.model.User;
import com.example.nani.repository.UserRepository;

@Component
@Repository
@Controller
public class webcontroller {
	@Autowired
	private UserRepository repos;
	@ResponseBody
	//To Return A Sample String
	@RequestMapping("/home")
	public String home() {
		return "hi boss";
	}

	// welcome page
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	// Registration page
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	// Saving Function
	@PostMapping("/user-saved")
	public String opUser(@ModelAttribute User user, BindingResult bindingresult, HttpServletRequest request) {
		repos.save(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

    //All User Data 
	@GetMapping("/show-users")
	public String shouser(HttpServletRequest request) {
		request.setAttribute("users", repos.findAll());
		request.setAttribute("mode", "MODE_ADDUSER");
		return "welcomepage";

	}
	
	//Delete User
	@RequestMapping("/delete-user")
		public String delete(@RequestParam int id,HttpServletRequest request) {
		repos.deleteById(id);
		request.setAttribute("users", repos.findAll());
			request.setAttribute("mode", "MODE_ADDUSER");
			return "welcomepage";
			
		}

	//Update User
	@RequestMapping("/update-user")
	public String update(@RequestParam("id")int id,@ModelAttribute User user, BindingResult bindingresult,HttpServletRequest request) {
		 Optional<User> uss=repos.findById(id);
		 uss.get().setId(user.getId());
		 uss.get().setName(user.getName());
		 uss.get().setEmail(user.getEmail());
		 request.setAttribute("user",user);
			request.setAttribute("mode", "MODE_UPDATE");
			return "welcomepage";
		}
	
	}
