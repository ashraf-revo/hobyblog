package org.revo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * 
 * @author revo
 */
@Entity
public class PostTags implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Post post;
	@ManyToOne
	private Tags tags;

	public PostTags() {
		super();
	}

	public PostTags(Post post, Tags tags) {
		super();
		this.post = post;
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Tags getTags() {
		return tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

}
