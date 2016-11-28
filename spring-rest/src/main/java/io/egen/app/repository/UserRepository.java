package io.egen.app.repository;

import java.util.List;


import io.egen.app.entity.User;

public interface UserRepository {

	public List<User> findAll();

	public User findOne(String usrId);


	public User findByusername(String username);


	public User create(User usr);
	public User create_Admin(User usr);
	public User update(User usr);

	public void delete(User existing);
}
