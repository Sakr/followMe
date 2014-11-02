<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<img class="activityResume" src="resources/images/activityResume.png" onclick="activityBox(this);"/>
<img class="account" src="resources/images/img_profil.png" onclick="accountBox(this);"/>
<div>
  <img class="logo" src="resources/images/logo.png">
</div>
<div class="langueSelection">
	<p class="langue">
		<label><spring:message code="home.langue"/></label>
		<select id="idLanguage" onchange="changeLanguage(this)" >
			<option value="lang" label="" selected="selected" />
			<option value="fr" label="Français"  />
			<option value="en" label="English" />	
		</select>
	</p>		
</div>
