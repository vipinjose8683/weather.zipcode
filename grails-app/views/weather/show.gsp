
<%@ page import="com.weather.zipcode.Weather" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'weather.label', default: 'Weather')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-weather" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form action="search" >
				Zip Code : <g:textField name="myField"/><g:actionSubmit value="Search" />
			</g:form>
		</div>
		<div id="show-weather" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<ol class="property-list weather">
			
				<g:if test="${weatherInstance?.temperature}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Temperature" /></span>
					
						<span class="property-value" aria-labelledby="temperature-label"><g:fieldValue bean="${weatherInstance}" field="temperature"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${weatherInstance?.zipCode}">
				<li class="fieldcontain">
					<span id="zipCode-label" class="property-label"><g:message code="weather.zipCode.label" default="Zip Code" /></span>
					
						<span class="property-value" aria-labelledby="zipCode-label"><g:fieldValue bean="${weatherInstance}" field="zipCode"/></span>
					
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>
