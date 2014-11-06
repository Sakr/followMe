<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<table class="tableHeader">
    <tr>
    	<c:if test="${not empty imageNotification}">
			<td><img class="activityResume" src="resources/images/activityResume.png" onclick="activityBox(this);"/><img class="notification" src="${imageNotification}"/></td>
		</c:if>
        
        <td><img class="logo" src="resources/images/logo.png"></td>
        <td><img class="account" src="resources/images/img_profil.png" onclick="accountBox(this);"/></td>
    </tr>
</table>
