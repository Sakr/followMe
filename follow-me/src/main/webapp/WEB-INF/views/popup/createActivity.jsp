<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- URL For add -->
<c:url value="/saveAddActivity" var="addURL" />
<c:url value="/resetAddActivity" var="resetAddActivityURL" />

<div class="block">
	<form:form method="POST" commandName="activityFormBean" action="${addURL}" class="popUpForm" target="_parent">
	
		<spring:message code="activity.lavel" var="labelActivity" />
		
		<div class="styled-select">
			<form:select path="activityNameId" id="nameActivity" >
				<form:option value="NONE" label="${labelActivity}" />
				<c:forEach items="${activityFormBean.listNameActivity}" var="entry">
					<form:option value="${entry.id}" label="${entry.name}"></form:option>
				</c:forEach>
			</form:select>
		</div>
		
		<spring:message code="activity.participantsNumber" var="participantsNumber"/>
		<form:input required="required" class = "input" type = "number" path="participantsNumber" id="idparticipantsNumber" placeholder="${participantsNumber}" value="" min="1" max="10"/>	
					
		<spring:message code="activity.description" var="description"/>
		<form:input required="required" class = "input" type = "text"  path="description" id="iddescription" placeholder="${description}"/>			
		
		<spring:message code="activity.date" var="dateActivity"/>
		<form:input required="required" class = "inputDate w16em dateformat-d-sl-m-sl-Y show-weeks no-animation opacity-99 disable-drag"
						maxlength="10" onchange="javascript:isDate(this.value)" type = "text"  path="effectiveDate" id="ideffectiveDate" placeholder="${dateActivity}"/>
		
		<div class="styled-select">
			<spring:message code="duration.label" var="labelDuration" />
			<spring:message code="duration.min" var="min"/>
			<spring:message code="duration.hour" var="hour"/>
			<form:select path="duration" id="durationActivity" >
				<form:option value="NONE" label="${labelDuration}" />
				<form:option value="15" label="15 ${min}"></form:option>
				<form:option value="30" label="30 ${min}"></form:option>
				<form:option value="45" label="45 ${min}"></form:option>
				<form:option value="1" label="1 ${hour}"></form:option>
				<form:option value="2" label="2 ${hour}"></form:option>
			</form:select>
        </div>

        <div class="styled-select">
        <spring:message code="difficulty.label" var="difficulty"/>
           <spring:message code="difficulty.relax" var="relax" />
			<spring:message code="difficulty.amateur" var="amateur"/>
			<spring:message code="difficulty.sportsman" var="sportsman"/>
			<form:select path="difficulty" id="nameActivity" >
				<form:option value="NONE" label="${difficulty}" />
				<form:option value="15" label="${relax}"></form:option>
				<form:option value="30" label="${amateur}"></form:option>
				<form:option value="45" label="${sportsman}"></form:option>
			</form:select>
        </div>
			
		<spring:message code="account.number" var="number"/>
		<form:input required="required" class = "input" type = "number" path="number" id="idAdressNumber" placeholder="${number}" value="" min="1"/>	
					
		<spring:message code="account.streetName" var="streetName"/>
		<form:input required="required" class = "input" type = "text"  path="street" id="idAdressStreetName" placeholder="${streetName}"/>			
		
		<spring:message code="account.postcode" var="zipCode"/>
		<form:input required="required" class = "input" type = "number" path="postcode" id="idCodeAdess" placeholder="${zipCode}" value="" min="0" max="99999"/>

		<spring:message code="account.cityAdress" var="city"/>
		<form:input required="required" class = "input" type = "text" path="city" id="idCityAdress" placeholder="${city}"/>		
				
<%--         <input type="submit" class="submit" name="rechercher" id="rechercher" value="<spring:message code="activity.save" />" />  --%>
<%-- 		<input type="reset" class="cancelAddActivity"name="reset" id="reset" value="<spring:message code="login.cancel" />" class="reset" onclick="javascript:doGet('${resetAddActivityURL}')" /> --%>
	
	</form:form>
</div>