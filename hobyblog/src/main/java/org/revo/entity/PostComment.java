/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * 
 * @author revo
 */
@Entity
public class PostComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String txt;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date PostCommentdate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Person person;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Post post;
	@OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PostCommentLike> postCommentLike;

	public PostComment() {
		this.PostCommentdate = new Date();
	}

	public PostComment(String txt, Person person, Post post) {
		this.txt = txt;
		this.person = person;
		this.post = post;
		this.PostCommentdate = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getPostCommentdate() {
		return PostCommentdate;
	}

	public void setPostCommentdate(Date PostCommentdate) {
		this.PostCommentdate = PostCommentdate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<PostCommentLike> getPostCommentLike() {
		return postCommentLike;
	}

	public void setPostCommentLike(List<PostCommentLike> postCommentLike) {
		this.postCommentLike = postCommentLike;
	}

}
