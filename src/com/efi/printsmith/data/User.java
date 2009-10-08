package com.efi.printsmith.data;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@NamedQueries( {
		@NamedQuery(name = "User.findAll", query = "from User"),
		@NamedQuery(name = "User.byId", query = "select u from User u where u.id= :id"),
		@NamedQuery(name = "User.byName", query = "select u from User u where upper(u.name)= upper(:name)")
})

@Entity
@Table(name = "users")		
public class User extends ModelBase{
	@Basic
	@Column(name = "name", nullable = false, unique = false)
	private String name;

	@Basic
	@Column(name = "password", nullable = false, unique = false)
	private String password;
	
	public User() {

		super();

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}
	
}