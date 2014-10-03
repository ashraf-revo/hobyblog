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
public class PostLike implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date PostLikedate;
	@ManyToOne
	private Post post;
	@ManyToOne
	private Person person;

	public PostLike() {
		this.PostLikedate = new Date();
	}

	public PostLike(Post post, Person person) {
		this.post = post;
		this.person = person;
		this.PostLikedate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPostLikedate() {
		return PostLikedate;
	}

	public void setPostLikedate(Date PostLikedate) {
		this.PostLikedate = PostLikedate;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
