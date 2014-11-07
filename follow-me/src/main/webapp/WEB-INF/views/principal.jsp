<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>



<script type="text/javascript">
	function activityBox() {

		var activityBox = document.getElementById("activityBox");

		if (activityBox.style.display != 'none') {
			activityBox.style.display = 'none';
		} else {
			activityBox.style.display = 'block';
		}

	}

	function accountBox() {

		var accountBox = document.getElementById("accountBox");

		if (accountBox.style.display != 'none') {
			accountBox.style.display = 'none';
		} else {
			accountBox.style.display = 'block';

		}

	}

	var map;
	var markers = [];

	function initialize() {
		
		//Centrer la page sur l'adress de l'utilisateur
		var centerpoint = new google.maps.LatLng('${connectedUser.adress.latitude}', '${connectedUser.adress.longitude}');
		//
		var activitypoint = new google.maps.LatLng(48.819428, 2.281654);
		var mapOptions = {
			zoom : 17,
			center : centerpoint,
			mapTypeId : google.maps.MapTypeId.TERRAIN
		};
		map = new google.maps.Map(document.getElementById('map'), mapOptions);
		google.maps.event.addListener(map, 'click', function(event) {
			addMarker('resources/images/fitness.png', event.latLng);
		});
	

	}

	//Add a marker to the map and push to the array.
	//function addMarker(imageUrl, lati, longi) {
	function addMarker(imageUrl, location) {
		var image = {
			url : imageUrl,
			origin : new google.maps.Point(0, 0),
			anchor : new google.maps.Point(18, 48),
			scaledSize : new google.maps.Size(35, 48)
		};

		var marker = new google.maps.Marker({
			// position: location,
			position : new google.maps.LatLng(location.lat(), location.lng()),
			map : map,
			icon : image,
			visible : true
		});

		infobox = new InfoBox({
			content : document.getElementById("infobox"),
			disableAutoPan : false,
			maxWidth : 150,
			pixelOffset : new google.maps.Size(-123, -330),
			zIndex : null,
			boxStyle : {
				width : "250px",
				height : "100px"
			},
			closeBoxMargin : "5px 0px 0px 2px",
			closeBoxURL : "resources/images/close.png",
			infoBoxClearance : new google.maps.Size(1, 1)
		});

		google.maps.event.addListener(marker, 'click', function() {
			infobox.open(map, this);
			map.panTo(loc);
		});

		markers.push(marker);
	}

	//Sets the map on all markers in the array.
	function setAllMap(map) {
		for (var i = 0; i < markers.length; i++) {
			markers[i].setMap(map);
		}
	}

	//Shows any markers currently in the array.
	function showMarkers() {
		setAllMap(map);
	}

	//Removes the markers from the map
	function deleteMarkers() {
		// setAllMap(null);
		markers[0].setMap(null);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
	
	function disablebtn(id) { 
	      document.getElementById(id).setAttribute("disabled","disabled");
	}
	
</script>

<c:url value="?locale=fr" var="francais" />
<c:url value="?locale=en" var="english" />

<div id="searchBar" style="display: none" class="searchBar">
	<input type="text"></input>
</div>
<c:url value="/accept" var="acceptParticipant" />

<div id="activityBox" style="display: none;">
	</br>
	<!--  <input class = "button" type="submit" value="Ajouter une activité" onclick="addMarker('resources/images/skate.png', {37.7699298; -122.4469157}); addMarker('image/pin_sport.png', 38.7699298, -122.4469157);"/>
      	-->
	<spring:message code="principal.accept" var="accept" />
	<c:forEach items="${notificationsFormBeanList}" var="notification" varStatus="status">
		<c:url value="/accept?index=${status.index}" var="acceptParticipant" />
		<div>
			<span class="participant">${notification.labelNotification}</span> 
			<input  class="accept" name="rechercher" id="rechercher" value="${accept}" onclick="javascript:doGet('${acceptParticipant}');disablebtn();"/> 
		</div>
	</c:forEach>
	



</div>

<div id="accountBox" style="display: none;">
	</br>



	<a href="<c:url value="/logout"/>"> 
		<spring:message code="parincipal.deconnexion" var="deconnexion" /> 
		<input class="button" type="submit" value="${deconnexion}" />
	</a>
	<a class="lien iframe" href="<c:url value="/addActivity"/>"> 
		<spring:message code="add.activity" var="addActivity" /> 
		<input class="button" type="submit" value="${addActivity}" />
	</a>
	<table class="tableFlagMain">
		<tr>
			<td><a href="${francais}"><img class="languageFlag"
					src="resources/images/drapeau-fr.png" /></a></td>
			<td><a href="${english}"><img class="languageFlag"
					src="resources/images/drapeau-en.png" /></a></td>
		</tr>
	</table>

</div>


<div id="map"></div>
<br>



<div class="infobox-wrapper">
	<div id="infobox">
		<div id="popUpFrame">

			<div class="head-wrapper">
				<span class="popUpActivity"> <span class="popUpActivityTitle">FOOTING</span></br>
					<span class="popUpActivityLeader">proposé par Gaston</span>
				</span> <img class="img_profil" src="resources/images/img_profil.png" />
			</div>
			<div class="body-wrapper">
				<span class="popUpAdress"> <span class="PopUpAdressTitle">
						Adresse de l'activité :</span></br> <span class="PopUpAdressContent">
						Parc Frédéric Pic</br> 92170, Vanves
				</span>
				</span>
			</div>
			<table class="tableCarac">
				<tr>
					<td><img class="pictoCarac" src="resources/images/duree.png" /></td>
					<td><img class="pictoCarac" src="resources/images/detente.png" /></td>
					<td><img class="pictoCarac" src="resources/images/place.png" /></td>
				</tr>
				<tr>
					<td>40 min</td>
					<td>Détente</td>
					<td>03/10</td>
				</tr>
			</table>

			<div id="footer-wrapper">
				<input class="button" type="submit" value="PARTICIPER !" /> <a href="#" class="contactLeader">Contacter l'organisateur</a>
			</div>

		</div>
	</div>
</div>

