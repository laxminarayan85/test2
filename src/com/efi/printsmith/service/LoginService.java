package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LoginService extends DataService {

	public LoginService() {
		super();
	}

	public User validateLogin(String userName, String password) {
		try {		
			log.info("Attempting login for " + userName);
			EntityManager em = entityManagerFactory.createEntityManager();
			Query q = em.createNamedQuery("User.byName");
			q.setParameter("name", userName);
			
			User user = (User) q.getSingleResult();
					
			if (user.getPassword().equals(password)) return user;
		} catch (Exception e) {
			log.error(e);
		}
		return null;		
	}
}