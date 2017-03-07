
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
      <div class="jumbotron">
        <h3>
			<g:if test="${weatherInstance?.zipCode}">
				<g:fieldValue bean="${weatherInstance}" field="zipCode"/>
			</g:if>
		</h3>
      </div>
		<div id="show-weather" class="content scaffold-show" role="main">
			<ol class="property-list weather">
			
			
				<g:if test="${weatherInstance?.temperature}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Temperature" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><g:fieldValue bean="${weatherInstance}" field="temperature"/></span>
				</li>
				</g:if>
				
				<g:if test="${weatherInstance?.iconUrl}">
				<li class="fieldcontain">
					<span id="temperature-label" class="property-label"><g:message code="weather.temperature.label" default="Temperature" /></span>
					<span class="property-value" aria-labelledby="temperature-label"><img src="<g:fieldValue bean="${weatherInstance}" field="iconUrl"/>" alt="Grails"/></span>
				</li>
				</g:if>
				
			
			</ol>
		</div>
      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img data-src="holder.js/1140x500/auto/#777:#555/text:First slide" alt="First slide">
          </div>
          <div class="item">
            <img data-src="holder.js/1140x500/auto/#666:#444/text:Second slide" alt="Second slide">
          </div>
          <div class="item">
            <img data-src="holder.js/1140x500/auto/#555:#333/text:Third slide" alt="Third slide">
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
