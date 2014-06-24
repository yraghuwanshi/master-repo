<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="/WEB-INF/struts-html.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>Welcome to the registration case study</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>  
  <body>
  
  <html:errors/>
  
    <html:form action="/login">
      <table border="0">
        <tr>
          <td>Login:</td>
          <td><html:text property="userId" /></td>
        </tr>
        <tr>
          <td>Password:</td>
          <td><html:text property="password" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit value="Login"/></td>
        </tr>
      </table>
    </html:form>
  </body>
</html>
