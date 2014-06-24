<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />    
    <title>Add new user</title>
  </head>  
  <body>
  <center><h3>Add New User</h3></center>
  <CENTER><html:errors/></CENTER>
    <html:form action="/adduser" method="post">
      <table border="0" align="center">
        <tr>
          <td>User ID:</td>
          <td><html:text property="userId" /></td>
        </tr>
        <tr>
          <td>First Name:</td>
          <td><html:text property="firstName" /></td>
        </tr>
        <tr>
          <td>Last Name:</td>
          <td><html:text property="lastName" /></td>
        </tr>
        <tr>
          <td>Age:</td>
          <td><html:text property="age" /></td>
        </tr>
        <tr>
          <td>Email:</td>
          <td><html:text property="email" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit /></td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>
