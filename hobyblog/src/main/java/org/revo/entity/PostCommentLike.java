/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * 
 * @author revo
 */
@Entity
public class PostCommentLike implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date PostCommentLiketdate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Person person;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private PostComment postComment;

	public PostCommentLike() {
	}

	public PostCommentLike(Person person, PostComment postComment) {
		this.person = person;
		this.postComment = postComment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPostCommentLiketdate() {
		return PostCommentLiketdate;
	}

	public void setPostCommentLiketdate(Date PostCommentLiketdate) {
		this.PostCommentLiketdate = PostCommentLiketdate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public PostComment getPostComment() {
		return postComment;
	}

	public void setPostComment(PostComment postComment) {
		this.postComment = postComment;
	}

}
