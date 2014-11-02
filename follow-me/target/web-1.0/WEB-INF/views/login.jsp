<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<h1>Login</h1>

<div id="login-error">${error}</div>

<form action="j_spring_security_check" method="post" >

<p>
	<label for="j_username"><spring:message code="login.username"/></label>
	<input id="j_username" name="j_username" type="text" />
</p>

<p>
	<label for="j_password"><spring:message code="login.password"/></label>
	<input id="j_password" name="j_password" type="password" />
</p>

<input  type="submit" value="Login"/>								
	
</form>

