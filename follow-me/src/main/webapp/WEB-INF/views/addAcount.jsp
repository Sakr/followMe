<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url value="/saveAcount" var="saveAcountURL" />
<c:url value="/resetAcount" var="resetURL" />
<!-- Gestion des doublons -->
<c:if test="${not empty statutAccount}">
	<div class="" >${statutAccount}</div>
</c:if>

<form:form method="POST"  commandName="accountFormBean" action="${saveAcountURL}" class="createAccountForm" target="_parent">

        <img class="logo" src="<c:url value="resources/images/logo.png" />">
        
        <spring:message code="account.secondName" var="secondname"/>
		<form:input required="required" class = "input" type = "text"  path="name" id="idSecondName" placeholder="${secondname}"/>
		
        <spring:message code="account.firstName" var="firstname"/>
        <form:input required="required" class = "input" type = "text" path="firstName" id="idFirstName" placeholder="${firstname}"/>
		
		<spring:message code="account.mail" var="mail"/>
		<form:input required="required" class = "input" type = "email" path="mail" id="idMail" placeholder="${mail}"/>
			
		<spring:message code="account.phoneNumber" var="phoneNumber"/>
		<form:input required="required" class = "input" type = "number"  path="phoneNumber" id="idPhoneNumber" placeholder="${phoneNumber}" min="0" max="0799999999"/>
										

		
		<spring:message code="account.login" var="login"/>
		<form:input required="required" class = "input" type = "text" path="login" id="idLogin" placeholder="${login}"/>
					
		<spring:message code="account.password" var="password"/>
		<form:input required="required" class = "input" type = "password"  path="password" id="idPassword" placeholder="${password}"/>
					


		<spring:message code="account.number" var="number"/>
		<form:input required="required" class = "input" type = "number" path="number" id="idAdressNumber" placeholder="${number}" value="" min="0"/>	
					
		<spring:message code="account.streetName" var="streetName"/>
		<form:input required="required" class = "input" type = "text"  path="street" id="idAdressStreetName" placeholder="${streetName}"/>			
		
		<spring:message code="account.postcode" var="zipCode"/>
		<form:input required="required" class = "input" type = "number" path="postcode" id="idCodeAdess" placeholder="${zipCode}" value="" min="0" max="99999"/>

		<spring:message code="account.cityAdress" var="city"/>
		<form:input required="required" class = "input" type = "text" path="city" id="idCityAdress" placeholder="${city}"/>
			

				
        <input type="submit" class="submit" name="rechercher" id="rechercher" value="<spring:message code="account.save" />" /> 
		<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="login.cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
					

</form:form>
