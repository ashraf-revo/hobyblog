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
public class Messages implements Serializable {

	/**
     *
     */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String txt;
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date MessagesDate;
	@ManyToOne
	private Person from;
	@ManyToOne
	private Person to;

	public Messages(String txt, Person from, Person to) {
		super();
		this.txt = txt;
		this.from = from;
		this.to = to;
		this.MessagesDate = new Date();
	}

	public Messages() {
		super();
		this.MessagesDate = new Date();
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

	public Date getMessagesDate() {
		return MessagesDate;
	}

	public void setMessagesDate(Date messagesDate) {
		MessagesDate = messagesDate;
	}

	public Person getFrom() {
		return from;
	}

	public void setFrom(Person from) {
		this.from = from;
	}

	public Person getTo() {
		return to;
	}

	public void setTo(Person to) {
		this.to = to;
	}

}
