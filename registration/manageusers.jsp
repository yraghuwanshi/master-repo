<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Listing all users</title>
  </head>
  
  <body>
   <center><h3>User List</h3></center>
  <html:errors/>
  
  <logic:present name="list">
  	<table border="0" cellspacing="0" cellpadding="0" align="center" width="70%" style="border-collapse:collapse;">
  	<tr bgcolor="#98AFCC">
	  	<th>User ID</th>
	  	<th>First Name</th>
	  	<th>Last Name</th>
	  	<th>Email</th>	  		  	
  	</tr>
  	<%boolean even = false; %>
  	<logic:iterate id="user" name="list">
  	<% even = !even; %>
  	<tr bgcolor="<%=even?"#B7D3F5":"#D6E0F5" %>">
  	<td>
  		<bean:write name="user" property="userId" />
	</td>
  	<td>
  		<bean:write name="user" property="firstName" />
	</td>
	 <td>
  		<bean:write name="user" property="lastName" />
	</td>
	<td>
  		<bean:write name="user" property="email" />
	</td>
	</tr>
  	</logic:iterate>
  	<tr>
  	<td colspan="6" align="center">
  	<a href="adduser.jsp">Add New User</a>
  	</td>
  	</tr>
  	</table>
  </logic:present>

  </body>
</html>
