package com.example.nani.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.nani.model.User;
import com.example.nani.repository.UserRepository;
@Component
@Repository
@RestController
public class UserController {

	@Autowired
	private UserRepository userrepo;

//	Insert Values 
	@PostMapping("users/add")
	public User addUser(@RequestBody User newUser) {
		return userrepo.save(newUser);
	}
	
	//Get all users
	@GetMapping("/users/get")
	public List<User> getUsers(){
		return (List<User>) userrepo.findAll();
	}
	
	//get specific Users
	@GetMapping("/users/get/{id}")
	public User  getI(@PathVariable int id ) { 
		 Optional<User> us=userrepo.findById(id);
		 if(us.isPresent()) {
		return us.get() ;
	}
		return null;
	}

	//update Query
@PutMapping("/users/update/{id}")
public User update(@PathVariable int id, @RequestBody User use) {
	 Optional<User> uss=userrepo.findById(id);
	 if(uss.isPresent()) {
		 
	 uss.get().setId(use.getId());
	 uss.get().setName(use.getName());
	 uss.get().setEmail(use.getEmail());
	 return userrepo.save(uss.get());
	 }
	 else {
	return null;
	 }
}
//Delete Query
@DeleteMapping("/users/delete/{id}")
public User delete(@PathVariable int id) {
	Optional<User> uss=userrepo.findById(id);
	 if(uss.isPresent()) {
		 userrepo.deleteById(id);
	 }
	return null;

}
	@GetMapping("/data")
	public String hello() {
		return "user page";
	}
@GetMapping("/saveuser")
public String nani(@RequestParam(name="name") String name,@RequestParam (name="email") String email ) {
	User user=new User(name, email);
	userrepo.save(user);
	return "user saved";
}

//public List<User> AllUsers(){
//	List<User> users=new ArrayList<User>();
//	for(User user:userrepo.findAll()) {
//		users.add(user);
//	}
//	return users;
//}


}
