package com.efi.printsmith.security;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.efi.printsmith.data.Users;
import com.efi.printsmith.service.DataService;

public class AuthenticationService extends DataService implements UserDetailsService {

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		EntityManager em = entityManagerFactory.createEntityManager();
		Query q = em.createQuery("select u from Users u where upper(u.name)= upper(:name)");
		q.setParameter("name", userName);
		
		Users user1 = (Users) q.getSingleResult();
		
		User user = new User(user1.getName(), user1.getPassword(), true, true, true, true, null);
		return user;
	}

}
