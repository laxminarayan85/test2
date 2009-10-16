package com.efi.printsmith.service;

import com.efi.printsmith.data.*;



import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LoginService extends DataService {

	public LoginService() {
		super();
	}

	public Users validateLogin(String userName, String password) {
		
		try {		
			log.info("Attempting login for " + userName);
			EntityManager em = entityManagerFactory.createEntityManager();
			Query q = em.createQuery("select u from users u where upper(u.name)= upper(:name)");
			q.setParameter("name", userName);
			
			Users user1 = (Users) q.getSingleResult();
					
			if (user1.getPassword().equals(password)) return user1;
		} catch (Exception e) {
			log.error(e);
		}
		return null;		
	}
}