<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
	<head>
		<title>
			<tiles:insertAttribute  name="title" ignore="true"/>
		</title>		
		<tiles:insertAttribute  name="css" ignore="true"/>
		<tiles:insertAttribute  name="javascript" ignore="true"/>
		<tiles:insertAttribute  name="import" ignore="true"/>	
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/principal_popin.css"/>" media="screen" />
	</head>
	<body>
		<div id="centre">
			<div id="contenu_popin">
				<tiles:insertAttribute name="content"/>
		    </div><!-- fin #contenu -->
		</div><!-- fin #centre -->
	</body>
</html>
