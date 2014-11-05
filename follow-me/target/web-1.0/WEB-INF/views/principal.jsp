<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>      



<script type="text/javascript">

      function activityBox() {
 
          var activityBox = document.getElementById("activityBox");
           
          if(activityBox.style.display != 'none') {
          activityBox.style.display = 'none';
          } else {
          activityBox.style.display = 'block';
          }
       
      }

      function accountBox() {
 
          var accountBox = document.getElementById("accountBox");
           
          if(accountBox.style.display != 'none') {
          accountBox.style.display = 'none';
          } else {
          accountBox.style.display = 'block';
          
          }
       
      }
      
      
</script>

		<c:url value="?locale=fr" var="francais" />
		<c:url value="?locale=en" var="english" />

      <div id="searchBar" style="display:none" class="searchBar">
        <input type="text"></input>
      </div>


      <div id="activityBox" style="display: none;">
      </br>
          <!--  <input class = "button" type="submit" value="Ajouter une activité" onclick="addMarker('resources/images/skate.png', {37.7699298; -122.4469157}); addMarker('image/pin_sport.png', 38.7699298, -122.4469157);"/>
      	-->
      	<spring:message code="principal.accept" var="accept"/>
      	<div> <span class="participant">Gaston - Footing du 13/09</span> <input class = "accept" type="submit" value="${accept}"/></div>
      	
      	
      	
      </div>

      <div id="accountBox" style="display: none;">
          </br>


     <!-- 
        <div class="styled-select">
        

				<select id="idLanguage" onchange="changeLanguage(this)" >
					<option value="lang" label="Langue" selected="selected" />
					<option value="fr" label="Français"  />
					<option value="en" label="English" />	
				</select>

		</div>-->
			
		<a href="<c:url value="/logout"/>">
			<spring:message code="parincipal.deconnexion" var="deconnexion"/>
          	<input class = "button" type="submit" value="${deconnexion}" />
        </a>
        
        <table class="tableFlagMain">
	        <tr>
	            <td><a href="${francais}"><img class="languageFlag" src="resources/images/drapeau-fr.png"/></a></td>
	            <td><a href="${english}"><img class="languageFlag" src="resources/images/drapeau-en.png"/></a></td>
	        </tr>
	    </table>
        
      </div>


      <div id="map"></div>
      <br>

      <div class="infobox-wrapper">
          <div id="infobox">
                  <div id="popUpFrame">

                    <div class="head-wrapper">
                        <span class="popUpActivity">
                          <span class="popUpActivityTitle">FOOTING</span></br>
                          <span class="popUpActivityLeader">proposé par Gaston</span>
                        </span>

                        <img class="img_profil" src="resources/images/img_profil.png"/>
                    </div>


                    <div class="body-wrapper">

                      <span class="popUpAdress">
                        <span class="PopUpAdressTitle"> Adresse de l'activité :</span></br>
                        <span class="PopUpAdressContent"> Parc Frédéric Pic</br>
                                                          92170, Vanves </span>
                      </span>
                    </div>

                      <table class="tableCarac">
                          <tr>
                              <td><img class="pictoCarac" src="resources/images/duree.png"/></td>
                              <td><img class="pictoCarac" src="resources/images/detente.png"/></td>
                              <td><img class="pictoCarac" src="resources/images/place.png"/></td>
                          </tr>
                          <tr>
                              <td>40 min</td>
                              <td>Détente</td>
                              <td>03/10</td>
                          </tr>

                      </table>

                    <div id="footer-wrapper">

                      <input class = "button" type="submit" value="PARTICIPER !" />
                      <a href="#" class="contactLeader">Contacter l'organisateur</a>

                    </div>

                  </div>
          </div>
      </div>
      
      <div class="infobox-wrapper">
          <div id="infobox2">
                  <div id="popUpFrame">

                    <div class="head-wrapper">
                        <span class="popUpActivity">
                          <span class="popUpActivityTitle">FOOTING</span></br>
                          <span class="popUpActivityLeader">proposé par Gaston</span>
                        </span>

                        <img class="img_profil" src="resources/images/img_profil.png"/>
                    </div>


                    <div class="body-wrapper">

                      <span class="popUpAdress">
                        <span class="PopUpAdressTitle"> Adresse de l'activité :</span></br>
                        <span class="PopUpAdressContent"> Parc Frédéric Pic</br>
                                                          92170, Vanves </span>
                      </span>
                    </div>

                      <table class="tableCarac">
                          <tr>
                              <td><img class="pictoCarac" src="resources/images/duree.png"/></td>
                              <td><img class="pictoCarac" src="resources/images/detente.png"/></td>
                              <td><img class="pictoCarac" src="resources/images/place.png"/></td>
                          </tr>
                          <tr>
                              <td>40 min</td>
                              <td>Détente</td>
                              <td>03/10</td>
                          </tr>

                      </table>

                    <div id="footer-wrapper">

                      <input class = "button" type="submit" value="PARTICIPER !" />
                      <a href="#" class="contactLeader">Contacter l'organisateur</a>

                    </div>

                  </div>
          </div>
      </div>
      
