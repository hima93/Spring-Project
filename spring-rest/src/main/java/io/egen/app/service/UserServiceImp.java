package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.egen.app.entity.User;
import io.egen.app.exception.EntityAlreadyExistException;
import io.egen.app.exception.EntityNotFoundException;
//import io.egen.app.exception.PasswordIncorrectException;
import io.egen.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String usrId) {
		User usr = repository.findOne(usrId);
		if (usr == null) {
			throw new EntityNotFoundException("User not found");
		}
		return usr;
	}

	@Transactional
	@Override
	public String create(User usr) {
		User existing = repository.findByusername(usr.getusername());
		if (existing != null) {
			throw new EntityAlreadyExistException( "User already exists with this username");
		}
		
		 if(usr.getPassword().equals(usr.getConfirmPassword())){
			 repository.create(usr);
			 return "Registration Successful";
		 }
		 else
		 {
			 return "Passwords doesn't match";
		 }
			 
		 
	}


	@Transactional
	@Override
	public User update(String usrId, User usr) {
		User existing = repository.findOne(usrId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(usr);
	}

	@Transactional
	@Override
	public void remove(String usrId) {
		User existing = repository.findOne(usrId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
	}

	@Override
	public String login(User usr) {
		User existing = repository.findByusername(usr.getusername());
		if (existing != null) {
			
			if((existing.getPassword()).equals(usr.getPassword()))
			{
				return "Login Successful";
			}
			else
			{
				return "Incorrect Password";
			}
			
		}
		else{
							return "User doesn't exist";
	}	
		}

	@Transactional
	@Override
	public String create_Admin(User usr) {
		User existing = repository.findByusername(usr.getusername());
		if (existing != null) {
		
				throw new EntityAlreadyExistException( "Admin already exists with this username");
			}
			
			 if(usr.getPassword().equals(usr.getConfirmPassword())){
				 repository.create_Admin(usr);
				 return "Registration Successful";
			 }
			 else
			 {
				 return "Passwords doesn't match";
			 }
	}
		

}