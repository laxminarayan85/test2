package com.efi.printsmith.service;

import com.efi.printsmith.data.*;

import flex.messaging.FlexContext;



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
			Query q = em.createQuery("select u from Users u where upper(u.name)= upper(:name)");
			q.setParameter("name", userName);
			
			Users user = (Users) q.getSingleResult();
			if (user.getDisableUser().equals(false))		
				if (user.getPassword().equals(password)) {
					if(FlexContext.getFlexSession() != null){
			    		FlexContext.getFlexSession().setAttribute("userInfo", user);
    				}
					return user;
				}
		} catch (Exception e) {
			log.error(e);
		}
		return null;		
	}
}