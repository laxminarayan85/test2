package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LoginService extends DataService {

	public LoginService() {
		super();
	}

	public Boolean validateLogin(String userName, String password) {
		try {		
			log.info("Attempting login for " + userName);
			EntityManager em = entityManagerFactory.createEntityManager();
			Query q = em.createNamedQuery("User.byName");
			q.setParameter("name", userName);
			
			List<User> users = q.getResultList();
			if (users.size() != 1)
				return false;
			
			if (users.get(0).getPassword().equals(password)) return true;
		} catch (Exception e) {
			log.error(e);
		}
		return false;		
	}
}