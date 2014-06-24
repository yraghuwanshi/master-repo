/**
 * 
 */
package com.visualbuilder.struts.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * This is the User class that represents a USER in the USERS table in the database
 * 
 * @author VisualBuilder
 *
 */
public class User extends ActionForm{
	private String userId = "";
	private String firstName = "";
	private String lastName = "";
	private int age = 0;
	private String email = "";
	private String password = "";
	
	public User(String userId) {
		super();
		this.userId = userId;
	}
	public User(){
		super();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ActionErrors validate( 
	      ActionMapping mapping, HttpServletRequest request ) {
		
	      ActionErrors errors = new ActionErrors();	      
	      if( getUserId().length()<1 ) {
	        errors.add("name",new ActionMessage("null.check","User ID"));
	      }
	      if(getEmail().length()>0)
	      {
	    	  //Yes! user entered email address. validate it
	    	  if(!getEmail().matches("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$")){
	    		  errors.add("name",new ActionMessage("email.invalid"));
	    	  }
	      }
	      return errors;
	  }
}
