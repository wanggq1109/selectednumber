package com.cvssp.selectednumber.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_User")
public class User extends DomainImpl {

	
	@Column(name="name",nullable=true)
	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
