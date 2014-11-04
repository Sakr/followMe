<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div id="login-error">${error}</div>

<form action="j_spring_security_check" class="login" method="post" >

<img class="logo" src="<c:url value="resources/images/logo.png" />">
<%-- 	<label for="j_username"><spring:message code="login.username"/></label> --%>
	<input  class = "input" placeholder="Login" id="j_username" name="j_username" type="text" />
<%-- 	<label for="j_password"><spring:message code="login.password"/></label> --%>
	<input class = "input" placeholder="Password" id="j_password" name="j_password" type="password" />

	<input class = "submit" value = "SIGN IN"  type="submit" />								
	<a class = "createAccount" href="#">Create an account</a>
</form>

