package io.egen.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.app.entity.Role;
import io.egen.app.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String usrId) {
		return em.find(User.class, usrId);
	}

	
	
	@Override
	public User findByusername(String username) {
		TypedQuery<User> query = em.createNamedQuery("User.findByusername", User.class);
		query.setParameter("pusername", username);
		List<User> users = query.getResultList();
		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}


	@Override
	public User create(User usr) {
		
		
		Role role=new Role();
		role.setRoleName("USER");
		em.persist(role);
		usr.setRole(role);
		em.persist(usr);
		return usr;
	}

	@Override
	public User update(User usr) {
		return em.merge(usr);
	}

	@Override
	public void delete(User existing) {
		
		em.remove(existing);
		
	}

	@Override
	public User create_Admin(User usr) {

		Role role=new Role();
		role.setRoleName("ADMIN");
		em.persist(role);
		usr.setRole(role);
		em.persist(usr);
		return usr;
	}

	
}