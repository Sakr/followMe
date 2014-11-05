// function initialize() {
//     var loc, map, marker, infobox;
    
//     loc = new google.maps.LatLng(48.818255, 2.281214);
    
//     map = new google.maps.Map(document.getElementById("map"), {
//          zoom: 15,
//          center: loc,
//          mapTypeId: google.maps.MapTypeId.ROADMAP
//     });

//     var image = {
//       url: 'image/pin_sport.png',
//       /*size: new google.maps.Size(700, 700),*/
//       origin: new google.maps.Point(0, 0),
//       anchor: new google.maps.Point(18, 48),
//       scaledSize: new google.maps.Size(35, 48)
//     };
    
//     marker = new google.maps.Marker({
//         map: map,
//         position: loc,
//         icon: image,
//         visible: true
//     });

//     infobox = new InfoBox({
//          content: document.getElementById("infobox"),
//          disableAutoPan: false,
//          maxWidth: 150,
//          pixelOffset: new google.maps.Size(-123, -330),
//          zIndex: null,
//          boxStyle: {
//             /*background: "url('http://google-maps-utility-library-v3.googlecode.com/svn/trunk/infobox/examples/tipbox.gif') no-repeat",*/
//             width: "250px",
//             height:"100px"
//         },
//         closeBoxMargin: "12px 8px 2px 2px",
//         closeBoxURL: "image/close.png",
//         infoBoxClearance: new google.maps.Size(1, 1)
//     });
    
//     google.maps.event.addListener(marker, 'click', function() {
//         infobox.open(map, this);
//         map.panTo(loc);
//     });


// }

// google.maps.event.addDomListener(window, 'load', initialize);


var map;
var markers = [];

function initialize() {
  var centerpoint = new google.maps.LatLng(48.8219906, 2.2938723999999997);
  var activitypoint = new google.maps.LatLng(48.819428, 2.281654);
  
  
  var mapOptions = {
    zoom: 17,
    center: centerpoint,
    mapTypeId: google.maps.MapTypeId.TERRAIN
  };
  map = new google.maps.Map(document.getElementById('map'),
      mapOptions);

  google.maps.event.addListener(map, 'click', function(event) {
    addMarker('resources/images/fitness.png', event.latLng);
  });
  
  var image = {
	      url: 'resources/images/pin_sport.png',
	      origin: new google.maps.Point(0, 0),
	      anchor: new google.maps.Point(18, 48),
	      scaledSize: new google.maps.Size(35, 48)
	    };

	  var marker = new google.maps.Marker({
	    // position: location,
	    position: activitypoint,
	    map: map,
	    icon: image,
	    visible: true
	  });

	  infobox = new InfoBox({
	         content: document.getElementById("infobox2"),
	         disableAutoPan: false,
	         maxWidth: 150,
	         pixelOffset: new google.maps.Size(-123, -330),
	         zIndex: null,
	         boxStyle: {
	            width: "250px",
	            height:"100px"
	        },
	        closeBoxMargin: "5px 0px 0px 2px",
	        closeBoxURL: "resources/images/close.png",
	        infoBoxClearance: new google.maps.Size(1, 1)
	    });
	    
	    google.maps.event.addListener(marker, 'click', function() {
	        infobox.open(map, this);
	        map.panTo(loc);
	    });


}

// // Add a marker to the map and push to the array.
// function addMarker() {
//     var image = {
//       url: 'image/pin_sport.png',
//       origin: new google.maps.Point(0, 0),
//       anchor: new google.maps.Point(18, 48),
//       scaledSize: new google.maps.Size(35, 48)
//     };

//   var marker = new google.maps.Marker({
//     position: new google.maps.LatLng(37.7699298, -122.4469157),
//     map: map,
//     icon: image,
//     visible: true
//   });
//   markers.push(marker);

//   infobox = new InfoBox({
//          content: document.getElementById("infobox"),
//          disableAutoPan: false,
//          maxWidth: 150,
//          pixelOffset: new google.maps.Size(-123, -330),
//          zIndex: null,
//          boxStyle: {
//             width: "250px",
//             height:"100px"
//         },
//         closeBoxMargin: "12px 8px 2px 2px",
//         closeBoxURL: "image/close.png",
//         infoBoxClearance: new google.maps.Size(1, 1)
//     });
    
//     google.maps.event.addListener(marker, 'click', function() {
//         infobox.open(map, this);
//         map.panTo(loc);
//     });
// }

// Add a marker to the map and push to the array.
// function addMarker(imageUrl, lati, longi) {
function addMarker(imageUrl, location) {
    var image = {
      url: imageUrl,
      origin: new google.maps.Point(0, 0),
      anchor: new google.maps.Point(18, 48),
      scaledSize: new google.maps.Size(35, 48)
    };

  var marker = new google.maps.Marker({
    // position: location,
    position: new google.maps.LatLng(location.lat(), location.lng()),
    map: map,
    icon: image,
    visible: true
  });

  infobox = new InfoBox({
         content: document.getElementById("infobox"),
         disableAutoPan: false,
         maxWidth: 150,
         pixelOffset: new google.maps.Size(-123, -330),
         zIndex: null,
         boxStyle: {
            width: "250px",
            height:"100px"
        },
        closeBoxMargin: "5px 0px 0px 2px",
        closeBoxURL: "resources/images/close.png",
        infoBoxClearance: new google.maps.Size(1, 1)
    });
    
    google.maps.event.addListener(marker, 'click', function() {
        infobox.open(map, this);
        map.panTo(loc);
    });

    markers.push(marker);
}

// Sets the map on all markers in the array.
function setAllMap(map) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}

// Shows any markers currently in the array.
function showMarkers() {
  setAllMap(map);
}

// Removes the markers from the map
function deleteMarkers() {
  // setAllMap(null);
  markers[0].setMap(null);
}



google.maps.event.addDomListener(window, 'load', initialize);