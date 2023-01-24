package com.example.nani.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import com.example.nani.model.User;

@RestController
@Transactional
public class ServiceClass {
	@Autowired
	UserRepository userrepo;
	
public ServiceClass(UserRepository userrepo) {
		this.userrepo = userrepo;
	}

public void saveUser(User user) {
	userrepo.save(user);
}
//}
}
