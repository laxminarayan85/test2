package com.efi.printsmith.data;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "users")
@NamedQueries( {
		@NamedQuery(name = "users.findAll", query = "from User"),
		@NamedQuery(name = "users.byId", query = "select u from User u where u.id= :id"),
		@NamedQuery(name = "users.byName", query = "select u from User u where upper(u.name)= upper(:name)")
})
		
public class User extends ModelBase{
	@Basic
	@Column(name = "name", nullable = true, unique = true)
	private String name;

	@Basic
	@Column(name = "password", nullable = true, unique = false)
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