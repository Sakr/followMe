<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="?locale=fr" var="francais" />
<c:url value="?locale=en" var="english" />

<head>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute  name="css" ignore="true"/>
<tiles:insertAttribute  name="javascript" ignore="false"/>

</head>


<body>
	<table class="tableFlag">
        <tr>
            <td><a href="${francais}"><img class="languageFlag" src="resources/images/drapeau-fr.png"/></a></td>
            <td><a href="${english}"><img class="languageFlag" src="resources/images/drapeau-en.png"/></a></td>
        </tr>
    </table>
    
	<tiles:insertAttribute name="content" />
</body>
</html>

