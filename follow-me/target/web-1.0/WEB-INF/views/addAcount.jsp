<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url value="/saveAcount" var="saveAcountURL" />
<!-- Gestion des doublons -->
<c:if test="${not empty statutAccount}">
	<div class="" >${statutAccount}</div>
</c:if>

<form:form method="POST"  commandName="accountFormBean" action="${saveAcountURL}" class="modify" target="_parent">
		<table>
			<tr>
				<td>
					<div>
						<img class ="picto" src="resources/images/name.png" />
						<spring:message code="account.firstName" var="firstname"/>
						<form:input required="required" class = "inputmodify" type = "text" path="firstName" id="idFirstName" placeholder="${firstname}"/>
						
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.secondName" var="secondname"/>
						<form:input required="required" class = "inputmodify" type = "text"  path="name" id="idSecondName" placeholder="${secondname}"/>
					</div>
					
					<div>
						<img class ="picto" src="resources/images/mail.png" />
						<spring:message code="account.mail" var="mail"/>
						<form:input required="required" class = "inputmodify" type = "email" path="mail" id="idMail" placeholder="${mail}"/>
					</div>	
							
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.login" var="login"/>
						<form:input required="required" class = "inputmodify" type = "text" path="login" id="idLogin" placeholder="${login}"/>
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.password" var="password"/>
						<form:input required="required" class = "inputmodify" type = "password"  path="password" id="idPassword" placeholder="${password}"/>
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.photo" var="photo"/>
						<form:input required="required" class = "inputmodify" type = "text" path="photo" id="idPhoto" placeholder="${photo}"/>
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.phoneNumber" var="phoneNumber"/>
						<form:input required="required" class = "inputmodify" type = "text"  path="phoneNumber" id="idPhoneNumber" placeholder="${phoneNumber}"/>
					</div>
				</td>
				<td>
					<div>
						<img class ="picto" src="resources/images/adresse.png" />
						<spring:message code="account.number" var="number"/>
						<form:input required="required" class = "inputmodify" type = "text" path="number" id="idAdressNumber" placeholder="${number}" value=""/>	
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.streetName" var="streetName"/>
						<form:input required="required" class = "inputmodify" type = "text"  path="street" id="idAdressStreetName" placeholder="${streetName}"/>			
					</div>	
							
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.postcode" var="zipCode"/>
						<form:input required="required" class = "inputmodify" type = "text" path="postcode" id="idCodeAdess" placeholder="${zipCode}" value=""/>
					</div>
					
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.cityAdress" var="city"/>
						<form:input required="required" class = "inputmodify" type = "text" path="city" id="idCityAdress" placeholder="${city}"/>
					</div>
						
					<div>
						<img class ="picto" src="resources/images/blank.png" />
						<spring:message code="account.establishment" var="establishment"/>
						<form:input required="required" class = "inputmodify" type = "text" path="establishment" id="idEstablishment" placeholder="${establishment}"/>
					</div>
					<div style="margin-top:13px;">
						<input type="submit" class="buttonmodify" name="rechercher" id="rechercher" value="<spring:message code="account.save" />" /> 
						<input type="reset" class="cancel"name="reset" id="reset" value="<spring:message code="cancel" />" class="reset" onclick="javascript:doGet('${resetURL}')" />
					</div>
				</td>
			</tr>
		</table>
		
		
		
	</form:form>