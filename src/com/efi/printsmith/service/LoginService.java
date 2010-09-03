package com.efi.printsmith.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.efi.printsmith.data.*;
import flex.messaging.client.FlexClient;
import flex.messaging.FlexContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.efi.printsmith.service.EncryptionService;

public class LoginService extends DataService {

	public LoginService() {
		super();
	}

	public Users validateLogin(String userName, String password) {
		
		try {		
			log.info("Attempting login for " + userName);
			
			/* Following line is a hack to try to resolve the DuplicateSession error being thrown by BlazeDS
			 * if more than one session is logged in simultaneously. See 
			 * http://helpqlodhelp.blogspot.com/2009/11/lcds-flex-solution-for-duplicate.html
			 */
			FlexContext.getFlexClient().invalidate();
						
			EntityManager em = entityManagerFactory.createEntityManager();
			Query q = em.createQuery("select u from Users u where upper(u.name)= upper(:name)");
			q.setParameter("name", userName);
			
			Users user = (Users) q.getSingleResult();
			if (user.getDisableUser().equals(false)) {		
				if (user.getRobustPassword() != null && user.getRobustPassword().booleanValue() == true) {
					String localPW = EncryptionService.decryptData(user.getPassword(), "AES256PASSWORD_A");
				
					if (localPW.equals(password)) {
					  Date tempDate = new Date();
					  Calendar NintyDayCalendar = Calendar.getInstance();
					  NintyDayCalendar.setTime(tempDate);
					  NintyDayCalendar.add(Calendar.DATE, -90);

					  //
					  // to long sense last GOOD login, disable the user
					  //
					  if (user.getLastLogin() != null && user.getLastLogin().before(NintyDayCalendar.getTime())) {
							user.setDisableUser(true);
							this.addUpdate(user);
							return null;
					  }
					  else {
						  user.setLastLogin(tempDate);
					  }
					  
					  if (user.getPasswordChangedDate() != null && user.getPasswordChangedDate().getTime() != 0 && user.getPasswordChangedDate().before(NintyDayCalendar.getTime())) {
					  	user.setForcePasswordChange(true);
					  }
					  
					  user.setLoginAttempts(0);
					  this.addUpdate(user);
						
					  if(FlexContext.getFlexSession() != null){
				    		FlexContext.getFlexSession().setAttribute("userInfo", user);
					  }
					  return user;
					} else {
						// failed login attempts
						user.setLoginAttempts(user.getLoginAttempts() + 1);
						if (user.getLoginAttempts() > 4) {
							user.setDisableUser(true);
							user.setLoginAttempts(0);
						}
						this.addUpdate(user);
					}
				} else {
					if (user.getPassword().equals(password)) {
						
						user.setLastLogin(new Date());
						user.setLoginAttempts(0);
						
						this.addUpdate(user);

						if(FlexContext.getFlexSession() != null){
				    		FlexContext.getFlexSession().setAttribute("userInfo", user);
	    				}
						return user;
					} else {
						// failed login attempts
						user.setLoginAttempts(user.getLoginAttempts() + 1);
						if (user.getLoginAttempts() > 4)
							user.setDisableUser(true);
						this.addUpdate(user);
					}
				}
			} 
			//
			// User is disabled, return back to the interface so it can be reported
			//
			else {
				 if (FlexContext.getFlexSession() != null){
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