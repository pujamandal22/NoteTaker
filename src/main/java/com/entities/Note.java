package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="notes")
public class Note {
	@Id
private int id;
private String title;
@Column(length=1500)
private String Content;
private Date add_date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return Content;
}
public void setContent(String content) {
	Content = content;
}
public Date getAdd_date() {
	return add_date;
}
public void setAdd_date(Date add_date) {
	this.add_date = add_date;
}
public Note( String title, String content, Date add_date) {
	super();
	this.id = new Random().nextInt(100000);//user theke id nebo nh...tai util package er random class ta use korlm
	                                      //r 100000 dewa mane....0-100000 er mdhye jekono random number db te save hbe
	this.title = title;
	Content = content;
	this.add_date = add_date;
}
public Note() {
	super();
	// TODO Auto-generated constructor stub
}


}
