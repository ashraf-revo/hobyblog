/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * 
 * @author revo
 */
@Entity
public class Friends implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date Friendsdate;
	@ManyToOne
	private Person person1;
	@ManyToOne
	private Person person2;

	public Friends() {
		super();
		this.Friendsdate = new Date();
	}

	public Friends(Person person1, Person person2) {
		super();
		this.person1 = person1;
		this.person2 = person2;
		this.Friendsdate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFriendsdate() {
		return Friendsdate;
	}

	public void setFriendsdate(Date Friendsdate) {
		this.Friendsdate = Friendsdate;
	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

}
