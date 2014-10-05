/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.revo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author revo
 */
@Entity
public class Tags implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy = "tags", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PostTags> postTags;
	public Tags() {
		super();
	}

	public Tags(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PostTags> getPostTags() {
		return postTags;
	}

	public void setPostTags(List<PostTags> postTags) {
		this.postTags = postTags;
	}

 

}
