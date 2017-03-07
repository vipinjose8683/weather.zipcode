
<%@ page import="com.weather.zipcode.Weather" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="bootstrap-main"/>
		<g:set var="entityName" value="${message(code: 'weather.label', default: 'Weather')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<g:if test="${flash.message}">
				<div class="alert alert-danger" role="alert">${flash.message}</div>
			</g:if>
			<g:form action="search" >
				Zip Code : <g:textField name="myField"/><g:actionSubmit value="${message(code: 'weather.label.show', default: 'Show Weather')}" action="search"/>
			</g:form>
		</div>
		<div id="show-weather" class="content scaffold-show" role="main">
			<ol class="property-list weather">
			</ol>
		</div>
      <div class="weatherZipCode">
			<h1>
				<g:if test="${weatherInstance?.zipCode}">
					<g:fieldValue bean="${weatherInstance}" field="zipCode"/>
				</g:if>
			</h1>
      </div>
      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
          <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
			<div class="weatherProperty">
				<g:if test="${weatherInstance?.iconUrl}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Weather" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><img src="<g:fieldValue bean="${weatherInstance}" field="iconUrl"/>" alt="Grails"/></span>
				</li>
				</g:if>
			</div>
          </div>
          <div class="item">
			<div class="weatherProperty">
				<g:if test="${weatherInstance?.temperature}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Temperature" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><g:fieldValue bean="${weatherInstance}" field="temperature"/></span>
				</li>
				</g:if>
			</div>
          </div>
          <div class="item">
			<div class="weatherProperty">
				<g:if test="${weatherInstance?.humidity}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Humidity" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><g:fieldValue bean="${weatherInstance}" field="humidity"/></span>
				</li>
				</g:if>
			</div>
          </div>
          <div class="item">
			<div class="weatherProperty">
				<g:if test="${weatherInstance?.windSpeed}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Wind Speed" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><g:fieldValue bean="${weatherInstance}" field="windSpeed"/></span>
				</li>
				</g:if>
			</div>
          </div>
        </div>
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>	</body>
</html>
