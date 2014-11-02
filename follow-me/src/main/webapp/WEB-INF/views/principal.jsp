<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>      





      

      <div id="searchBar" style="display:none" class="searchBar">
        <input type="text"></input>


      </div>


      <div id="activityBox" style="display: none;">
      </br>
          <input class = "button" type="submit" value="Ajouter une activitÃ©" onclick="addMarker('resources/images/skate.png', {37.7699298; -122.4469157}); addMarker('image/pin_sport.png', 38.7699298, -122.4469157);"/>
      </div>

      <div id="accountBox" style="display: none;">
          </br>
          <input class = "button" type="submit" value="Se dÃ©connecter" onclick="deleteMarkers();" />
      </div>


      <div id="map"></div>
      <br>

      <div class="infobox-wrapper">
          <div id="infobox">
                  <div id="popUpFrame">

                    <div class="head-wrapper">
                        <span class="popUpActivity">
                          <span class="popUpActivityTitle">FOOTING</span></br>
                          <span class="popUpActivityLeader">proposÃ© par Gaston</span>
                        </span>

                        <img class="img_profil" src="resources/images/img_profil.png"/>
                    </div>


                    <div class="body-wrapper">

                      <span class="popUpAdress">
                        <span class="PopUpAdressTitle"> Adresse de l'activitÃ© :</span></br>
                        <span class="PopUpAdressContent"> Parc FrÃ©dÃ©ric Pic</br>
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
                              <td>DÃ©tente</td>
                              <td>03/10</td>
                          </tr>

                      </table>

                    <div id="footer">

                      <input class = "button" type="submit" value="PARTICIPER !" />
                      <a href="#" class="contactLeader">Contacter l'organisateur</a>

                    </div>

                  </div>
          </div>
      </div>
