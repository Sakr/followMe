<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:if test="${not empty error}">
	<div id="login-error">${error}</div>
</c:if>

<c:url value="/addAcount" var="addAcountURL" />
<form action="j_spring_security_check" class="login" method="post" >

<img class="logo" src="<c:url value="resources/images/logo.png" />">
<%-- 	<label for="j_username"><spring:message code="login.username"/></label> --%>

	<spring:message code="login.username" var="login"/>
	<input  class = "input" placeholder="${login}" id="j_username" name="j_username" type="text" />
<%-- 	<label for="j_password"><spring:message code="login.password"/></label> --%>

	<spring:message code="login.password" var="password"/>
	<input class = "input" placeholder="${password}" id="j_password" name="j_password" type="password" />

	<spring:message code="login.signin" var="signin"/>
	<input class = "submit" value = "${signin}"  type="submit" />	
								
	<a class = "createAccount" href="${addAcountURL}"><spring:message code="login.createaccount"/></a>
</form>

