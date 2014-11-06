<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- URL For add -->
<c:url value="/addActivity" var="addURL" />
<c:url value="/resetAddActivity" var="resetAddActivityURL" />


<div class="block">
	<form:form method="POST" commandName="activityFormBean" action="${addURL}" class="createAccountForm" target="_parent">
	
	
		
				
		<spring:message code="account.number" var="number"/>
		<form:input required="required" class = "input" type = "number" path="number" id="idAdressNumber" placeholder="${number}" value=""/>	
					
		<spring:message code="account.streetName" var="streetName"/>
		<form:input required="required" class = "input" type = "text"  path="street" id="idAdressStreetName" placeholder="${streetName}"/>			
		
		<spring:message code="account.postcode" var="zipCode"/>
		<form:input required="required" class = "input" type = "number" path="postcode" id="idCodeAdess" placeholder="${zipCode}" value=""/>

		<spring:message code="account.cityAdress" var="city"/>
		<form:input required="required" class = "input" type = "text" path="city" id="idCityAdress" placeholder="${city}"/>		
				
        <input type="submit" class="submit" name="rechercher" id="rechercher" value="<spring:message code="activity.save" />" /> 
		<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="login.cancel" />" class="reset" onclick="javascript:doGet('${resetAddActivityURL}')" />
	
	</form:form>
</div>